#!/usr/bin/perl
#
# spew_guts.pl
#
# ==============================================================
#
# Copyright 2009 Sirius Corporation plc and Duncan Gibb
# 
# This is Free Software, licenced under the GNU General Public
# License ("GPL").  Version 3 of the GPL shall apply unless a
# later version has been published by the Free Software
# Software Foundation ("FSF") at the time you receive this
# software, in which case that later version shall apply instead.
# At your your option, you may apply any version of the GPL
# published by the FSF later than that prescribed above.
#
# This software is supplied "as is" and "with all faults".
# There is ABSOLUTELY NO WARRANTY.  Please refer to the relevant
# section of the licence for more details.
#
# If you do not have a copy of the licence, please refer to
# <http://www.gnu.org/licenses/>.
#
# ==============================================================
#
# This script takes an ndrb Grand Unified Taxonomy Specifier
# as its input, and spews out the actual Grand Unified Taxonomy
# in Agrega-friendly vdex format.
#
# Where references to external zthes taxonomies are encountered
# these are converted to vdex in passing using a heuristic
# adapted from xfrm.xsl by Mark Cave-Ayland.
#
# Sections of vdex tree may also be imported using taxon
# references in the spec.
#
# ==============================================================
#
# Known bugs
#
# It's moderately horrible, quite ugly, and it takes ages to run.
#
# The input format is not documented and has no schema.
#
# The walkers ought to be abstracted better.  Both the Zthes
# and vdex importers ought to be novel constructors of the
# vdex fragment class.
#
# Adding descriptions at all breaks Agrega.
#
# There is a namespacing issue which means we treat
# vdex and Zthes inputs differently.
#
# Output needs to be fed through xmllint --format
# to make it indent properly and remove whitespace noise.
#
# ==============================================================
{
package Sirius::XML::escape;
@ISA = ('Exporter');
@EXPORT = qw( xml_escape );
@EXPORT_OK = qw( xml_escape );

sub xml_escape($) {
  my $data = _escapeLiteral( $_[0] );
  return _escapeASCII( $data );
}

sub identifier_escape($) {
  my $data = $_[0];
  $data =~ s/&/_and_/g;
  $data =~ s/\</_lt_/g;
  $data =~ s/\>/_gt_/g;
  $data =~ s/\"/_quot_/g;
  $data =~ s/([^a-zA-Z0-9_.-])/_/ge;
  return $data;
}

# Stolen verbatim from XML::Writer

sub _escapeLiteral($) {
  my $data = $_[0];
  if ($data =~ /[\&\<\>\"]/) {
    $data =~ s/\&/\&amp\;/g;
    $data =~ s/\</\&lt\;/g;
    $data =~ s/\>/\&gt\;/g;
    $data =~ s/\"/\&quot\;/g;
  }
  return $data;
}

sub _escapeASCII($) {
  $_[0] =~ s/([^\x00-\x7F])/sprintf('&#x%X;', ord($1))/ge;
  return $_[0];
}

1;
}

# ==============================================================

{
# Class representing a vdex fragment.  This is just a
# wrapper around an array of terms.

package Sirius::vdex::fragment;

sub new {
  my $class = shift;
  my $self = {};
  bless $self, $class;
  $self->{'children'} = ();
  $self->{'comment'} = undef;
  $self->{'terms'} = {};
  $self->{'context'} = $self;
  return $self;
}

sub clone {
  my $self = shift;
  my $clone = Sirius::vdex::fragment->new();
  for my $c ( $self->children() ) {
    $clone->addChild( $c->clone() );
  }
  return $clone;
}

sub setContext {
  my $self = shift;
  my $context = shift;
  
  print STDERR "Setting context of $self to $context\n" if( $debug > 50 );
  
  return if( $context eq $self->{'context'} );
  
  if( $self->{'context'} ) {
    $self->{'context'}->removeTerm( $self );
  }
  
  $self->{'context'} = $context;
  $context->addTerm( $self )  if( $context );
  for my $c ( $self->children() ) {
    $c->setContext( $context );
  }
}

sub termIdentifier {
  return '';
}

sub origIdentifier {
  return '';
}

sub comment {
  my $self = shift;
  my $id = shift or return $self->{'comment'};
  $self->{'comment'} = $id;
}

sub addPrefix {
  my $self = shift;
  my $prefix = shift;
  for my $c ( $self->children() ) {
    $c->addPrefix( $prefix );
  }
}

sub newChild {
  my $self = shift;
  my $cid = shift or undef;
  my $child = Sirius::vdex::term->new($cid);
  $child->{'parent'} = $self;
  $child->setContext( $self->{'context'} );
  push @{$self->{'children'}}, $child;
  return $child;
}

sub addChild {
  my $self = shift;
  my $c = shift;
  my $cc = $c->clone();
  $cc->{'parent'} = $self;
  $cc->setContext( $self->{'context'} );
  push @{$self->{'children'}}, $cc;
  return $cc;
}

sub addTerm {
  my $self = shift;
  my $term = shift;
  print STDERR "Adding $term to $self\n" if( $debug > 50 );
  $self->{'terms'}->{$term->origIdentifier()} = () 
    unless( $self->{'terms'}->{$term->origIdentifier()} );
  push @{$self->{'terms'}->{$term->origIdentifier()}}, $term;
}

sub removeTerm {
  my $self = shift;
  my $term = shift;
  my $id = $term->origIdentifier();
  print STDERR "Removing $term from $self\n" if( $debug > 50 );
  for( my $i = 0 ; $i < $#{$self->{'terms'}->{$id}} ; $i++ ) {
    if( $self->{'terms'}->{$id}[$i] eq $term ) {
      delete $self->{'terms'}->{$id}[$i];
      $i--;
    }
  }
}

sub weldFragment {
  my $self = shift;
  my $frag = shift;
  for $c ( $frag->children ) {
    $self->addChild( $c );
  }
}

sub findChild {
  my $self = shift;
  my $id = shift;
  for $c ( @{$self->{'children'}} ) {
    return $c if( $c->termIdentifier() eq $id );
  }
  return undef;
}

sub children {
  my $self = shift;
  return @{$self->{'children'}};
}

sub makeUniqueIdentifiers {
  my $self = shift;
  
  # WARNING We are about to run the world's most hiddeously inefficient
  # WARNING de-duplication algorithm - basically scanning the tree repeatedly
  # WARNING until we complete a whole scan without finding any more work to do.

  my $debug = 0;

  print STDERR "Looking for duplicate terms...\n" if( $debug );
  for $k ( keys ( %{ $self->{'terms'} } ) ) {
    for $terms ( $self->{'terms'}->{$k} ) {
    
      next if( $#{ $terms } < 1 ); # Max subscript is 0, ie no duplication.

      my $round = 0;
      my %changes = {};
      do {
	my %forcechange = {};
	$round++;
	print STDERR "De-duplicating '".$terms->[0]->origIdentifier()."' - round $round...\n" if( $debug > 10 );
	$change = 0;
	for $t ( @{ $terms } ) {
	  print STDERR "Instance $t: " if( $debug > 50 );
	  my $id = $t->termIdentifier();
	  my $oid = $t->origIdentifier();
	  print STDERR "termId is $id " if( $debug > 50 );
	  print STDERR "origId is $oid\n" if( $debug > 50 );
	  if( "$id" eq "$oid" ) {
	    # We haven't previously tried to resolve this, so stick
	    # the parent origIdentifier on the front.
	    $t->termIdentifier( $t->{'parent'}->origIdentifier().'.'
				.$t->termIdentifier() );
	    $change = 1;
	    $changes{"$t"}++;
	    print STDERR "Initially changed $oid $t from $id to '".$t->termIdentifier()."'\n" if( $debug );
	  }
	  else {
	    if( ( $round > $changes{"$t"} ) and not $forcechange{"$t"} ) {
	      # See if what we've done so far resolved the duplicate.
	      my $dup = 0;
	      for $s ( @{ $terms } ) {
		my $sid = $s->termIdentifier();
		next if( "$s" eq "$t" );	# Identity is not duplication.  Ask Leibniz.
		if( "$id" eq "$sid" ) {
		  my $mypath = '';
		  my $otherpath = '';
		  for( my $par = $t; $par->{'parent'}; $par=$par->{'parent'} ) {
		    $mypath = $par->origIdentifier().'/'.$mypath;
		  }
		  for( my $par = $s; $par->{'parent'}; $par=$par->{'parent'} ) {
		    $otherpath = $par->origIdentifier().'/'.$otherpath;
		  }
		  print STDERR "This term, '$id' at $mypath ($t), "
				."is a duplicate of '$sid' at $otherpath ($s).\n" if( $debug );
		  $dup = 1;
		  $forcechange{"$s"} = 1;
		}
	      }
	      next unless( $dup );
	    } # end $round > 1
	  
	    # FIXME This is sub-optimal.  Rather than insert the identifiers
	    # FIXME of parents which are common to the current term and the
	    # FIXME ones we're trying to distinuish it from.  We could
	    # FIXME find the branch at which the paths diverged.
	  
	    my @bits = split /\./, $id;
	    my @newbits = ();
	    my $tm = $t;
	    unshift @newbits, pop @bits; # Own identifier
	    while( @bits[0] ) {
	      unshift @newbits, pop @bits;         # move one identifier across
	      if( $tm->{'parent'} ) {              # if we have a parent term
		$tm = $tm->{'parent'};             # look at it
		my $pid = $tm->origIdentifier();
		next if( "$pid" eq $newbits[0] );  # round again if we already tried that
		
		push @bits, shift @newbits;	   # move the old prefix term id back
		unshift @newbits, $pid;            # insert the parent's id
		$t->termIdentifier( join '.', (@bits, @newbits) );
		print STDERR "Changed $oid $t from $id to '".$t->termIdentifier()."'\n" if( $debug );
		$change = 1;
		$changes{"$t"}++;
		last; 
	      }
	      print STDERR "Reached root node de-duping '".$t->termIdentifier()."'\n" if( $debug );
	    }
	  }

	}
      } until( $change == 0 );
    }
  }
}

sub sortUniq {
  my $self = shift;
  my %kids = ();
  for $c (@{$self->{'children'}} ) {
    my %captions = $c->captions();
    my @caps = sort keys %captions;
    $kids{ $caps[0] } = $c;
  }
  $self->{'children'} = ();
  for $c ( sort keys %kids ) {
    push @{$self->{'children'}}, $kids{$c};
  }
}

sub toXMLfrag {
  my $self = shift;
  my $r = '';

  $r .= '<!-- '.$self->comment()." -->\n\n" if( $self->comment() );

  for $c ( $self->children() ) {
    $r .= $c->toXMLfrag();
  }
  
  return $r;
}

1;
}

# ==============================================================

{
# Class representing a vdex term.  Holds the actual properties
# plus the child terms (which is how it extends the fragment class).

package Sirius::vdex::term;
@ISA = ('Sirius::vdex::fragment');

use URI::Escape;

sub new {
  my $class = shift;
  my $self = {};
  bless $self, $class;
  $self->termIdentifier( shift );
  $self->{'captions'} = {};
  $self->{'descriptions'} = {};
  $self->{'parent'} = undef;
  $self->{'comment'} = undef;
  $self->{'children'} = ();
  $self->{'context'} = undef;
  return $self;
}

sub clone {
  my $self = shift;
  my $clone = Sirius::vdex::term->new( $self->termIdentifier() );
  $clone->origIdentifier( $self->origIdentifier() );
  for my $t qw( captions descriptions comment ) {
    $clone->{$t} = $self->{$t}; # by value
  }
  for my $c ( $self->children() ) {
    $clone->addChild( $c->clone() );
  }
  return $clone;
}

sub termIdentifier {
  my $self = shift;
  my $id = shift or return $self->{'termIdentifier'};
  $self->origIdentifier( $id ) unless $self->origIdentifier();
  $self->{'termIdentifier'} = $id;
}

sub origIdentifier {
  my $self = shift;
  my $id = shift or return $self->{'origIdentifier'};
  if( $self->{'origIdentifier'} and $self->{'context'}) {
    $self->{'context'}->removeTerm( $self );
  }
  $self->{'origIdentifier'} = $id;
  if( $self->{'context'} ) {
    $self->{'context'}->addTerm( $self );
  }
}

sub addPrefix {
  my $self = shift;
  my $prefix = shift;
  $self->termIdentifier( $prefix.'.'.$self->termIdentifier() );
  for my $c ( $self->children() ) {
    $c->addPrefix( $prefix );
  }
  return $self->termIdentifier();
}

sub addCaption {
  my $self = shift;
  my $c = shift;
  my $l = shift;
  # HACK
  $c =~ s/\x{2019}/'/;
  # /HACK
  ${$self->{'captions'}}{$c} = $l;
}

sub captions {
  my $self = shift;
  return %{$self->{'captions'}};
}

sub addDescription {
  my $self = shift;
  my $c = shift;
  my $l = shift;
  ${$self->{'descriptions'}}{$c} = $l;
}

sub descriptions {
  my $self = shift;
  return %{$self->{'descriptions'}};
}


sub toXMLfrag {
  my $self = shift;
  my $r = '<term>';

  $r .= '<!-- '.$self->comment()." -->\n\n" if( $self->comment() );

  #$r .= '<termIdentifier>'.uri_escape_utf8($self->termIdentifier()).'</termIdentifier>';
  $r .= '<termIdentifier>'.Sirius::XML::escape::identifier_escape($self->termIdentifier()).'</termIdentifier>';
  
  my $c = '';
  for $cap ( keys %{$self->{'captions'}} ) {
    $c .= '<langstring'. ( $self->{'captions'}{$cap} ? 
	    ' language="'.$self->{'captions'}{$cap}.'">' :
	    '>' );
    $c .= Sirius::XML::escape::xml_escape($cap);
    $c .= '</langstring>';
  }
  $r .= '<caption>'.$c.'</caption>' if( $c );
  
  my $d = '';
  for $desc ( keys %{$self->{'descriptions'}} ) {
    $d .= '<langstring'. ( $self->{'descriptions'}{$desc} ? 
	    ' language="'.$self->{'descriptions'}{$desc}.'">' :
	    '>' );
    $d .= Sirius::XML::escape::xml_escape($desc);
    $d .= '</langstring>';
  }
  $r .= '<description>'.$d.'</description>' if( $d );
  
  for $c ( $self->children() ) {
    $r .= $c->toXMLfrag();
  }
  $r .= '</term>';
  
  return $r;
}

1;
}

# ==============================================================

{
# Package representing a whole vdex file.
# Like the term class, this is only a small extension of
# the fragment class.

package Sirius::vdex;
@ISA = ( "Sirius::vdex::fragment" );

use URI::Escape;

sub new {
  my $class = shift;
  my $name = shift;
  my $self = {};
  bless $self, $class;
  $self->{'vocabName'} = {};
  $self->{'comment '} = undef;
  $self->{'children'} = ();
  $self->addVocabName($name) if( $name );
  $self->{'context'} = $self;
  return $self;
}

sub clone {
  my $self = shift;
  my $clone = Sirius::vdex->new();
  for my $t qw( vocabName comment ) {
    $clone->{$t} = $self->{$t}; # by value
  }
  for my $c ( $self->children() ) {
    $clone->addChild( $c->clone() );
  }
  return $clone;
}

sub addVocabName {
  my $self = shift;
  my $c = shift;
  my $l = shift;
  ${$self->{'vocabName'}}{$c} = $l;
}

sub vocabName {
  my $self = shift;
  return %{$self->{'vocabName'}};
}

sub addPrefix {
  my $self = shift;
  my $prefix = shift;
  for my $c ( $self->children() ) {
    $c->addPrefix( $prefix );
  }
}

sub toXML {
  my $self = shift;
  my $r = '<?xml version="1.0" encoding="UTF-8"?>
    <vdex xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	  xmlns="http://www.imsglobal.org/xsd/imsvdex_v1p0"
	  xsi:schemaLocation="http://www.imsglobal.org/xsd/imsvdex_v1p0 http://www.imsglobal.org/xsd/imsvdex_v1p0.xsd"
	  orderSignificant="true"
	  profileType="hierarchicalTokenTerms"
	  language="en">'."\n\n";	# FIXME: Probably shouldn't hard-code language

  $r .= '<!-- '.$self->comment()." -->\n\n" if( $self->comment() );

  my $v = '';
  for $vn ( keys %{$self->{'vocabName'}} ) {
    $v .= '<langstring'. ( $self->{'vocabName'}{$vn} ? 
	    ' language="'.$self->{'vocabName'}{$vn}.'">' :
	    '>' );
    $v .= Sirius::XML::escape::xml_escape($vn);
    $v .= '</langstring>';
  }
  $r .= '<vocabName>'.$v.'</vocabName>' if( $v );
  for $c ( $self->children() ) {
    $r .= $c->toXMLfrag();
  }
  $r .= '</vdex>';
  
  return $r;
}

1;
}

# ==============================================================

$debug = 100;

use XML::LibXML;
use Switch;
use Date::Format;

my $parser = new XML::LibXML;

my $spec = $parser->parse_fh( STDIN );

my $guts = $spec->documentElement();

unless( ( $guts->getName() ) eq 'guts' ) {
  die("You must pass a Grand Unified Taxonomy Specfier on stdin.");
}

my $name = $guts->getAttribute( 'name' );
$name .= ' v'.$guts->getAttribute( 'version' ) if( $guts->getAttribute( 'version' ) );

my $vdex = Sirius::vdex->new( $name );

$vdex->comment('
  =============================================================='
  ."\n\n  = ndrb Grand Unified Taxonomy generated "
  .time2str( '%Y-%m-%d %H:%M:%S ', time() )." =\n"
  .'
  ==============================================================

  Copyright 2009 Sirius Corporation plc and Duncan Gibb
 
  This is Free Software, licenced under the GNU General Public
  License ("GPL").  Version 3 of the GPL shall apply unless a
  later version has been published by the Free Software
  Software Foundation ("FSF") at the time you receive this
  software, in which case that later version shall apply instead.
  At your your option, you may apply any version of the GPL
  published by the FSF later than that prescribed above.
 
  This software is supplied "as is" and "with all faults".
  There is ABSOLUTELY NO WARRANTY.  Please refer to the relevant
  section of the licence for more details.
 
  If you do not have a copy of the licence, please refer to
  <http://www.gnu.org/licenses/>.
  
  ==============================================================
 ' );

my $pointer = $vdex;
my @pstack = ();
my @c = $guts->childNodes();

guts_walk( @c );

$vdex->makeUniqueIdentifiers();

binmode STDOUT, ":utf8";
print $vdex->toXML();

exit;

################################################################

{
my %taxoncache = {};

sub guts_walk()
{
  unshift @pstack, $pointer;

  for $node (@_) {

    switch( $node->getName()){
    
      case '#text' {
	  # There should not be any non-empty text nodes in the spec file
	  # because all the magic is done with elements and attributes.
	  unless ( $node->textContent() =~ /^[\s]*$/ ) {
	    die( "Did not understand your spec at ".$node->nodeValue() );
	  }
	}

      case '#comment' {
	# Pass any comments in the source through to the output.
	my $c =  $node->textContent();
	$pointer->comment( $c ); # unless $pointer->comment();
      }

      case 'node' {
        # Spec nodes are one-to-one mappings to vdex nodes.
	unless ( $node->textContent() =~ /^[\s]*$/ ) {
	  die( "Did not understand your spec at ".$node->nodeValue() );
	}

	# We place the name attribute into the caption langstring,
	# and optionally the description into the description langstring
	
	my $name = $node->getAttribute('id');
	print STDERR "Creating vdex term for '$name'.\n" if( $debug );
	$pointer = $pointer->newChild( $name );
	$pointer->addCaption( $node->getAttribute('name') );
      }

      case 'taxon' {
	# This element imports an external taxonomy.
	# We cache the results of parsing these so we don't
	# have to download and process the sources multiple
	# times per run.  Zthes conversion is particularly slow.

	my $taxon;
	
	$src = $node->getAttribute('src');
	
	if( exists $taxoncache{$src} ) {
	  print STDERR "Using cached taxonomy to re-import $src\n" if( $debug );
	  $taxon = $taxoncache{$src}->clone();
	} else {
	  $taxon = new Sirius::vdex::fragment;
	  print STDERR "Importing external taxonomy from $src\n" if( $debug );
	  $tax = $parser->parse_file($src);
	  $trt = $tax->documentElement();
	  switch( $trt->getName() ) {

	      case 'Zthes' {
		$tax->indexElements();
		zthes_to_vdextree( $trt, $taxon );
	      }
	      
	      case 'vdex' {
		vdex_xml_import( $trt, $taxon );
	      }
	      
	      else {
		die("Could not process external taxonomy from ".$src)
	      }
	  }

	  $taxon->sortUniq();
	  $taxoncache{$src} = $taxon->clone();
	
	}

	if( $p = $node->getAttribute('prefix') ) {
	  $taxon->addPrefix( $p );
	}
	
	# Glue the results into the master tree.
	$pointer->weldFragment( $taxon );
	
      }

      else {
        print STDERR 'Ignoring unknown input: '.$node->getName().": ";
	@atts = $node->getAttributes();
	for $at (@atts) {
	  $na = $at -> getName();
	  $va = $at -> getValue();
	  print STDERR " ${na}[$va] ";
	}
	print STDERR "\n";
      }
    }

    # Recurse down the source tree.
    guts_walk( $node->childNodes() );

    $pointer = @pstack[0];
  }
  
  $pointer = shift @pstack;
}

} # End scope for %taxoncache

# ==============================================================

sub zthes_to_vdextree()
{
  $z = shift;
  $taxon = shift;

  # Convert a Zthes vocabulary into a section of vdex tree.
  # The logic and the XPath expressions in this routine are
  # inspired by Mark Cave-Ayland's earlier XSLT implementation,
  # with some additional guesswork based on the web presentation
  # at http://bank.vocman.com/bank-webapp/

  # Top level terms are Prefered Terms (PT) - or, in QCA
  # Cross-curricular Skills, Node Labels (NL) - which have zero
  # Broader Term (BT) relations.  There's probably a way to
  # express this as a single XPath, but for now just get all the
  # PTs and throw away any which do have a BT relation.

  # FIXME this is excruciatingly slow FIXME
  
  my @baseterms = ();
  my @terms = $z->findnodes("/Zthes/term[termType='PT' or termType='NL']");
  for $cand ( @terms ) {
    my @rels = $cand->findnodes("relation[relationType='BT']");
    if( -1 == $#rels ) {
      push @baseterms, $cand;
    }
  }
  
  for $zt ( @baseterms ) {
    my $t = $taxon->newChild( $zt->find('termId') );
    $t->addCaption( $zt->find('termName') );
    
    my $children = zthes_find_descendants( $zt );
    $t->weldFragment( $children );
  }
}

sub zthes_find_descendants()
{
  my $parent = shift;
  my $r = new Sirius::vdex::fragment;
  
  # If we ask the parent to name its children, we have to
  # do a second lookup per child to get the context in
  # which we can ask it to name the grandchildren.
  # Instead, search for all the terms in the thesaurus
  # with our current node as their parent.
  # There is a heavy tacit assumption here that the Zthes
  # input file is completely consistent.

  # FIXME This is very slow.  It is probably quicker FIXME
  # FIXME to look up the NT relation targets in the  FIXME
  # FIXME parent, then drag them out of the vdex by  FIXME
  # FIXME their identifiers.                         FIXME

  my $pid = $parent->find('termId');
  for my $zt ( $parent->findnodes("/Zthes/term/relation[relationType='BT' and termId='$pid']/..") )
  {
    my $termId = $zt->find('termId');
    my $termName = $zt->find('termName');
    my $t = $r->newChild($termId);
    $t->addCaption($termName);

    my $children = zthes_find_descendants( $zt );
    $t->weldFragment( $children );
  }

  $r->sortUniq();  
  return $r;
}

# ==============================================================

sub vdex_xml_import()
{
  $v = shift;
  $taxon = shift;

  for my $c ( $v->getChildrenByTagName('term') ) {
    my @ids = $c->getChildrenByTagName('termIdentifier');
    my $id = $ids[0]->textContent();
    my $t = $taxon->newChild( $id );
    
    my @caps = $c->getChildrenByTagName('caption');
    my @l = $caps[0]->getChildrenByTagName('langstring');
    
    $t->addCaption( $l[0]->textContent() );
        
    for my $g ( $c->getChildrenByTagName('term') ) {
      vdex_xml_import( $g, $t );
    }
    $t->sortUniq();
  }
}

# ==============================================================

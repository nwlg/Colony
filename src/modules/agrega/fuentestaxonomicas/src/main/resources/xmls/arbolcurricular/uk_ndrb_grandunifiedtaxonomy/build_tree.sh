#!/bin/bash 

# Make a mess
./spew_guts.pl <gut_spec.xml >/tmp/untidy.xml

# Tidy it up
xmllint --format /tmp/untidy.xml >../uk_ndrb_curriculum_tree_en.xml
rm /tmp/untidy.xml

# Make it multi-lingual ;-)
if [ -f ../uk_ndrb_curriculum_tree_en-gb.xml ]; then
	rm ../uk_ndrb_curriculum_tree_en-gb.xml
fi
ln -s uk_ndrb_curriculum_tree_en.xml ../uk_ndrb_curriculum_tree_en-gb.xml

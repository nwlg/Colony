<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xhtml11="http://www.w3.org/1999/xhtml" exclude-result-prefixes="xhtml11" version="1.0">
	<!-- =====================================================================================================
	Copyright (c) 2003  Belus Technology Inc.  All rights reserved.
	====================================================================================================== -->
	<xsl:output method="xml" indent="yes" omit-xml-declaration="yes"></xsl:output>

	<xsl:param name="lang">en</xsl:param>

	<!-- =====================================================================================================
	Localization
	====================================================================================================== -->
	<xsl:variable name="ucase">ABCDEFGHIJKLMNOPQRSTUVWXYZΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ</xsl:variable>
	<xsl:variable name="lcase">abcdefghijklmnopqrstuvwxyzαβγδεζηθικλμνξοπρστυφχψω</xsl:variable>


	<xsl:variable name="text-page-title">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Previsualización en el Lector de Pantalla</xsl:when>
			<xsl:otherwise>Screen Reader Preview</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>

	<xsl:variable name="alert-bold">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Este documento contiene una etiqueta &lt;b&gt;. Es mejor utilizar &lt;strong&gt;.</xsl:when>
			<xsl:otherwise>This document contains an &lt;b&gt; tag.  It is better to use &lt;strong&gt;.</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="alert-italic">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Este documento contiene una etiqueta &lt;i&gt;.  Es mejor utilizar &lt;em&gt;.</xsl:when>
			<xsl:otherwise>This document contains an &lt;i&gt; tag.  It is better to use &lt;em&gt;.</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="alert-alt">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Hace falta el texto alternativo de esta imagen.</xsl:when>
			<xsl:otherwise>The alt text for this image is missing.</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="alert-summary">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Hace falta el texto de resumen de esta imagen.</xsl:when>
			<xsl:otherwise>The summary text for this table is missing.</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="alert-bad-link-text">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Puede que este vínculo no resulte lo suficientemente claro si fuese leído independientemente</xsl:when>
			<xsl:otherwise>This link text may not be meaningful when read on its own</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-click-here">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">haga click aquí</xsl:when>
			<xsl:otherwise>click here</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-here">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">aquí</xsl:when>
			<xsl:otherwise>here</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-more">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">más</xsl:when>
			<xsl:otherwise>more</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-summary">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Resumen</xsl:when>
			<xsl:otherwise>Summary</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-caption">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Subtítulo</xsl:when>
			<xsl:otherwise>Caption</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-separator">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Separador</xsl:when>
			<xsl:otherwise>Separator</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>

	<xsl:variable name="text-quotation">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Comillas</xsl:when>
			<xsl:otherwise>Quotation</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-image">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Imagen</xsl:when>
			<xsl:otherwise>Image</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-abbreviation">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">abreviación</xsl:when>
			<xsl:otherwise>abbreviation</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-acronym">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">acrónimo</xsl:when>
			<xsl:otherwise>acronym</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-cite">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">citación</xsl:when>
			<xsl:otherwise>citation</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-code">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">código</xsl:when>
			<xsl:otherwise>code</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-definition">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">definición</xsl:when>
			<xsl:otherwise>definition</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>

	<xsl:variable name="text-kbd">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">golpes de tecla</xsl:when>
			<xsl:otherwise>keystrokes</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-samp">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">ejemplo</xsl:when>
			<xsl:otherwise>example</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	
	<xsl:variable name="text-var">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">variable</xsl:when>
			<xsl:otherwise>variable</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>


	<xsl:variable name="alert-decorative-image">
		<xsl:choose>
			<xsl:when test="$lang = 'es'">Esta es una imagen decorativa que será ignorada por las tecnologías de ayuda.</xsl:when>
			<xsl:otherwise>This is a decorative image that will be ignored by assistive technologies.</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>



	<!-- =====================================================================================================
	Root node
	====================================================================================================== -->
	<xsl:template match="/">
		<xsl:variable name="dir">
			<xsl:choose>
				<xsl:when test="string(/xhtml11:html/@dir) != ''"><xsl:value-of select="/xhtml11:html/@dir"></xsl:value-of></xsl:when>
				<xsl:when test="string(/html/@dir) != ''"><xsl:value-of select="/html/@dir"></xsl:value-of></xsl:when>
				<xsl:otherwise>ltr</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html PUBLIC &quot;-//W3C//DTD XHTML 1.0 Strict//EN&quot; &quot;http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd&quot;&gt;
			&lt;!-- saved from url=(0021)http://xstandard.com/ --&gt;
		</xsl:text>
		<html xmlns="http://www.w3.org/1999/xhtml" dir="{$dir}">
			<head>
				<title><xsl:value-of select="$text-page-title"></xsl:value-of></title>
				<style type="text/css">
					body {font-family:arial;font-size:.8em;color:black}
					span.image {border:1px solid silver;padding:1px;text-align:center;background-color:#dcdcdc}
					div.table {border:1px solid silver;padding:5px;margin:5px}
					div.cell {border:1px solid silver;padding:5px;margin:5px}
					div.blockquote {margin-left:40px;margin-right:40px;font-style:italic}
					div.error {border:1px solid black;background-color:yellow;padding:5px;margin:5px}
					span.metadata {font-family:arial;color:black;background-color:#ccffcc}
					span.abbr {font-family:arial;border-bottom:1px dashed}
					span.acronym {font-family:arial;border-bottom:1px dashed}
					span.cite {font-family:arial;font-style:italic}
					span.code {font-family:courier, monospace}
					span.dfn {font-family:arial;border-bottom:1px dashed}
					span.kbd {font-family:courier, monospace}
					span.samp {font-family:courier, monospace}
					span.var {font-family:courier, monospace;font-style:italic}
					span.error {background-color:yellow}
					div.report {border:0px;background-color:yellow;padding:5px}
				</style>
			</head>
			<body>
				<!-- =====================================================================================================
				Report any errors
				====================================================================================================== -->
				<xsl:if test="descendant::b|descendant::xhtml11:b">
					<div class="report"><xsl:value-of select="$alert-bold"></xsl:value-of></div>
				</xsl:if>
				<xsl:if test="descendant::i|descendant::xhtml11:i">
					<div class="report"><xsl:value-of select="$alert-italic"></xsl:value-of></div>
				</xsl:if>

				
				<!-- =====================================================================================================
				Checkpoint 13.1 - Clearly identify the target of each link
				====================================================================================================== -->
				<xsl:for-each select="descendant::a[@href]|descendant::xhtml11:a[@href]">
					<xsl:if test="translate(text(), $ucase, $lcase) = translate($text-more, $ucase, $lcase) or translate(text(), $ucase, $lcase) = translate($text-here, $ucase, $lcase) or translate(text(), $ucase, $lcase) = translate($text-click-here, $ucase, $lcase)">
						<div class="report"><xsl:value-of select="$alert-bad-link-text"></xsl:value-of>: <xsl:value-of select="text()"></xsl:value-of></div>
					</xsl:if>
				</xsl:for-each>
				
				<xsl:apply-templates></xsl:apply-templates>
			</body>
		</html>
	</xsl:template>

	<!-- =====================================================================================================
	Match optional document structure tags
	====================================================================================================== -->
	<xsl:template match="html|body|xhtml11:html|xhtml11:body">
		<xsl:apply-templates></xsl:apply-templates>
	</xsl:template>

	<!-- =====================================================================================================
	Match elements supported by screen readers
	====================================================================================================== -->
	<xsl:template match="h1|h2|h3|h4|h5|h6|p|div|strong|em|ol|ul|li|dl|dt|dd|xhtml11:h1|xhtml11:h2|xhtml11:h3|xhtml11:h4|xhtml11:h5|xhtml11:h6|xhtml11:p|xhtml11:div|xhtml11:strong|xhtml11:em|xhtml11:ol|xhtml11:ul|xhtml11:li|xhtml11:dl|xhtml11:dt|xhtml11:dd">
		<xsl:element name="{name()}">
			<xsl:if test="string(@dir) != ''">
				<xsl:attribute name="dir"><xsl:value-of select="@dir"></xsl:value-of></xsl:attribute>
			</xsl:if>
			<xsl:apply-templates></xsl:apply-templates>
		</xsl:element>
	</xsl:template>

	<!-- =====================================================================================================
	Match elements not supported by screen readers
	====================================================================================================== -->
	<xsl:template match="style|base|title|script|link|meta|object|xhtml11:style|xhtml11:base|xhtml11:title|xhtml11:script|xhtml11:link|xhtml11:meta|xhtml11:object">

	</xsl:template>

	<!-- =====================================================================================================
	Match noscript
	====================================================================================================== -->
	<xsl:template match="noscript|xhtml11:noscript">
		<xsl:apply-templates></xsl:apply-templates>
	</xsl:template>


	<!-- =====================================================================================================
	Match hyperlink
	====================================================================================================== -->
	<xsl:template match="a[@href]|xhtml11:a[@href]">
		<a href="{@href}" onclick="return false;" onkeypress="return false;">
			<xsl:choose>
				<xsl:when test="translate(text(), $ucase, $lcase) = translate($text-more, $ucase, $lcase) or translate(text(), $ucase, $lcase) = translate($text-here, $ucase, $lcase) or translate(text(), $ucase, $lcase) = translate($text-click-here, $ucase, $lcase)"><span class="error"><xsl:apply-templates></xsl:apply-templates></span></xsl:when>
				<xsl:otherwise><xsl:apply-templates></xsl:apply-templates></xsl:otherwise>
			</xsl:choose>
		</a>
	</xsl:template>

	<!-- =====================================================================================================
	Match abbreviation
	====================================================================================================== -->
	<xsl:template match="abbr|xhtml11:abbr">
		<xsl:if test="(ancestor::abbr or ancestor::xhtml11:abbr or ancestor::acronym or ancestor::xhtml11:acronym or ancestor::dfn or ancestor::xhtml11:dfn) = false"><span class="abbr"><xsl:value-of select="."></xsl:value-of></span><xsl:text> </xsl:text></xsl:if><span class="metadata">[<xsl:value-of select="$text-abbreviation"></xsl:value-of><xsl:if test="string(@title) != ''">: <xsl:value-of select="@title"></xsl:value-of></xsl:if>]</span>
		<xsl:apply-templates select="child::*"></xsl:apply-templates>
	</xsl:template>
	
	<!-- =====================================================================================================
	Match acronym
	====================================================================================================== -->
	<xsl:template match="acronym|xhtml11:acronym">
		<xsl:if test="(ancestor::abbr or ancestor::xhtml11:abbr or ancestor::acronym or ancestor::xhtml11:acronym or ancestor::dfn or ancestor::xhtml11:dfn) = false"><span class="acronym"><xsl:value-of select="."></xsl:value-of></span><xsl:text> </xsl:text></xsl:if><span class="metadata">[<xsl:value-of select="$text-acronym"></xsl:value-of><xsl:if test="string(@title) != ''">: <xsl:value-of select="@title"></xsl:value-of></xsl:if>]</span>
		<xsl:apply-templates select="child::*"></xsl:apply-templates>
	</xsl:template>

	<!-- =====================================================================================================
	Match cite
	====================================================================================================== -->
	<xsl:template match="cite|xhtml11:cite">
		<span class="metadata">[<xsl:value-of select="$text-cite"></xsl:value-of>]</span><xsl:text> </xsl:text><span class="cite"><xsl:apply-templates></xsl:apply-templates></span>
	</xsl:template>

	<!-- =====================================================================================================
	Match definition
	====================================================================================================== -->
	<xsl:template match="dfn|xhtml11:dfn">
		<xsl:if test="(ancestor::abbr or ancestor::xhtml11:abbr or ancestor::acronym or ancestor::xhtml11:acronym or ancestor::dfn or ancestor::xhtml11:dfn) = false"><span class="dfn"><xsl:value-of select="."></xsl:value-of></span><xsl:text> </xsl:text></xsl:if><span class="metadata">[<xsl:value-of select="$text-definition"></xsl:value-of><xsl:if test="string(@title) != ''">: <xsl:value-of select="@title"></xsl:value-of></xsl:if>]</span>
		<xsl:apply-templates select="child::*"></xsl:apply-templates>
	</xsl:template>

	<!-- =====================================================================================================
	Match code
	====================================================================================================== -->
	<xsl:template match="code|xhtml11:code">
		<span class="metadata">[<xsl:value-of select="$text-code"></xsl:value-of>]</span><xsl:text> </xsl:text><span class="code"><xsl:apply-templates></xsl:apply-templates></span>
	</xsl:template>

	<!-- =====================================================================================================
	Match keystrokes
	====================================================================================================== -->
	<xsl:template match="kbd|xhtml11:kbd">
		<span class="metadata">[<xsl:value-of select="$text-kbd"></xsl:value-of>]</span><xsl:text> </xsl:text><span class="kbd"><xsl:apply-templates></xsl:apply-templates></span>
	</xsl:template>
	
	<!-- =====================================================================================================
	Match example
	====================================================================================================== -->
	<xsl:template match="samp|xhtml11:samp">
		<span class="metadata">[<xsl:value-of select="$text-samp"></xsl:value-of>]</span><xsl:text> </xsl:text><span class="samp"><xsl:apply-templates></xsl:apply-templates></span>
	</xsl:template>
	
	<!-- =====================================================================================================
	Match variable
	====================================================================================================== -->
	<xsl:template match="var|xhtml11:var">
		<span class="metadata">[<xsl:value-of select="$text-var"></xsl:value-of>]</span><xsl:text> </xsl:text><span class="var"><xsl:apply-templates></xsl:apply-templates></span>
	</xsl:template>

	<!-- =====================================================================================================
	Match bold and italic
	====================================================================================================== -->
	<xsl:template match="b|i|xhtml11:b|xhtml11:i">
		<span class="error">
			<xsl:element name="{name()}">
				<xsl:apply-templates></xsl:apply-templates>
			</xsl:element>
		</span>
	</xsl:template>

	<!-- =====================================================================================================
	Match image
	====================================================================================================== -->
	<xsl:template match="img|xhtml11:img">
		<xsl:choose>
			<xsl:when test="@alt">
				<xsl:choose>
					<xsl:when test="string(@alt) = ''">
						<span class="error"><xsl:value-of select="$text-image"></xsl:value-of>: <xsl:value-of select="$alert-decorative-image"></xsl:value-of></span>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text> </xsl:text><span class="image"><xsl:value-of select="@alt"></xsl:value-of></span><xsl:text> </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<span class="error"><xsl:value-of select="$text-image"></xsl:value-of>: <xsl:value-of select="$alert-alt"></xsl:value-of></span>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- =====================================================================================================
	Match long quotation
	====================================================================================================== -->
	<xsl:template match="blockquote|xhtml11:blockquote">
		<div>
			<span class="metadata">[<xsl:value-of select="$text-quotation"></xsl:value-of>]</span>:
			<div class="blockquote">
				<xsl:apply-templates></xsl:apply-templates>
			</div>
		</div>
	</xsl:template>


	<!-- =====================================================================================================
	Match short quotation
	====================================================================================================== -->
	<xsl:template match="q|xhtml11:q">
		<xsl:choose>
			<xsl:when test="ancestor::q">'<xsl:apply-templates></xsl:apply-templates>'</xsl:when>
			<xsl:otherwise>&quot;<xsl:apply-templates></xsl:apply-templates>&quot;</xsl:otherwise>
		</xsl:choose>
	</xsl:template>


	<!-- =====================================================================================================
	Match preformatted text
	====================================================================================================== -->
	<xsl:template match="pre|xhtml11:pre">
		<xsl:element name="div">
			<xsl:if test="string(@dir) != ''">
				<xsl:attribute name="dir"><xsl:value-of select="@dir"></xsl:value-of></xsl:attribute>
			</xsl:if>
			<xsl:apply-templates></xsl:apply-templates>
		</xsl:element>
	</xsl:template>

	
	<!-- =====================================================================================================
	Match hr
	====================================================================================================== -->
	<xsl:template match="hr|xhtml11:hr">
		<div>[<xsl:value-of select="$text-separator"></xsl:value-of>]</div>
	</xsl:template>

	<!-- =====================================================================================================
	Match br
	====================================================================================================== -->
	<xsl:template match="br|xhtml11:br">
		<br></br>
	</xsl:template>

	<!-- =====================================================================================================
	Match table
	====================================================================================================== -->
	<xsl:template match="table|xhtml11:table">
		<!-- =====================================================================================================
		Indentify the table as a data table|a layout table
		====================================================================================================== -->
		<xsl:choose>
			<xsl:when test="descendant::th|descendant::thead|descendant::tbody|descendant::tfoot|descendant::td/@headers|descendant::caption|descendant::tr/@title|descendant::td/@title|@title|descendant::xhtml11:th|descendant::xhtml11:thead|descendant::xhtml11:tbody|descendant::xhtml11:tfoot|descendant::xhtml11:td/@headers|descendant::xhtml11:caption|descendant::xhtml11:tr/@title|descendant::xhtml11:td/@title">
				<div class="table">
					<!-- =====================================================================================================
					Render table caption
					====================================================================================================== -->
					<xsl:for-each select="caption|xhtml11:caption">
						<div><strong><xsl:value-of select="$text-caption"></xsl:value-of></strong>: <xsl:apply-templates></xsl:apply-templates></div>
					</xsl:for-each>

					<!-- =====================================================================================================
					Render table summary
					====================================================================================================== -->
					<xsl:choose>
						<xsl:when test="string(@summary) = ''">
							<div class="error"><xsl:value-of select="$alert-summary"></xsl:value-of></div>
						</xsl:when>
						<xsl:otherwise>
							<div><strong><xsl:value-of select="$text-summary"></xsl:value-of></strong>: <xsl:value-of select="@summary"></xsl:value-of></div>
						</xsl:otherwise>
					</xsl:choose>
					
					<!-- =====================================================================================================
					Serialize table cells
					====================================================================================================== -->
					<xsl:for-each select="descendant::tr[td]|descendant::xhtml11:tr[td]">
						<div class="cell">
							<xsl:for-each select="td|xhtml11:td">
								<xsl:variable name="headers"><xsl:value-of select="string(@headers)"></xsl:value-of></xsl:variable>
								<xsl:for-each select="(ancestor::table//th[string(@id) != '' and (string(@id) = $headers or contains($headers, concat(' ', string(@id))) or contains($headers, concat(string(@id), ' ')))]) | (ancestor::xhtml11:table//xhtml11:th[string(@id) != '' and (string(@id) = $headers or contains($headers, concat(' ', string(@id))) or contains($headers, concat(string(@id), ' ')))])">
									<strong>
										<xsl:choose>
											<xsl:when test="string(@abbr) != ''"><xsl:value-of select="@abbr"></xsl:value-of></xsl:when>
											<xsl:otherwise><xsl:value-of select="."></xsl:value-of></xsl:otherwise>
										</xsl:choose>

										<xsl:if test="position() != last()">
											<xsl:text> / </xsl:text>
										</xsl:if>
									</strong>
								</xsl:for-each>

								<xsl:text>: </xsl:text>
								
								<xsl:apply-templates></xsl:apply-templates>
								<xsl:if test="position() != last()">
									<xsl:text>, </xsl:text>
								</xsl:if>
							</xsl:for-each>
						</div>
					</xsl:for-each>
				</div>
			</xsl:when>
			<xsl:otherwise>
				<!-- =====================================================================================================
				Layout table
				====================================================================================================== -->
				<div class="table">
					<xsl:for-each select="tr|xhtml11:tr">
						<xsl:for-each select="td|xhtml11:tr">
							<div class="cell">
								<xsl:apply-templates></xsl:apply-templates>
							</div>
						</xsl:for-each>
					</xsl:for-each>
				</div>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- =====================================================================================================
	Match any text
	====================================================================================================== -->
	<xsl:template match="text()">
		<xsl:value-of select="."></xsl:value-of>
	</xsl:template>
</xsl:stylesheet>

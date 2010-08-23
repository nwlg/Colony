<xsl:stylesheet version="2.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:imsmd="http://www.imsglobal.org/xsd/imsmd_v1p2"
xmlns="http://www.imsglobal.org/xsd/imscp_v1p1" 
xmlns:ns1="http://www.imsglobal.org/xsd/imscp_v1p1" 
xmlns:lomes="http://ltsc.ieee.org/xsd/LOM" 
xmlns:xsi="http://www.w3.org/2001/XML-Schema-instance"
xmlns:imsss="http://www.imsglobal.org/xsd/imsss" 
xmlns:adlseq="http://www.adlnet.org/xsd/adlseq_v1p3"
xmlns:adlnav="http://www.adlnet.org/xsd/adlnav_v1p3"
>


	<xsl:output indent="yes" encoding="UTF-8" method="xml"/>

	<xsl:template match="/">
		<xsl:element name="manifest" >
			<xsl:namespace name="xsi" select="'http://www.w3.org/2001/XMLSchema-instance'"/>
			<xsl:attribute name="xsi:schemaLocation">
				<xsl:text>http://www.imsglobal.org/xsd/imscp_v1p1 imscp_v1p1.xsd  http://www.imsglobal.org/xsd/imsmd_v1p2 imsmd_v1p2p4.xsd</xsl:text>
			</xsl:attribute>
			
			<xsl:attribute name="identifier">
				<xsl:value-of select="/ns1:manifest/@identifier"/>
			</xsl:attribute>
			<xsl:if test="/ns1:manifest/@version"><xsl:attribute name="version"><xsl:text>IMS CP 1.1.4</xsl:text></xsl:attribute></xsl:if>
			<xsl:if test="/ns1:manifest/@xml:base"><xsl:attribute name="xml:base"><xsl:value-of select="/ns1:manifest/@xml:base"/> </xsl:attribute></xsl:if>

			<xsl:apply-templates select="/ns1:manifest/ns1:metadata"/>
			<xsl:element name="organizations">
				<xsl:apply-templates select="/ns1:manifest/ns1:organizations/@*"/>
				<xsl:apply-templates select="/ns1:manifest/ns1:organizations/*"/>
			</xsl:element>
			
			<xsl:element name="resources">
				<xsl:apply-templates select="/ns1:manifest/ns1:resources/@*"/>
				<xsl:apply-templates select="/ns1:manifest/ns1:resources/*"/>
			</xsl:element>

			<xsl:apply-templates select="/ns1:manifest/ns1:manifest"/>

		</xsl:element>
	</xsl:template>

	<xsl:template match="ns1:metadata">
		<xsl:element name="metadata">
			<xsl:if  test = "local-name(./..) = 'manifest' ">
				<xsl:element name="schema">
					<xsl:text>IMS Content</xsl:text>
				</xsl:element>
				<xsl:element name="schemaversion">
					<xsl:text>1.1</xsl:text>
				</xsl:element>
			</xsl:if>
			<xsl:apply-templates select="lomes:lom"/>
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns1:organizations">
		<xsl:element name="organizations">
			<xsl:apply-templates select="@*|*"/>			
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns1:organization" >
		<xsl:element name="organization">
			<xsl:apply-templates select="@*|*"/>
		</xsl:element>
	</xsl:template>

	<xsl:template match="@*" >
            	<xsl:attribute name = "{name()}">
			<xsl:value-of select = "."/>
		</xsl:attribute>
	</xsl:template>

	<xsl:template match="*" >
		<xsl:element name="{name()}" >
			<xsl:apply-templates select="@*"/>
			<xsl:if  test="descendant::*" >
				<xsl:apply-templates select="*"/>
			</xsl:if>
			<xsl:if test="not(descendant::*)" >
				<xsl:value-of select="."/>
			</xsl:if>
		</xsl:element>
	</xsl:template>
	

	<xsl:template match="lomes:*">
		<xsl:element name="imsmd:{local-name()}"  >
			<xsl:apply-templates select="@*"/>
			<xsl:if  test="descendant::*" >
				<xsl:apply-templates select="*"/>
			</xsl:if>
			<xsl:if test="not(descendant::*)" >
				<xsl:value-of select="."/>
			</xsl:if>
		</xsl:element>
	</xsl:template>

	<xsl:template match="imsss:*|adlseq:*|adlnav:*">
	</xsl:template>

</xsl:stylesheet>
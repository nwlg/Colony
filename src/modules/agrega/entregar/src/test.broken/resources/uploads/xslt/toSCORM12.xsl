<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:imsmd="http://www.imsglobal.org/xsd/imsmd_v1p2"
	xmlns:lomes="http://ltsc.ieee.org/xsd/LOM"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:ns2="http://www.adlnet.org/xsd/adlcp_v1p3" 
	xmlns:ns1="http://www.imsglobal.org/xsd/imscp_v1p1" 
	xmlns:adlcp="http://www.adlnet.org/xsd/adlcp_rootv1p2"
	xmlns:imsss="http://www.imsglobal.org/xsd/imsss" 
	xmlns:adlseq="http://www.adlnet.org/xsd/adlseq_v1p3"
	xmlns:adlnav="http://www.adlnet.org/xsd/adlnav_v1p3"

	exclude-result-prefixes="ns1 ns2" >
	


	<xsl:output indent="yes" encoding="UTF-8" method="xml"/>
	<xsl:strip-space elements="*"/>

	<xsl:template match="/" >
		<xsl:element name="manifest" >
			<xsl:attribute name="xsi:schemaLocation">
				<xsl:text>http://www.imsproject.org/xsd/imscp_rootv1p1p2 imscp_rootv1p1p2.xsd http://www.imsglobal.org/xsd/imsmd_rootv1p2p1 imsmd_rootv1p2p1.xsd http://www.adlnet.org/xsd/adlcp_rootv1p2 adlcp_rootv1p2.xsd</xsl:text>
			</xsl:attribute>
			<xsl:attribute name="identifier"><xsl:value-of select="/ns1:manifest/@identifier"/></xsl:attribute>
			<xsl:if test="/ns1:manifest/@version"><xsl:attribute name="version"><xsl:text>1.2</xsl:text></xsl:attribute></xsl:if>
			<xsl:if test="/ns1:manifest/@xml:base"><xsl:attribute name="xml:base"><xsl:value-of select="/ns1:manifest/@xml:base"/> </xsl:attribute></xsl:if>
			

			<xsl:apply-templates select="/ns1:manifest/ns1:metadata"/>
			
			<xsl:element name="organizations">
				<xsl:if test="/ns1:manifest/ns1:organizations/@default">
					<xsl:attribute name="default">
						<xsl:value-of select="/ns1:manifest/ns1:organizations/@default"/>
					</xsl:attribute>
				</xsl:if>
				<xsl:apply-templates select="/ns1:manifest/ns1:organizations/*"/>
			</xsl:element>
			
			<xsl:element name="resources">
				<xsl:if test="/ns1:manifest/ns1:resources/@xml:base"><xsl:attribute name="xml:base"><xsl:value-of select="/ns1:manifest/ns1:resources/@xml:base"/></xsl:attribute></xsl:if>
				<xsl:apply-templates select="/ns1:manifest/ns1:resources/*"/>
			</xsl:element>
			<xsl:apply-templates select="/ns1:manifest/ns1:manifest"/>
		</xsl:element>
	</xsl:template>


	<xsl:template match="ns1:metadata">
		<xsl:element name="metadata">
			<xsl:if  test = "local-name(./..) = 'manifest' ">
				<xsl:if test="ns1:schema">
					<xsl:element name="schema">
						<xsl:text>ADL SCORM</xsl:text>
					</xsl:element>
				</xsl:if>
				<xsl:if test="ns1:schemaversion">
					<xsl:element name="schemaversion">
						<xsl:text>1.2</xsl:text>
					</xsl:element>
				</xsl:if>
			</xsl:if>
			<xsl:apply-templates select="lomes:lom"/>
			<xsl:apply-templates select="adlcp:location"/>
		</xsl:element>
	</xsl:template>




	<xsl:template match="ns1:resource">
		<xsl:element name="resource">
			<xsl:attribute name="identifier">
				<xsl:value-of select="@identifier"/>
			</xsl:attribute>
			<xsl:attribute name="type">
				<xsl:value-of select="@type"/>
			</xsl:attribute>
			<xsl:if test="@href">
				<xsl:attribute name="href">
					<xsl:value-of select="@href"/>
				</xsl:attribute>
			</xsl:if>
			<xsl:attribute name="adlcp:scormType">
				<xsl:value-of select="@ns2:scormType"/>
			</xsl:attribute>
			<xsl:if test="@xml:base">
				<xsl:attribute name="xml:base"><xsl:value-of select="@xml:base"/></xsl:attribute>
			</xsl:if>

			
			<xsl:apply-templates select="./*"/>
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
	
	<xsl:template match="imsss:*|adlseq:*|adlnav:*">
	</xsl:template>

</xsl:stylesheet>
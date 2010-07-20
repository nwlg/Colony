<#ftl ns_prefixes={"D":"http://www.imsglobal.org/xsd/imscp_v1p1",
					"xml":"http://www.w3.org/XML/1998/namespace",
					"lomes":"http://ltsc.ieee.org/xsd/LOM"}
	strip_whitespace=true>
<#recurse doc>

<#macro manifest>
<?xml version="1.0" encoding="UTF-8"?>
<lomes:lom xmlns:lomes="http://ltsc.ieee.org/xsd/LOM" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://ltsc.ieee.org/xsd/LOM lomCustom.xsd" xsi:type="lomes:lom">
<#list doc.manifest.metadata['lomes:lom'].*  as lom>
	<#if lom?node_type ='element'><#visit lom></#if>
</#list>
</lomes:lom>
</#macro>




<#macro @element>
<#if .node?node_type = 'element'>
	<#assign attr="">
	<#list .node.@@  as at>
	<#if at?node_name != 'uniqueElementName'>
		<#assign attr='${attr} ${at?node_name}="${at}"' >
	</#if>
	</#list>
	<lomes:${.node?node_name} ${attr}><#recurse></lomes:${.node?node_name}>
</#if>
</#macro>


<#macro @text>${.node?xml}</#macro>


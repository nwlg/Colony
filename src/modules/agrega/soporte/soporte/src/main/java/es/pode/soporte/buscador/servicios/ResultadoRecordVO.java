/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * ResultadoRecordVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.pode.soporte.buscador.servicios;


/**
 * Este objeto de valor representa la informacion relativa a un
 *                         registro del indice que satisface los campos
 * necesarios en el
 *                         Dublin Core que estan indexados en el repositorio.
 */
public class ResultadoRecordVO  implements java.io.Serializable {
    /* Identificador del ODE dentro del repositorio. */
    private java.lang.String identificador;

    /* Titulo del ODE. */
    private java.lang.String titulo;

    /* Iidoma de catalogacion del ODE. */
    private java.lang.String idioma;

    /* Descripcion del ODE. */
    private java.lang.String descripcion;

    /* Palabras clave del ODE. */
    private java.lang.String[] tema;

    /* Ambitos del ODE. */
    private java.lang.String[] ambito;

    /* Tipo de recurso. */
    private java.lang.String[] tipo;

    /* Fecha de publicacion del ODE. */
    private java.lang.String fecha;

    /* Autores del ODE. */
    private java.lang.String[] autores;

    /* Formatos presentes en el ODE. */
    private java.lang.String[] formatos;

    /* Licencias a las que esta sujeto el contenido del ODE. */
    private java.lang.String[] derechos;

    /* Contribuciones al ODE. */
    private java.lang.String[] contribuidor;

    /* Publicadores del ODE. */
    private java.lang.String[] publicador;

    /* Relaciones del ODE con otros elementos. */
    private java.lang.String[] relacion;

    /* Identificadores de elementos que pueden considerarse fuente
     * del
     *                                 ODE. */
    private java.lang.String[] fuente;

    public ResultadoRecordVO() {
    }

    public ResultadoRecordVO(
           java.lang.String identificador,
           java.lang.String titulo,
           java.lang.String idioma,
           java.lang.String descripcion,
           java.lang.String[] tema,
           java.lang.String[] ambito,
           java.lang.String[] tipo,
           java.lang.String fecha,
           java.lang.String[] autores,
           java.lang.String[] formatos,
           java.lang.String[] derechos,
           java.lang.String[] contribuidor,
           java.lang.String[] publicador,
           java.lang.String[] relacion,
           java.lang.String[] fuente) {
           this.identificador = identificador;
           this.titulo = titulo;
           this.idioma = idioma;
           this.descripcion = descripcion;
           this.tema = tema;
           this.ambito = ambito;
           this.tipo = tipo;
           this.fecha = fecha;
           this.autores = autores;
           this.formatos = formatos;
           this.derechos = derechos;
           this.contribuidor = contribuidor;
           this.publicador = publicador;
           this.relacion = relacion;
           this.fuente = fuente;
    }


    /**
     * Gets the identificador value for this ResultadoRecordVO.
     * 
     * @return identificador   * Identificador del ODE dentro del repositorio.
     */
    public java.lang.String getIdentificador() {
        return identificador;
    }


    /**
     * Sets the identificador value for this ResultadoRecordVO.
     * 
     * @param identificador   * Identificador del ODE dentro del repositorio.
     */
    public void setIdentificador(java.lang.String identificador) {
        this.identificador = identificador;
    }


    /**
     * Gets the titulo value for this ResultadoRecordVO.
     * 
     * @return titulo   * Titulo del ODE.
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this ResultadoRecordVO.
     * 
     * @param titulo   * Titulo del ODE.
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }


    /**
     * Gets the idioma value for this ResultadoRecordVO.
     * 
     * @return idioma   * Iidoma de catalogacion del ODE.
     */
    public java.lang.String getIdioma() {
        return idioma;
    }


    /**
     * Sets the idioma value for this ResultadoRecordVO.
     * 
     * @param idioma   * Iidoma de catalogacion del ODE.
     */
    public void setIdioma(java.lang.String idioma) {
        this.idioma = idioma;
    }


    /**
     * Gets the descripcion value for this ResultadoRecordVO.
     * 
     * @return descripcion   * Descripcion del ODE.
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ResultadoRecordVO.
     * 
     * @param descripcion   * Descripcion del ODE.
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the tema value for this ResultadoRecordVO.
     * 
     * @return tema   * Palabras clave del ODE.
     */
    public java.lang.String[] getTema() {
        return tema;
    }


    /**
     * Sets the tema value for this ResultadoRecordVO.
     * 
     * @param tema   * Palabras clave del ODE.
     */
    public void setTema(java.lang.String[] tema) {
        this.tema = tema;
    }


    /**
     * Gets the ambito value for this ResultadoRecordVO.
     * 
     * @return ambito   * Ambitos del ODE.
     */
    public java.lang.String[] getAmbito() {
        return ambito;
    }


    /**
     * Sets the ambito value for this ResultadoRecordVO.
     * 
     * @param ambito   * Ambitos del ODE.
     */
    public void setAmbito(java.lang.String[] ambito) {
        this.ambito = ambito;
    }


    /**
     * Gets the tipo value for this ResultadoRecordVO.
     * 
     * @return tipo   * Tipo de recurso.
     */
    public java.lang.String[] getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this ResultadoRecordVO.
     * 
     * @param tipo   * Tipo de recurso.
     */
    public void setTipo(java.lang.String[] tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the fecha value for this ResultadoRecordVO.
     * 
     * @return fecha   * Fecha de publicacion del ODE.
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ResultadoRecordVO.
     * 
     * @param fecha   * Fecha de publicacion del ODE.
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the autores value for this ResultadoRecordVO.
     * 
     * @return autores   * Autores del ODE.
     */
    public java.lang.String[] getAutores() {
        return autores;
    }


    /**
     * Sets the autores value for this ResultadoRecordVO.
     * 
     * @param autores   * Autores del ODE.
     */
    public void setAutores(java.lang.String[] autores) {
        this.autores = autores;
    }


    /**
     * Gets the formatos value for this ResultadoRecordVO.
     * 
     * @return formatos   * Formatos presentes en el ODE.
     */
    public java.lang.String[] getFormatos() {
        return formatos;
    }


    /**
     * Sets the formatos value for this ResultadoRecordVO.
     * 
     * @param formatos   * Formatos presentes en el ODE.
     */
    public void setFormatos(java.lang.String[] formatos) {
        this.formatos = formatos;
    }


    /**
     * Gets the derechos value for this ResultadoRecordVO.
     * 
     * @return derechos   * Licencias a las que esta sujeto el contenido del ODE.
     */
    public java.lang.String[] getDerechos() {
        return derechos;
    }


    /**
     * Sets the derechos value for this ResultadoRecordVO.
     * 
     * @param derechos   * Licencias a las que esta sujeto el contenido del ODE.
     */
    public void setDerechos(java.lang.String[] derechos) {
        this.derechos = derechos;
    }


    /**
     * Gets the contribuidor value for this ResultadoRecordVO.
     * 
     * @return contribuidor   * Contribuciones al ODE.
     */
    public java.lang.String[] getContribuidor() {
        return contribuidor;
    }


    /**
     * Sets the contribuidor value for this ResultadoRecordVO.
     * 
     * @param contribuidor   * Contribuciones al ODE.
     */
    public void setContribuidor(java.lang.String[] contribuidor) {
        this.contribuidor = contribuidor;
    }


    /**
     * Gets the publicador value for this ResultadoRecordVO.
     * 
     * @return publicador   * Publicadores del ODE.
     */
    public java.lang.String[] getPublicador() {
        return publicador;
    }


    /**
     * Sets the publicador value for this ResultadoRecordVO.
     * 
     * @param publicador   * Publicadores del ODE.
     */
    public void setPublicador(java.lang.String[] publicador) {
        this.publicador = publicador;
    }


    /**
     * Gets the relacion value for this ResultadoRecordVO.
     * 
     * @return relacion   * Relaciones del ODE con otros elementos.
     */
    public java.lang.String[] getRelacion() {
        return relacion;
    }


    /**
     * Sets the relacion value for this ResultadoRecordVO.
     * 
     * @param relacion   * Relaciones del ODE con otros elementos.
     */
    public void setRelacion(java.lang.String[] relacion) {
        this.relacion = relacion;
    }


    /**
     * Gets the fuente value for this ResultadoRecordVO.
     * 
     * @return fuente   * Identificadores de elementos que pueden considerarse fuente
     * del
     *                                 ODE.
     */
    public java.lang.String[] getFuente() {
        return fuente;
    }


    /**
     * Sets the fuente value for this ResultadoRecordVO.
     * 
     * @param fuente   * Identificadores de elementos que pueden considerarse fuente
     * del
     *                                 ODE.
     */
    public void setFuente(java.lang.String[] fuente) {
        this.fuente = fuente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoRecordVO)) return false;
        ResultadoRecordVO other = (ResultadoRecordVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.identificador==null && other.getIdentificador()==null) || 
             (this.identificador!=null &&
              this.identificador.equals(other.getIdentificador()))) &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo()))) &&
            ((this.idioma==null && other.getIdioma()==null) || 
             (this.idioma!=null &&
              this.idioma.equals(other.getIdioma()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.tema==null && other.getTema()==null) || 
             (this.tema!=null &&
              java.util.Arrays.equals(this.tema, other.getTema()))) &&
            ((this.ambito==null && other.getAmbito()==null) || 
             (this.ambito!=null &&
              java.util.Arrays.equals(this.ambito, other.getAmbito()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              java.util.Arrays.equals(this.tipo, other.getTipo()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.autores==null && other.getAutores()==null) || 
             (this.autores!=null &&
              java.util.Arrays.equals(this.autores, other.getAutores()))) &&
            ((this.formatos==null && other.getFormatos()==null) || 
             (this.formatos!=null &&
              java.util.Arrays.equals(this.formatos, other.getFormatos()))) &&
            ((this.derechos==null && other.getDerechos()==null) || 
             (this.derechos!=null &&
              java.util.Arrays.equals(this.derechos, other.getDerechos()))) &&
            ((this.contribuidor==null && other.getContribuidor()==null) || 
             (this.contribuidor!=null &&
              java.util.Arrays.equals(this.contribuidor, other.getContribuidor()))) &&
            ((this.publicador==null && other.getPublicador()==null) || 
             (this.publicador!=null &&
              java.util.Arrays.equals(this.publicador, other.getPublicador()))) &&
            ((this.relacion==null && other.getRelacion()==null) || 
             (this.relacion!=null &&
              java.util.Arrays.equals(this.relacion, other.getRelacion()))) &&
            ((this.fuente==null && other.getFuente()==null) || 
             (this.fuente!=null &&
              java.util.Arrays.equals(this.fuente, other.getFuente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIdentificador() != null) {
            _hashCode += getIdentificador().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        if (getIdioma() != null) {
            _hashCode += getIdioma().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getTema() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTema());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTema(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAmbito() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAmbito());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAmbito(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTipo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTipo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTipo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getAutores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAutores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAutores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFormatos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFormatos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFormatos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDerechos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDerechos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDerechos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContribuidor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContribuidor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContribuidor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPublicador() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublicador());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublicador(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFuente() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFuente());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFuente(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoRecordVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ResultadoRecordVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "identificador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "titulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idioma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "idioma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tema");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "tema"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ambito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "ambito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autores");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "autores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "formatos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("derechos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "derechos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contribuidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "contribuidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "publicador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "relacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fuente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "fuente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://busqueda.servicios.negocio.indexador.pode.es", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

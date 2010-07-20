/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.empaquetador.presentacion.basico.asociar.AsociarSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController
 */
public class AsociacionArchivosControllerImpl extends AsociacionArchivosController
{

	private static Logger logger = Logger.getLogger(AsociacionArchivosControllerImpl.class);


	public void cargarPath(ActionMapping mapping, CargarPathForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Inicia el path a la carpeta raiz
		String idOde = this.getEmpaquetadorSession(request).getIdLocalizador();
		GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
		ArchivoVO arbol= this.getSrvGestorArchivosService().recuperarArbol(idOde);
		List pathList=new ArrayList();
		sesArch.setPath(pathList);
		pathList.add(arbol);
	}


    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#recuperarDatos(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.RecuperarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	AsociarSession asoSes= this.getAsociarSession(request);
    	AsociacionArchivosSession  asoArcSes = this.getAsociacionArchivosSession(request);
//    	if(asoArcSes.getFicheros()==null)
//    		asoArcSes.setFicheros(new ArrayList());
    	
        EmpaquetadorSession empSes= this.getEmpaquetadorSession(request);
        GestorArchivosSession sesArch = this.getGestorArchivosSession(request);

        String idOde= empSes.getIdLocalizador();
        ArchivoVO arbol= this.getSrvGestorArchivosService().recuperarArbol(idOde);
        if(logger.isDebugEnabled()) logger.debug("creo la lista de path");
    	
    		List listaPath = sesArch.getPath();
    		listaPath.set(0, arbol);
    		for(int i=1; i<listaPath.size();i++)
    		{
    			ArchivoVO elemento = (ArchivoVO) listaPath.get(i);
    			String nombre=elemento.getNombre();
    			ArchivoVO elementoAnterior=(ArchivoVO) listaPath.get(i-1);
    			ArchivoVO[] arrayContenidos = elementoAnterior.getContenidos();

    			ArchivoVO hijo=null;
    			for(int j=0; j<arrayContenidos.length && hijo == null;j++)
    			{
    				if (arrayContenidos[j].getNombre().equals(nombre))
    				{
    					hijo=arrayContenidos[j];
    				}
    			}
    			listaPath.set(i,hijo);
    		}
    	
    	ArchivoVO[] lista =	null;
    	ArchivoVO ultimoEnPath= null;
    	if(sesArch.getPath().size()!=1)
    	{
    		ultimoEnPath = (ArchivoVO)sesArch.getPath().get(sesArch.getPath().size()-1);
    		if(ultimoEnPath.getCarpetaPadre()==null)
    		{
    			lista = this.getSrvGestorArchivosService().listar(idOde, ultimoEnPath.getNombre());
    		}
    		else
        	{
        		
        		lista = this.getSrvGestorArchivosService().listar(idOde, ultimoEnPath.getCarpetaPadre()+"/"+ultimoEnPath.getNombre());
        	}
    			
    	}
    	else if (sesArch.getPath().size()==1)
    	{
    		lista = this.getSrvGestorArchivosService().listar(idOde, null);
    	}
    	
        form.setFicheros( Arrays.asList(lista));//ArchivoVO
        
        if(asoArcSes.getFicheros()==null)
        {
        	if(logger.isDebugEnabled()) logger.debug("lista de ficheros en asosiacionArchivoSession esta vacia... la relleno");
        	asoArcSes.setFicheros(new ArrayList()); 
        	asoArcSes.getFicheros().addAll(asoSes.getFicheros() );
        }
        
        
        form.setFicherosSeleccionados(asoArcSes.getFicheros() );//FileVO
        form.setPath(sesArch.getPath());
        form.setArbol((ArchivoVO)sesArch.getPath().get(0));
        
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#navegar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.NavegarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void navegar(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.NavegarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	GestorSesion gs= new GestorSesion();
    	
    	GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
    	String referencia = form.getHref();
    	List listaPath = sesArch.getPath();
    	
    	List ruta=new ArrayList();
    	if(logger.isDebugEnabled()) logger.debug("Path es el primer ArchivoVO");
    	ArchivoVO path = (ArchivoVO) listaPath.get(0);
    	
    	if(logger.isDebugEnabled()) logger.debug("si el href está aki, se acaba, si no se hace recursividad");
    	if(path.getHref().equals(referencia))
    	{
    		ruta.add(path);
    	}
    	else
    	{
        	if(logger.isDebugEnabled()) logger.debug("llama a un método recursivo para calcular la ruta");
    		
    		List tmpList = gs.rellenarBarraNavegacion(path.getContenidos(), referencia);
    		ruta.add(path);
	    	if (tmpList != null && tmpList.size() > 0) 
	    	{
	    		ruta.addAll(tmpList);
	    	}
	    }
    	sesArch.setPath(ruta);
//    	if(!sesArch.getAccion().equals("Normal"))
//    	{
//    		sesArch.setModoPegar(true);
//    	}
     }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#asociar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void asociar(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociacionArchivosSession asocArSes= this.getAsociacionArchivosSession(request);
    	GestorArchivosSession archSes= this.getGestorArchivosSession(request);
    	
    	String nombre= form.getNombre();
    	if(logger.isDebugEnabled()) logger.debug("voy a buscar el ArchivoVO con el nombre " + nombre);
    	ArchivoVO archivo= (ArchivoVO)archSes.getPath().get(archSes.getPath().size()-1);
    	ArchivoVO recu= buscarPorNombre(archivo, nombre);
    	
    	Set tempSet= new HashSet(asocArSes.getFicheros());
    	
    	//primer caso .. recu es es un fichero... lo agrego a la lista sin mas
    	if(recu.getEsFichero().booleanValue())
    	{
        	String nombreFile;
        	if(recu.getCarpetaPadre()!=null && !recu.getCarpetaPadre().equals(""))
    		{
        		nombreFile = recu.getCarpetaPadre() +"/"+recu.getNombre();
    		}else
    		{
    			nombreFile= recu.getNombre();
    		}
        	FileVO file= new FileVO();
        	file.setHref(nombreFile);
        	
        	if(tempSet.add(file ))
			{
				asocArSes.getFicheros().add(file);
			}
    	}else{//caso dos .. recu es una carpeta, por lo que debo agregar a la lista todos sus contendios
    		List filesTemp= new ArrayList();
    		ArchivoVO[] archivos= recu.getContenidos();
    		if(archivos!=null && archivos.length>0)
    		{
    			listarFileVO(archivos, filesTemp);
    		}

    		for(int i=0;i<filesTemp.size();i++)
    		{
    			if(tempSet.add(filesTemp.get(i) ))
    			{
    				asocArSes.getFicheros().add(filesTemp.get(i) );
    			}
    		}
    		
    		
    	}
    	
    	
		
    	
    	
    }

    private void listarFileVO(ArchivoVO[] archivos,List files)
    {
    	
    	for(int i=0;i<archivos.length;i++)
    	{
    		if(archivos[i].getEsFichero().booleanValue())
    		{
            	String nombreFile;
            	if(archivos[i].getCarpetaPadre()!=null && !archivos[i].getCarpetaPadre().equals(""))
        		{
            		nombreFile = archivos[i].getCarpetaPadre() +"/"+archivos[i].getNombre();
        		}else
        		{
        			nombreFile= archivos[i].getNombre();
        		}
            	FileVO file= new FileVO();
            	file.setHref(nombreFile);
            	files.add(file);
    		}else
    		{
    			listarFileVO(archivos[i].getContenidos(), files);
    		}
    	}
    }
    
    
    
    private ArchivoVO buscarPorNombre(ArchivoVO arch, String nombre)
    {
    	if(arch.getNombre().equals(nombre))
    	{
        	if(logger.isDebugEnabled()) logger.debug("ArchivoVO encontrado " + nombre);
    		return arch;
    	}else
    	{	
    		ArchivoVO[] contenido= arch.getContenidos();
    		if(contenido!=null )
    		{
    		for(int i=0;i<contenido.length;i++)
    		{
    			ArchivoVO tmp= buscarPorNombre(contenido[i], nombre);
    			if( tmp!=null) return tmp; 
    		}
    		}
    	}
    	return null;
    }






    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#desasociar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.DesasociarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void desasociar(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.DesasociarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociacionArchivosSession asoArcSes= this.getAsociacionArchivosSession(request);
    	GestorArchivosSession archSes= this.getGestorArchivosSession(request);
    	AsociarSession asoSes= this.getAsociarSession(request);
    	List files = asoArcSes.getFicheros();
    	
    	ArchivoVO archivo= (ArchivoVO)archSes.getPath().get(archSes.getPath().size()-1);
    	if(logger.isDebugEnabled()) logger.debug("voy a buscar el ArchivoVO con el nombre " + form.getNombre());
    	ArchivoVO recu= buscarPorNombre(archivo, form.getNombre());
    	String nombreFile;
    	if(recu.getCarpetaPadre()!=null && !recu.getCarpetaPadre().equals(""))
		{
    		nombreFile = recu.getCarpetaPadre() +"/"+recu.getNombre();
		}else
		{
			nombreFile= recu.getNombre();
		}
    	
    	if(recu.getEsFichero().booleanValue())
    	{
	    	for(int i=0;i<files.size();i++)
	    	{
	    		if(((FileVO)files.get(i)).getHref().equals(nombreFile ))
	    		{
	    			files.remove(i);
	    			if(nombreFile.equals(asoSes.getHref()))
	    			{
	    				asoSes.setHref("");
	    			}
	    		}
	    	}
    	}else
    	{
    		List listaBorrar= new ArrayList();
    		listarFileVO( recu.getContenidos() , listaBorrar);
    		boolean eliminado;
    		for(int i=0;i<listaBorrar.size();i++)
    		{
    			eliminado= false;
    	    	for(int j=0;j<files.size() && !eliminado;j++)
    	    	{
    	    		if(((FileVO)files.get(j)).getHref().equals(((FileVO)listaBorrar.get(i)).getHref() ))
    	    		{
    	    			if(files.get(j).equals(asoSes.getHref()))
    	    			{
    	    				asoSes.setHref("");
    	    			}
    	    			files.remove(j);
    	    			eliminado=true;
    	    		}
    	    	}
    			
    		}
    	}
    	
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#submit(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String submit(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	String resultado = null;
    	
    	if (accion.equals(i18n.getString("portalempaquetado.Aceptar")))
     	{
    		resultado="Aceptar";
     	}
    	else
    	{
    		resultado="Cancelar";
    	}
    	return resultado;
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#borrarSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.BorrarSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void borrarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("Elimino de la sesion AsociarArchivosSession");
        if(this.getAsociacionArchivosSession(request)!=null)
        	request.getSession().removeAttribute(AsociacionArchivosSession.SESSION_KEY );
        form.setIdentifier(this.getAsociarSession(request).getIdGrupo());
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#hayPrincipal(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.HayPrincipalForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String hayPrincipal(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.HayPrincipalForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociarSession asoSes= this.getAsociarSession(request);
    	AsociacionArchivosSession asoArcSes= this.getAsociacionArchivosSession(request);
    	if(asoArcSes.getFicheros().size()==0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("la lista de ficheros a asociar esta vacia, lanzo una exception");
    		throw new ValidatorException("{portalempaquetado.basico.asociar.error.sinficheros}");
    	}
    	String resultado="No";
    	if(asoSes.getHref()!=null && !asoSes.getHref().equals(""))
    	{
    		resultado="Si";
    	}else if(asoArcSes.getFicheros().size()==1)
    	{
//    		String nombre;
    		FileVO file= (FileVO) asoArcSes.getFicheros().get(0);
//    		ArchivoVO arc= (ArchivoVO)asoSes.getFicheros().get(0);
//    		if(arc.getCarpetaPadre()!=null && !arc.getCarpetaPadre().equals(""))
//    			nombre= arc.getCarpetaPadre()+"/"+ arc.getNombre();
//    		else
//    			nombre=  arc.getNombre();
    		asoSes.setHref( file.getHref());
    		resultado="Si";
    	}
    	
    	return resultado;
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#aceptarFicheros(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.AceptarFicherosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void aceptarFicheros(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.AceptarFicherosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if(form instanceof PrincipalSubmitFormImpl)
    	{
    		PrincipalSubmitFormImpl principalForm= (PrincipalSubmitFormImpl) form;
    		if(principalForm.getPrincipal()==null)
    		{
    			if(logger.isDebugEnabled()) logger.debug("no se ha seleccionado ningun fichero principal");
    			throw new ValidatorException("{portalempaquetado.basico.asociar.error.sinprincipal}");
    		}
    	}
    	
        AsociacionArchivosSession asoArcSes= this.getAsociacionArchivosSession(request);
        AsociarSession asoSes=this.getAsociarSession(request);
        
        asoSes.setFicheros(asoArcSes.getFicheros());
        
        asoArcSes.setFicheros(null);

    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#recuperarFicheros(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.RecuperarFicherosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarFicheros(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.RecuperarFicherosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociacionArchivosSession asoArcSes= this.getAsociacionArchivosSession(request);
    	
    	form.setFicheros( asoArcSes.getFicheros());
    }

    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#submitPrincipal(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.SubmitPrincipalForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String submitPrincipal(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.archivos.SubmitPrincipalForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociarSession asoSes= this.getAsociarSession(request);
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	String resultado = null;
    	if (accion.equals(i18n.getString("portalempaquetado.Aceptar")))
     	{
    		asoSes.setHref(form.getPrincipal());
    		resultado="Aceptar";
    	}
    	else
    	{
    		resultado="Cancelar";
    	}
    	return resultado;
    }

}
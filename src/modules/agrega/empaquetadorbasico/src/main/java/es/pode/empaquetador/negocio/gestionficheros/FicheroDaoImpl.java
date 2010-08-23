/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.negocio.gestionficheros;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.FicheroVO;

public class FicheroDaoImpl implements FicheroDao {

	private Logger logger = Logger.getLogger(this.getClass());

	public FicheroDaoImpl() {
	}

	public void almacenar(Fichero fichero) throws FicheroException {
		if (fichero.getFichero() == null || !fichero.getFichero().exists()) {
			if (fichero.getRuta()!= null || fichero.getRuta().trim().length()!=0) {
				File ruta = new File(fichero.getRuta());
				if (!ruta.exists())
					ruta.mkdir();
			}			
			File nuevoFichero = new File(fichero.getRuta() + "/"
					+ fichero.getNombre());
			try {
				nuevoFichero.createNewFile();
				FileOutputStream fos = new FileOutputStream(nuevoFichero);
				fichero.getDatos().writeTo(fos);
			} catch (IOException e) {
				logger.warn("Fallo al almacenar el fichero "
						+ fichero.getNombre(), e);
			}
		} else {
			FicheroException e = new FicheroException(
					"Fichero ya existe previamente: " + fichero.getNombre());
			logger.warn(e);
			throw e;
		}
	}

	public void eliminar(Fichero fichero) throws FicheroException {

		
		if (fichero ==null || fichero.getFichero()==null || !fichero.getFichero().exists()) {
			FicheroException e = new FicheroException("Fichero no encontrado: "
					//It didn't work if fichero==null
					//+ fichero.getNombre());
					+ fichero==null?fichero.getNombre():"null");
			logger.warn(e);
			throw e;

		}	
		// es un directorio?
		else if (fichero.getFichero().isDirectory()) {
			// cargamos los archivos del directorio en un array
			File[] archivoEliminar = fichero.getFichero().listFiles();
			// eliminamos elementos del array
			for (int i = 0; i < archivoEliminar.length; i++) {
				
				Fichero fichero2 = new Fichero();
				//pasamos a tipo fichero para el caso en el que exista un directorio dentro de otro, entonces se llame asi mismo
				fichero2.setFichero(archivoEliminar[i]);
				this.eliminar(fichero2);
			}
			// eliminamos directorio
			fichero.getFichero().delete();
		} else {
			fichero.getFichero().delete();
		} 
	}

	public Fichero cargar(Fichero fichero) throws FicheroException {
		if (fichero.getFichero() != null && fichero.getFichero().exists()) {
			Fichero nuevoFichero = new Fichero();
			nuevoFichero.setFichero(fichero.getFichero());
			nuevoFichero.setNombre(fichero.getNombre());
			nuevoFichero.setSize(new Long(fichero.getFichero().length()));
			nuevoFichero.setDatos(new DataHandler(new FileDataSource(fichero
					.getFichero())));
			nuevoFichero
					.setRuta(fichero.getFichero().getParentFile().getName());
			return nuevoFichero;
		} else {
			FicheroException e = new FicheroException("Fichero no encontrado: "
					+ fichero.getNombre());
			logger.warn(e);
			throw e;
		}
	}

	public void crearCarpeta(String carpeta, String nuevaCarpeta)
			throws FicheroException {

		File carpeta_actual = new File(carpeta + File.separator + nuevaCarpeta);
		if (!carpeta_actual.mkdirs())
			throw new FicheroException("No se pudo crear la carpeta "
					+ carpeta_actual.getAbsolutePath());

	}

	private MapperIF beanMapperAux = null;

	public MapperIF getBeanMapperAux() {
		return beanMapperAux;
	}

	public void setBeanMapperAux(MapperIF beanMapperAux) {
		this.beanMapperAux = beanMapperAux;
	}

	public FicheroVO toFicheroVO(Fichero fichero) {
		FicheroVO nuevoFichero = (FicheroVO) this.getBeanMapperAux().map(
				fichero, FicheroVO.class);

		return nuevoFichero;
	}

	public Fichero fromFicheroVO(FicheroVO ficheroVO) {
		Fichero nuevoFichero = (Fichero) this.getBeanMapperAux().map(ficheroVO,
				Fichero.class);
		return nuevoFichero;
	}
}

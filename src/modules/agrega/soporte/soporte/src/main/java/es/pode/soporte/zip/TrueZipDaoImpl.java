/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.soporte.zip;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.schlichtherle.io.ArchiveDetector;
import de.schlichtherle.io.File;

/**
 * @author fjespino y mcmegia
 * 
 */
public  class TrueZipDaoImpl implements ZipDao {

	private Log logger = LogFactory.getLog(this.getClass());

	private void umount() {
		try {
			File.umount(true);
		} catch (Exception e) {
			logger.error("Error al actualizar true-zip VFS", e);
		}
	}

	// FUNCIONA
	public boolean chequearEntrada(String entrada, String archivo) {
		boolean chequeoCorrecto = false;
		File entrad = new File(archivo, entrada);

		if (entrad.exists()) {
			chequeoCorrecto = true;
		}
		umount();
		return chequeoCorrecto;
	}

	// FUNCIONA
	public void comprimir(String rutaArchivo, String rutaOrigen)
			throws ZipDaoException {
		logger.debug("Nos disponemos a comprimir " + rutaOrigen);
		File archivo = new File(rutaArchivo);
		boolean resultado = archivo.copyAllFrom(new java.io.File(rutaOrigen),ArchiveDetector.NULL,ArchiveDetector.NULL);
		if (!resultado)
			logger.error("No se pudo comprimir " + rutaOrigen + " en "
					+ rutaArchivo);
		umount();
	}

	// FUNCIONA
	public void descomprimir(String rutaArchivo, String rutaDestino)
			throws ZipDaoException {
		File comprimido = new File(rutaArchivo);
		java.io.File destino = new java.io.File(rutaDestino);
		if (!destino.isDirectory()) {
			logger.error("El destino " + rutaDestino + " no es un directorio");
			throw new ZipDaoException("El destino " + rutaDestino
					+ " no es un directorio");
		}
		if (comprimido.exists()) {
			boolean resultado = comprimido
					.archiveCopyAllTo(new File(rutaDestino),
							ArchiveDetector.NULL, ArchiveDetector.NULL);
			if (!resultado) {
				logger.error("No se pudo descomprimir el archivo "
						+ rutaArchivo + " en el directorio " + rutaDestino);
				throw new ZipDaoException("No se pudo descomprimir el archivo "
						+ rutaArchivo + " en el directorio " + rutaDestino);
			}
		} else {
			logger.debug("El archivo " + rutaArchivo + " no existe");
			throw new ZipDaoException("El archivo " + rutaArchivo
					+ " no existe");
		}
		umount();
	}

	// FUNCIONA
	public boolean esZip(String archivo) {
		boolean zip = false;
		File File1 = new File(archivo);

		if ((File1.isArchive() && File1.isDirectory() && !File1.isFile()
				&& File1.exists() && File1.length() == 0)) {
			zip = true;
		}
		umount();
		return zip;
	}

	// FUNCIONA
	public void extraerFichero(String fichero, String archivo, String destino) {
		String path = archivo + "/" + fichero;
		File entradaZip = new File(path);
		java.io.File ficheroDescomprimido = new java.io.File(destino + "/"
				+ fichero);

		try {
			if (entradaZip.isFile()) {
				logger.debug("El fichero " + path
						+ " NO ES CARPETA y lo vamos a descomprimir");
				File.cp_p(entradaZip, ficheroDescomprimido);
			} else if (entradaZip.isDirectory()) {
				logger.debug("El fichero " + path
						+ " ES CARPETA y lo vamos a descomprimir");
				destino = destino + "/" + fichero;
				new File(path).archiveCopyAllTo(new File(destino),
						ArchiveDetector.DEFAULT, ArchiveDetector.NULL);
			}

		} catch (IOException e) {
			logger.error(e);
		}

	}

	// FUNCIONA
	public void comprimir(String rutaArchivo, String rutaOrigen,
			String[] exclude) throws Exception {

		logger
				.debug("voy a crear el comprimido del que quitaré los ficheros indicados en "
						+ rutaArchivo);
		comprimir(rutaArchivo, rutaOrigen);

		// Si hay ficheros a excluir de la compresión
		if (exclude != null) {
			for (int i = 0; i < exclude.length; i++) {
				String ruta = rutaArchivo + "/" + exclude[i];

				logger.debug("excluimos el fichero " + ruta);
				File rute = new File(ruta);
				if (rute.exists()) {
					new File(ruta).deleteAll();
				} else {
					logger.info("no existe el fichero a excluir " + ruta);
				}
				
			}
			
		}
		// Comprime todos
		else {
			logger
					.debug("Como el array de ficheros a exluir=null comprimimos toda la ruta origen "
							+ rutaArchivo);
			comprimir(rutaArchivo, rutaOrigen);
		}
		umount();
	}

}

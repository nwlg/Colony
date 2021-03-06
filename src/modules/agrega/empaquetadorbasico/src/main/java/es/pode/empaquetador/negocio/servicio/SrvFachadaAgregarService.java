// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.empaquetador.negocio.servicio;

/**
 * <p>
 * Servicio que ofrece un �nico metodo para todos los posibles
 * agregar que se ofrecen en el modulo de empaquetaci�n.
 * </p>
 */
public interface SrvFachadaAgregarService
{
    public void agregar(java.lang.String idOde, java.lang.String idDestino, java.lang.String tipoEmpaquetador, java.lang.String idAgregar);

    public void agregarFederado(java.lang.String idODE, java.lang.String idDestino, java.lang.String tipoEmpaquetador, java.lang.String url);

  /**
   * <p>
   * Realiza las gestiones necesarias con el catalogador para poder
   * visualizar el metadato de un ODE publicado.
   * </p>
      * @param identificador  Identificador del ODE que se desea preparar para visualizacion de metadatos.
      * @return java.lang.String
   */
    public java.lang.String prepararMetadatos(java.lang.String identificador);

  /**
   * <p>
   * Descarga el metadato visualizado de la memoria del catalogador.
   * </p>
      */
    public void descargarMetadato(java.lang.String identificador);

    public void generarManifest(java.lang.String identificador, java.lang.String[] files, java.lang.String href, java.lang.String idioma);

    public void generarManifestRCP(java.lang.String identificador, java.lang.String idioma);

  /**
   * <p>
   * Analiza el archivo dado y determina si es un RCP, un ODE
   * (devuelve "CA"), un archivo ZIP o un fichero individual.
   * </p>
      * @param rutaArchivo  Ruta al fichero pendiente de an�lisis
      * @return es.pode.empaquetador.negocio.servicio.AnalizaArchivoVO
   */
    public es.pode.empaquetador.negocio.servicio.AnalizaArchivoVO analizarArchivo(java.lang.String rutaArchivo);

    public void generarManifestLom(java.lang.String identificador, java.lang.String[] files, java.lang.String href, java.lang.String idioma, java.lang.String titulo, java.lang.String descripcion, java.lang.String idiomaDestinatario, java.lang.String tipo);

}

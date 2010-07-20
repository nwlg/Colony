package uk.co.siriusit.acegi.shibboleth;

import org.apache.commons.codec.binary.Base64;

import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceServiceLocator;

/**
 * Utility class for the NDRB Shibboleth-acegi subsystem.  Provides encoding and
 * service lookup methods.
 */
public class Util {

    /**
     * Generates an "NDRB-safe" userId from a sourceId.
     *
     * @param sourceId a unique sourceId
     * @param encoding the encoding of the sourceId value
     * @return java.lang.String userId produced from sourceId
     * @throws java.io.UnsupportedEncodingException if encoding is not supported
     */
    protected String generateUsuario(String sourceId, String encoding)
        throws java.io.UnsupportedEncodingException {
        //
        // URL-safe mode will use the base64url[1] encoding and will also skip
        // padding so we can avoid potential NDRB breakages.  Also, we try not
        // to find out the consequences of CRLF sequences occurring in uids by
        // disabling chunking.  Note that the chunk separator is only used if
        // the chunk size is > 0.
        //
        // [1] -- http://tools.ietf.org/html/rfc4648#section-5
        //
        Base64 base64UrlEncoder = new Base64(0,           /* disable chunking */
                                             null,         /* chunk separator */
                                             true);               /* URL-safe */
        byte[] encBytes = base64UrlEncoder.encode(sourceId.getBytes(encoding));
        return new String(encBytes, encoding);
    }

    /**
     * Returns a reference to the srvAdminUsuariosService service.
     * @return es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService
     * @throws java.lang.Exception Exception
     */
    protected final SrvAdminUsuariosService getSrvAdminUsuariosService()
            throws java.lang.Exception {
        SrvAdminUsuariosServiceServiceLocator srvLocator = new
            SrvAdminUsuariosServiceServiceLocator();
        return (srvLocator.getSrvAdminUsuariosService());
    }
}
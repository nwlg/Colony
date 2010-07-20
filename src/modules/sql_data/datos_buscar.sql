--
-- Encoding: UTF-8
--

BEGIN;

/* Comunidades autónomas */

 insert into CCAA (ID, CODIGO, DESCRIPCION) values (1, 'AR', 'Comunidad Autónoma de Aragón');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (2, 'IC', 'Comunidad Autónoma de Canarias');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (3, 'CB', 'Comunidad Autónoma de Cantabria');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (4, 'LR', 'Comunidad Autónoma de La Rioja');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (5, 'MU', 'Comunidad Autónoma de Murcia');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (6, 'CM', 'Comunidad de Castilla La Mancha');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (7, 'M', 'Comunidad de Madrid');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (8, 'AS', 'Comunidad del Principado de Asturias');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (9, 'NA', 'Comunidad Foral de Navarra');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (10, 'CT', 'Generalitat de Catalunya');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (11, 'CV', 'Generalitat Valenciana');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (12, 'IB', 'Islas Baleares');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (13, 'AN', 'Junta de Andalucía');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (14, 'CL', 'Junta de Castilla y Leon');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (15, 'EX', 'Junta de Extremadura');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (16, 'GA', 'Xunta de Galicia');
 insert into CCAA (ID, CODIGO, DESCRIPCION) values (17, 'EU', 'País Vasco');


/* Nodos */

 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (1, 'Comunidad Autónoma de Aragón', 'aragon.agrega.indra.es', '2008-02-06 00:00:00','8080', 1, 'aragon.agrega.indra.es', 'es_ar_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (2, 'Comunidad Autónoma de Canarias', 'canarias.agrega.indra.es', '2008-02-06 00:00:00','8080', 2, 'canarias.agrega.indra.es', 'es_ic_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (3, 'Comunidad Autónoma de Cantabria', 'cantabria.agrega.indra.es', '2008-02-06 00:00:00','8080', 3, 'cantabria.agrega.indra.es', 'es_cb_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (4, 'Comunidad Autónoma de La Rioja', 'larioja.agrega.indra.es', '2008-02-06 00:00:00','8080', 4, 'larioja.agrega.indra.es', 'es_lr_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (5, 'Comunidad Autónoma de Murcia', 'murcia.agrega.indra.es', '2008-02-06 00:00:00','8080', 5, 'murcia.agrega.indra.es', 'es_mu_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (6, 'Comunidad de Castilla La Mancha', 'castillalamancha.agrega.indra.es', '2008-02-06 00:00:00','8080', 6, 'castillalamancha.agrega.indra.es', 'es_cm_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (7, 'Comunidad de Madrid', 'madrid.agrega.indra.es', '2008-02-06 00:00:00','8080', 7, 'madrid.agrega.indra.es', 'es_m_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (8, 'Comunidad del Principado de Asturias', 'asturias.agrega.indra.es', '2008-02-06 00:00:00','8080', 8, 'asturias.agrega.indra.es', 'es_as_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (9, 'Comunidad Foral de Navarra', 'navarra.agrega.indra.es', '2008-02-06 00:00:00','8080', 9, 'navarra.agrega.indra.es', 'es_na_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (10, 'Generalitat de Catalunya', 'catalunya.agrega.indra.es', '2008-02-06 00:00:00','8080', 10, 'catalunya.agrega.indra.es', 'es_ct_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (11, 'Generalitat Valenciana', 'valencia.agrega.indra.es', '2008-02-06 00:00:00','8080', 11, 'valencia.agrega.indra.es', 'es_cv_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (12, 'Islas Baleares', 'baleares.agrega.indra.es', '2008-02-06 00:00:00','8080', 12, 'baleares.agrega.indra.es', 'es_ib_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (13, 'Junta de Andalucía', 'andalucia.agrega.indra.es', '2008-02-06 00:00:00','8080', 13, 'andalucia.agrega.indra.es', 'es_an_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (14, 'Junta de Castilla y Leon', 'castillayleon.agrega.indra.es', '2008-02-06 00:00:00','8080', 14, 'castillayleon.agrega.indra.es', 'es_cl_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (15, 'Junta de Extremadura', 'extremadura.agrega.indra.es', '2008-02-06 00:00:00','8080', 15, 'extremadura.agrega.indra.es', 'es_ex_20080513000000');
 insert into NODO (ID, NODO, URL, FECHA_ALTA, PUERTO, CCAA_FK, URL_W_S, ID_NODO) values (16, 'Xunta de Galicia', 'galicia.agrega.indra.es', '2008-02-06 00:00:00','8080', 16, 'galicia.agrega.indra.es', 'es_ga_20080513000000');

/* Servicios*/

insert into SERVICIO (ID, descripcion, url, nombre) values (1, 'Buscar', '/buscar-1/services/SrvBuscarFederadaService', 'SrvBuscarService');
insert into SERVICIO (ID, descripcion, url, nombre) values (2, 'Entregar', '/entregar-1/services/SrvEntregarService', 'SrvEntregarService');
insert into SERVICIO (ID, descripcion, url, nombre) values (3, 'Oai-pmh', '/oaipmh/services/SrvOaiPmhService', 'SrvOaiPmhService');
insert into SERVICIO (ID, descripcion, url, nombre) values (4, 'DRI', '/dri-1/services/SrvDRIService', 'SrvDRIService');
insert into SERVICIO (ID, descripcion, url, nombre) values (5, 'SQI', '/dri-1/services/SrvSQIService', 'SrvSQIService');


insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (1,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (2,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (3,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (4,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (5,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (6,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (7,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (8,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (9,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (10,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (11,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (12,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (13,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (14,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (15,1);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (16,1);

insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (1,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (2,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (3,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (4,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (5,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (6,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (7,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (8,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (9,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (10,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (11,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (12,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (13,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (14,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (15,2);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (16,2);

insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (1,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (2,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (3,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (4,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (5,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (6,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (7,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (8,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (9,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (10,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (11,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (12,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (13,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (14,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (15,3);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (16,3);

insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (1,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (2,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (3,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (4,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (5,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (6,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (7,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (8,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (9,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (10,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (11,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (12,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (13,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (14,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (15,4);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (16,4);

insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (1,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (2,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (3,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (4,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (5,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (6,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (7,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (8,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (9,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (10,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (11,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (12,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (13,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (14,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (15,5);
insert into NODOS2SERVICIO (NODOS_FK, SERVICIO_FK) values (16,5);

COMMIT;

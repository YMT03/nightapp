# CHANGELOG

04/11/2019 -- Seteos en EstablecimientoDTO

02/11/2019 -- OrderBy Fixed.

02/11/2019 -- Update DB dml.

18/10/2019 -- Posibilidad de Ordenar por nombre o rating. 

30/09/2019 -- Ordenamiento en Establecimientos filtrados y cambio de JsonProperty para compatibilidad con front.

30/09/2019 -- Se agrega Rating en Establecimiento, java y DB.

30/09/2019 -- Se agrega Filtro multiple.

28/09/2019 -- Se agrega Menu. CRUD.

28/09/2019 -- Se agrega Servicio. CRUD. Y algunos inserts.

27/09/2019 -- Se permiten conexiones desde protocolos no http. Por cuestiones de integracion

27/09/2019 -- Actualizacion en Entidades y sus relaciones.

27/09/2019 -- Se agrega Ciudad. CRUD.

27/09/2019 -- Se agrega Localidad. CRUD.

27/09/2019 -- Se agrega relacion categorias-establecimientos

26/09/2019 -- Se agrega posibilidad de almacenar habilitaciones

25/09/2019 -- Inserts DB

22/09/2019 -- Modificaciones en DB

16/09/2019 -- Modificaciones en DB

13/09/2019 -- Update Documentacion.

09/09/2019 -- Filtrado de Establecimientos por Nombre.

09/09/2019 -- CRUD Categoria.

09/09/2019 -- Nuevo BO. Categoria. ddl, dml, endpoint, service, model. get All method.

09/09/2019 -- Refactor en Comentario-> getById. Codigo mas performante, se verifica la relacion con el establecimiento en Query.

09/09/2019 -- Posibilidad de acceder a un Comentarios especifico asociado a un Establecimiento.

09/09/2019 -- Posibilidad de eliminar Comentarios asociados a un Establecimiento.

09/09/2019 -- Posibilidad de agregar Comentarios asociados a un Establecimiento.

09/09/2019 -- Excepcion correspondiente cuando no existe el Establecimiento asociado

09/09/2019 -- Posibilidad de ver todos los comentarios asociados a un establecimiento y paginados.

06/09/2019 -- Modificacion en DB. DML y DDL.

06/09/2019 -- Comentarios agregados.

06/09/2019 -- El listado de Establecimientos ahora tiene Paginacion.

06/09/2019 -- Nueva Excepcion particular para diferenciar HttpCode y mensaje asociado a la busqueda de un id inexistente.

06/09/2019 -- Update Documentacion

06/09/2019 -- Fix con ubicacion embebida en update/insert de Establecimientos. Cambios en las validaciones y tablas.

06/09/2019 -- Se agrega Ubicacion a Establecimientos.

06/09/2019 -- Modificacion en modelo de datos. Un Establecimiento ahora tiene descripcion.

06/09/2019 -- Discriminacion en errores a la hora de insertar/modificar. Ahora diferencia la razon del bad request en casos de por ej nombre muy largo o vacio en los Establecimientos.

06/09/2019 -- Habilidad de modificar un Establecimiento. PUT method en /app/establecimientos. Con un EstablecimientoDTO en el Body Request.

06/09/2019 -- Habilidad de agregar un Establecimiento. POST method en /app/establecimientos. Con un EstablecimientoDTO en el Body Request.

06/09/2019 -- Fix. EstablecimientoDTO ahora muestra el Id.

06/09/2019 -- Documentacion. Doc Comments agregados, a nivel clase y metodo.

06/09/2019 -- GET method en /app/establecimientos/{id}. Obtiene un establecimiento concreto por {id}.

06/09/2019 -- Componente Mapper encargado de los parseos de objetos modelo a objetos vista o viceversa

06/09/2019 -- DELETE method en /app/establecimientos/{id}. Elimina el establecimiento en cuestion.

05/09/2019 -- Primer script sql ddl y dml. model/dao/endpoint/service asociados. GET method en /app/establecimientos. Retorna todos los Establecimientos de DB. Se elimino HomeEndpoint.java

05/09/2019 -- Primer Endpoint de prueba

05/09/2019 -- Configuracion Inicial

05/09/2019 -- Inicio proyecto

## Aviso importante para pruebas en clientes HTTP

La URL base para probar la API desde un cliente HTTP como Postman, Bruno, Insomnia o Thunder Client es:

```http
http://localhost:8080
```

## Nota sobre la colección de Postman

La colección incluida para Postman fue generada a partir de una colección exportada originalmente desde Bruno. Debido a esta conversión, es posible que algunas peticiones no se importen correctamente en Postman.

En algunos casos, especialmente en peticiones GET que utilizan paginación, filtros o variables de ruta, Postman puede duplicar o construir de forma incorrecta ciertos parámetros. Esto puede provocar que la URL final quede mal formada y que el servidor responda con errores de tipo 400 Bad Request.

Por ejemplo, una URL incorrecta podría quedar de la siguiente forma:

```http
http://localhost:8080/api/specimens?page=0&size=5&sortBy=name&sortOrder=asc?page=0&size=5&sortBy=name&sortOrder=asc
```

Por esta razón, antes de ejecutar las peticiones en Postman, se recomienda revisar la URL final generada por el cliente HTTP. Esto aplica principalmente a las solicitudes que utilizan paginación, filtros o variables dinámicas en la ruta.

Si una petición falla en Postman, primero se debe verificar que la URL esté correctamente construida antes de asumir que existe un error en la API.

# API de Gestión de Tickets

Esta es una API RESTful para la gestión de tickets. Permite crear, eliminar, editar y recuperar tickets con paginación, y se puede recuperar todos o filtrar por uno específico.

## Requisitos

- **Java 11** o superior
- **Maven** 3.6 o superior
- **PostgreSQL** 13 o superior
- **Swagger** para la interfaz de prueba de la API

## Instalación y Configuración

### 1. Clonar el repositorio

- git clone https://github.com/LuisZuluaga22/TicketsAPI
- cd tu_repositorio


### 2. Configuración de la Base de Datos
   Asegurarse de tener PostgreSQL corriendo y crear una base de datos para la aplicación con los siguientes parametros:

    Nombre BD: postgres
    UserName: postgres
    password: 1234

con esto, configuramos los parámetros de conexión en el archivo application.properties dentro de src/main/resources:

#### application.properties:

    spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/postgres
    spring.datasource.username=postgres
    spring.datasource.password=1234
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driver-class-name=org.postgresql.Driver


### 3. Iniciar la Aplicación
   Ejecutar desde el IDE preferido la clase main: [LuisZuluagaApplication.java]
   
Esto iniciará el servidor en el puerto por defecto 8080. 

### 4. Acceder a la Interfaz Swagger
   Una vez que la aplicación esté en ejecución, podemos acceder a Swagger a través de la siguiente URL:

    http://localhost:8080/api/swagger-ui/swagger-ui/index.html#/

En Swagger, se podrá ver todos los endpoints disponibles y probarlos directamente desde el navegador.

Endpoints de la API:
- Crear un ticket

      Método: POST
      RequestBody: Nombre de usuario
      PATH: /api/tickets
      Descripción: Crea un nuevo ticket.

   Cuerpo de la petición (JSON):
      
      Juan Pérez

   Respuesta de ejemplo:
      OK[200]

      {
      "id": 1,
      "user": "Juan Pérez",
      "createdAt": "2024-12-12T12:34:56",
      "updatedAt": "null",
      "status": "ABIERTO"
      }

- Actualizar un ticket

       Método: PUT 
       PATH: /api/tickets/{id}
       Parámetros de ruta: {id}: ID del ticket a actualizar.
       Descripción: Actualiza un ticket existente.
       
   Cuerpo de la petición (JSON):

       CERRADO

   Respuesta de ejemplo:

      {
      "id": 1,
      "user": "Juan Pérez",
      "createdAt": "2024-12-12T12:34:56",
      "updatedAt": "2024-12-12T12:35:10",
      "status": "CERRADO"
      }


- Eliminar un ticket

      Método: DELETE 
      PATH: /api/tickets/{id}
      Parámetros de ruta: {id}: ID del ticket a eliminar.
      Descripción: Elimina un ticket por ID.
      
   Respuesta :
   OK[200]

      El ticket se ha borrado con exito.


- Obtener todos los tickets con paginación

      Método: GET 
      PATH: /api/tickets
      Parámetros de consulta:
         page: Número de página (por defecto 0).
         size: Número de tickets por página (por defecto 20).
      Descripción: Obtiene una lista de todos los tickets con paginación.
      
   
   Ejemplo de URL:

      GET http://localhost:8080/api/tickets?page=0&size=10
   
   Respuesta:
   
         [
         {
         "id": 1,
         "user": "Juan Pérez",
         "createdAt": "2024-12-12T12:34:56",
         "updatedAt": "2024-12-12T12:34:56",
         "status": "ABIERTO"
         },
         {
         "id": 2,
         "user": "Mateo Pérez",
         "createdAt": "2024-12-12T12:34:56",
         "updatedAt": "2024-12-12T12:34:56",
         "status": "ABIERTO"
         },
         {
         "id": 3,
         "user": "Mateo Lopez",
         "createdAt": "2024-12-12T12:34:56",
         "updatedAt": "2024-12-12T12:34:56",
         "status": "ABIERTO"
         }
         ]


- Obtener un ticket por ID

      Método: GET 
      PATH: /api/tickets/{id}
      Parámetros de ruta: {id}: ID del ticket a obtener.
      Descripción: Obtiene un ticket por su ID.
      
   Ejemplo de URL:
   
      GET http://localhost:8080/api/tickets/1
   
   Respuesta:
   OK[200]

      {
      "id": 1,
      "user": "Juan Pérez",
      "createdAt": "2024-12-12T12:34:56",
      "updatedAt": "2024-12-12T12:34:56",
      "status": "ABIERTO"
      }

# Social Network

### Integrantes del grupo
- Francisco Piñero Alpañés
- Rubén Esquerdo

## Guía de desarrollo
### Día 1
#### Tareas completadas
- Mapeo de las entidades de la base de datos
- Mapeo de las relaciones entre las entidades
- Pruebas para el flujo de trabajo en git
- Reparto de tareas
#### Responsabilidades
- Ambos nos hemos encargado de mapear la BBDD así como de debatir las responsabilidades del proyecto
#### Tareas previstas para el siguiente día
- Revisar el mapeo de la BBDD
- Crear todos las clases necesarias del resto de paquetes
- Completar la funcionalidad REST de la entidad Event

### Día 2
#### Tareas completadas
- Creados los repositorios
- Flujo de servicios REST de User
  - GET /users
  - GET /users/{id}
  - GET /users/fullUser/{id}
  - POST /users
  - PUT /users/{id}
  - POST /users/login
- Flujo de servicios REST de Event
  - GET /events
  - GET /events/{id}
- Flujo de servicios REST de Message
  - GET /messages
  - GET /messages/{id}
- Creados los dto necesarios
- Usado ModelMapper para transformar los DTO entrantes en entidades y viceversa
#### Responsabilidades
- Rubén se ha encargado del flujo de los servicios REST de Event y Message
- Fran se ha encargado del flujo de los servicios REST de User y de comprender el uso de los DTOs
#### Tareas previstas para el siguiente día
- Terminar el flujo de User (Fran)
- Empezar con el flujo de las otras dos entidades (Rubén y Fran)

### Día 3
#### Tareas completadas
- Flujo de servicios REST de User
  - GET /users/{id}/friendRelationship
  - GET /users/{id}/pendingRelationship
- Flujo de servicios REST de Event [FINALIZADO]
- Corregidos archivos del GitHub
#### Responsabilidades
- Rubén y Fran se han encargado de terminar el flujo de los servicios REST de Event
- Fran se ha encargado de borrar la carpeta .settings del repositorio de GitHub
#### Tareas previstas para el siguiente día
Terminar la aplicación

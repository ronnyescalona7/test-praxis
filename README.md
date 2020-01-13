# test-praxis

Para la solucion se utilizo Spring Boot.

Como entorno de desarrollo se uso IntelliJ Idea Community Edition.

Se uso Spring Initalizr para configurar el proyecto con las siguientes dependencias:
-Spring Web
-Spring JPA
-Spring h2
- Thymeleaf (No imnplementado todavia)

Asi como el servidor web embebido que trae por dejecto spring boot para desplegar, en este caso un .jar

El uso de h2 corresponde a cuestiones de prueba, ya que para ejecutar la aplicacion no se necesitaria un motor relacional instalado previamente.

La clase Person es abstracta , por ende pienso que el CRUD deberia realizarse sobre Student y Professor, que heredan atributos y comportamiento de Person,
esto garantiza un diseno mas claro y desacoplado.

Se creo una interface comun tipo DAO mas alla de los objetos tipo Repository del JPA, solo por granularidad.

Por cuestiones de tiempo algunas cosas que pudieran ser mejoradas serian:
- Crear builders para los constructores que poseen muchos parametros
- Tratamiento a profundidad de excepciones
- En el modelo enviado, creo que faltarian clases Seminar y Enrollment, o una interfaz de enrollment, dado los nombres de los campos.
- Falta por realizar el HTML, mi opcion era thymeleaf, pero por compromisos laborales no tuve la holgura necesaria para terminarla.

Todas el CRUD puede ser accedido por REST, las pruebas se realizaron con POSTMAN

he aqui algunos ejemplos para enviar via REST:

Metodo POST - URL: http://localhost:8080/api/v1/students
JSON en el Body:

{
        "name" : "Manuel Perez",
        "phoneNumber" : "3184435678",
        "emailAddress" : "manuelperez@gmail.com",
        "studentNumber" : "100",
        "averageMark" : "3.4",
        "seminarsToken" : "2",
        "address" : {"street": "La Esmeralda","city": "Bogota","state": "Cundinamarca","postalCode": "111321", "country": "Colombia"}
}

Metodo GET -  URL: http://localhost:8080/api/v1/students

Obtiene una lista de los estudiantes actuales.

Metodo DELETE - URL: URL: http://localhost:8080/api/v1/students/{id}

Elimina el registro solicitado.

Metodo UPDATE -  URL: http://localhost:8080/api/v1/students/{id}

Actualiza el registro con el id dado.

Asi mismo todos los metodos pueden ser usados en la entidad Professor, cambiando el URL a:

http://localhost:8080/api/v1/professors

La clase principal es TestApplication.

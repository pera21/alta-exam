# alta-exam
Exam for Alta

Las Tecnologias que use fueron:
- Java
- JPA
- Spring Boot
- MySQL
- Maven

Para levantarlo va a necesitar [Maven](https://maven.apache.org/) y parandose en la ruta principal del proyecto hay que poner el siguiente comando
```bash
./mvnw.cmd spring-boot:run
```
Tambien les dejo un dump de la DB que use yo para probar el proyecto, tiene el nombre de "altaexam.sql"

Hay solamente una cosa que quedo distinta a lo que pidieron en el word que no pude hacer. Es que la request GET "/loans?page=1&size=50&user_id=2", me quedo con el userId, en vez de con el user_id. Por lo que la request que funciona es GET "/loans?page=1&size=50&userId=2"

# CitasMedicas

CitasMedicas es un proyecto educativo que esta compuesta de dos partes, una de cliente que le permite registrarse, agendar citas, editar la cita.
Luego consta de una parte administrativa que gestiona los horarios y la disponibilidad de los doctores, asi como su registro en el sistema.

### Prerequisites

Como pre-requisitos necesitas tener instalado el JDK 1.8 y JRE 1.8 de Java, Maven, Apache Tommcat EE y PostgresSQL.
Tambien sera necesario, tener instalado Node JS y la Angular CLI. Para comprobar ejecuta los siguientes comandos:

```
java -version
mvn -version
```

### Installing

Para instalar el proyecto debe clonar el repositorio, y dentro de la carpeta de frontendcitas ejecutar:
```
npm install O yarn install
```
Dentro de la carpeta de backendcitas, abrirlo con tu editor IntelliJ y el automaticamente sincronizara las dependencias del proyecto; tambien en la carpeta /resources/ debes crear un nuevo archivo (file) con el nombre application.yml donde ira las credenciales para la
conexion a la Base de Datos
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nameDatabase
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
```
Una vez hecho estas cosas, debes ejecutar el backend y en el frontend ng serve. Luego estaran corriendo en los siguientes puertos:
```
localhost:8080 --> Server
localhost:4200 --> Client
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring boot](https://spring.io/projects/spring-boot) - Used to generate like framework
* [Hibernate](https://hibernate.org/) - Used like ORM (Object relational mapping)
* [Angular](https://angular.io) - Used to develop the frontend side

## Authors

* **Gerson Castillo Hernandez** - *Initial work* - [GCH](https://github.com/GCH77)
* **Jhon Sebastian Salcedo** - *Initial work* - [jhonssal](https://github.com/jhonssal)
* **Leidy Merchan** - *Initial work*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

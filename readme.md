# Information4Developer
This is a skeleton of a simple Springboot app with a configured PostgreSQL database dockerized.

## Goals
 + Provide a configuration of a **_PostgreSQL docker_**
 + Provide a configuration, in yaml file, of JPA and respective database info
 + Include a **_HeartBeat_** web service sample
 + Include a **_MapStruct_** usage/implementation

## Docker PostgreSQL configuration
* Directory: `docker/database`
* Configuration file: `docker-compose.yml`
* Complementary files:
  * `db.sql` - declaration schemas
  * `schema.sql` - schema content structure database
  * `data.sql` - data necessary for each table 

## System Properties Required
This properties will be used when the server start (please add it at 'Environment variables')
* DATABASE_HOST=<hostname>
* DATABASE_PORT=<hostname_port>
* DATABASE_NAME=<database_name>
* DATABASE_USERNAME=<database_username>
* DATABASE_PASSWORD=<database_password>

## [Docker] How to start
### [Docker Compose] Create dockerized PostgreSQL database
Launch database: docker/database
```bash
 docker-compose up -d
```

Destroy database (when needed)
```bash
 docker-compose down
```

## [Docker] How to start
### [Dockerfile] To be used with DockerEngine - How to start
Build from dockerfile: 
```bash
docker build --tag db-postgresql:<version_number> .
```

Run docker from build: 
```bash
docker run --publish 8080:8080 --detach --name docker-db-postgresql db-postgresql:latest \
    --DATABASE_HOST=<hostname> \
    --DATABASE_PORT=<hostname_port> \
    --DATABASE_NAME=<database_name> \
    --DATABASE_USERNAME=<database_username> \
    --DATABASE_PASSWORD=<database_password>
```

### Reference Documentation
For further reference, please consider the following sections:

* [Docker Docs](https://docs.docker.com/)
* [PostgreSQL](https://www.postgresql.org)
* [MapStruct](https://mapstruct.org/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)



### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

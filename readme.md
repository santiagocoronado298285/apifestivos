# API Festivos (Spring Boot)

Resumen rápido
- API RESTful para gestionar festivos, países y tipos de festivo usando Spring Boot + JPA + PostgreSQL.
- Proyecto multi-módulo: módulos principales: `dominio`, `infraestructura` y el módulo con controladores (actualmente `api`).

Requisitos
- Java 17
- Maven (o usar `./mvnw`)
- PostgreSQL accesible
- `psql` u otra herramienta para administrar la BD (opcional)

Estructura relevante
- /src/main/java/festivos/api — clase principal y controladores
- /dominio — entidades JPA (entities)
- /infraestructura — repositorios JPA (repositories)
- /src/main/resources/application.properties — configuración principal

Configurar la base de datos
- Recomendado: no dejar credenciales en `application.properties`. Usar variables de entorno.
- Ejemplo en `application.properties`:
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/festivos
  spring.datasource.username=${DB_USER:postgres}
  spring.datasource.password=${DB_PASS:password}
  spring.datasource.driver-class-name=org.postgresql.Driver

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

  server.port=8080
  ```
- Ejemplo de `.env` (si decides usar una librería que cargue `.env` o exportarlas en shell):
  ```
  DB_USER=postgres
  DB_PASS=miPassword
  ```

Construir y ejecutar
- Construir todo:
  ```
  mvn clean install
  ```
  o con wrapper:
  ```
  ./mvnw clean install
  ```
- Si el build falla por multi-módulo (repackage o falta de main), pasos útiles:
  - Añadir en los POM de módulos que no son aplicación:
    ```xml
    <properties>
      <spring-boot.repackage.skip>true</spring-boot.repackage.skip>
    </properties>
    ```
  - Asegurar dependencia entre módulos (ej. `infraestructura` depende de `dominio`):
    ```xml
    <dependency>
      <groupId>festivos</groupId>
      <artifactId>dominio</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```
  - Si el módulo `api` contiene la clase main, cambiar su `packaging` a `jar` y declarar el plugin `spring-boot-maven-plugin` sólo allí.

Ejecutar la aplicación (desde el módulo que tiene la clase main):
```
mvn spring-boot:run
# o si generaste jar:
java -jar target/tu-app.jar
```

Pruebas de conexión DB
- Endpoint de prueba: `GET /dbtest` (si fue creado). Devuelve éxito o el error de conexión.
- Alternativa: usar `psql` para conectarte:
  ```
  PGPASSWORD=miPassword psql -h localhost -U postgres -d festivos
  ```

CRUD País (endpoints sugeridos)
- GET /paises — listar
- GET /paises/{id} — obtener por id
- POST /paises — crear
- PUT /paises/{id} — actualizar
- DELETE /paises/{id} — eliminar

DTOs
- Usar DTOs para respuestas (no exponer entidades directamente).
- Ejemplo `FestivoDTO`: id, nombreFestivo, dia, mes, nombrePais, descripcionTipoFestivo.
- Mapear entidades -> DTO en un servicio o usar librería (MapStruct / ModelMapper).

Errores comunes y soluciones rápidas
- "package repositories does not exist": compilar módulos en orden o declarar dependencia del módulo `infraestructura` donde se usan los repositorios.
- "Unable to find main class" al repackage: saltar repackage en módulos no ejecutables o mover plugin al módulo que contiene `main`.
- Ver imports y `package` en sus entidades/repositories: la declaración `package` debe coincidir con la ruta `src/main/java/{paquete}`.

Comandos útiles
- Compilar solo un módulo y dependencias:
  ```
  mvn -pl :dominio -am clean install
  mvn -pl :infraestructura -am clean install
  ```
- Reconstruir todo después de arreglos:
  ```
  mvn clean install
  ```

Sugerencias
- Mantener controladores en el módulo/aplicación (p. ej. paquete `festivos.api.controller`).
- Mantener entidades en `dominio` y repositorios en `infraestructura`.
- Añadir pruebas unitarias y de integración bajo `src/test/java`.

Contacto / contribución
- Abrir issues o PRs con cambios. Documentar modificaciones en READMEs de cada módulo cuando agregues POM o dependencias.

Fin.// filepath: /home/crocs/itm_code/apiFestivos/api/README.md
# API Festivos (Spring Boot)

Resumen rápido
- API RESTful para gestionar festivos, países y tipos de festivo usando Spring Boot + JPA + PostgreSQL.
- Proyecto multi-módulo: módulos principales: `dominio`, `infraestructura` y el módulo con controladores (actualmente `api`).

Requisitos
- Java 17
- Maven (o usar `./mvnw`)
- PostgreSQL accesible
- `psql` u otra herramienta para administrar la BD (opcional)

Estructura relevante
- /src/main/java/festivos/api — clase principal y controladores
- /dominio — entidades JPA (entities)
- /infraestructura — repositorios JPA (repositories)
- /src/main/resources/application.properties — configuración principal

Configurar la base de datos
- Recomendado: no dejar credenciales en `application.properties`. Usar variables de entorno.
- Ejemplo en `application.properties`:
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/festivos
  spring.datasource.username=${DB_USER:postgres}
  spring.datasource.password=${DB_PASS:password}
  spring.datasource.driver-class-name=org.postgresql.Driver

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

  server.port=8080
  ```
- Ejemplo de `.env` (si decides usar una librería que cargue `.env` o exportarlas en shell):
  ```
  DB_USER=postgres
  DB_PASS=miPassword
  ```

Construir y ejecutar
- Construir todo:
  ```
  mvn clean install
  ```
  o con wrapper:
  ```
  ./mvnw clean install
  ```
- Si el build falla por multi-módulo (repackage o falta de main), pasos útiles:
  - Añadir en los POM de módulos que no son aplicación:
    ```xml
    <properties>
      <spring-boot.repackage.skip>true</spring-boot.repackage.skip>
    </properties>
    ```
  - Asegurar dependencia entre módulos (ej. `infraestructura` depende de `dominio`):
    ```xml
    <dependency>
      <groupId>festivos</groupId>
      <artifactId>dominio</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```
  - Si el módulo `api` contiene la clase main, cambiar su `packaging` a `jar` y declarar el plugin `spring-boot-maven-plugin` sólo allí.

Ejecutar la aplicación (desde el módulo que tiene la clase main):
```
mvn spring-boot:run
# o si generaste jar:
java -jar target/tu-app.jar
```

Pruebas de conexión DB
- Endpoint de prueba: `GET /dbtest` (si fue creado). Devuelve éxito o el error de conexión.
- Alternativa: usar `psql` para conectarte:
  ```
  PGPASSWORD=miPassword psql -h localhost -U postgres -d festivos
  ```

CRUD País (endpoints sugeridos)
- GET /paises — listar
- GET /paises/{id} — obtener por id
- POST /paises — crear
- PUT /paises/{id} — actualizar
- DELETE /paises/{id} — eliminar

DTOs
- Usar DTOs para respuestas (no exponer entidades directamente).
- Ejemplo `FestivoDTO`: id, nombreFestivo, dia, mes, nombrePais, descripcionTipoFestivo.
- Mapear entidades -> DTO en un servicio o usar librería (MapStruct / ModelMapper).

Errores comunes y soluciones rápidas
- "package repositories does not exist": compilar módulos en orden o declarar dependencia del módulo `infraestructura` donde se usan los repositorios.
- "Unable to find main class" al repackage: saltar repackage en módulos no ejecutables o mover plugin al módulo que contiene `main`.
- Ver imports y `package` en sus entidades/repositories: la declaración `package` debe coincidir con la ruta `src/main/java/{paquete}`.

Comandos útiles
- Compilar solo un módulo y dependencias:
  ```
  mvn -pl :dominio -am clean install
  mvn -pl :infraestructura -am clean install
  ```
- Reconstruir todo después de arreglos:
  ```
  mvn clean install
  ```

Sugerencias
- Mantener controladores en el módulo/aplicación (p. ej. paquete `festivos.api.controller`).
- Mantener entidades en `dominio` y repositorios en `infraestructura`.
- Añadir pruebas unitarias y de integración bajo `src/test/java`.

Contacto / contribución
- Abrir issues o PRs con cambios. Documentar modificaciones en READMEs de cada módulo cuando agregues POM o dependencias.

Fin.
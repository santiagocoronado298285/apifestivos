# API Festivos (Spring Boot)

## Resumen

API RESTful para gestionar festivos, países y tipos de festivo usando Spring Boot, JPA y PostgreSQL. Este proyecto está estructurado como un proyecto multi-módulo con los siguientes módulos principales:

- **dominio**: Contiene las entidades JPA.
- **infraestructura**: Contiene los repositorios JPA.
- **api**: Contiene los controladores y la clase principal de la aplicación.

---

## Requisitos

Para replicar y ejecutar este proyecto, asegúrate de tener lo siguiente instalado:

- **Java 17** o superior.
- **Maven** (o usar el wrapper `./mvnw` incluido en el proyecto).
- **PostgreSQL** accesible.
- Herramienta para administrar la base de datos (opcional, como `psql`).

---

## Configuración de la base de datos

### 1. Crear la base de datos

Ejecuta el siguiente comando en PostgreSQL para crear la base de datos:

```sql
CREATE DATABASE festivos;
```

### 2. Configurar credenciales

Es recomendable no dejar las credenciales directamente en el archivo `application.properties`. En su lugar, utiliza variables de entorno. Aquí tienes un ejemplo de cómo podrías configurar las variables de entorno en un archivo `.env`:

```
DB_USER=postgres
DB_PASS=miPassword
```

### 3. Configurar `application.properties`

Asegúrate de que tu archivo `src/main/resources/application.properties` contenga la configuración correcta para la conexión a la base de datos. Un ejemplo de configuración es el siguiente:

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

---

## Construir y ejecutar

### 1. Construir el proyecto

Para construir todo el proyecto, ejecuta el siguiente comando en la raíz del proyecto:

```
mvn clean install
```

Si prefieres usar el wrapper de Maven, el comando sería:

```
./mvnw clean install
```

### 2. Ejecutar la aplicación

Una vez construido el proyecto, puedes ejecutar la aplicación con el siguiente comando (asegúrate de estar en el módulo que contiene la clase principal):

```
mvn spring-boot:run
```

Si has generado un archivo JAR y prefieres ejecutarlo de esa manera, utiliza:

```
java -jar target/tu-app.jar
```

---

## Pruebas de conexión a la base de datos

Para verificar que la conexión a la base de datos está funcionando correctamente, puedes hacer una petición al endpoint de prueba (si fue creado):

```
GET /dbtest
```

Este endpoint debería devolver un mensaje de éxito o un error relacionado con la conexión a la base de datos.

Como alternativa, también puedes probar la conexión usando `psql` directamente desde la línea de comandos:

```
PGPASSWORD=miPassword psql -h localhost -U postgres -d festivos
```

---

## CRUD País (endpoints sugeridos)

Para gestionar los países en la aplicación, se sugieren los siguientes endpoints:

- `GET /paises` — Listar todos los países.
- `GET /paises/{id}` — Obtener un país por su ID.
- `POST /paises` — Crear un nuevo país.
- `PUT /paises/{id}` — Actualizar un país existente.
- `DELETE /paises/{id}` — Eliminar un país.

---

## DTOs

Es recomendable usar DTOs (Data Transfer Objects) para las respuestas de la API, en lugar de exponer las entidades JPA directamente. Por ejemplo, un `FestivoDTO` podría contener los siguientes campos: `id`, `nombreFestivo`, `dia`, `mes`, `nombrePais`, `descripcionTipoFestivo`. La conversión entre entidades y DTOs se puede manejar en un servicio dedicado o utilizando una librería como MapStruct o ModelMapper.

---

## Errores comunes y soluciones rápidas

Algunos errores comunes que podrías encontrar incluyen:

- **"package repositories does not exist"**: Asegúrate de compilar los módulos en el orden correcto o de declarar la dependencia del módulo `infraestructura` donde se utilizan los repositorios.
- **"Unable to find main class"** al intentar repackage: Este error puede solucionarse omitiendo el repackage en los módulos que no son ejecutables o moviendo el plugin al módulo que contiene la clase `main`.
- Verifica los imports y la declaración de `package` en tus entidades y repositorios. La declaración de `package` debe coincidir con la ruta del sistema de archivos `src/main/java/{paquete}`.

---

## Comandos útiles

Aquí hay algunos comandos de Maven que pueden ser útiles durante el desarrollo:

- Para compilar solo un módulo específico y sus dependencias:

```
mvn -pl :dominio -am clean install
mvn -pl :infraestructura -am clean install
```

- Para limpiar y reconstruir todo el proyecto después de realizar cambios:

```
mvn clean install
```

---

## Sugerencias

Algunas buenas prácticas y sugerencias para trabajar en este proyecto:

- Mantén los controladores en el módulo/aplicación correspondiente (por ejemplo, en el paquete `festivos.api.controller`).
- Las entidades deben estar en el módulo `dominio` y los repositorios en `infraestructura`.
- Considera añadir pruebas unitarias y de integración en el directorio `src/test/java`.

---

## Contacto / contribución

Para cualquier consulta, reporte de errores o contribuciones, por favor abre un issue o un pull request con los cambios propuestos. Si realizas modificaciones significativas, documenta los cambios en el README de cada módulo afectado, especialmente si has agregado o modificado dependencias en el archivo POM.

---

Fin.

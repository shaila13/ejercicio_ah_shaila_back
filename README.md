
# Servicio de Consulta de Precios
Este proyecto es una aplicación Spring Boot que proporciona un servicio REST para consultar precios en un sistema de comercio electrónicoque sigue la arquitectura hexagonal. Permite a los usuarios obtener información detallada sobre los precios de productos en diferentes marcas y fechas específicas. Utiliza una base de datos en memoria H2 para almacenar y recuperar los datos de precios de manera eficiente.


## Características
Consulta el precio actual de un producto en una cadena específica en una fecha determinada.
Proporciona un servicio REST para consultar precios.
Almacena los datos de precios en una base de datos H2 en memoria para una fácil administración y acceso.
Se integra con Swagger para documentar la aplicación y facilitar su uso.

## Caso de Uso
### Consultar Precio Actual
Este caso de uso permite a un usuario consultar el precio actual de un producto en una cadena específica en una fecha determinada.

Actores: Usuario

![Consultar el precio aplicable de un producto.](https://github.com/shaila13/ejercicio_ah_shaila_back/blob/main/GetPricesInfoUseCase.png)


## Diagrama de Flujo

Consultar Precio Actual

Este diagrama de flujo representa el flujo de interacción entre el usuario y el sistema para consultar el precio actual de un producto.

![Consultar Precio Actual.](https://github.com/shaila13/ejercicio_ah_shaila_back/blob/main/GetPricesInfo.png)

## Instalación
Para ejecutar la aplicaciónlicación en tu máquina local, sigue estos pasos:

```bash
  git clone https://github.com/shaila13/ejercicio_ah_shaila_back.git
  cd ejercicio_ah_shaila_back
  ./mvnw spring-boot:run
```
La aplicación se ejecutará en http://localhost:8080/swagger-ui/index.html

## Importar y Ejecutar el Proyecto en IntelliJ IDEA o Eclipse

### Importar a IntelliJ IDEA:

1. Clonar el Repositorio:

```bash
  git clone https://github.com/shaila13/ejercicio_ah_shaila_back.git
```
2. Abrir IntelliJ IDEA:

Abre IntelliJ IDEA en tu ordenador.

3. Importar el Proyecto:

En la ventana de bienvenida, selecciona "Import Project".
Navega hasta el directorio donde clonaste el repositorio y selecciona la carpeta del proyecto.
Selecciona "Maven" como el modelo de proyecto y haz clic en "Next".
Asegúrate de que las casillas "Import Maven projects automatically" y "Create modules from existing sources" estén marcadas.
Haz clic en "Next" y luego en "Finish".

4. Configurar el JDK (si es necesario):

Si IntelliJ IDEA no detecta automáticamente el JDK, ve a File > Project Structure > Project Settings > Project y asegúrate de que el JDK esté configurado correctamente.

5. Ejecutar la Aplicación:

Abre la clase principal Application.java ubicada en src/main/java/com/shaila/ejercicio/Application.java.
Haz clic con el botón derecho en la clase y selecciona "Run Application" para ejecutar la aplicación Spring Boot.

6. Acceder a Swagger:

Una vez que la aplicación esté en funcionamiento, puedes acceder a Swagger en tu navegador web: http://localhost:8080/swagger-ui/index.html
Aquí encontrarás la documentación y podrás probar el endpoint de la aplicación.

### Importar a Eclipse:

1. Clonar el Repositorio:

```bash
  git clone https://github.com/shaila13/ejercicio_ah_shaila_back.git
```
2. Abrir Eclipse:

Abre Eclipse en tu ordenador.

3. Importar el Proyecto:
Ve a File > Import > Existing Maven Projects.
Navega hasta el directorio donde clonaste el repositorio y selecciona la carpeta del proyecto.
Haz clic en "Finish" para importar el proyecto.

4. Ejecutar la Aplicación:

Abre la clase principal Application.java ubicada en src/main/java/com/shaila/ejercicio/Application.java.
Haz clic con el botón derecho en la clase y selecciona "Run As" > "Java Application" para ejecutar la aplicación Spring Boot.

5. Acceder a Swagger:

Una vez que la aplicación esté en funcionamiento, puedes acceder a Swagger en tu navegador web: http://localhost:8080/swagger-ui/index.html
Aquí encontrarás la documentación y podrás probar el endpoint de la aplicación.

## Uso
Una vez que la aplicación esté en funcionamiento, se pueden enviar solicitudes HTTP para consultar precios utilizando el endpoint REST proporcionado.

## Consultar Precio
Envía una solicitud GET a /prices con los siguientes parámetros de consulta:

brandId: Identificador de la cadena.
productId: Identificador del producto.
applicationDate: Fecha de aplicación con formato yyyy-MM-dd HH:mm:ss.
Ejemplo de solicitud:

```bash
GET /prices?brandId=1&productId=35455&applicationDate=2022-01-01 10:00:00
```

## APP Reference

#### Get prices
```http
  GET /prices
```

| Parameter  | Type        | Description                |
| :--------- | :---------- | :------------------------- |
| `applicationDate`  | `String` | **Required**. Fecha aplicación con formato 'yyyy-MM-dd-HH.mm.ss'. |
| `productId`| `long` | **Required**. Identificador del producto. |
| `brandId`  | `long` | **Required**. Identificador de la cadena. |

Por ejemplo:

GET /prices?brandId=1&productId=35455&applicationDate=2022-01-01 10:00:00

## Respuesta Exitosa
```bash
{
    "price": {
        "productId": 35455,
        "brandId": 1,
        "priceList": 1,
        "startDate": "2020-06-14T00:00:00",
        "endDate": "2020-12-31T23:59:59",
        "price": 35.5
    }
}

```
## Respuestas de Error
```bash
{
    "status": "NOT_FOUND",
    "message": "No prices were found for the provided parameters.",
    "timestamp": "2024-04-29T13:47:04.4583627"
}
{
    "status": "BAD_REQUEST",
    "message": "Incorrect date format. Expected 'yyyy-MM-dd HH:mm:ss'.",
    "timestamp": "2024-04-29T13:47:23.2061319"
}
```

## Postman Collection E2E-Tests-shaila

## Importar la colección de Postman

1. **Descargar la colección**:
   - Puedes descargar la colección de Postman desde [este enlace](/postman/E2E-Tests-shaila.postman_collection.json).

2. **Importar la colección**:
   - Abre [Postman](https://www.postman.com/) en tu computadora.
   - Haz clic en el botón "Import" en la esquina superior izquierda.
   - Selecciona la opción "Import File".
   - Navega hasta donde descargaste el archivo `E2E-Tests-shaila.postman_collection.json` y selecciónalo.
   - Postman importará la colección automáticamente.

3. **Verificar la importación**:
   - Una vez importada, verás la colección "E2E Tests Shaila" en tu panel de colecciones en Postman.

## Ejecutar las pruebas E2E
Puedes ejecutar las pruebas end-to-end (E2E) proporcionadas en la colección para probar la aplicación. Asegúrate de configurar las variables de entorno necesarias antes de ejecutarlas.

### Variables de entorno
- Antes de ejecutar las pruebas, asegúrate de configurar las siguientes variables de entorno en Postman:
   - `URL`: La URL base de la APP que quieres probar (por ejemplo, `http://localhost:8080`).

### Ejecutar las pruebas
- Abre la colección "E2E Tests Shaila" en Postman.
- Haz clic en "Runner" en la parte superior o haz clic en ... en el nombre de la colección y selecciona "Run collection".
- Selecciona la colección "E2E Tests Shaila" y las variables de entorno configuradas.
- Haz clic en "Run E2E-Tests-shaila" para ejecutar las pruebas E2E.

Con estos pasos, podrás probar fácilmente la aplicación utilizando las pruebas E2E proporcionadas en la colección de Postman.

## Construido Con
Java 17
Spring Boot
Maven
H2 Database
Swagger

Autores
Shaila Pérez Fernández - https://github.com/shaila13

## Licencia
Este proyecto está bajo la Licencia MIT.
[MIT](https://choosealicense.com/licenses/mit/)


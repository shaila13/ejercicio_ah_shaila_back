
# Servicio de Consulta de Precios
Este proyecto es una aplicación Spring Boot que proporciona un servicio REST para consultar precios en un sistema de comercio electrónico. Permite a los usuarios obtener información detallada sobre los precios de productos en diferentes marcas y fechas específicas. Utiliza una base de datos en memoria H2 para almacenar y recuperar los datos de precios de manera eficiente.


## Características
Consulta el precio actual de un producto en una cadena específica en una fecha determinada.
Proporciona un servicio RESTful para consultar precios.
Almacena los datos de precios en una base de datos H2 en memoria para una fácil administración y acceso.
Se integra con Swagger para documentar la API y facilitar su uso.

## Caso de Uso
### Consultar Precio Actual
Este caso de uso permite a un usuario consultar el precio actual de un producto en una cadena específica en una fecha determinada.

Actores: Usuario

![Consultar el precio aplicable de un producto.](url completa de la imagen)

## Diagrama de Flujo

Consultar Precio Actual

Este diagrama de flujo representa el flujo de interacción entre el usuario y el sistema para consultar el precio actual de un producto.

![](url completa de la imagen)

## Instalación
Para ejecutar la aplicación en tu máquina local, sigue estos pasos:

```bash
  git clone https://github.com/shaila13/ejercicio_ah_shaila_back.git
  cd ejercicio_ah_shaila_back
  ./mvnw spring-boot:run
```
La aplicación se ejecutará en http://localhost:8080/swagger-ui/index.html

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

## API Reference

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
{
  "prices": [
    {
      "productId": 35455,
      "brandId": 1,
      "priceList": 1,
      "startDate": "2022-01-01T00:00:00",
      "endDate": "2022-01-01T23:59:59",
      "price": 35.50
    },
    {
      "productId": 35455,
      "brandId": 1,
      "priceList": 2,
      "startDate": "2022-01-01T15:00:00",
      "endDate": "2022-01-01T18:30:00",
      "price": 25.45
    }
  ]
}

## Respuestas de Error
404 Not Found
Cuerpo: { "status": "404", "message": "No se encontraron precios para los parámetros proporcionados." }
400 Bad Request
Cuerpo: { "status": "400", "message": "Formato de fecha incorrecto. Se esperaba 'yyyy-MM-dd HH:mm:ss'." }

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


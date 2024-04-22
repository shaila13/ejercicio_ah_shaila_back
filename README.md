
# Servicio de Consulta de Precios
Este proyecto es una aplicación Spring Boot que proporciona un servicio REST para consultar precios en un sistema de comercio electrónico que sigue la arquitectura hexagonal. Utiliza una base de datos en memoria H2 para almacenar y recuperar datos de precios.

Este es un proyecto inicial para Java 17 con Maven.







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
  git clone https://github.com/shaila13/gft-e-commerce-price.git
  cd gft-e-commerce-price
  ./mvnw spring-boot:run
```
La aplicación se ejecutará en https://localhost:8080/api/v1.
## Uso

Una vez que la aplicación esté en funcionamiento, se pueden enviar solicitudes HTTP para consultar precios utilizando el endpoint REST proporcionado.
Envía una solicitud GET a /prices con los siguientes parámetros de consulta:

```bash
GET /prices?applicationDate=2022-01-01T10:00:00&productId=35455&brandId=1

```


## API Reference

#### Get all products

```http
  GET /api/v1/prices
```

| Parameter  | Type        | Description                |
| :--------- | :---------- | :------------------------- |
| `date`  | `Timestamp` | **Required**. Fecha aplicación con formato yyyy-MM-dd-HH.mm.ss. |
| `productId`| `long` | **Required**. Identificador del producto. |
| `brandId`  | `long` | **Required**. Identificador de la cadena. |

Por ejemplo:

GET /prices?date=2020-06-15-10.00.00&productId=35455&brandId=1
## Licencia
Este proyecto está bajo la Licencia MIT.
[MIT](https://choosealicense.com/licenses/mit/)


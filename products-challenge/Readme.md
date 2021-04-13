# Desafio Spring

### Tomas Matias Olalde

#### BaseURL: http://localhost:8080/api/v1/ 
En la raíz del proyecto se encuentra la colección de postman utilizada para probar las apis en caso de querer utilizarla.

#### Product Controller
|Metodo         | URI              | Ejemplo Request    | Description
| ------------- |:---------------:| :---------------:|---------: |
| `GET`           | articles       | /api/v1/articles?category=Deportes&freeShipping=true |Retorna losproductos filtrados o todos si no se aplica ningun filtro  |
| `GET`           | articles/{id}   | /api/v1/articles/1|  Retorna un producto por id         |


#### Client Controller
|Metodo         | URI              | Ejemplo Request    | Description
| :-------------: |:---------------:| :---------------:|---------: |
| `POST`           | client       | /api/v1/client |Crea un cliente y lo almacena en la BD |
| `GET`           | client  | /api/v1/client?provincia=LA Pampa&name=Tomas Olalde|Retorna los clientes filtrados o todos si no se aplica ningun filtro|
| `GET`           | client/{id}   | /api/v1/client/1|Retorna un cliente|

#### Ticket Controller
|Metodo         | URI              | Ejemplo Request    | Description
| ------------- |:---------------:| :---------------:|---------: |
| `POST`           | purchase-request       | /api/v1/purchase-request | Crea una orden de compras |
| `GET`           | ticket  | /api/v1/ticket | Retorna un ticket filtrado por id |
| `GET`           | ticket/{id}   | /api/v1/ticket/1 | Retorna el historial de tickets creados |

### Material de prueba
#### http://localhost:8080/api/v1/purchase-request
```
{
    "articles": [
            {
                "productId" : 8, 
                "name": "Smartwatch",
                "brand": "Noga",
                "quantity": 1
            },
            {
                "productId" : 5, 
                "name": "Zapatillas Deportivas",
                "brand": "Adidas",
                "quantity": 2
            }
    ]
}
```

#### http://localhost:8080/api/v1/client
```
{
    "name": "Tomas Matias Olalde",
    "state": "La Pampa"
}
```
### GlobalExceptionHandler

La clase GlobalExceptionHandler se encarga de capturar las distintas excepciones que 
existen en la aplicacion con el fin de enviar al frontend un modelo que sea siempre el mismo,
para asi la funcion encargada de recibir el modelo puede trabajar de forma consistente con el mismo

En el manejo de excepciones tabien entran en juego las clases **ApiError** y **ApiException**

En donde **ApiError** es el modelo que se le devuelve al frontend cuando surge una excepcion y **ApiException**
es la excepcion.

### Mejoras

* Asociar los usuarios a cada orden de compras.
* Que el stock de los productos sea descontado al momento de confirmar la compra y no cuando se genera la orden de compra. 
Ejemplo: si un *cliente A* genera una orden de compras y termina el stock de todos los productos de un articulo pero no los paga 
  y un *cliente B* quiere comprar ese articulo no va a poder. Si el *cliente A* llegara a cancelar la orden de compra, el negocio perdio la posibilidad de vender X cantidad de productos.   
  
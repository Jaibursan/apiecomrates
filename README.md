# apiecomrates

Microservicio con las funcionalidades relacionadas con las tarifas de e-commerce.

Incluye 2 controladores para los dos principales niveles del microservicio:
- PricesController: Se ha desarrollado usando una clase @Configuration con la
- Brands: Se ha desarrollado usando autoinyecciones

## Endpoints

- /prices 
    - GET
        - Descripción: Colección de tarifas de comercio electrónico
        - Tablas utilizadas: PRICES
        - Parámetros de entrada:
            - date?: dateTime. Fecha de aplicación. (Opcional)
            - product?: string. Identificador del producto (Opcional)
            - brand?: string. Identificador de la cadena (Opcional)
        - Respuesta: 
            - rates: Colección de tarifas. El objeto Rate contiene los siguientes campos:
                - product: string. Identificador del producto
                - brand: string. Identificador de la cadena
                - rate: string. Tarifa a aplicar
                - startDate: dateTime. Fecha de inicio de aplicación
                - endDate: dateTime. Fecha de fin de aplicación
                - price: Precio final a aplicar. El objeto Money contiene los siguientes campos: 
                    - money: number. Cantidad
                    - currency: string. Código de divisa según ISO-4217
# apiecomrates

Microservicio con las funcionalidades relacionadas con las tarifas de e-commerce.
Está estructurado en capas o paquetes y dentro de cada capa los archivos están separados por funcionalidades, según estén relacionadas con precios/tarifas o con marcas/cadenas.

El microservicio utiliza una base de datos H2 cargada en memoria al arrancar el servidor.

Las capas del microservicio son:

- api: Controladores y servicios que reciben las peticiones REST.
    - controller: Controladores que reciben las peticiones http.
    - service: Servicios utilizados por los controladores con las funciones asignadas a cada endpoint.
    - model: Modelos de datos que corresponden a los objetos de solicitud y respuesta de los endpoints del API. (No se utilizan en este proyecto porque se han utilizado los propios modelos del dominio) 
    - converter: Clases conversoras de los modelos de datos internos del dominio a los objetos de solicitud y respuesta de los endpoints. (No se utilizan en este proyecto porque se han utilizado los propios modelos del dominio) 

- application: Interfaces con las declaraciones de los métodos que ejecutan toda la la lógica de negocio.
    - bussines: Clases manejadoras y métodos que implementan la lógica de negocio.

- domain: Paquete para la implementación del dominio
    - model: Modelos de datos del dominio que dan soporte a la lógica del negocio y a la transferencia de información.

- infrastructure: Capa de conectores a sistemas externos (bases de datos, transacciones, webservices... En esta aplicación únicamente se utiliza conexión a una base de datos en memoria H2)
    - db.datasource: Conectores a bases de datos.
        - entity: Clases de las entidades que mapean las tablas de la base de datos (DAO)
        - repository: Paquete que contendrá las interfaces con la definición de las consultas y ejecución de procedimientos almacenados propios del datasource.
        - converter: Clases conversoras de las entidades a los modelos de datos del dominio de la aplicación.

- config: Clase que incluye y añade los beans necesarios al contexto Spring para la correcta ejecución de la aplicación.

## Endpoints precios/tarifas

- /prices 
    - GET
        - Descripción: Colección de tarifas de comercio electrónico
        - Tablas utilizadas: PRICES
        - Respuesta: 
            - prices: Colección de tarifas. El objeto Price contiene los siguientes campos:
                - product: string. Identificador del producto
                - brand: string. Identificador de la cadena
                - rate: string. Tarifa a aplicar
                - startDate: dateTime. Fecha de inicio de aplicación
                - endDate: dateTime. Fecha de fin de aplicación
                - price: Precio final a aplicar. El objeto Money contiene los siguientes campos: 
                    - money: number. Cantidad
                    - currency: string. Código de divisa según ISO-4217

- /pricestoapply 
    - GET
        - Descripción: Tarifa a aplicar para los filtros indicados
        - Tablas utilizadas: PRICES
        - Parámetros de entrada:
            - date?: string. Fecha de aplicación, en formato 'yyyy-MM-dd HH:mm:ss'. (Opcional)
            - producId?: string. Identificador del producto (Opcional)
            - brandId?: string. Identificador de la cadena (Opcional)
        - Respuesta: 
            - price: Colección de tarifas. El objeto Price contiene los siguientes campos:
                - productId: string. Identificador del producto
                - brandId: string. Identificador de la cadena
                - priceList: string. Tarifa a aplicar
                - startDate: dateTime. Fecha de inicio de aplicación
                - endDate: dateTime. Fecha de fin de aplicación
                - price: Precio final a aplicar. El objeto Money contiene los siguientes campos: 
                    - money: number. Cantidad
                    - currency: string. Código de divisa según ISO-4217
                
## Endpoints marcas/cadenas

- /brands 
    - GET
        - Descripción: Colección de marcas/cadenas de comercio electrónico
        - Tablas utilizadas: BRANDS
        - Respuesta: 
            - brands: Colección de marcas/cadenas. El objeto Brand, para este endpoint, contiene los siguientes campos:
                - brandId: string. Identificador de la marca/cadena.
                - brandName: string. Nombre de la marca/cadena.

- /brands/{brandId}
    - GET
        - Descripción: Detalle de marca/cadena de comercio electrónico, por identificador de la cadena.
        - Tablas utilizadas: BRANDS
        - Parámetros de entrada:
            - brandId?: string. Identificador de la cadena
        - Respuesta: 
            - brand: Detalle de marca/cadena. El objeto Brand, para este endpoint, contiene los siguientes campos:
                - brandId: string. Identificador de la marca/cadena.
                - brandName: string. Nombre de la marca/cadena.
                - nif: string. NIF de la marca/cadena.
                - address: string. Dirección fiscal de la marca/cadena.
                - cnae_code: string. Código de actividad CNAE de la marca/cadena.

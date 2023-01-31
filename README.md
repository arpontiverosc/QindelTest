Qindel Prices Test Applicacion
----------------------------------

Aplicación/servicio en SpringBoot (Versión 3.0.0 - Java 17) que provee una endpoint rest de consulta  tal que:
 
Acepta como parámetros de entrada (fecha de aplicación, identificador de producto y identificador de cadena).
Devuelve como datos de salida (identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar).
 
Incluye tests al endpoint rest que validan las siguientes peticiones al servicio con los datos del ejemplo:

                                                                                       
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

Para lanzar test. 
----------------------------------
Desde linea de comandos, en la ruta del proyecto donde se encuentra el fichero pom.xml ejecutar:
mvn test

Lanzar aplicación. 
----------------------------------
Desde linea de comandos, en ruta del proyecto donde se encuentra el fichero pom.xml ejecutar: 
mvn spring-boot:run

Postman
https://github.com/arpontiverosc/QindelTest/blob/main/src/main/resources/Qindel%20Test.postman_collection.json

Swagger
http://localhost:8080/swagger-ui/index.html



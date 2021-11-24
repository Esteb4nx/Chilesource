# Chilesource
Foro web desarrollado con framework Spring (Boot), Thymeleaf y Bootstrap  
Orientado a formar una comunidad en torno a la Informática en Chile

### Requerimientos:  
 - Maven 3.2+
 - OpenJDK/JDK 17 o superior
 - Servidor local o remoto de MariaDB/MySQL

### Instalación:
Antes de instalar:  
 1. Debes tener creada la base de datos `chilesourcedb` y aplicar el schema diseñado para el proyecto disponible
 [aqui](https://github.com/Esteb4nx/Chilesource/blob/main/src/main/resources/chilesource-schema.sql)


 2. Puedes poblar la base de datos con datos disponibles 
 [aquí](https://github.com/Esteb4nx/Chilesource/blob/main/src/main/resources/chilesource-data.sql) (Opcional)


 3. Tener disponible y en ejecución servicio MariaDB/MySQL, puedes modificar las configuraciones de la aplicación y 
 ajustarla a tu entorno o usuario en el archivo 
 [application.properties](https://github.com/Esteb4nx/Chilesource/blob/main/src/main/resources/application.properties)
 
Asegurados los pasos 1 y 3 de la etapa anterior:

 - En la carpeta raíz de Chilesource ejecutar: `mvn clean package`
   - Esto ejecutará las pruebas unitarias y creará el archivo `Foroweb-spring-0.0.1.jar` que será nuestra app 

 - Luego ejecutar `.jar` con: `java -jar target/Foroweb-spring-0.0.1.jar`


---
Iniciado en sept. 2021  
Fin desarrollo en nov. 2021

Creado por:
[Esteb4nx](https://github.com/Esteb4nx/) y [jmainhard](https://github.com/jmainhard)

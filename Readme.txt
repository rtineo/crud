1. El proyecto se le definio el puerto 9055 en src/resources/application.properties
2. Para desplegar la imagen se crea el snapshoot ejecutando en power shell:
mvn clean package

3. Una vez verificado que exista el snapshot en la carpeta /target del equipo ejecutamos en powershell:

docker build -t crud:v1 .

4. Verificamos que exista la imagen crud:
docker images

5. Desplegamos el contenedor basado en la imagen con puerto diferente 
docker run -d -p 8088:9055 --name pf-crud crud:v1

6. verificamos la escucha de la app desde http://localhost:8088/productos
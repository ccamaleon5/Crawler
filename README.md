# Crawler
Crawler navega páginas principales y encuentra patrones de hashtags, nombres de usuarios de twitter y cualquier nombre propio.


#JAR
java -jar crawler-1.0.0-SNAPSHOT.jar pathFile

#Docker
Ejecutar el archivo DockerFile, el cual contiene el archivo
websites.txt

docker build --build-arg artifact_id=crawler-ms --build-arg artifact_version=1.0.0 -t crawler-ms:1.0.0-SNAPSHOT .

docker run -dit crawler-ms:1.0.0-SNAPSHOT
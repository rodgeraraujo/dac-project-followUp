docker build -t java/database ./database
docker run -p 5433:5432 -d --name database java/database
mvn clean package
docker build -t java/app .
docker run -p 4848:4848 -p 8081:8080 --name followUp --link database:host-banco java/app
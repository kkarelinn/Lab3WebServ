docker stop sushi
docker stop webservice
docker stop java-postgres
docker container prune -f
docker rmi webserv_sushi
docker rmi webserv_webserv
docker rmi postgres:14.1-alpine

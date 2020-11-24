# aplicacao saque
Pre requisitos: Docker e docker-compose instalados na máquina, Java 11 e maven 3.6.x

1- Com maven configurado executar "mvn clean install -Dmaven.test.skip=true" na pasta raiz do projeto

2- Para subir aplicação bastar rodar o comando: "docker-compose up --build --force-recreate" na pasta raiz do projeto

para entrar no sistema: http://localhost:8080

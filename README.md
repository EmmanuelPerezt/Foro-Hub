<h1 align="center">Forohub</h1>


<img src='./assets/esp infrestructura.svg'>

---
<p>challenge final para el programa orcacle one.</p>


<p>este challenge consta en la realizacion de una api rest, el esecnario consta de una plataforma de de foro </p>


<h3 align="center">Documentacion</h3>

<p>en este caso en concreto usamos swagger para la documentacion el cual puedes visitar al estar corriendo el proyecto en:

http://localhost:8080/swagger-ui/index.html#/
</p>

<h3 align="center">Dockerizacion</h3>
<p>como atributo extra añadi dockerizacion para esta aplicacion por lo que puedes corrrer el proyecto de esta forma</p>


```bash
docker build -t <nombre de tu contenedor> .

docker run -p8080:8080 -d <nombre de tu contenedor>
```

<p>nota: el contenedor se conecta a la base de datos a nivel local de maquina host por lo que deberas tener corriendo ya un servicio mysql con las credenciales del archivo de produccion</p>




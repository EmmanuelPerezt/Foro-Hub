<h1 align="center">Forohub</h1>


<img src='./assets/esp infrestructura.svg'>

---
<p>Challenge final para el programa oracle one.</p>


<p>Este challenge consta en la implementacion de una api rest, el escenario consta de una plataforma de foro. </p>


<h3 align="center">Documentación</h3>

<p>En este caso en concreto usamos swagger para la documentacion el cual puedes visitar al estar corriendo el proyecto en:

http://localhost:8080/swagger-ui/index.html#/
</p>

<h3 align="center">Dockerizacion</h3>
<p>Como atributo extra añadi dockerizacion para esta aplicacion por lo que puedes corrrer el proyecto de esta forma.</p>


```bash
docker build -t <nombre de tu contenedor> .

docker run -p8080:8080 -d <nombre de tu contenedor>
```

<p>Nota: el contenedor se conecta a la base de datos a nivel local de maquina host por lo que deberas tener corriendo ya un servicio mysql con las credenciales del archivo de produccion.</p>


---
<h3 align="center">To do:</h3>
<p>El proyecto cumple con los requerimientos generales del readme, teniendo como bonus swagger y docker, pero para estar complementa faltarian de implementar.

- Respuesta endpoints
- curso endpoints
- registrar usuario

</p>

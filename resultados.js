var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);

idCuestionarios= 1;//parametros.get("Cuestionario");
idUsuario = 1;//parametros.get("Usuario");    
axios.get("http://localhost:4567/resultados?idUsuario=" + idUsuario + "&idCuestionario="+idCuestionarios)
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaRespuestas");
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                var num =1;
                let fila = document.createElement("tr");
                var col1 = document.createElement("th");
                col1.innerHTML = num;
                var col2 = document.createElement("td");
                col2.innerHTML = json[clave].pregunta;
                var col3 = document.createElement("td");
                col3.innerHTML = json[clave].respuesta;
                
                tablaRespuestas.appendChild(fila);
                fila.appendChild(col1);
                fila.appendChild(col2);
                fila.appendChild(col3);
                num = num +1;
            }
        }
    })
    .catch()

    axios.get("http://localhost:4567/video?idUsuario=" + idUsuario + "&idCuestionario="+idCuestionarios)
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaRespuestas");
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                var a = document.createElement('a')
                var texto = document.createTextNode("Descarga el video que tu alumno te envio")
                a.appendChild(texto)
                a.href = json[clave].video;
                a.download = "video.mp4"

                x = document.getElementById('descargaVideo')
                x.appendChild(a)
            }
        }
    })
    .catch()

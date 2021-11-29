axios.get("http://localhost:4567/asignacion")
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaUsuarios");
        var num =1;
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                let fila = document.createElement("tr");
                var col1 = document.createElement("th");
                col1.innerHTML = num;
                var col2 = document.createElement("td");
                col2.innerHTML = json[clave].nombre;
                var col3 = document.createElement("td");
                col3.innerHTML = json[clave].estado;
                var col4 = document.createElement("td");
                col4.innerHTML = `<a href='//127.0.0.1:5500/Resultados.html' type="button" class="btn btn-info">Revisar</a>`

                tablaRespuestas.appendChild(fila);
                fila.appendChild(col1);
                fila.appendChild(col2);
                fila.appendChild(col3);
                fila.appendChild(col4);
                num = num +1;
            }
        }
    })
    .catch()

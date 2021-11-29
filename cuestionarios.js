axios.get("http://localhost:4567/cuestionarios")
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaCuestionarios");
        var num =1;
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                let fila = document.createElement("tr");
                var col1 = document.createElement("th");
                col1.innerHTML = num;
                var col2 = document.createElement("td");
                col2.innerHTML = json[clave].nombre;
                var col3 = document.createElement("td");
                col3.innerHTML = `<a style="float: right;" type="button" value="`+ json[clave].id+`" id="lista" class="btn btn-success">Revisar</a>`

                tablaRespuestas.appendChild(fila);
                fila.appendChild(col1);
                fila.appendChild(col2);
                fila.appendChild(col3);
                num = num +1;
            }
        }
    })

var revisarCuestionario = document.getElementById("lista");
revisarCuestionario.addEventListener("click",function(){
    var id = revisarCuestionario.getAttribute("value");
    window.location.replace("/lista.html");
});

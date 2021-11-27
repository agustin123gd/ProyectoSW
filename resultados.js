    axios.get("http://localhost:4567/resultados")
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaRespuestas");
        for (var clave in json) {
            // Controlando que json realmente tenga esa propiedad
            if (json.hasOwnProperty(clave)) {
                // Mostrando en pantalla la clave junto a su valor
                // alert("La clave es " + clave + " y el valor es " + json[clave]);
                let fila = document.createElement("tr");
                fila.textContent = 
                    `<td scope="row">`+ clave+`</td>
                    <td>`+json[clave].correo+`</td>
                    <td>`+json[clave].correo+`</td>`
                tablaRespuestas.appendChild(tarea);


            }
        }
    })
    .catch()
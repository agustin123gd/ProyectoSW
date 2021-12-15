var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);

idCuestionarios = 1;//parametros.get("cuestionario");
nombre = "Matematicas"; //parametros.get("nombre");
idUsu=2; //parametros.get("usuario");

// var json;
var jsonRespuestas;
var preguntas =0;

preguntaCart = document.getElementById("preguntas");
var titulo = document.getElementById("nombreCuestionario");
titulo.innerHTML = nombre;

axios.get("http://localhost:4567/preguntas?idCuestionario=1")
    .then(function (res) {
        let json = res.data;
        cargarPreguntas(json)
        for (i in json)
            if (json[i].tipo == "multiple")
                cargarRespuestas(json[i].id);
            else {
                crearCampo(json[i].id);
            }
    })
    .catch();

function cargarPreguntas(json) {
    for (var clave in json) {
        if (json.hasOwnProperty(clave)) {
            // console.log("id " + json[clave].tipo)
            var preg = document.createElement("form");
            preg.setAttribute('class', 'card');
            preg.setAttribute('name','SinContestar')
            preg.setAttribute('id', json[clave].id);
            preg.setAttribute('style', 'width: 90%; margin-left: 5%;margin-right:  5%;');
            preg.innerHTML = `<h5 text-align="rigth" class="card-title">` + json[clave].pregunta + `</h5>`;
            var respuestas = document.createElement('ul');
            respuestas.setAttribute('id','ul'+json[clave].id)
            respuestas.setAttribute('class', 'list-group list-group-flush');
            preg.appendChild(respuestas);
            preguntaCart.appendChild(preg);
            preguntas ++;
            console.log(preguntas)
        }
    }
}


function cargarRespuestas(clave) {
    axios.get("http://localhost:4567/respuestas?idPregunta=" + clave)
        .then(function (res) {
            let jsonRespuesta = res.data;
            for (var i in jsonRespuesta) {
                let tmp = document.getElementById("ul"+clave)
                var r = document.createElement("li");
                r.setAttribute('style', 'width: 90%; margin-left: 5%;margin-right:  5%;');
                r.setAttribute('class', 'list-group-item');
                r.innerHTML = '<input type="radio" onclick="seleccion('+clave+`,\``+jsonRespuesta[i].respuesta+'\`)" name="li'+clave+'"><label>' + jsonRespuesta[i].respuesta + '</label>';
                tmp.appendChild(r)
            }
        })
        .catch();
}

function crearCampo(clave) {
    let tmp = document.getElementById(clave)
    var r = document.createElement("span");
    r.setAttribute('style', 'width: 90%; margin-left: 5%;margin-right:  5%;');
    r.setAttribute('class', 'list-group-item');
    r.innerHTML='<textarea id="btn'+clave+'" rows="5" cols="80"></textarea> <a type="button" onclick="asignarR('+clave+')">Guardar</a>';
    tmp.appendChild(r)
}

function seleccion(idPregunta,seleccion){
    let form = document.getElementById(idPregunta);
    form.setAttribute('name',seleccion)
}

function asignarR(idPregunta){
    let form = document.getElementById(idPregunta);
    let respuesta = document.getElementById('btn'+idPregunta).value;
    form.setAttribute('name',respuesta);

}

function guardar(){
    for(i=0;i<preguntas;i++){
        idP = document.forms[i].id;
        final = document.forms[i].name;
        guardarRespuesta(idP,final);
    }
}

function guardarRespuesta(id,respues){
    axios.post("http://localhost:4567/guardarRespuestas", { 
        idPregunta: id, 
        respuesta: respues, 
        idUsuario:  idUsu
    })
        .then(function (rs) {
            console.log(rs.data);
        })
        .catch(function (error) {
            console.log(error);
        });
}


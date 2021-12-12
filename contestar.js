var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);

idCuestionarios=1;//parametros.get("idCuestionario");
nombre ="cuestionario"; //parametros.get("nombre");

axios.get("http://localhost:4567/preguntas?idCuestionario=1")
    .then(function (res) {
        let json = res.data;
        let preguntaCart = document.getElementById("preguntas");
        var num =1;
        let titulo = document.getElementById("nombreCuestionario");
        titulo.innerHTML=nombre;
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                console.log("id "+json[clave].tipo)
                if(json[clave].tipo == "multiple"){
                    var preg = document.createElement("div");
                    preg.setAttribute('class','card');
                    preg.setAttribute('id','pregunta');
                    preg.setAttribute('style','width: 90%; margin-left: 5%;margin-right:  5%;');
                    preg.innerHTML = `<h5 text-align="rigth" class="card-title">`+json[clave].pregunta+`</h5>`;
                        
                    var respuestas= document.createElement('ul');
                    respuestas.setAttribute('clas','list-group list-group-flush');
                    axios.get("http://localhost:4567/respuestas?idPregunta=" + json[clave].id)
                        .then(function (res2) {
                            let jsonRespuestas = res2.data;

                            for (var clave2 in jsonRespuestas) {
                                if (jsonRespuestas.hasOwnProperty(clave2)) {
                                    var r =document.createElement("li");
                                    r.setAttribute('style','width: 90%; margin-left: 5%;margin-right:  5%;');
                                    r.setAttribute('clas','list-group-item');
                                    r.innerHTML ='<input type="radio"><label>'+jsonRespuestas[clave2].respuesta+'</label>';
                                    preg.appendChild(r);
                                }
                            }
                            
                        })
                        .catch()
                        
                    preg.appendChild(respuestas);
                    preguntaCart.appendChild(preg);     

                }else{
                    var preg = document.createElement("div");
                    preg.setAttribute('class','card');
                    preg.setAttribute('id','pregunta');
                    preg.setAttribute('style','width: 90%; margin-left: 5%;margin-right:  5%;');
                    preg.innerHTML = `<h5 text-align="rigth" class="card-title">`+json[clave].pregunta+`</h5>`;
        
                    var respuestas= document.createElement('ul');
                    respuestas.setAttribute('clas','list-group list-group-flush');
                    respuestas.innerHTML='<li style="width: 80%; margin-left: 5%;margin-right:  5%;" class="list-group-item"><textarea rows="5" cols="80"></textarea></li>';
                    
                    preg.appendChild(respuestas);
                    preguntaCart.appendChild(preg);
                }
            }
            num = num +1;

        }
    })
    .catch()
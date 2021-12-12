//const nuevaPregunta = document.querySelector('input');
//var NoPreguntas = 1;
//let CkAbierta = document.getElementById("RadioAbierta");
//let CkCerrada = document.getElementById("RadioCerrada");

function PreguntaCerrada() {
  div = document.getElementById('preguntaabierta');
  div.style.display = 'none';
  div = document.getElementById('preguntacerrada');
  div.style.display = '';
}

function Agregar(){
    
  var e = document.getElementById("btnAgregarMayor" + NoPreguntas);
  var e_eliminar = document.getElementById("btnAgregar" + NoPreguntas);
  var throwawayNode = e.removeChild(e_eliminar);
  NoPreguntas++;
  $('#secundario').append(actualizarplantilla);
}

function PreguntaAbierta() {
  div = document.getElementById('preguntacerrada');
  div.style.display = 'none';
  div = document.getElementById('preguntaabierta');
  div.style.display = '';
}

function añadirPregunta(){

  //Primer div para titulo de pregunta y opciones de pregunta
  let div = document.createElement("div"); //crear el div
  let pa = document.createElement("p");
  let input = document.createElement("input"); //crear el input
  let radio = document.createElement("input"); //crear radio1
  let radio2 = document.createElement("input"); //crear radio2
  //Atributos a los elementos
  div.className="contenido";
  input.id="pregunta2";
  input.placeholder="Pregunta sin título";
  input.style="width:400px;height:20px"
  radio.type="radio";
  radio.name="pregunta";
  radio.id="RadioAbierta";
  radio.onclick="PreguntaAbierta()";
  radio.textContent="Abierta";
  radio2.type="radio";
  radio2.name="pregunta";
  radio2.id="RadioCerrada";
  radio2.onclick="PreguntaCerrada()";
  radio2.textContent="OpcionMultiple";
  //agregamos los elementos al Div
  pa.appendChild(radio);
  pa.appendChild(radio2);
  div.appendChild(input);
  div.appendChild(pa);

  //Segundo div para las preguntas opcion multiple
  let div2 = document.createElement("div");
  let pa2 = document.createElement("p");
  let pa3 = document.createElement("p");
  let pa4 = document.createElement("p");
  let op1 = document.createElement("input");
  let op2 = document.createElement("input");
  let op3 = document.createElement("input");
  div2.className="preguntamulti";
  op1.name="resp";
  op1.placeholder="Escribe la opcion 1";
  op2.name="resp";
  op2.placeholder="Escribe la opcion 2";
  op3.name="resp";
  op3.placeholder="Escribe la opcion 3";

  pa2.appendChild(op1);
  pa3.appendChild(op2);
  pa4.appendChild(op3);
  div.appendChild(pa2);
  div.appendChild(pa3);
  div.appendChild(pa4);

  //tercer div para preguntas abiertas
  let div3 = document.createElement("div");
  let resp = document.createElement("input");
  div3.className="preguntaabierta";
  resp.placeholder="Escribe aquí la respuesta";
  resp.style="width:400px;height:20px";

  div3.appendChild(resp);

  div.appendChild(div2);
  div.appendChild(div3);

  document.body.appendChild(div);
}

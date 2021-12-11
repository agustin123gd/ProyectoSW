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
  let input = document.createElement("input"); //crear el input
  let radio = document.createElement("input"); //crear radio1
  let radio2 = document.createElement("input"); //crear radio2
  //Atributos a los elementos
  div.className="contenido";
  input.id="pregunta2";
  radio.type="radio";
  radio.value="Abierta";
  radio2.type="radio";
  radio2.value="OpcionMultiple";
  //agregamos los elementos al Div
  div.appendChild(input);
  div.appendChild(radio);
  div.appendChild(radio2);

  //Segundo div para las preguntas opcion multiple
  let div2 = document.createElement("div");
  let op1 = document.createElement("input");
  let op2 = document.createElement("input");
  let op3 = document.createElement("input");
  div2.className="preguntamulti";
  op1.type="radio";
  op2.type="radio";
  op3.type="radio";

  div2.appendChild(op1);
  div2.appendChild(op2);
  div2.appendChild(op3);

  div.appendChild(div2);

  document.body.appendChild(div);
}

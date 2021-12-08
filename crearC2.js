const nuevaPregunta = document.querySelector('input');

function seleccionar(){
  let sel = document.getElementById('select');
  let elegido = sel.value;

  document.getElementById('Seleccionado').innerText = `Ud. ha seleccionado pregunta ${elegido}.`;

}

function preguntaAbierta(){
  input.textContent = 'Prueba';
  const input = document.createElement('input');
  nuevaPregunta.appendChild(input);
}

/*function agregarPregunta(){
  var newDiv = document.createElement("div");
  var newContent = document.createElement("input");
  newDiv.appendChild(newContent);
  //document.getElementById("titulo").innerHTML = "otro intento";
}
document.getElementById("agregar").onclick = function(){
  preguntaAbierta();
}*/
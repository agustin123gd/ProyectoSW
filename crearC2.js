function seleccionar(){
  let sel = document.getElementById('select');
  let elegido = sel.value;

  document.getElementById('Seleccionado').innerText = `Ud. ha seleccionado el lenguaje ${elegido}.`;
}

function preguntaAbierta(){
  var textInput = document.createElement('input');
  textInput.setAttribute('type', 'button');
  textInput.setAttribute('name', respAbierta);
  //document.getElementById("titulo").innerHTML = "otro intento";
}
document.getElementById("agregar").onclick = function(){
  preguntaAbierta();
}
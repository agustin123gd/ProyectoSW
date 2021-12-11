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
  let div = document.createElement("div");
  let input = document.createElement("input");
  
  document.body.appendChild(input);
}

//creamos una clase para añadir la nueva pregunta
/*class nuevaPregunta extends HTMLElement {
  constructor() {
    //llamar al super constructor
    super();

    //crear un shadow root
    var shadow = this.attachShadow({mode: 'open'});

    //crear elementos
    var info = document.createElement('span');
    info.setAttribute('class', 'info');

    //coger el contenido del atributo text y ponerlo en el span info
    var text = this.getAttribute('text');
    info.textContent = text;

    //crear los estilos Css e incluirlos en el shadow DOM
    var style = document.createElement('style');
    style.textContent = '.wrapper {' +
                              '}' +

                              '.info {' +
                              'font-size: 0.8rem;' +
                              'width: 200px;' +
                              'display: inline-block;' +
                              'border: 1px solid black;' +
                              'padding: 10px;' +
                              'background: white;' +
                              'border-radius: 10px;' +
                              'opacity: 0;' +
                              'transition: 0.6s all;' +
                              'position: absolute;' +
                              'bottom: 20px;' +
                              'left: 10px;' +
                              'z-index: 3;' +
                            '}';
                       
    //adjuntar los elementos creados al shadow DOM 
    //notese que el span wrapper contiene los elementos

    shadow.appendChild(this.style);
    shadow.appendChild(wrapper);
    shadow.appendChild(info);

  }
}

//definir nuevo elemento
customElements.define('nuevaPregunta', nuevaPregunta); */
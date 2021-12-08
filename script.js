var btnRegistrar = document.getElementById("btnRegistrar");
btnRegistrar.addEventListener("click", () => {
    axios.post("http://localhost:4567/usuario", {
        nombre: document.getElementById("nombre").value,
        correo: document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value,
        tipo: document.getElementById("tipo").value
    })
        .then(function (res) {
            alert("Usuario:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});

var btnIniciar = document.getElementById("btnIniciar");
btnIniciar.addEventListener("click",function(){
    window.location.replace("/elige.html");
})
var btnIniciar = document.getElementById("login-button");
btnIniciar.addEventListener("click", () => { 
    axios.get("http://localhost:4567/validar", {
        correo:  document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value
    })
    .then(function(rs) {
        console.log(rs.data);
    })
    .catch(function (error) {
        console.log(error);
    });
});

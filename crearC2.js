function validar(){
        
    valor = document.getElementById('radio').value;
    
    if( valor == null || valor.length == 0) {
      alert('Error, elige una opción');
    return false;
    }  
  
}
  
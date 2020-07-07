function validate() {
    var name = document.getElementById("nameId").value;
    var email = document.getElementById("emailId").value;
    var prov = document.getElementById("provId").value;
    
    if (name != "" && email != "") {
        if (name.length <= 20) {
            document.getElementById("info").innerHTML = name + " con email " + email + " vive en " + prov;
            document.getElementById("alert").style.color = "black";
            document.getElementById("alert").innerHTML = "CORRECTO"
        } else {
            document.getElementById("alert").style.color = "red";
            document.getElementById("alert").innerHTML = "El nombre no puede superar los 20 caracteres"
        }
    } else {
        document.getElementById("alert").style.color = "red";
        document.getElementById("alert").innerHTML = "Rellena todos los campos"
    }
}
var nombre = "Sonia";
var obj = {
    nombre: "Pepito",
    saludo: function() {
        var saludo_fn = function(miNombre) {
            console.log("Hola " + miNombre);
        };
        saludo_fn(this.nombre);
    }
}

obj.saludo();
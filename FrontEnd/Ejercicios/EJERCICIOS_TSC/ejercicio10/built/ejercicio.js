class Persona {
    constructor(client) {
        this.edad = client.edad;
        this.nombre = client.nombre;
        this.apellidos = client.apellidos;
    }
    getEdad() {
        return this.edad;
    }
    getNombreCompleto() {
        return (this.nombre + " " + this.apellidos);
    }
}
class Operario extends Persona {
    getNombreOperario() {
        return ("OPERARIO: " + this.nombre + " " + this.apellidos);
    }
    getEdadOperario() {
        return this.edad;
    }
}
let operario = new Operario({ edad: 21, nombre: "Fran", apellidos: "Piñero" });
console.log(operario.getEdadOperario());

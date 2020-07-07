class Cliente {
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
let cliente = new Cliente({ edad: 21, nombre: "Fran", apellidos: "Piñero" });
console.log(cliente.getEdad());
console.log(cliente.getNombreCompleto());

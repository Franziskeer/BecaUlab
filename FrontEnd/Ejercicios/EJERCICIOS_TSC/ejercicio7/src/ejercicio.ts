interface datosPersonales {
    edad:number;
    nombre:string;
    apellidos:string;
}

class Persona implements datosPersonales {
    edad:number;
    nombre:string;
    apellidos:string;

    constructor(client:datosPersonales) {
        this.edad = client.edad;
        this.nombre = client.nombre;
        this.apellidos = client.apellidos;
    }

    getEdad():number {
        return this.edad;
    }
    getNombreCompleto():string {
        return (this.nombre + " " + this.apellidos);
    }
}

let cliente = new Persona({edad:21, nombre:"Fran", apellidos:"Piñero"});
console.log(cliente.getEdad());
console.log(cliente.getNombreCompleto());
interface datosPersonales {
    edad:number;
    nombre:string;
    apellidos:string;
}

class Persona implements datosPersonales {
    readonly edad:number;
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

    /*
    setEdad(edad:number):void {
        this.edad = edad;
    }
    setNombre(nombre:string):void {
        this.nombre = nombre;
    }
    setApellidos(apellidos:string):void {
        this.apellidos = apellidos;
    }
    */
}

class Operario extends Persona {
    getNombreOperario():string {
        return ("OPERARIO: " + this.nombre + " " + this.apellidos); 
    }
    getEdadOperario():number {
        return this.edad;
    }
}

let operario = new Operario({edad:21, nombre:"Fran", apellidos:"Piñero"});
console.log(operario.getEdadOperario());
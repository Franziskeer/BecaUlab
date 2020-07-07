interface datosPersonales {
    edad:number;
    nombre:string;
    apellidos:string;
    domicilio?:string;
}

function verDatosPersonales(datos:datosPersonales):void {
    console.log("EDAD: " + datos.edad);
    console.log("NOMBRE: " + datos.nombre);
    console.log("APELLIDOS: " + datos.apellidos);
    console.log("DOMICILIO: " + datos.domicilio);
}
/*
let cliente = { edad: 21, nombre: "Francisco", apellidos: "Piñero Alpañés", domicilio: "C/Libertad, 24"};
*/
let cliente:datosPersonales = {edad:100, nombre:'ANTONIO', apellidos:'MARTÍNEZ'};
verDatosPersonales(cliente);


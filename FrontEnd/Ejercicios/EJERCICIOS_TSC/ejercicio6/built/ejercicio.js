function verDatosPersonales(datos) {
    console.log("EDAD: " + datos.edad);
    console.log("NOMBRE: " + datos.nombre);
    console.log("APELLIDOS: " + datos.apellidos);
    console.log("DOMICILIO: " + datos.domicilio);
}
/*
let cliente = { edad: 21, nombre: "Francisco", apellidos: "Piñero Alpañés", domicilio: "C/Libertad, 24"};
*/
let cliente = { edad: 100, nombre: 'ANTONIO', apellidos: 'MARTÍNEZ' };
verDatosPersonales(cliente);

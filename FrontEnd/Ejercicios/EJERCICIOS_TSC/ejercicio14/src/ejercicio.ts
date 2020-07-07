interface objetoCliente<T,U> {
    cliente:T;  
    estado:U
}

let cliente1:objetoCliente<string,string> = { cliente: "ANTONIO", estado: "ACTIVO" };
console.log(cliente1);
let cliente2:objetoCliente<number,number> = { cliente: 12, estado: 1 };
console.log(cliente2);

enum CLIENTES {
    codigo,
    estado
}
let cliente3:objetoCliente<CLIENTES, CLIENTES> = { cliente: CLIENTES.codigo, estado: CLIENTES.estado };
console.log(cliente3);

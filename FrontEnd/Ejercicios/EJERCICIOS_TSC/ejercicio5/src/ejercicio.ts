function suma(op1:number, op2:number):number {
    return op1+op2;
}

function men3(op1?:number):boolean {
    if (op1 > 3)
        return false;
    
    return true;
}

function def(op1:string="INDEFINIDO"):string {
    return op1;
}

let a:number = suma(1,2);
let b:boolean = men3(5);
let c:string = def(undefined);

console.log(a);
console.log(b);
console.log(c);
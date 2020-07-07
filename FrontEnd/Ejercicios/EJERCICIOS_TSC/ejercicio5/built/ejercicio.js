function suma(op1, op2) {
    return op1 + op2;
}
function men3(op1) {
    if (op1 > 3)
        return false;
    return true;
}
function def(op1 = "INDEFINIDO") {
    return op1;
}
let a = suma(1, 2);
let b = men3(5);
let c = def(undefined);
console.log(a);
console.log(b);
console.log(c);

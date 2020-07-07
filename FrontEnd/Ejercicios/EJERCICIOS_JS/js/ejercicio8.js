function suma(suma1, suma2) {
    console.log(suma1 + suma2);
}

(function(suma1, suma2) {
    console.log(suma1 + suma2);
}(12,12))

window.onload=function() {
    suma(1,1);
;}

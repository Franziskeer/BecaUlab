
function startTime() {
    today=new Date();
    h=today.getHours();
    m=today.getMinutes();
    s=today.getSeconds();
    document.getElementById("reloj").innerHTML="Hora actual: "+h+":"+m+":"+s;
;}

window.onload=function() {
    startTime()
;}

let EventEmitter = require("events").EventEmitter;
let pub = new EventEmitter();

pub.on("ev", (m) => {
    console.log("[ev]", m);
});
pub.once("ev", (m) =>{
    console.log("(ha sido la primera vez)");
});

pub.emit("ev", "Soy un Emisor de Eventos!");
pub.emit("ev", "Me vas a ver muy a menudo...");

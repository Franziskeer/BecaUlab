let Promise = require("promise");

let hazAlgoCritico = (p1) => {
    return new Promise( (resolve, reject) => {
        if (p1 === 1) resolve({ resultado: "EJECUTADO CON EXITO"});
        if (p1 === 0) reject({ resultado: "EJECUTADO CON ERROR"});
        reject({ resultado: "NO TRATADO"})
    });
}

hazAlgoCritico(0).then(
    ok => {
        debugger;
        console.log(ok);
    },
    err => {
        console.log(err);
    }
)
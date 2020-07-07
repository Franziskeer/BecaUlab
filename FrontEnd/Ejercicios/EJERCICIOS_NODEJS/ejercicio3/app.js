let http = require("http");
let server = http.createServer();

server.on("request", function(req, res) {
    res.end("<b>Hola, Mundo!</b>");
});

server.listen(3000);

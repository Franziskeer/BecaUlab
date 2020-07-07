let express = require("express");
let app = express();
let route = express.Router();

app.get("/prueba1", (req, res) => {
    res.status(200).send("Prueba 1");
})

app.post("/prueba1", function (req, res) {
    res.send(req.body);
});

app.use(function(req, res, next) {
    res.status(404).send("Sorry, that route doesn't exist. Have a nice day :)");
});

app.use(route);
app.listen(3000, function () {
    console.log('Example app listening on port 3000.');
});
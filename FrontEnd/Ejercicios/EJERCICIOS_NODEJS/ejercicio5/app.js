let express = require("express"), app = express();

app.get('/', function (req, res) {
    res.send("¡Hola mundo! :3");
})
   
app.listen(3000);
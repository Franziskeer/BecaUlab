var objetoPadre = {
    edad: null,
    nombre: null,
    apellidos: null,
    muestraDatos: function() {
        console.log(this.nombre + " " + this.apellidos + " " + this.edad);
    }
}

var hijo1 = Object.create(objetoPadre);
hijo1.edad = 21;
hijo1.nombre = "Antonio";
hijo1.apellidos = "Martinez Soria";

hijo1.muestraDatos();
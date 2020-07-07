try {
    throw new EvalError('Se ha producido un error','ejercicio13.js',100);
} catch (err) {
    console.log(err.message);
}
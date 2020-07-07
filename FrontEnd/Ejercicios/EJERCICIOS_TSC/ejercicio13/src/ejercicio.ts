function generica<T> (param:T) {
    console.log(param);
}

generica<string>("Hola mundo");
generica<number>(21);
generica<number[]>([1,2,3,4]);
generica<string[]>(["uno","dos","tres","cuatro"]);
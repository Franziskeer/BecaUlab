let myMenu = { menu: 'menu1', precio: '20' };
let nuevoMenu = Object.assign(Object.assign({}, myMenu), { menu: 'menu2', precio: '30' });
console.log(nuevoMenu);

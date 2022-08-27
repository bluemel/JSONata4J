var jsonata = require("./jsonata");

console.log('@@@ JS mapping @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');
console.log(mapping);
console.log('@@@ JS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');
var expression = jsonata(mapping);
console.log('@@@ expression = "' + expression + '"');
console.log('@@@ JS input @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');
console.log(input);
console.log('@@@ JS output @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');
var output = expression.evaluate(input);
console.log(output);
console.log('@@@ JS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');

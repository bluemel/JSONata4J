const jsonata = require("./jsonata");

let json = JSON.parse(input)

const output = jsonata(mapping).evaluate(json, {}, async (error, result) => {
    if (error) {
        console.error(error);
        return;
    }
});
output.then((value) => {
    console.log(value)
})

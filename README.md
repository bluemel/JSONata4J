A first try to run [JSONata](https://jsonata.org/) original Javascript sources on Java using the [GraalVM](https://www.graalvm.org/).

However... currently it does not work out.
I've managed so far
- to parse the original JSONata Javascript sources using the org.graalvm.polyglot.Context from the [GraalVM SDK](https://www.graalvm.org/sdk/javadoc/)
- to hand over a JSONata mapping definition and some input JSON
  (from JSONata Exerciser example "Invoice") to a simple
  Javascript main program:

```javascript
var jsonata = require("./jsonata");
var expression = jsonata(mapping);
var output = expression.evaluate(input);
```

But unfortunately the javascript seems not to produce any output
(output is "undefined" / null).

I'd appreciate very much if someone could help me out.

Versions used (last update August 27th 2022
- openjdk version "17-ea" 2021-09-14
- Apache Maven 3.6.3
- GraalVM Java SDK org.graalvm.sdk:graal-sdk:22.2.0
- GraalVM js 22.2.0 org.graalvm.js:js:22.2.0
- JSONata 1.8.6 (Javascript sources only)

In order to build and run my code simply:
- clone this git repository
- Download the JSONata sources and unpack them
- copy all 6 Javascript source files to project folder 
  src/main/js where main.js already resides:
    - jsonata.js
    - parser.js
    - signature.js
    - datetime.js
    - functions.js
    - utils.js
- Then build the project with Maven install

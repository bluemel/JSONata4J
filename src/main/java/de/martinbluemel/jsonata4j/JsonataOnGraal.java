package de.martinbluemel.jsonata4j;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class JsonataOnGraal {

	final Source jsonataSource;
	final Context jsContext;

	public JsonataOnGraal() {
		try {
			this.jsonataSource = Source
					// .newBuilder("js", new File("src/lib/jsonata-1.8.6/experimental/jsonataAll.js"))
					.newBuilder("js", new File("src/main/js/main.js"))
					.build();
			// see https://github.com/oracle/graaljs/issues/415
			Map<String, String> options = new HashMap<>();
			options.put("js.commonjs-require", "true");
			options.put("js.commonjs-require-cwd", "./");
			this.jsContext = Context.newBuilder("js")
					.allowExperimentalOptions(true)
					.allowAllAccess(true)
					.allowIO(true)
					.options(options)
					.build();
			jsContext.parse(jsonataSource);
		} catch (IOException e) {
			throw new MappingEvaluationException(e);
		}
	}

	public String map(String input, String mapping) {
		// evaluate(expr, input, environment)
		Value bindings = this.jsContext.getBindings("js");
		bindings.putMember("input", input);
		bindings.putMember("mapping", mapping);
		Value result = this.jsContext.eval(jsonataSource);
		return result.asString();
		// return bindings.getMember("output").asString();
	}
}

package de.martinbluemel.jsonata4j;

import java.io.File;
import java.io.IOException;

import com.api.jsonata4java.expressions.EvaluateException;
import com.api.jsonata4java.expressions.Expressions;
import com.api.jsonata4java.expressions.ParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonata4JavaMapper extends JsonataMapper {

	private final Expressions expressions;

	private final ObjectMapper mapper = new ObjectMapper();

	Jsonata4JavaMapper(String mappingDescription) {
		super(mappingDescription);
		this.expressions = parseMappingDescription();
	}

	@Override
	public String map(String in) {
		JsonNode outNode;
		try {
			outNode = this.expressions.evaluate(mapper.readTree(in));
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(outNode);
		} catch (JsonProcessingException | EvaluateException e) {
			throw new MappingEvaluationException(e);
		}
	}

	@Override
	public void map(File in, File out) {
		throw new RuntimeException("Not yet implemented");
	}

	Jsonata4JavaMapper(File mappingDescriptionFile) {
		super(mappingDescriptionFile);
		this.expressions = parseMappingDescription();
	}

	private Expressions parseMappingDescription() {
		try {
			return Expressions.parse(super.mappingDescription);
		} catch (ParseException | IOException e) {
			throw new MappingParseException(e);
		}
	}
}

package de.martinbluemel.jsonata4j;

import java.io.File;

public class JsonataOnGraalMapper extends JsonataMapper {

	@Override
	public String map(String in) {
		throw new RuntimeException("Not yet implemented");
	}

	@Override
	public void map(File in, File out) {
		throw new RuntimeException("Not yet implemented");
	}

	JsonataOnGraalMapper(String mappingDescription) {
		super(mappingDescription);
		// this.expressions = parseMappingDescription();
	}

	JsonataOnGraalMapper(File mappingDescriptionFile) {
		super(mappingDescriptionFile);
		// this.expressions = parseMappingDescription();
	}
}

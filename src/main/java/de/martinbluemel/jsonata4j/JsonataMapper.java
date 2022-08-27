package de.martinbluemel.jsonata4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class JsonataMapper {

	protected final String mappingDescription;

	public abstract String map(String in);

	public abstract void map(File in, File out);

	JsonataMapper(final File mapping) {
		this.mappingDescription = readFile(mapping);
	}

	public JsonataMapper(String mappingDescription) {
		this.mappingDescription = mappingDescription;
	}

	public static String readFile(final File file) {
		try {
			return new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			throw new MappingParseException(e);
		}
	}
}

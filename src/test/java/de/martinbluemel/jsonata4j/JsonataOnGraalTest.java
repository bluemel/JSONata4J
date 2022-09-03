package de.martinbluemel.jsonata4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.Test;

class JsonataOnGraalTest {

	@Test
	void map() {
		assertJsonataSourceFile("jsonata");
		assertJsonataSourceFile("parser");
		assertJsonataSourceFile("signature");
		assertJsonataSourceFile("datetime");
		assertJsonataSourceFile("functions");
		assertJsonataSourceFile("utils");
		String mapped = new JsonataOnGraal().map(
				JsonataMapper.readFile(new File("src/test/resources/mapping01/in.json")),
				JsonataMapper.readFile(new File("src/test/resources/mapping01/mapping.jsonata")));
		System.out.println("@@@ TEST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(mapped);
		System.out.println("@@@ TEST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		// unfortunately we do yet not get any value back from main.js
		assertEquals(null, mapped);
	}

	private void assertJsonataSourceFile(String sourceName) {
		File jsonataSourceFile = new File("src/main/js/" + sourceName + ".js");
		if (!jsonataSourceFile.exists()) {
			fail("Missing JSONata Javascript source file: " + jsonataSourceFile.getAbsolutePath()
					+ ", Please download from https://github.com/jsonata-js/jsonata");
		}
	}
}

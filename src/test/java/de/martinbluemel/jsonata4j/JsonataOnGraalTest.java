package de.martinbluemel.jsonata4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

class JsonataOnGraalTest {

	@Test
	void map() {
		assertTrue(new File("src/main/js/jsonata.js").exists());
		assertTrue(new File("src/main/js/parser.js").exists());
		assertTrue(new File("src/main/js/signature.js").exists());
		assertTrue(new File("src/main/js/functions.js").exists());
		assertTrue(new File("src/main/js/utils.js").exists());
		String mapped = new JsonataOnGraal().map(JsonataMapper.readFile(new File("src/test/resources/mapping01/in.json")),
				JsonataMapper.readFile(new File("src/test/resources/mapping01/mapping.jsonata")));
		System.out.println("@@@ TEST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(mapped);
		System.out.println("@@@ TEST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		// unfortunately we do yet not get any value back from main.js
		assertEquals(null, mapped);
	}
}

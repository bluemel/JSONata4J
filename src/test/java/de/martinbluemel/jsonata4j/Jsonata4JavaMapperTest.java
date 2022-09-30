package de.martinbluemel.jsonata4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Jsonata4JavaMapperTest {

	Jsonata4JavaMapper mapper;

	@Test
	void jsonata4JavasContainsFunctionCanNotWorkWithRegularExpressions() {
		assertEquals("\"yes\"", new Jsonata4JavaMapper("$contains(a, \"schoener\") ? \"yes\" : \"nope\"")
				.map("{ \"a\": \"Das ist ein schoener Test\" }"));
		assertEquals("\"yes\"", new Jsonata4JavaMapper("$contains(a, /sch.*ner/) ? \"yes\" : \"nope\"")
				.map("{ \"a\": \"Das ist ein schoener Test\" }"));
	}
}

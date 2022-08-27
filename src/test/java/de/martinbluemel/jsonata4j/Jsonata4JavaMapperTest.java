package de.martinbluemel.jsonata4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Jsonata4JavaMapperTest {

	Jsonata4JavaMapper mapper;

	@Test
	void jsonata4JavasContainsFunctionCanNotWorkWithRegularExpressions() {
		assertEquals("\"yes\"", new Jsonata4JavaMapper("$contains(a, \"schoener\") ? \"yes\" : \"nope\"")
				.map("{ \"a\": \"Das ist ein schoener Test\" }"));
		RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			new Jsonata4JavaMapper("$contains(a, /sch.*ner/) ? \"yes\" : \"nope\"")
					.map("{ \"a\": \"Das ist ein schoener Test\" }");
		});
		assertTrue(thrown instanceof MappingParseException);
	}
}

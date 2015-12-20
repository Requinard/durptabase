package parser;

import parser.tokenizer.Token;

import java.util.Collection;

/**
 * Edited on david on 20-12-15.
 */
public class ParserTest {

    @org.junit.Test
    public void testParse() throws Exception {
        Parser p = new Parser();
        String query = "select all from database";

        Collection<Token> tokens = p.parse(query);

        tokens.stream().forEach((Token t) -> System.out.println(t));
    }
}
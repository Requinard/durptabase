package parser;

import parser.instruction.Instruction;
import parser.tokenizer.Token;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Edited on david on 20-12-15.
 */
public class ParserTest {
    private final String query_happy = "select all from database";
    private final String query_with_newlines = "select all \r\n\tfrom database";
    private final String query_with_where = "select all from database where x <= 0 and y = 0" ;

    @org.junit.Test
    public void testTokenize() throws Exception {
        Parser p = new Parser();

        Collection<Token> tokens;

        tokens = p.tokenize(query_happy);

        assertTrue("Did not get the right amount of tokens during tokenization of a string", tokens.size() == query_happy.split(" ").length);

        tokens.stream().forEach((Token t) -> System.out.println(t));

        p = new Parser();

        tokens = p.tokenize(query_with_newlines);

        assertTrue("input with newlines did not get the right amount of tokens", tokens.size() == query_with_newlines.split(" ").length);

    }

    @org.junit.Test
    public void testParse() {
        Parser p = new Parser();

        Instruction instruction;

        instruction = p.parse(query_happy);

        System.out.println(instruction);

        instruction = p.parse(query_with_where);

        System.out.println(instruction);
    }
}
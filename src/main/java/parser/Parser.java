package parser;

import parser.tokenizer.Token;
import parser.tokenizer.Tokenizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Edited on david on 20-12-15.
 */
public class Parser {
    public final Tokenizer tokenizer;


    public Parser() {
        tokenizer = new Tokenizer();

        tokenizer.add("select", 1); //Starting out formats
        tokenizer.add("from", 2); // Table definition
        tokenizer.add("[a-zA-Z0-9_]*",3); // variables
    }

    public Collection<Token> parse(String input){
        return tokenizer.tokenize(input);
    }
}

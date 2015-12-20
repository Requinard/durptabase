package parser;

import parser.instruction.Instruction;
import parser.tokenizer.Token;
import parser.tokenizer.Tokenizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Edited on david on 20-12-15.
 */
public class Parser {
    public final Tokenizer tokenizer;

    public Parser() {
        tokenizer = new Tokenizer();

        List<String> tokens = getTokens();

        for (int i = 0; i < tokens.size(); i++) {
            tokenizer.add((String) tokens.toArray()[i], i);
        }
    }

    public List<String> getTokens() {
        return Arrays.asList(
                "select|insert",    //Operation
                "from|into",        // Table definition
                "where",            //Condition
                "and|or",           // Boolean operator
                "[<>=]+",           // Expression Operator
                "[a-zA-Z0-9_]*"     // Variables
        );
    }

    public Instruction parse(String input) {
        Collection<Token> tokens = tokenize(input);

        Instruction instruction = new Instruction(tokens);

        return instruction;
    }

    public Collection<Token> tokenize(String input) {
        return tokenizer.tokenize(input);
    }
}

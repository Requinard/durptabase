package parser.instruction;

import parser.tokenizer.Token;

import java.util.Arrays;
import java.util.Collection;

/**
 * Edited on david on 20-12-15.
 */
public class Instruction {
    Token operator;
    Token value;
    Instruction subInstruction;
    Instruction parallelInstruction;

    public Instruction(Collection<Token> input) {
        Token[] tokens = (Token[]) input.toArray(new Token[0]);
        operator = tokens[0];

        if (tokens.length > 1) {
            value = tokens[1];
        }

        if (tokens.length > 2){
            if(tokens[2].token <= operator.token){
                parallelInstruction = new Instruction(Arrays.asList(tokens).subList(2, tokens.length));
            } else {
                subInstruction = new Instruction(Arrays.asList(tokens).subList(2, tokens.length));
            }
        }
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(operator.sequence);

        if (value != null)
            builder.append("\t" + value.sequence);

        builder.append("\r\n");

        if (subInstruction != null) {
            String[] split = subInstruction.toString().split("\r\n");

            for(String s: split){
                builder.append("\t" + s + "\r\n");
            }
        }
        if(parallelInstruction != null){
            String[] split = parallelInstruction.toString().split("\r\n");

            for(String s: split){
                builder.append(s + "\r\n");
            }
        }

        return builder.toString();
    }
}

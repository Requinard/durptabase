package parser.tokenizer;

import jdk.nashorn.internal.runtime.ParserException;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Modular tokenizer class that can handle tokenizing input strings to form generic parsers
 * Help from: http://cogitolearning.co.uk/?p=525
 */
public class Tokenizer {
    private List<TokenInfo> tokenInfos;
    private List<Token> tokens;

    public Tokenizer() {
        tokenInfos = new LinkedList<>();
        tokens = new LinkedList<>();
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
    }

    public Collection<Token> tokenize(String input){
        String local = new String(input);
        tokens.clear();

        while(!local.equals("")){
            boolean match = false;

            for(TokenInfo info: tokenInfos){
                Matcher m = info.regex.matcher(local);

                if(m.find()){
                    match=true;

                    String token = m.group().trim();

                    tokens.add(new Token(info.token, token));

                    local = m.replaceFirst("").trim();
                    break;
                }
            }

            if(!match) throw new ParserException("Unexpected character in input");
        }

        return Collections.unmodifiableCollection(tokens);
    }

}

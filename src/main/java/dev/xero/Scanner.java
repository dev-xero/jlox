package dev.xero;

import java.util.ArrayList;
import java.util.List;

import static dev.xero.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while(!isAtEnd()) {
            // We are at the beginning of the next lexeme
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }
}

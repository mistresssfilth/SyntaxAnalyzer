import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
         String code = "2 + 2 * -2";
         Lexer lexer = new Lexer(code);
         List<Token> tokenList = lexer.tokenize();
         for (Token token : tokenList){
             System.out.println(token.getTokenType() + " " + token.getText());
         }

         final List<Expression> expressions = new Parser(tokenList).parse();
        for (Expression expression : expressions){
            System.out.println(expression + " " + expression.eval());
        }
    }
}

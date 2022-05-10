package lab10.lab10simplearthmeticcalculatorpart1;

public class ArithmeticExpression {
    private String expression;
    private InfixExpression infix = new InfixExpression();

    public ArithmeticExpression(String exp) {
        this.expression = exp;
        convertToInfix();
    }

    private void convertToInfix() {
        char[] characters = expression.toCharArray();
        for (int i=0;i<characters.length;i++) {
            switch (characters[i]) {
                case '+':
                    infix.addToken(new Addition());
                    break;
                case '-':
                    infix.addToken(new Subtraction());
                    break;
                case '/':
                    infix.addToken(new Division());
                    break;
                case '*':
                    infix.addToken(new Multiplication());
                    break;
                default:
                    String temp=Character.toString(characters[i]);
                    while(i+1 < characters.length && Character.isDigit(characters[i+1])){
                        temp=temp+characters[i+1];
                    i++;
                    }
                    infix.addToken(new Operand(Double.parseDouble(temp)));
                    break;
            }
        }
    }
    public double evaluate(){
        return infix.evaluate();
    }
}

package lab10.lab10simplearthmeticcalculatorpart1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PostfixEvaluator {
    private ArrayList<Token> expression = new ArrayList<>();
    public double evaluate(){
        ArrayDeque <Operand> operands = new ArrayDeque<>();
            for (int i = 0; i < expression.size(); i++) {
                if (expression.get(i).isOperand()) {
                    operands.push((Operand) expression.get(i));
                } else {
                    if (operands.size() < 2) {
                        throw new ArithmeticException("You have not entered 2 operands, please enter 2 operands to " +
                                "complete the evaluation.");
                    }
                    Operand op2 = operands.pop();
                    Operand op1 = operands.pop();
                    Operator operator = (Operator) expression.get(i);
                    operands.push(operator.evaluate(op1,op2));//flip op1 and op2
                }
            }
            if (operands.size() != 1)
                throw new ArithmeticException("Operation is incomplete, theirs missing an operator!");

                return operands.pop().getValue();
            }
    public void addToken(Token t){
        expression.add(t);
    }

}

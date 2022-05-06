package lab10.lab10simplearthmeticcalculatorpart1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class InfixExpression {
    private ArrayList<Token> expression = new ArrayList<Token>();
    public void addToken(Token t){
        expression.add(t);
    }
    public double evaluate(){
        PostfixEvaluator postfix = new PostfixEvaluator();
        ArrayDeque<Operator> operators = new ArrayDeque<Operator>();
        for(Token t:expression){
            if(t.isOperand())
                postfix.addToken(t);
            else {
                Operator tt = (Operator) t;

            if(operators.isEmpty()){
                operators.push(tt);
            }else{
                if(tt.priority()>operators.getFirst().priority()){

                    operators.push(tt);
                }
                else{

                    while (!operators.isEmpty() && tt.priority()<operators.getFirst().priority()){
                        postfix.addToken(operators.pop());
                    }
                    operators.push(tt);
                }
            }
            }
        }
        while(!operators.isEmpty()){
            postfix.addToken(operators.pop());
        }
        return postfix.evaluate();
    }
}

package lab10simplearthmeticcalculatorpart1;

import lab10.lab10simplearthmeticcalculatorpart1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestPostfixEvaluator {
    @Test
    public void PostfixEvaluator_CorrectExpression_EvaluateToANumber(){
        PostfixEvaluator evaluator = new PostfixEvaluator();
        evaluator.addToken(new Operand(3));
        evaluator.addToken(new Operand(2));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(5));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Operand(4));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Addition());
        assertEquals(evaluator.evaluate(),35);
    }
    @Test
    public void PostfixEvaluator_ExpressionWithOneOperandOnlyAndOneOperator_ThrowsArithmeticException(){
        Exception exception = assertThrows(ArithmeticException.class, ()->{
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.addToken(new Operand(3));
            evaluator.addToken(new Multiplication());
            evaluator.evaluate();
        });
        String expectedMessage = "You have not entered 2 operands, please enter 2 operands to complete the evaluation.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void PostfixEvaluator_ExpressionWithOperantsButNoOperator_ThrowsArithmeticException(){
        Exception exception = assertThrows(ArithmeticException.class, ()->{
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.addToken(new Operand(5));
            evaluator.addToken(new Operand(6));
            evaluator.evaluate();
        });
        String expectedMessage = "Operation is incomplete, theirs missing an operator!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void PostfixEvaluator_LongExpressionTesting(){
        PostfixEvaluator evaluator = new PostfixEvaluator();
        evaluator.addToken(new Operand(56));
        evaluator.addToken(new Operand(32));
        evaluator.addToken(new Subtraction());
        evaluator.addToken(new Operand(54));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(2));
        evaluator.addToken(new Multiplication());
        assertEquals(evaluator.evaluate(),156);
    }
    @Test
    public void PostfixEvaluator_TestOurTeacherAskedUsToWrite_WeDontKnowYet(){

        Exception exception = assertThrows(ArithmeticException.class, ()->{
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.evaluate();
        });
        String expectedMessage = "Operation is incomplete, theirs missing an operator!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void InfixExpression_CorrectExpression_EvaluateToANumber(){
        InfixExpression evaluator = new InfixExpression();
        evaluator.addToken(new Operand(3));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(2));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(5));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(4));
        assertEquals(35, evaluator.evaluate());
    }

    @Test
    public void ArithmeticExpression_CorrectExpression_EvaluateToANumber(){
        ArithmeticExpression expression = new ArithmeticExpression("12+6*2");
        assertEquals(expression.evaluate(), 24);
    }


}

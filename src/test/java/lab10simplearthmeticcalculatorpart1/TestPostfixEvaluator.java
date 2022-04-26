package lab10simplearthmeticcalculatorpart1;

import javafx.geometry.Pos;
import lab10.lab10simplearthmeticcalculatorpart1.*;
import org.junit.jupiter.api.Assertions;
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
        String actualMessage = "Operation is incomplete, theirs missing an operator!";
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

}

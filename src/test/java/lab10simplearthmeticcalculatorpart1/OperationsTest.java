package lab10simplearthmeticcalculatorpart1;
import lab10.lab10simplearthmeticcalculatorpart1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void AdditionEvaluate_TwoPositiveOperands_AddTheNumbers() {
        Operand op1 = new Operand(2);
        Operand op2 = new Operand(3);
        Addition addition = new Addition();
        Operand result = addition.evaluate(op1, op2);
        assertEquals(result.getValue(), 5);
    }
    @Test
    public void SubtractionEvaluate_TwoPositiveOperands_SubtractTheNumbers(){
        Operand op1 = new Operand(5);
        Operand op2 = new Operand(3);
        Subtraction subtraction = new Subtraction();
        Operand result = subtraction.evaluate(op1,op2);
        assertEquals(result.getValue(),2);
    }
    @Test
    public void MultiplicationEvaluate_TwoPositiveOperands_MultiplyTheNumbers(){
        Operand op1 = new Operand(2);
        Operand op2 = new Operand(5);
        Multiplication multiplication = new Multiplication();
        Operand result = multiplication.evaluate(op1,op2);
        assertEquals(result.getValue(),10);
    }
    @Test
    public void DivisionEvaluate_TwoPositiveOperands_DivideTheNumbers(){
        Operand op1 = new Operand(10);
        Operand op2 = new Operand(2);
        Division division = new Division();
        Operand result = division.evaluate(op1,op2);
        assertEquals(result.getValue(),5);
    }


}

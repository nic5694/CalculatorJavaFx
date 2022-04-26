package lab10.lab10simplearthmeticcalculatorpart1;

public abstract class Operator implements Token{
    @Override
    public Boolean isOperand(){
        return false;
    }

public abstract Operand evaluate(Operand op1, Operand op2);


}

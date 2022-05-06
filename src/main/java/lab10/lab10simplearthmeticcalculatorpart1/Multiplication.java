package lab10.lab10simplearthmeticcalculatorpart1;

public class Multiplication extends Operator{
    @Override
    public Operand evaluate(Operand op1, Operand op2) {
        return new Operand(op1.getValue()* op2.getValue());
    }

    @Override
    public int priority() {
        return 2;
    }

}

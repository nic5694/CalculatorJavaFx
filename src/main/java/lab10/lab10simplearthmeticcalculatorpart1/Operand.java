package lab10.lab10simplearthmeticcalculatorpart1;

public class Operand implements Token{
    private double value;

    public Operand(double value){
        this.value=value;
    }
    @Override
    public Boolean isOperand() {
        return true;
    }
    public final double getValue(){
        return value;
    }
}

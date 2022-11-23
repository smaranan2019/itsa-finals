public class EURConverter implements Rule{

    @Override
    public double calculate(double amount) {
        return amount * 1.5;
    }
    
}

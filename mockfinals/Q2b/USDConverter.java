public class USDConverter implements Rule{

    @Override
    public double calculate(double amount) {
        return amount * 1.3;
    }
    
}

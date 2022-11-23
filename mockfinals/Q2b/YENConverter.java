public class YENConverter implements Rule {

    @Override
    public double calculate(double amount) {
        return amount / 92;
    }
    

}

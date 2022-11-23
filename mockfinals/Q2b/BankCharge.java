public class BankCharge implements Charge{

    @Override
    public double addCharge(double amount) {
        return amount + 1;
    }
    
}

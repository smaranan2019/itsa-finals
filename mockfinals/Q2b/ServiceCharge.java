public class ServiceCharge implements Charge{

    @Override
    public double addCharge(double amount) {
        return amount * 1.03;
    }
    
}

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class GSTCharge implements Charge{

    @Override
    public double addCharge(double amount) {
        return amount * 1.07;
    }
    
}

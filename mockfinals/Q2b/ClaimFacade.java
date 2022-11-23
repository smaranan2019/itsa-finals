import java.util.*;

public class ClaimFacade {

    protected Claim claim;
    protected Rule rule;
    protected List<Charge> listOfCharges = new ArrayList<>();

    public ClaimFacade(Claim claim) {

        this.claim = claim;
        // settle the rules first
        if(this.claim.isUSD()) {
            rule = new USDConverter();
        } else if(this.claim.isEUR()) {
            rule = new EURConverter();
        } else if(this.claim.isYEN()) {
            rule = new YENConverter();
        } else {
            rule = new SGDConverter();
        }

        if(this.claim.isGST()) {
            listOfCharges.add(new GSTCharge());
        }

        if(this.claim.isServiceCharge()) {
            listOfCharges.add(new ServiceCharge());
        }

        if(this.claim.isBankCharge()) {
            listOfCharges.add(new BankCharge());
        }
    } 

    public String getName() {
        return this.claim.getName();
    }
    
    
    public double processClaim() {
        double ruleProcessedAmount = rule.calculate(this.claim.cost);

        for(Charge charge : listOfCharges) {
            ruleProcessedAmount = charge.addCharge(ruleProcessedAmount);
        }
        
        return (double)Math.round(ruleProcessedAmount * 100000d) / 100000d;
    }
}

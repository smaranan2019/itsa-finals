public class Claim {
    String name;
    double cost = 0;

    // Either none or one of the following can be true. Not more than one.
    boolean isUSD = false; // if true, multiply cost by 1.3
    boolean isEUR = false; // if true, multiply cost by 1.5
    boolean isYEN = false; // if true, divide cost by 1.07

    // Either none or one or more of the following can be true. Bank charge must be
    // applied after GST and ServiceCharge.
    boolean isGST = false; // if true, multiple cost by 1.07. A $10 item becomes $10.70
    boolean isServiceCharge = false; // if true, multiple cost by 1.03. A $10 item becomes $10.30
    boolean isBankCharge = false; // if true, add cost by $1. A $10 item becomes $11

    public Claim(String name, double cost, boolean isGST, boolean isServiceCharge, boolean isBankCharge, boolean isUSD,
            boolean isEUR, boolean isYEN) {
        this.name = name;
        this.cost = cost;
        this.isGST = isGST;
        this.isServiceCharge = isServiceCharge;
        this.isBankCharge = isBankCharge;
        this.isUSD = isUSD;
        this.isEUR = isEUR;
        this.isYEN = isYEN;
    }

    public double getCost() {
        return (double)Math.round(cost * 100000d) / 100000d;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isGST() {
        return isGST;
    }

    public void addGSTCost() {
        this.cost = this.cost * 1.07;
    }

    public boolean isServiceCharge() {
        return isServiceCharge;
    }

    public void addServiceChargeCost() {
        this.cost = this.cost * 1.03;
    }

    public boolean isBankCharge() {
        return isBankCharge;
    }

    public void addBankChargeCost() {
        this.cost = this.cost + 1;    
    }

    public boolean isUSD() {
        return isUSD;
    }

    public void convertFromUSD() {
        this.cost = this.cost * 1.3;
    }

    public boolean isEUR() {
        return isEUR;
    }

    public void convertFromEUR() {
        this.cost = this.cost * 1.5;
    }

    public boolean isYEN() {
        return isYEN;
    }

    public void convertFromYEN() {
        this.cost = this.cost / 92;
    }

    public String getName() {
        return name;
    }

}

// Name :
//
// Matric :
//
import java.util.*;
public class App {

    // public void processClaim(Claim claim) {
    //     if (claim.isUSD() || claim.isEUR() || claim.isYEN()) {
            
    //         if (claim.isUSD()) {
    //             claim.convertFromUSD();
    //         } else if (claim.isEUR()) {
    //             claim.convertFromEUR();
    //         } else if (claim.isYEN()) {
    //             claim.convertFromYEN();
    //         }
    //     }

    //     if (claim.isGST()) {
    //         claim.addGSTCost();
    //     }

    //     if (claim.isServiceCharge()) {
    //         claim.addServiceChargeCost();
    //     }

    //     if (claim.isBankCharge()) {
    //         claim.addBankChargeCost();
    //     }
    // }

    public static void main(String[] args) {
        Claim[] claims = {
                new Claim("Claim1", 100, true, false, false, false, false, false),
                new Claim("Claim2", 100, true, true, false, false, false, false),
                new Claim("Claim3", 100, true, true, true, false, false, false),
                new Claim("Claim4", 100, true, false, false, true, false, false),
                new Claim("Claim5", 100, true, true, false, false, true, false),
                new Claim("Claim6", 100, true, true, true, false, false, true),
        };

        List<ClaimFacade> facades = new ArrayList<>();
        for(Claim claim : claims) {
            facades.add(new ClaimFacade(claim));
        }

        for(ClaimFacade facade : facades) {
            System.out.println("Final cost of " + facade.getName() + " is " + facade.processClaim());
        }

        // App app = new App();

        // for (Claim claim : claims) {
        //     app.processClaim(claim);
        //     System.out.println("Final cost of " + claim.getName() + " is " + claim.getCost());
        // }

    }
}

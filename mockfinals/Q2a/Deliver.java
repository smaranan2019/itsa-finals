public class Deliver {
    private static Deliver instance; //store singleton instance, private so no new 

    public static Deliver getInstance() { //access to singleton instance
        if (Deliver.instance == null) {
            Deliver.instance = new Deliver();
        }
        return Deliver.instance;
    }


    public void makeDelivery() { //methods existing in App that 
        AriesService service1 = new AriesService();
        CancerService service2 = new CancerService();
        VirgoService service3 = new VirgoService();

        String sender = "CS301";
        String receiver = "IS442";
        String item = "Laptop";

        service1.sendItem(receiver, item, sender);
        service2.moveItem(sender, receiver, item);
        service3.deliverItem(item, sender, receiver);
        
    }
    
}

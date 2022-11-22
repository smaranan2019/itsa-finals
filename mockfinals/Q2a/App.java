// Name :
//
// Matric :
//
public class App {

    public static void main(String[] args) {
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

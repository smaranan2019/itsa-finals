// You are required to state your name, matriculation number, 
// name of the design pattern(s) for both parts at the top of Client.java.
// Name : Frances Severino
// Matruculation Number : 01373646
// Design Pattern(s) and any explanation for part (a) : Chain of Responsibility 
// Design Pattern(s) and any explanation for part (b) : Builder

public class Client {
    
    public static void main(String args[]) {
        ServiceHandler service = new ServiceHandler();
        Request request = new Request("http", "www.itsa.com", "443", "/", "GET", "", "accept: text/html", "");

        request.setHandlerName("getOrders");
        Response response = service.handle(request);
        System.out.println(response.getBody());

        request.setHandlerName("buyOrder");
        response = service.handle(request);
        System.out.println(response.getBody());

        request.setHandlerName("sellOrder");
        response = service.handle(request);
        System.out.println(response.getBody());

    }
}

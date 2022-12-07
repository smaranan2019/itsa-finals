public class ServiceHandler {

    public Response handle(Request request) {
        Response response = new Response("","");
        String message = "";

        if (request.getHandlerName().equals("getOrders")) {
            message += new LogHandler().logging();
            message += " " + new OrderHandler().getOrders();
            message += " " + new NotificationHandler().sendNotification();
        } else if (request.getHandlerName().equals("buyOrder")) {
            message += new LogHandler().logging();
            message += " " + new OrderHandler().buyOrder();
            message += " " + new NotificationHandler().sendNotification();
        } else if (request.getHandlerName().equals("sellOrder")) {
            message += new LogHandler().logging();
            message += " " + new OrderHandler().sellOrder();
            message += " " + new NotificationHandler().sendNotification();
        } else {
            message = "No such method";
        }
        response.setBody(message);
        return response;
    }

}

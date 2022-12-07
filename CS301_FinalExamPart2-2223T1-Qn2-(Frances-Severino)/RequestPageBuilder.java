public class RequestPageBuilder implements RequestBase {

    String header;
    String body;
   
    public String getHeaders() {
        return header;
    }

    public void setHeaders(String header) {
        this.header = header;
    }

    public  String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

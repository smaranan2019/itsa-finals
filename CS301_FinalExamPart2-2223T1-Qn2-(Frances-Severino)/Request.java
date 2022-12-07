public class Request {
    
    private String handlerName;
    private String protocol;
    private String host;
    private String port;
    private String path;
    private String method;
    private String header;
    private String body;

    public Request(String protocol, String host, String port, String path, String method, String handlerName, String header, String body) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.path = path;
        this.method = method;
        this.handlerName = handlerName;
        this.header = header;
        this.body = body;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHeaders() {
        return header;
    }

    public void setHeaders(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


}

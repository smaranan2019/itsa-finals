interface RequestBase {
    public String getHost();
    public void setHost(String host);
    public String getPort();
    public void setPort(String port);
    public String getHeaders();
    public void setHeaders(String header);
    public String getBody();
    public void setBody(String body);
    public String getPath();
    public void setPath(String path);
    public String getHandlerName();
    public void setHandlerName(String handlerName);
    public String getProtocol();
    public void setProtocol(String protocol);
    public String getMethod();
    public void setMethod(String method);
}

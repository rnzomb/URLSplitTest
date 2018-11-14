package models;

// Model to store our values and output by toString()
public class Url {

    private String scheme;

    private String host;

    private String port;

    private String path;

    private String parameters;

//  constructor used by state machine splitter, setters used consistently
    public Url() {
    }
//  used by regex splitter
    public Url(String scheme, String host, String port, String path, String parameters) {
        this.scheme = scheme;
        this.host = host;
        this.port = port;
        this.path = path;
        this.parameters = parameters;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "scheme: " + scheme + "\n" +
                "host:   " + host + "\n" +
                "port:   " + port + "\n" +
                "path:   " + (path.length() > 0 ? path + "\n" : "None\n") +
                "params: " + (parameters != null ? parameters : "None");

    }
}

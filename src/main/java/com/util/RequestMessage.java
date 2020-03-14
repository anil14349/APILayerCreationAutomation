package com.util;

import java.util.Map;

public class RequestMessage {
    
    private int sequence;
    private String httpMethod;
    private Object requestBody;
    private String protocal;
    private String host;
    private int port;
    private Map<String,String> uriParams;
    private Map<String,String> queryParams;
    private Map<String,String> headerParams;
 
    
    /**
     * @return int return the sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    /**
     * @return String return the httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * @param httpMethod the httpMethod to set
     */
    public void setHttpMethod(final String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * @return Object return the requestBody
     */
    public Object getRequestBody() {
        return requestBody;
    }

    /**
     * @param requestBody the requestBody to set
     */
    public void setRequestBody(final Object requestBody) {
        this.requestBody = requestBody;
    }

    /**
     * @return String return the protocal
     */
    public String getProtocal() {
        return protocal;
    }

    /**
     * @param protocal the protocal to set
     */
    public void setProtocal(final String protocal) {
        this.protocal = protocal;
    }

    /**
     * @return String return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * @return int return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * @return Map<String,String> return the uriParams
     */
    public Map<String,String> getUriParams() {
        return uriParams;
    }

    /**
     * @param uriParams the uriParams to set
     */
    public void setUriParams(final Map<String,String> uriParams) {
        this.uriParams = uriParams;
    }

    /**
     * @return Map<String,String> return the queryParams
     */
    public Map<String,String> getQueryParams() {
        return queryParams;
    }

    /**
     * @param queryParams the queryParams to set
     */
    public void setQueryParams(final Map<String,String> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * @return Map<String,String> return the headerParams
     */
    public Map<String,String> getHeaderParams() {
        return headerParams;
    }

    /**
     * @param headerParams the headerParams to set
     */
    public void setHeaderParams(final Map<String,String> headerParams) {
        this.headerParams = headerParams;
    }

}
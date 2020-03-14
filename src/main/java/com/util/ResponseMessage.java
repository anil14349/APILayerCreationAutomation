package com.util;

public class ResponseMessage{

    private String httpStatus;
    private String contentType;
    private Object response;


    /**
     * @return String return the httpStatus
     */
    public String getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus the httpStatus to set
     */
    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * @return String return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return Object return the response
     */
    public Object getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(Object response) {
        this.response = response;
    }

}
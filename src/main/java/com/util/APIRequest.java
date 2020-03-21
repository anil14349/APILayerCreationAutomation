package com.util;

import java.util.Map;

import com.jsoniter.any.Any;

public class APIRequest {
    
    private Any requestBody;
    private Map<String,Object> uriParams;
    private Map<String,Object> queryParams;
    private Map<String,Object> headerParams;

    /**
     * @return Map<String,Object> return the uriParams
     */
    public Map<String,Object> getUriParams() {
        return uriParams;
    }

    /**
     * @param uriParams the uriParams to set
     */
    public void setUriParams(Map<String,Object> uriParams) {
        this.uriParams = uriParams;
    }

    /**
     * @return Map<String,Object> return the queryParams
     */
    public Map<String,Object> getQueryParams() {
        return queryParams;
    }

    /**
     * @param queryParams the queryParams to set
     */
    public void setQueryParams(Map<String,Object> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * @return Map<String,Object> return the headerParams
     */
    public Map<String,Object> getHeaderParams() {
        return headerParams;
    }

    /**
     * @param headerParams the headerParams to set
     */
    public void setHeaderParams(Map<String,Object> headerParams) {
        this.headerParams = headerParams;
    }


    /**
     * @return Map<String,Object> return the requestBody
     */
    public Any getRequestBody() {
        return requestBody;
    }

    /**
     * @param requestBody the requestBody to set
     */
    public void setRequestBody(Any requestBody) {
        this.requestBody = requestBody;
    }

}
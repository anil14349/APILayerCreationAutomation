package com.util;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MappingProcessor {

    private int sequence;
    private String httpMethod;
    private Object requestBody;
    private String protocal;
    private String host;
    private int port;
    private Map<String, String> uriParmsMappings;
    private Map<String, String> queryParamsMappings;
    private Map<String, String> headerParmsMappings;
    private Map<String, String> requestBobyMappings;
    private List<String> resFieldstoExtract;

    public MappingProcessor(APIRequest request, Map<String, Object> mongoData) {

        this.sequence = (int) mongoData.get("sequence");
        this.httpMethod = (String) mongoData.get("httpMethod");
        this.requestBody = (String) mongoData.get("requestBody");
        this.protocal = (String) mongoData.get("protocal");
        this.port = (int) mongoData.get("port");
        this.uriParmsMappings = mapMongoData(request, (Map<String, String>) mongoData.get("uriParmsMappings"));
        this.queryParamsMappings = mapMongoData(request, (Map<String, String>) mongoData.get("queryParamsMappings"));
        this.headerParmsMappings = mapMongoData(request, (Map<String, String>) mongoData.get("headerParmsMappings"));
        this.requestBobyMappings = mapMongoData(request, (Map<String, String>) mongoData.get("requestBobyMappings"));
        this.resFieldstoExtract = (List<String>) mongoData.get("resFieldstoExtract");

    }

    /**
     * @return int return the sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(int sequence) {
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
    public void setHttpMethod(String httpMethod) {
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
    public void setRequestBody(Object requestBody) {
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
    public void setProtocal(String protocal) {
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
    public void setHost(String host) {
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
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return Map<String, String> return the uriParmsMappings
     */
    public Map<String, String> getUriParmsMappings() {
        return uriParmsMappings;
    }

    /**
     * @param uriParmsMappings the uriParmsMappings to set
     */
    public void setUriParmsMappings(Map<String, String> uriParmsMappings) {
        this.uriParmsMappings = uriParmsMappings;
    }

    /**
     * @return Map<String, String> return the queryParamsMappings
     */
    public Map<String, String> getQueryParamsMappings() {
        return queryParamsMappings;
    }

    /**
     * @param queryParamsMappings the queryParamsMappings to set
     */
    public void setQueryParamsMappings(Map<String, String> queryParamsMappings) {
        this.queryParamsMappings = queryParamsMappings;
    }

    /**
     * @return Map<String, String> return the headerParmsMappings
     */
    public Map<String, String> getHeaderParmsMappings() {
        return headerParmsMappings;
    }

    /**
     * @param headerParmsMappings the headerParmsMappings to set
     */
    public void setHeaderParmsMappings(Map<String, String> headerParmsMappings) {
        this.headerParmsMappings = headerParmsMappings;
    }

    /**
     * @return Map<String, String> return the requestBobyMappings
     */
    public Map<String, String> getRequestBobyMappings() {
        return requestBobyMappings;
    }

    /**
     * @param requestBobyMappings the requestBobyMappings to set
     */
    public void setRequestBobyMappings(Map<String, String> requestBobyMappings) {
        this.requestBobyMappings = requestBobyMappings;
    }

    /**
     * @return List<String> return the resFieldstoExtract
     */
    public List<String> getResFieldstoExtract() {
        return resFieldstoExtract;
    }

    /**
     * @param resFieldstoExtract the resFieldstoExtract to set
     */
    public void setResFieldstoExtract(List<String> resFieldstoExtract) {
        this.resFieldstoExtract = resFieldstoExtract;
    }

    private Map<String, String> mapMongoData(APIRequest reqData, Map<String, String> dbData) {

        Map<String, String> hMap = new HashMap<String, String>();
        Object value = null;
        for (String key : dbData.keySet()) {
            String dbVal = (String) dbData.get(key);

            if (dbVal.startsWith("header")) {
                value = reqData.getHeaderParams().get("dbVal");
            } else if (dbVal.startsWith("queryParam")) {
                value = reqData.getQueryParams().get("dbVal");
            } else if (dbVal.startsWith("request")) {
                value = reqData.getRequestBody().get("dbVal");
            }
            if(value != null) // value conversion needs enhancement for other data types
                hMap.put(key, (String) value);

        }

        return hMap;
    }

}
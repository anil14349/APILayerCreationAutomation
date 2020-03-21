package com.util;

import java.util.HashMap;
import java.util.Map;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

public class ProcessUtil {

    public static void main(String[] args) {

        
        ProcessUtil pUtil = new ProcessUtil();
        // extract api request - complete
        APIRequest request = pUtil.extractApiRequest();
        // extract mappings from Db
        Map<String,Object> mapMongoData=pUtil.extractMappingData();
        // prepare datta for next requests
        MappingProcessor mProcessor = new MappingProcessor(request,mapMongoData);
        
        System.out.println("Header Mappings :\n\t"+mProcessor.getHeaderParmsMappings());
        System.out.println("Query Mappings :\n\t"+mProcessor.getQueryParamsMappings());
        System.out.println("Uri Mappings :\n\t"+mProcessor.getUriParmsMappings());
        System.out.println("Request Body Mappings :\n\t"+mProcessor.getRequestBobyMappings());
        System.out.println("Response  :\n\t"+pUtil.extractResponse(mProcessor));

    }


    /**
     * prepare APIRequest from input request
     * @return
     */
    private APIRequest extractApiRequest(){
        
        APIRequest request = new APIRequest();
        
        Map<String,Object> headers=new HashMap<String,Object>();
        headers.put("X-COM-COUNTRY", "US");
        headers.put("X-COM-LOB", "TestLOB");
       
        Map<String,Object> queryParams=new HashMap<String,Object>();
        queryParams.put("country", "uk");

        Map<String,Object> uriParams=new HashMap<String,Object>();
        uriParams.put("cin", 1234567);

        String input = "{\"id\":\"1\",\"firstName\":\"Joe\",\"surname\":\"Blogg\"}";
        Any reqBody=JsonIterator.deserialize(input);

        request.setHeaderParams(headers);
        request.setQueryParams(queryParams);
        request.setRequestBody(reqBody);
        request.setUriParams(uriParams);

        return request;
    }

    /**
     * @draft
     * need to extract the data from mongo and prepate the Map Object
     * or List<Map> 
     * @return
     */
    private Map<String,Object> extractMappingData(){

        Map<String,Object> mapMongoData= new HashMap<String,Object>();

        mapMongoData.put("sequence",1);
        mapMongoData.put("iterate", true);
        mapMongoData.put("httpMethod","GET");
        mapMongoData.put("requestBody","");
        mapMongoData.put("protocal","https");
        mapMongoData.put("port",8082);
       
        //mapdata (mappings in databse)
        String uriJsonStr= "{\"id\":\"uriParam.cin\",\"id2\":\"request.id\"}";
        String headerJsonStr= "{\"country\":\"header.X-COM-COUNTRY\",\"lob\":\"header.X-COM-LOB\"}";
        String queryParamsJsonStr= "{\"country\":\"queryParam.country\"}";
        String reqJsonStr= "{\"fName\":\"request.firstName\",\"id\":\"request.id\",\"cin\":\"uriParam.cin\"}";


        // extract db configuration below
        mapMongoData.put("uriParmsMappings",JsonIterator.deserialize(uriJsonStr));
        mapMongoData.put("queryParamsMappings",JsonIterator.deserialize(queryParamsJsonStr));
        mapMongoData.put("headerParmsMappings",JsonIterator.deserialize(headerJsonStr)); 
        mapMongoData.put("requestBobyMappings",JsonIterator.deserialize(reqJsonStr));
        // list
        mapMongoData.put("resFieldstoExtract",null);

        return mapMongoData;
    }


    private RequestMessage prepareRequest(MappingProcessor mProcessor) {
        RequestMessage req = new RequestMessage();
        req.setProtocal(mProcessor.getProtocal());
        req.setHost(mProcessor.getHost());
        req.setPort(mProcessor.getPort());
        req.setHttpMethod(mProcessor.getHttpMethod());
        req.setQueryParams(mProcessor.getQueryParamsMappings());
        req.setUriParams(mProcessor.getUriParmsMappings());
        req.setHeaderParams(mProcessor.getHeaderParmsMappings());
        req.setSequence(mProcessor.getSequence());
        req.setRequestBody(mProcessor.getRequestBody());
        return req;

      }

    
    private Object extractResponse(MappingProcessor mProcessor) {
        RequestMessage req = prepareRequest(mProcessor);
        Object res = invokeService(req);
        return res;
    }

    /**
     * @draft
     * invoke logic need to be added
     * @param req
     * @return
     */
    private Object invokeService(RequestMessage req) {
        // need to implement flow API calling Logic and return JSON data in response
        return prepareResponse();
    }


    private Any prepareResponse(){
        String uriJsonStr= "{\"id\":\"1234567890\",\"id2\":\"rxfcgvhbh87\"}";
        return JsonIterator.deserialize(uriJsonStr) ;
    }

}
package com.util;

import java.util.HashMap;
import java.util.Map;

public class ProcessUtil {

    public static void main(String[] args) {

        Map<String,Object> mongoData=new HashMap<String, Object>();
        APIRequest request = new APIRequest();
        MappingProcessor mProcessor = new MappingProcessor(request,mongoData);
        ProcessUtil pUtil = new ProcessUtil();
        pUtil.extractResponse(mProcessor);

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

    private Object invokeService(RequestMessage req) {
        // need to implement flow API calling Logic and return JSON data in response
        return prepareResponse();
    }

    private Object prepareResponse(){
        return null;
    }

}
package com.txsh.services;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest;
import com.txsh.base.BaseHttpService;
import com.txsh.constants.APIConstants;
import com.txsh.exception.ZMHttpException;
import com.txsh.exception.ZMParserException;
import com.txsh.http.IWebService;
import com.txsh.http.ZMHttpRequestMessage;
import com.txsh.model.MLBaseResponse;
import com.txsh.model.MLLeaveDetailResponse;
import com.txsh.model.MLLeaveResponse;
import com.txsh.model.MLMessagePublishResponse;
import com.txsh.model.MLRegister;
import com.txsh.utils.ZMJsonParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MLAdvanServices extends BaseHttpService implements IWebService {

    public String home_cache = null;

    public static MLAdvanServices INSTANCE = new MLAdvanServices();

    public static MLAdvanServices getInstance() {
        return INSTANCE;
    }

    @Override
    public Object httpPost(ZMHttpRequestMessage httpMessage)
            throws ZMParserException, ZMHttpException {
        switch (httpMessage.getHttpType()) {
            case ADVAN_ADD: {
                //添加优势件
            	return addLeave(MLRegister.class,httpMessage);
            }
            case ADVAN_LIST: {
                //优势件列表
            	return getResonseData(MLLeaveResponse.class,httpMessage);
            }
            case ADVAN_MY_LIST: {
                //我的优势件列表
            	return getResonseData(MLLeaveResponse.class,httpMessage);
            }
            case ADVAN_DEATAIL: {
                //优势件详情
            	return getResonseData(MLLeaveDetailResponse.class,httpMessage);
            }
            case ADVAN_DEL: {
                //删除优势件
            	return getResonseData(MLRegister.class,httpMessage);
            }
            
            default:
                break;
        }
        return null;
    }
    
    /**
      * @description  添加事故车
      *
      * @author marcello
     * @throws ZMHttpException 
     * @throws ZMParserException 
     */
    private Object addLeave(Class<MLRegister> class1,
			ZMHttpRequestMessage httpMessage) throws ZMParserException, ZMHttpException {
    	List<String> paths = (List<String>) httpMessage.getOtherParmas("image");
    	String imageId = "";
    	for(int i = 0;i<paths.size();i++){
    		RequestParams params = new RequestParams();
    		params.addBodyParameter("file",  new File(paths.get(i)));
    	    HttpUtils http = new HttpUtils();
            http.configCurrentHttpCacheExpiry(1000 * 10);
            try {
				ResponseStream responseStream = http.sendSync(HttpRequest.HttpMethod.POST, APIConstants.API_IMAGE_UPLOAD,params);
				MLMessagePublishResponse ret = ZMJsonParser.fromJsonString(MLMessagePublishResponse.class, responseStream.readString());
				
				if( i ==paths.size()-1){
					imageId= imageId+ret.datas;
				}else{
					imageId= imageId+ret.datas+",";
				}
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ZMParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	httpMessage.addPostParam("images",imageId);
		return getResonseData(class1,httpMessage);
	}

	private <T  extends MLBaseResponse> Object getResonseData( Class<T> cls , ZMHttpRequestMessage httpMessage) throws ZMParserException, ZMHttpException{
    	T ret = post(httpMessage, cls);
		return ret;
    }
}

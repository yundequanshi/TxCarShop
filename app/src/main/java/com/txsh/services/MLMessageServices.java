package com.txsh.services;

import com.txsh.base.BaseHttpService;
import com.txsh.exception.ZMHttpException;
import com.txsh.exception.ZMParserException;
import com.txsh.http.IWebService;
import com.txsh.http.ZMHttpRequestMessage;
import com.txsh.model.MLBaseResponse;
import com.txsh.model.MLInteractionData;
import com.txsh.model.MLMessageListResponse;
import com.txsh.model.MLParseResponse;
import com.txsh.model.MLRegister;

public class MLMessageServices extends BaseHttpService implements IWebService {

  public String home_cache = null;

  public static MLMessageServices INSTANCE = new MLMessageServices();

  public static MLMessageServices getInstance() {
    return INSTANCE;
  }

  @Override
  public Object httpPost(ZMHttpRequestMessage httpMessage)
      throws ZMParserException, ZMHttpException {
    switch (httpMessage.getHttpType()) {
      case MESSAGE_LIST: {
        //获取互动列表
        return getResonseData(MLMessageListResponse.class, httpMessage);
      }
      case FIND_COLLECT_INTERACTION: {
        return getResonseData(MLMessageListResponse.class, httpMessage);
      }
      case MESSAGE_REPLY: {
        //回复消息
        return getResonseData(MLRegister.class, httpMessage);
      }

      case MESSAGE_PUBLISH: {
        //发表互动消息
        return getResonseData(MLRegister.class, httpMessage);
      }
      case MESSAGE_REPORT: {
        //举报
        return getResonseData(MLRegister.class, httpMessage);
      }

      case MY_MESSAGE: {
        //获取我的互动列表
        return getResonseData(MLMessageListResponse.class, httpMessage);
      }
      case MY_MESSAGE_ME: {
        //@我
        return getResonseData(MLMessageListResponse.class, httpMessage);
      }
      case MY_MESSAGE_REPLY: {
        //我的回复消息
        return getResonseData(MLRegister.class, httpMessage);
      }
      case MY_MESSAGE_DEL: {
        //我的-删除互动消息
        return getResonseData(MLRegister.class, httpMessage);
      }
      case HD_COLLECTION: {
        //收藏
        return getResonseData(MLRegister.class, httpMessage);
      }
      case HD_DIANZAN: {
        //点赞
        return getResonseData(MLRegister.class, httpMessage);
      }
      case HD_JUBAO: {
        //举报
        return getResonseData(MLInteractionData.class, httpMessage);
      }
      //修理厂互动
      case GET_USER_TRENDS: {
        return getResonseData(MLMessageListResponse.class, httpMessage);
      } //修理厂互动
      case FIND_PRAISEINFO_BY_INTERACTIONID: {
        return getResonseData(MLParseResponse.class, httpMessage);
      }
      default:
        break;
    }
    return null;
  }

  private <T extends MLBaseResponse> Object getResonseData(Class<T> cls,
      ZMHttpRequestMessage httpMessage) throws ZMParserException, ZMHttpException {
    T ret = post(httpMessage, cls);
    return ret;
  }
}

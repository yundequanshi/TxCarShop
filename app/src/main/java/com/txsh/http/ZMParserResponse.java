package com.txsh.http;

import com.txsh.R;
import com.txsh.exception.ZMParserException;
import com.txsh.utils.MLToolUtil;
import com.txsh.utils.ZMJsonParser;


/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 12-12-8
 * Time: 下午4:37
 * Description:
 */
public class ZMParserResponse {

    public static <T> T parserResponse(ZMHttpType.ResponseType responseType,
                                                                   String response, Class<T> cls) throws ZMParserException {
        if (responseType == ZMHttpType.ResponseType.JSON) {
            return ZMJsonParser.fromJsonString(cls, response);
        }
        throw new ZMParserException(MLToolUtil.getResourceString(R.string.config_response_error_not_json));
    }
}

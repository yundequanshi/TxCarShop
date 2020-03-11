/**
 * FlieName:IWebService.java
 * Destribution:
 * Author:michael
 * 2013-5-20 上午10:12:37
 */
package com.txsh.http;

import com.txsh.exception.ZMHttpException;
import com.txsh.exception.ZMParserException;

/**
 * @author michael
 *
 */
public interface IWebService {
	
	
	
	
	Object httpPost(ZMHttpRequestMessage httpMessage) throws ZMParserException, ZMHttpException;

}

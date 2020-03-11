package com.txsh.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.txsh.base.BaseHttpService;
import com.txsh.exception.ZMHttpException;
import com.txsh.exception.ZMParserException;
import com.txsh.http.IWebService;
import com.txsh.http.ZMHttpRequestMessage;

import java.io.InputStream;

public class HttpDownloadServices extends BaseHttpService implements IWebService {

	public String home_cache = null;

	public static HttpDownloadServices INSTANCE = new HttpDownloadServices();

	public static HttpDownloadServices getInstance() {
		return INSTANCE;
	}

	@Override
	public Object httpPost(ZMHttpRequestMessage httpMessage)
			throws ZMParserException, ZMHttpException {
		switch (httpMessage.getHttpType()) {

		case  DOWNLOADFILE:{
			return download(httpMessage);
		}
		default:
			break;
		}
		return null;
	}

 
	private Bitmap download(ZMHttpRequestMessage httpMessage)
			throws ZMParserException, ZMHttpException {
		InputStream is =  get(httpMessage);
		Bitmap b = BitmapFactory.decodeStream(is);
		return b;
	}
	
}

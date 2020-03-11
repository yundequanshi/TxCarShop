package com.txsh.model;

import com.google.gson.annotations.Expose;
import com.txsh.services.MLPayServices.LocalRetCode;

public class MLPayTokenData extends MLBaseResponse{
	@Expose
	public String access_token;
	@Expose
	public String expires_in;
	@Expose
	public String errcode;
	@Expose
	public String errmsg;
	
	
	@Expose
	public String prepayid;
	
	
	public LocalRetCode localRetCode = LocalRetCode.ERR_OTHER;
}

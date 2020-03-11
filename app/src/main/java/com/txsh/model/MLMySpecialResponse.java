package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLMySpecialResponse extends MLBaseResponse{
	
	@Expose
	public List<MLMySpecialData> datas;
	
}

package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLHomeProductResponse extends MLBaseResponse{
	
	@Expose
	public List<MLHomeProductData> datas;
	
}

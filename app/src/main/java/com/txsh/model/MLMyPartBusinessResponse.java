package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLMyPartBusinessResponse extends MLBaseResponse{
	
	@Expose
	public List<MLMyPartBusinessData> datas;
	
}

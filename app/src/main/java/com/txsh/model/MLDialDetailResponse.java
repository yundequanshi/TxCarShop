package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLDialDetailResponse extends MLBaseResponse{
	
	@Expose
	public List<MLDialDetailData> datas;
	
}

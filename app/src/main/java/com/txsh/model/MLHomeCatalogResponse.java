package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLHomeCatalogResponse extends MLBaseResponse{
	
	@Expose
	public List<MLHomeCatalogData> datas;
	
}

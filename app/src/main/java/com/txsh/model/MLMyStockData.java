package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLMyStockData extends MLBaseResponse{
	
	@Expose
	public String id;
	
	@Expose
	public String mtime;
	
	@Expose
	public String companyName;
	
	@Expose
	public String companyPhone;
	
	
	@Expose
	public List<MLMyStockDetail> stockDetail;
	@Expose
	public TXData date;
}

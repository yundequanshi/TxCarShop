package com.txsh.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MLParseResponse extends MLBaseResponse {

  @Expose
  public List<ParseInfoData> datas;

}

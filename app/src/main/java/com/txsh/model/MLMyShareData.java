package com.txsh.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Administrator on 2015/7/15.
 */
public class MLMyShareData extends MLBaseResponse {
    @Expose
public   Data datas;
  public class Data extends MLBaseResponse{
      @Expose
      public String  title;
      @Expose
      public String  url;
      @Expose
      public String  remark;
  }

}

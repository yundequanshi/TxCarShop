package com.txsh.home;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.txsh.R;
import com.txsh.auxiliary.MLAuxiliaryActivity;
import com.txsh.base.BaseApplication;
import com.txsh.base.BaseFragment;
import com.txsh.constants.MLConstants;
import com.txsh.http.ZMHttpError;
import com.txsh.http.ZMHttpRequestMessage;
import com.txsh.http.ZMHttpType.RequestType;
import com.txsh.http.ZMRequestParams;
import com.txsh.model.MLAccidentInfo;
import com.txsh.model.MLLogin;
import com.txsh.model.MLRegister;
import com.txsh.services.MLAccidentServices;
import com.txsh.utils.MLToolUtil;

import java.util.HashMap;
import java.util.Map;

import cn.ml.base.utils.IEvent;

/**
 * 发布信息-step3
 * @author Marcello
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MLAccidentadd3Frg extends BaseFragment{

	public static MLAccidentadd3Frg INSTANCE =null;
	
	private static MLAccidentInfo detail;
	public static MLAccidentadd3Frg instance(Object obj){
		detail = (MLAccidentInfo) obj;
	//	if(INSTANCE==null){
			INSTANCE = new MLAccidentadd3Frg();
	//	}
		return INSTANCE;
	}
	
	@ViewInject(R.id.accident_gv_photo)
	private GridView _photoGv;
	
	@ViewInject(R.id.accident_et_content)
	private EditText _contentEt;
	
	@ViewInject(R.id.accident_add_root)
	private RelativeLayout _root;
	/*@ViewInject(R.id.violation_wb)
	private WebView _webview;*/
	private Context _context;
	private String _content;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.accident_add3, null);
		ViewUtils.inject(this,view);
		
		_context = inflater.getContext();
		
		initView();
		return view;
	}
	
	
	private void initView() {
	}
	
	@OnClick(R.id.top_back)
	public void backOnClick(View view){
		//startActivity(new Intent(_context,MLHomeActivity.class));
		((MLAuxiliaryActivity)_context).onBackPressed();
	}
	
	/**
	  * @description  下一步
	  *
	  * @author marcello
	 */
	private String imageId="";
	@OnClick(R.id.accident_btn_next)
	public void nextOnClick(View view){
		_content = _contentEt.getText().toString();
		if(MLToolUtil.isNull(_content)){
			showMessage("描述不能为空!");
			return ;
		}
		requestAccident();

		/*   for(final String path : detail.paths){
		//上传图片
		   RequestParams params = new RequestParams();
			params.addBodyParameter("file", new File(path));
	    	HttpUtils http = new HttpUtils();
	    	http.send(HttpRequest.HttpMethod.POST,
	    	   APIConstants.API_IMAGE_UPLOAD,
	    	    params,
	    	    new RequestCallBack<String>() {
	    	        @Override
	    	        public void onStart() {
	    	        }
	    	        @Override
	    	        public void onLoading(long total, long current, boolean isUploading) {
	    	        }
	    	        @Override
	    	        public void onSuccess(ResponseInfo<String> responseInfo) {
	    	        	try {
							MLMessagePublishResponse ret = ZMJsonParser.fromJsonString(MLMessagePublishResponse.class, responseInfo.result);
						
							if(detail.paths.get(detail.paths.size()-1).equalsIgnoreCase(path)){
								imageId= imageId+ret.datas;
								//上传图片完成 ，开始添加事故车
								requestAccident();
							}else{
								imageId= imageId+ret.datas+",";
							}
							//	System.out.println("");
						//	publish(ret.datas);
						} catch (ZMParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    	        }
	    	        @Override
	    	        public void onFailure(HttpException error, String msg) {
	    	        	showMessage("图片上传失败!");
	    	        }
	    	});	
		   }*/
	    	
	    	
/*	detail.companyId = "";
	detail.companyLogo="";
	detail.depotLogo="";
	detail.id="";
	detail.image="";*/
		
		
	}
	
	private void requestAccident(){
		MLLogin user = ((BaseApplication)getActivity().getApplication()).get_user();
	  ZMRequestParams params = new ZMRequestParams();
		if(user.isDepot){
			params.addParameter(MLConstants.PARAM_LOGIN_DEPORTID,user.Id);
		}else{
			params.addParameter(MLConstants.PARAM_HOME_BUSINESSID1,user.Id);
		}
	//	params.addParameter(MLConstants.PARAM_MY_IMAGE,imageId);
		//params.addParameter("city.id",BaseApplication._currentCity);
		params.addParameter("city.id","1");
		params.addParameter(MLConstants.PARAM_MY_CITY,detail.city);
		params.addParameter(MLConstants.PARAM_MY_ACCIDENT,detail.accidentName);
		params.addParameter(MLConstants.PARAM_MY_DAMAGED,detail.damaged);
		
		params.addParameter(MLConstants.PARAM_MY_DISPLACE,detail.displacement);
		params.addParameter(MLConstants.PARAM_MY_MASTERNAME,detail.masterName);
		params.addParameter(MLConstants.PARAM_MY_MASTERPHONE,detail.masterPhone);
		
		params.addParameter(MLConstants.PARAM_MY_MASTERCONTENT,_content);
		params.addParameter(MLConstants.PARAM_MY_PRICE,detail.price);
		params.addParameter(MLConstants.PARAM_MY_MILEAGE,detail.mileage);
		params.addParameter(MLConstants.PARAM_MY_OLDPRICE,detail.oldPrice);
		params.addParameter(MLConstants.PARAM_MY_PLATEDATA,detail.platedata);
		
	    ZMHttpRequestMessage message2 = new ZMHttpRequestMessage(RequestType.ACCIDENT_ADD, null, params, _handler,HTTP_RESPONSE_ACCIDENT_ADD , MLAccidentServices.getInstance());
	    
	    Map<String, Object> otherParam = new HashMap<String, Object>();
	    otherParam.put("image", detail.paths);
	    message2.setOtherParmas(otherParam);
	    loadDataWithMessage(_context, "正在发布...", message2);
	}
	
	 private static final int HTTP_RESPONSE_ACCIDENT_ADD= 0;
	    private Handler _handler = new Handler() {
	        @Override
	        public void handleMessage(Message msg) {
	            super.handleMessage(msg);
	      	 // dismissProgressDialog();
	            if (msg == null || msg.obj == null) {
	                showMessage(R.string.loading_data_failed);
	                return;
	            }
	            if (msg.obj instanceof ZMHttpError) {
	                ZMHttpError error = (ZMHttpError) msg.obj;
	                showMessage(error.errorMessage);
	                return;
	            }
	            switch (msg.what) {
	           //事故车添加
	            case HTTP_RESPONSE_ACCIDENT_ADD:{
	                	MLRegister ret = (MLRegister) msg.obj;
	                	if(ret.state.equalsIgnoreCase("1")){
	                		showMessageSuccess("事故车添加成功!");
	                		((MLAuxiliaryActivity)_context).setResult(MLConstants.RESULT_ACCEIDENT_ADD);
	                		((MLAuxiliaryActivity)_context).finish();
	                		
	                	}else{
	                		showMessageError("事故车添加失败!");
	                	}
	                    break;
	            }  
	                default:
	                    break;
	            }
	        }
	    };
	private IEvent<Object> _event;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		_event = (IEvent<Object>) activity;
	}
}

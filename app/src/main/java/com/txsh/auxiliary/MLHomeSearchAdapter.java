package com.txsh.auxiliary;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import com.txsh.base.AdapterBase;
import com.txsh.model.MLHomeBusinessData;

public class MLHomeSearchAdapter extends AdapterBase<MLHomeBusinessData>{

	private Context _context;
	
	private Handler _callHandler;
	public MLHomeSearchAdapter(Context _context, Handler callHandler) {
		super();
		_callHandler = callHandler;
		this._context = _context;
	}
	@Override
	protected View getExView(int position, View view, ViewGroup parent) {
		
		MLHomeSearchItemView item = null;
		if(view ==null){
			item = new MLHomeSearchItemView(_context,_callHandler);
			view = item;
		}else{
			item = (MLHomeSearchItemView) view;
		}
		MLHomeBusinessData data = (MLHomeBusinessData) getItem(position);
		item.setData(data);
		return item;
	}
}

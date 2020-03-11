package com.txsh.auxiliary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.txsh.base.AdapterBase;
import com.txsh.model.MLMySpecialData;

public class MLMySpecialAdapter extends AdapterBase<MLMySpecialData>{

	private Context _context;
	
	public MLMySpecialAdapter(Context _context) {
		super();
		this._context = _context;
	}
	@Override
	protected View getExView(int position, View view, ViewGroup parent) {
		
		MLMySpecialItemView item = null;
		if(view ==null){
			item = new MLMySpecialItemView(_context);
			view = item;
		}else{
			item = (MLMySpecialItemView) view;
		}
		MLMySpecialData data = (MLMySpecialData) getItem(position);
		item.setData(data);
		return item;
	}
}

package com.txsh.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.txsh.base.AdapterBase;
import com.txsh.model.MLHomeCityData;

public class MLHomeCityAdapter extends AdapterBase<MLHomeCityData>{

	private Context _context;
	
	public MLHomeCityAdapter(Context _context) {
		super();
		this._context = _context;
	}
	

	@Override
	protected View getExView(int position, View view, ViewGroup parent) {
		
		MLHomeCityItemView item = null;
		if(view ==null){
			item = new MLHomeCityItemView(_context);
			view = item;
		}else{
			item = (MLHomeCityItemView) view;
		}
		MLHomeCityData data = (MLHomeCityData) getItem(position);
		item.setData(data);
		return item;
	}
}

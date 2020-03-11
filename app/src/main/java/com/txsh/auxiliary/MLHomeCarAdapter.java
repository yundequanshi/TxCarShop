package com.txsh.auxiliary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.txsh.base.AdapterBase;
import com.txsh.model.MLHomeCatalogData;

public class MLHomeCarAdapter extends AdapterBase<MLHomeCatalogData>{

	private Context _context;
	
	public MLHomeCarAdapter(Context _context) {
		super();
		this._context = _context;
	}

	@Override
	protected View getExView(int position, View view, ViewGroup parent) {
		
		MLHomeCarItemView item = null;
		if(view ==null){
			item = new MLHomeCarItemView(_context);
			view = item;
		}else{
			item = (MLHomeCarItemView) view;
		}
		MLHomeCatalogData data = (MLHomeCatalogData) getItem(position);
		item.setData(data);
		return item;
	}
}

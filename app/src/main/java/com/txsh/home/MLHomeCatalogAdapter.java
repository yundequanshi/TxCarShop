package com.txsh.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.txsh.base.AdapterBase;
import com.txsh.model.MLHomeCatalogData;

public class MLHomeCatalogAdapter extends AdapterBase<MLHomeCatalogData>{

	private Context _context;
	
	public MLHomeCatalogAdapter(Context _context) {
		super();
		this._context = _context;
	}
/*
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 8;
	}
*/
	@Override
	protected View getExView(int position, View view, ViewGroup parent) {
		
		MLHomeCatalogItemView item = null;
		if(view ==null){
			item = new MLHomeCatalogItemView(_context);
			view = item;
		}else{
			item = (MLHomeCatalogItemView) view;
		}
		MLHomeCatalogData data = (MLHomeCatalogData) getItem(position);
		item.setData(data);
		return item;
	}
}

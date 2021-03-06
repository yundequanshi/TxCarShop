package com.txsh.auxiliary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.txsh.R;
import com.txsh.base.AdapterBase;
import com.txsh.base.BaseLayout;
import com.txsh.constants.APIConstants;
import com.txsh.model.MLDealListData;

import java.text.DecimalFormat;

public class MLMyBillDAdapter extends AdapterBase<MLDealListData> {

	private Context _context;

	public MLMyBillDAdapter(Context _context) {
		super();
		this._context = _context;
	}

	@Override
	protected View getExView(int position, View view, ViewGroup parent) {

		MLMyBillItmView item = null;
		if (view == null) {
			item = new MLMyBillItmView(_context);
			view = item;
		} else {
			item = (MLMyBillItmView) view;
		}
		MLDealListData data = (MLDealListData) getItem(position);
		item.setData(data);
		return item;
	}

	class MLMyBillItmView extends BaseLayout {

		public MLMyBillItmView(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			init();
		}

		public MLMyBillItmView(Context context, AttributeSet attrs) {
			super(context, attrs);
			init();
		}

		public MLMyBillItmView(Context context) {
			super(context);
			init();
		}

		@ViewInject(R.id.my_money_name)
		private TextView _nameTv;

		@ViewInject(R.id.my_money_state)
		private TextView _stateTv;

		@ViewInject(R.id.my_money_time)
		private TextView _timeTv;

		@ViewInject(R.id.my_money_price)
		private TextView _priceTv;
		@ViewInject(R.id.money_iv_icon)
		private ImageView _ivicon;

		private void init() {
			View view = LayoutInflater.from(_context).inflate(
					R.layout.my_bill_d_item, null);
			addView(view);
			ViewUtils.inject(this, view);
		}

		public void setData(MLDealListData data) {
			_nameTv.setText(data.userName);

			String iconUrl = APIConstants.API_IMAGE + "?id=" + data.userLogo;
			bitmapUtils.display(_ivicon, iconUrl, bigPicDisplayConfig);
			double m = Double.parseDouble(data.allMoney);
			DecimalFormat df = new DecimalFormat("#.##");
			String money = df.format(m);

			_priceTv.setText(money + "元");
			// _timeTv.setText(MLStringUtils.time_second(data.dealTime));
			_timeTv.setText(data.dealTime);

			if (data.dealType.equalsIgnoreCase("1")) {
				_stateTv.setText("交易中");
			} else if (data.dealType.equalsIgnoreCase("2")) {
				_stateTv.setText("交易成功");
			} else if (data.dealType.equalsIgnoreCase("3")) {
				_stateTv.setText("退货处理中");
			} else if (data.dealType.equalsIgnoreCase("4")) {
				_stateTv.setText("退款成功");
			} else if (data.dealType.equalsIgnoreCase("5")) {
				_stateTv.setText("卖家拒绝退款");
			} else if (data.dealType.equalsIgnoreCase("6")) {
				_stateTv.setText("退款成功");
			}

		}
	}
}

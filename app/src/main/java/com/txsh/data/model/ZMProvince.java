package com.txsh.data.model;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;
@Table(name="zm_province")
public class ZMProvince {

	@Id
	public  String  id;

	@Column
	public  String  name;
}
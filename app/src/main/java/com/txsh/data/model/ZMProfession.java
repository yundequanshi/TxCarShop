package com.txsh.data.model;
import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;
@Table(name="zm_profession")
public class ZMProfession {

	@Id
	public  String  id;

	@Column
	public  String  name;


}
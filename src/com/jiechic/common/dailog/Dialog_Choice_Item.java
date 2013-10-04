package com.jiechic.common.dailog;

public class Dialog_Choice_Item {
	private String key;
	private String value;
	
	public Dialog_Choice_Item(){

	}
	
	public Dialog_Choice_Item(String key,String value){
		this.key = key;
		this.value = value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	
}

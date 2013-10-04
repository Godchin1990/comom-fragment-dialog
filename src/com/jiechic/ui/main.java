package com.jiechic.ui;

import java.util.ArrayList;
import java.util.List;

import com.jiechic.R;
import com.jiechic.common.dailog.Dialog_Choice_Item;
import com.jiechic.common.dailog.Dialog_DateTime_Fragment;
import com.jiechic.common.dailog.Dialog_Date_Fragment;
import com.jiechic.common.dailog.Dialog_Double_Fragment;
import com.jiechic.common.dailog.Dialog_Integer_Fragment;
import com.jiechic.common.dailog.Dialog_MultipleChoice_Fragment;
import com.jiechic.common.dailog.Dialog_SingleChoice_Fragment;
import com.jiechic.common.dailog.Dialog_String_Fragment;
import com.jiechic.common.dailog.listener.Fragment_Dialog_Listener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class main extends Activity implements Fragment_Dialog_Listener{

	private Button btString=null;
	private Button btInteger=null;
	private Button btDouble=null;
	private Button btDate=null;
	private Button btDatetime=null;
	private Button btSinglechoice=null;
	private Button btMultiplechoice=null;
	
	private EditText et=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
		initButton();
	}
	
	private void initView(){
		btString=(Button) findViewById(R.id.btString);
		btInteger=(Button) findViewById(R.id.btInteger);
		btDouble=(Button) findViewById(R.id.btDouble);
		btDate=(Button) findViewById(R.id.btDate);
		btDatetime=(Button) findViewById(R.id.btDatetime);
		btSinglechoice=(Button) findViewById(R.id.btSinglechoice);
		btMultiplechoice=(Button) findViewById(R.id.btMultiplechoice);
		
		et=(EditText) findViewById(R.id.editText1);
		
	}
	private void initButton(){
		if (btString!=null){
			btString.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Dialog_String_Fragment dialog = Dialog_String_Fragment.newInstance();
					dialog.setCancelable(false);// 设置点击屏幕Dialog不消失


					dialog.setLx("String");
					dialog.setTitle("字符串");
					dialog.setDate(et.getText().toString());
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "String");
				}
			});
		}
		if (btInteger!=null){
			btInteger.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Dialog_Integer_Fragment dialog = Dialog_Integer_Fragment.newInstance();
					dialog.setCancelable(false);// 设置点击屏幕Dialog不消失


					dialog.setLx("Integer");
					dialog.setTitle("整型");
					dialog.setDate(et.getText().toString());
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Integer");
				}
			});
		}
		if (btDouble!=null){
			btDouble.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Dialog_Double_Fragment dialog = Dialog_Double_Fragment.newInstance();
					dialog.setCancelable(false);// 设置点击屏幕Dialog不消失


					dialog.setLx("Double");
					dialog.setTitle("双精度");
					dialog.setDate(et.getText().toString());
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Double");
				}
			});
		}
		if (btDate!=null){
			btDate.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Dialog_Date_Fragment dialog = Dialog_Date_Fragment.newInstance();
					dialog.setCancelable(false);// 设置点击屏幕Dialog不消失


					dialog.setLx("Date");
					dialog.setTitle("日期");
					dialog.setDate(et.getText().toString());
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Date");
				}
			});
		}
		if (btDatetime!=null){
			btDatetime.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Dialog_DateTime_Fragment dialog = Dialog_DateTime_Fragment.newInstance();
					dialog.setCancelable(false);// 设置点击屏幕Dialog不消失


					dialog.setLx("Datetime");
					dialog.setTitle("日期时间");
					dialog.setDate(et.getText().toString());
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Datetime");
				}
			});
		}
		if (btSinglechoice!=null){
			btSinglechoice.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					List<Dialog_Choice_Item> list=new ArrayList<Dialog_Choice_Item>();
					for(int i=0;i<4;i++){
						Dialog_Choice_Item item=new Dialog_Choice_Item();
						item.setKey(String.valueOf(i));
						item.setValue("单选"+i);
						list.add(item);
					}
					Dialog_SingleChoice_Fragment dialog=Dialog_SingleChoice_Fragment.newInstance();
					dialog.setCancelable(false);
					dialog.setTitle("单选");
					dialog.setLx("Singlechoice");
					dialog.setDate(list);
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Singlechoice");
				}
			});
		}
		if (btMultiplechoice!=null){
			btMultiplechoice.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					List<Dialog_Choice_Item> list=new ArrayList<Dialog_Choice_Item>();
					for(int i=0;i<4;i++){
						Dialog_Choice_Item item=new Dialog_Choice_Item();
						item.setKey(String.valueOf(i));
						item.setValue("多选"+i);
						list.add(item);
					}
					Dialog_MultipleChoice_Fragment dialog=Dialog_MultipleChoice_Fragment.newInstance();
					dialog.setCancelable(false);
					dialog.setTitle("多选");
					dialog.setLx("Multiplechoice");
					dialog.setDate(list);
					dialog.setDismissListener(main.this);
					dialog.show(getFragmentManager(), "Multiplechoice");
				}
			});
		}
	}

	@Override
	public void onFragment_Dialog_Listener(Bundle args) {
		// TODO Auto-generated method stub
		if(args.getBoolean("result")){
			String lx=args.getString("lx");
			String date=null;
			String []dates=new String[2];
			if("String".equals(lx)){
				date=args.getString("date");
				et.setText(date);
			}else if("Integer".equals(lx)){
				date=args.getString("date");
				et.setText(date);
			}else if("Double".equals(lx)){
				date=args.getString("date");
				et.setText(date);
			}else if("Date".equals(lx)){
				date=args.getString("date");
				et.setText(date);
			}else if("Datetime".equals(lx)){
				date=args.getString("date");
				et.setText(date);
			}else if("Singlechoice".equals(lx)){
				dates=args.getStringArray("date");
				et.setText(dates[1]);
			}else if("Multiplechoice".equals(lx)){
				dates=args.getStringArray("date");
				et.setText(dates[1]);
			}
			
		}
	}
}

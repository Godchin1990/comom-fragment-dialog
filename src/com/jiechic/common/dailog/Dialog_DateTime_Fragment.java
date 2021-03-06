package com.jiechic.common.dailog;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.jiechic.R;
import com.jiechic.common.Format;
import com.jiechic.common.logh;
import com.jiechic.common.dailog.listener.Fragment_Dialog_Listener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class Dialog_DateTime_Fragment extends DialogFragment {

	private final String TAG = getClass().getSimpleName();
	private Date date=null;
	private String lx=null;
	private String title=null;
	
	private Fragment_Dialog_Listener dismissListener=null;	

    public static Dialog_DateTime_Fragment newInstance() {
        return new Dialog_DateTime_Fragment();
    }

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Context context=getActivity();
		LayoutInflater inflater=getActivity().getLayoutInflater();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    	builder.setTitle(title);
    	
    	View v=inflater.inflate(R.layout.fragment_dialog_datetime, (ViewGroup)((Activity) context).findViewById(R.id.dialog_datetime));
    	final Calendar d = Calendar.getInstance(Locale.getDefault());
    	
    	if (date!=null||"".equals(date)){
    		logh.d(date==null?"":date.toLocaleString());
    		logh.d("111111");
			d.setTime(date);
		}else {
			date=new Date();
		}
    	
    	DatePicker datePicker= (DatePicker) v.findViewById(R.id.dialog_datetime_datePicker);
        datePicker.setCalendarViewShown(false);
        datePicker.init(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DAY_OF_MONTH), new OnDateChangedListener() {
        	
			@SuppressWarnings("deprecation")
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				Dialog_DateTime_Fragment.this.date.setYear(year-1900);
				Dialog_DateTime_Fragment.this.date.setMonth(monthOfYear);
				Dialog_DateTime_Fragment.this.date.setDate(dayOfMonth);
			}
		});
        TimePicker timePicker= (TimePicker) v.findViewById(R.id.dialog_datetime_timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(d.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(d.get(Calendar.MINUTE));
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				Dialog_DateTime_Fragment.this.date.setHours(hourOfDay);
				Dialog_DateTime_Fragment.this.date.setMinutes(minute);
			}
		});
    	
    	builder.setView(v);
		
    	builder.setPositiveButton("确认",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						close(true);
						
					}
				});
		builder.setNegativeButton("取消",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						close(false);// 删除
					}
				});
		Dialog dialog = builder.create();         
    	logh.d(TAG);
        return dialog;
    }

	public void doDismiss(int type_of_operation) {
		//type_of_operation=0;//0 取消 1 保存 2 删除
		boolean result=false;
		if(type_of_operation==1){
			//result=OperationRiskRecord(type_of_operation);
		}else if(type_of_operation==2){
			//result=OperationRiskRecord(type_of_operation);
		}else{
			result=true;
		}
		if(result){
			//Log.i(TAG,"super.onDismiss(dialog)");
			this.dismiss();			
		}
	}
	
	public void setDismissListener(Fragment_Dialog_Listener dismissListener) {
		this.dismissListener=dismissListener;		
	}

	public void setDate(String date) {
		this.date = Format.String_to_DateTime(date);
	}

	public void setLx(String lx) {
		this.lx = lx;
	}
	
	private void close(boolean isupdate) {
		// TODO Auto-generated method stub
		Bundle args=new Bundle();
		args.putBoolean("result", isupdate);
		args.putString("lx", lx);
		args.putString("date", Format.DateTime_to_String(date));
		dismissListener.onFragment_Dialog_Listener(args);
		Dialog_DateTime_Fragment.this.dismiss();
	}


	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title=title;
	}

}

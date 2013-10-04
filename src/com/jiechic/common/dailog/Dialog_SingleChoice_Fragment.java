package com.jiechic.common.dailog;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

import com.jiechic.R;
import com.jiechic.common.logh;
import com.jiechic.common.dailog.listener.Fragment_Dialog_Listener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Dialog_SingleChoice_Fragment extends DialogFragment {

	private final String TAG = getClass().getSimpleName();
	private String title=null;
	private String []date=new String[2];
	private List<Dialog_Choice_Item> list=null;
	private String lx=null;
	private Fragment_Dialog_Listener dismissListener=null;	
	private Boolean flag=false;
    public static Dialog_SingleChoice_Fragment newInstance() {
        return new Dialog_SingleChoice_Fragment();
    }
    
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		Context context=getActivity();
		LayoutInflater inflater=getActivity().getLayoutInflater();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    	builder.setTitle(title);
    	
    	
    	View v=inflater.inflate(R.layout.fragment_dialog_singlechoice, (ViewGroup)((Activity) context).findViewById(R.id.dialog_singlechoice));
    	final RadioGroup radiogroup=(RadioGroup) v.findViewById(R.id.dialog_radiogroup);
    	//RadioGroup radioGroup=new RadioGroup.LayoutParams(v);
    	
    	for (int i = 0; i < list.size(); i++) {
    		RadioButton radio=new RadioButton(context);
    		radio.setId(i);
    		radio.setText(list.get(i).getValue());
    		radio.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
    		radiogroup.addView((View)radio);
		}
    	
    	radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				RadioButton radio=(RadioButton) radiogroup.getChildAt(checkedId);
				date[0]=list.get(radio.getId()).getKey();
				date[1]=radio.getText().toString();
				flag=true;
				logh.d(date[0]+date[1]);
			}
		});

    	builder.setView(v);
		
    	builder.setPositiveButton("确认",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						if (flag) {
							try {
								Field field;
								field = dialog.getClass()
								.getSuperclass().getDeclaredField(
								         "mShowing" );
								field.setAccessible( true );
							     //   将mShowing变量设为false，表示对话框已关闭
								field.set(dialog,  true );
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							close(true);//关闭
						}else {
							try {
								Field field;
								field = dialog.getClass()
								.getSuperclass().getDeclaredField(
								         "mShowing" );
								field.setAccessible( true );
							     //   将mShowing变量设为false，表示对话框已关闭
								field.set(dialog,  false );
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(getActivity(), "请选择", Toast.LENGTH_SHORT);
							}
						}
					}
				});
		builder.setNegativeButton("取消",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						try {
							Field field;
							field = dialog.getClass()
							.getSuperclass().getDeclaredField(
							         "mShowing" );
							field.setAccessible( true );
						     //   将mShowing变量设为false，表示对话框已关闭
							field.set(dialog,  true );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						close(false);//关闭
					}
				});
		Dialog dialog = builder.create();         
    	logh.d(TAG);
//    	try 
//        {
//          
//            Field field  =  dialog.getClass().getDeclaredField( "mAlert" );
//            field.setAccessible( true );
//            //   获得mAlert变量的值
//            Object obj  =  field.get(dialog);
//            field  =  obj.getClass().getDeclaredField( "mHandler" );
//            field.setAccessible( true );
//            //   修改mHandler变量的值，使用新的ButtonHandler类
//            field.set(obj,  new  ButtonHandler(dialog));
//        }
//         catch  (Exception e)
//        {
//        }
        return dialog;
    }
	
	public void setDismissListener(Fragment_Dialog_Listener dismissListener) {
		this.dismissListener=dismissListener;		
	}

	public void setDate(List<Dialog_Choice_Item> list) {
		this.list = list;
	}


	public void setLx(String lx) {
		this.lx = lx;
	}
	
	private void close(boolean isupdate) {
		// TODO Auto-generated method stub
		Bundle args=new Bundle();
		args.putBoolean("result", isupdate);
		args.putString("lx", lx);
		args.putStringArray("date", date);
		Dialog_SingleChoice_Fragment.this.dismiss();
		dismissListener.onFragment_Dialog_Listener(args);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
//	class  ButtonHandler  extends  Handler
//	{
//
//	     private  WeakReference < DialogInterface >  mDialog;
//
//	     public  ButtonHandler(DialogInterface dialog)
//	    {
//	        mDialog  =   new  WeakReference < DialogInterface > (dialog);
//	    }
//
//	    @Override
//	     public   void  handleMessage(Message msg)
//	    {
//	         switch  (msg.what)
//	        {
//
//	             case  DialogInterface.BUTTON_POSITIVE:
//	             case  DialogInterface.BUTTON_NEGATIVE:
//	             case  DialogInterface.BUTTON_NEUTRAL:
//	                ((DialogInterface.OnClickListener) msg.obj).onClick(mDialog
//	                        .get(), msg.what);
//	                 break ;
//	        }
//	    }
//	}
}

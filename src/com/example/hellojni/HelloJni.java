
package com.example.hellojni;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HelloJni extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_1);
		//≤‚ ‘
		/*
		 * Create a TextView and set its content. the text is retrieved by
		 * calling a native function.
		 */
		//lc_doexcute1(null);

	}

	public void lc_doexcute1(View v) {
		TextView tv ;
		tv = (TextView) this.findViewById(R.id.textView1);
		String s=stringFromJNI();
		//tv.setText(s);
		 
		 nativeCallBack();
	}
	
	
	public void callback_func(int notify_id, int param) 
    { 
        Log.i("JNICallback","notify_id="+notify_id+";param="+param); 
        TextView tv ;
		tv = (TextView) this.findViewById(R.id.textView1);
		tv.setText(tv.getText() + ","+ param);
    } 
    public native void nativeCallBack();
	

	/*
	 * A native method that is implemented by the 'hello-jni' native library,
	 * which is packaged with this application.
	 */
	public native String stringFromJNI();

	/*
	 * This is another native method declaration that is *not* implemented by
	 * 'hello-jni'. This is simply to show that you can declare as many native
	 * methods in your Java code as you want, their implementation is searched
	 * in the currently loaded native libraries only the first time you call
	 * them.
	 *
	 * Trying to call this function will result in a
	 * java.lang.UnsatisfiedLinkError exception !
	 */
	public native String unimplementedStringFromJNI();

	/*
	 * this is used to load the 'hello-jni' library on application startup. The
	 * library has already been unpacked into
	 * /data/data/com.example.hellojni/lib/libhello-jni.so at installation time
	 * by the package manager.
	 */
	static {
		System.loadLibrary("hello-jni");
	}
}

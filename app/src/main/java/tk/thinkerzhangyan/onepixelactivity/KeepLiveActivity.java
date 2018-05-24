package tk.thinkerzhangyan.onepixelactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class KeepLiveActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("zhangyan", "keepLiveAcitivity被创建");
		Log.d("zhangyan", "保活进程的ID：" + getTaskId());


		// Activity是依附在Window上的
		Window window = getWindow();
		// 把这个一个像素点设置在左上角。
		window.setGravity(Gravity.LEFT | Gravity.TOP);
		// 设置一个像素
		LayoutParams params = new LayoutParams();
		params.width = 10;
		params.height = 10;
		window.setAttributes(params);
		
		KeepLiveActivityManager.getInstance(this).setKeepLiveActivity(this);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("zhangyan", "keepLiveAcitivity被销毁");
	}
}

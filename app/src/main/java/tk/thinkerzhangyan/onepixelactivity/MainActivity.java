package tk.thinkerzhangyan.onepixelactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//启动一个后台服务
		Intent intent = new Intent(this,ScreenService.class);
		startService(intent);

		Log.d("zhangyan", "主进程的ID："+getTaskId());
	}

}

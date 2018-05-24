package tk.thinkerzhangyan.onepixelactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ScreenService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();

		Log.d("zhangyan", "ScreenService被创建了");


		new ScreenListener(this).begin(new ScreenListener.ScreenStateListener() {

			@Override
			public void onScreenOn() {
				// 亮屏，finish一个像素的Activity
				KeepLiveActivityManager.getInstance(ScreenService.this)
						.finishKeepLiveActivity();
			}

			@Override
			public void onScreenOff() {
				// 灭屏，启动一个像素的Activity
				KeepLiveActivityManager.getInstance(ScreenService.this)
						.startKeepLiveActivity();
			}
		});


	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}

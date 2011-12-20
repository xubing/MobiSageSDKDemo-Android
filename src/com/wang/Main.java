package com.wang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mobisage.android.ads.AdOfInterval;
import com.mobisage.android.ads.AdOfSize;
import com.mobisage.android.ads.MobiSageView;
import com.mobisage.android.ads.msg.SYSTEM_EVENT_ENUM;

public class Main extends Activity {
	/** Called when the activity is first created. */

	private MobiSageView ad = null;
	private Button adonBtn = null;
	private Button adoffBtn = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		adonBtn = (Button) findViewById(R.id.adon);
		adonBtn.setText("send system track msg");
		adonBtn.setOnClickListener(new adOnButton());
		adonBtn.setVisibility(1);

		adoffBtn = (Button) findViewById(R.id.adoff);
		adoffBtn.setText("send user track msg");
		adoffBtn.setOnClickListener(new adOffButton());

		ad = new MobiSageView(this, // Context
				"588ea4f6175d4731ab020c765e4018f4");
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		ad.setLayoutParams(params);
		ad.setViewSize(AdOfSize.Size_320X48);
		ad.setInterval(AdOfInterval.Interval_15);

		Log.e("TestApp", "test");

		LinearLayout layout = (LinearLayout) findViewById(R.id.ads01);
		layout.addView(ad);
//		ad.startRequest();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ad.startRequest();			//send the request and show ad
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		ad.stopRequest();
	}

	class adOnButton implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ad.trackSystemEvent(SYSTEM_EVENT_ENUM.AppLaunchingEvent,
					"BingComing");

		}

	}

	class adOffButton implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ad.trackCustomerEvent("CustomerEvent", "BingComing");

		}

	}

}
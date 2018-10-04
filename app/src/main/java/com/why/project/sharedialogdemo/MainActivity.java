package com.why.project.sharedialogdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.why.project.sharedialogdemo.dialog.ShareDialog;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//显示分享底部区域
				Bundle bundle = new Bundle();
				ShareDialog shareDialog = ShareDialog.getInstance(mContext,bundle);
				shareDialog.setOnShareClickLitener(new ShareDialog.OnShareClickLitener() {
					@Override
					public void onShareToQQ() {
						openShare("QQ");
					}
					@Override
					public void onShareToQZone() {
						openShare("QZone");
					}
					@Override
					public void onShareToWX() {
						openShare("WX");
					}
					@Override
					public void onShareToWXCircle() {
						openShare("WXCircle");
					}
					@Override
					public void onShareToSina() {
						openShare("Sina");
					}
				});
				shareDialog.show(getSupportFragmentManager(), "Share");
			}
		});
	}

	//在这里可以配合友盟分享，通过switch语句，根据type判断平台。执行分享代码
	private void openShare(String type){
		Toast.makeText(mContext, type, Toast.LENGTH_SHORT).show();
	}
}

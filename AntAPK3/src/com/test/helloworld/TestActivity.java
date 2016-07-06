package com.test.helloworld;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity {

	Date serverTime;
	long C1;
	long C2;
	
	TextView showText;
	
	DateFormat df;
	
    @SuppressLint("SimpleDateFormat")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 服务器时间
        serverTime = new Date();
        // 开机之后会保持一个时钟(绝对时间）
        C1 = SystemClock.elapsedRealtime();
        
        showText = (TextView)findViewById(R.id.showText);
        
        Button button = (Button)findViewById(R.id.testButton);
        button.setText("当前时间:"+df.format(serverTime));
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				C2 = SystemClock.elapsedRealtime();
				// 当前时间=服务器时间+时间差
				Date curDate = new Date(serverTime.getTime()+(C2-C1));
				
				String s = df.format(curDate);
				showText.setText("最新当前时间:"+s);
			}
		});
        
    }


    
}

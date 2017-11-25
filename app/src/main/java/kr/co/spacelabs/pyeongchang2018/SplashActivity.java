package kr.co.spacelabs.pyeongchang2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by bahk_ on 2017-11-22.
 */

public class SplashActivity extends Activity {
    private int count = 1;
    private TextView tv_count_down;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        tv_count_down = (TextView) findViewById(R.id.tv_count_down);
        tv_count_down.setText(count+"");

        //startLoading();

    }

    // 화면에 보이는 액티비티의 상태를 알려준다
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            startCountDown();
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 카운트가 0일 경우 화면 이동을 한다.
            if (count == 0) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, SelectorActivity.class);
                intent.putExtra("name", "일정을 선택하세요");
                startActivity(intent);

                finish();
                return;
            }
            count = count - 1;
            tv_count_down.setText(count+"");

            startCountDown();
        }

    };

//    private void startLoading() {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);
//    }

    private void startCountDown(){
        handler.sendEmptyMessageDelayed(1000, 1000);
    }

}


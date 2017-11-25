package kr.co.spacelabs.pyeongchang2018;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bahk_ on 2017-11-22.
 */

public class SelectorActivity extends Activity {

    SharedPreferences preferences;
    TextView tv_name;

     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_activity);

        preferences = getSharedPreferences("pref_sale", Context.MODE_PRIVATE);

         Intent intent =getIntent();
         int name = intent.getIntExtra("name", 2018);

         tv_name = (TextView) findViewById(R.id.tv_name);
         tv_name.setText(name+"");

         findViewById(R.id.btn_game).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 launchActivity(ACT_GAME);
             }
         });
         findViewById(R.id.btn_date).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 launchActivity(ACT_DATE);
             }
         });

    }

    private final int ACT_GAME = 1;
     private final int ACT_DATE = 2;

    private void launchActivity(int type){
         String screen="";
         Intent intent;
         switch (type){
             case ACT_GAME:
                screen = "종목별 일정";
                        intent = new Intent(SelectorActivity.this, GameListView.class);
                        startActivity(intent);
                        break;

             case ACT_DATE:
                screen = "날짜별 일정";
                        intent = new Intent(SelectorActivity.this, DateListAcitivity.class);
                        startActivity(intent);
                        break;
         }

         SharedPreferences.Editor e = preferences.edit();
         e.putString("screen", screen);
         e.commit();
    }
}

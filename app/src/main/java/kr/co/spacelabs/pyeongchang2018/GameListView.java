package kr.co.spacelabs.pyeongchang2018;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by JeongMin Choe on 2017-11-25.
 */

public class GameListView extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_list_view_activity);
    }
}

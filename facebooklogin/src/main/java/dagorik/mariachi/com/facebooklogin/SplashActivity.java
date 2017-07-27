package dagorik.mariachi.com.facebooklogin;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(
                        SplashActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }

        };

        Timer time = new Timer();
        time.schedule(task,3000);
    }
}

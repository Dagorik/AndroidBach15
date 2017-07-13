package dagorik.mariachi.com.animationsprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagorik.mariachi.com.animationsprojects.AnimationTween.TweenAnimationActivity;
import dagorik.mariachi.com.animationsprojects.RevealAnimation.RevealAnimationActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.animation1)
    public void animation1(){
        startActivity(new Intent(this,TweenAnimationActivity.class));
    }

    @OnClick(R.id.animation_4)
    public void animator4(){
        startActivity(new Intent(this,RevealAnimationActivity.class));
    }
}

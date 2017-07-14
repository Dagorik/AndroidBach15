package dagorik.mariachi.com.animationsprojects.RevealAnimation;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagorik.mariachi.com.animationsprojects.R;

public class RevealAnimationActivity extends AppCompatActivity {
    @BindView(R.id.layout_reveal)
    LinearLayout revealLayout;

    @BindView(R.id.btn_show)
    Button showReveal;

    @BindView(R.id.tv1)
    TextView tv1;

    @BindView(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_animation);
        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        
    }

    private void startReveal(){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade1);
        tv1.startAnimation(animation1);
        tv2.startAnimation(animation1);
        // get the center for the clipping circle
        int cx = (revealLayout.getLeft() + revealLayout.getRight()) / 2;
        int cy = (revealLayout.getTop() + revealLayout.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(revealLayout.getWidth(), revealLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(revealLayout, cx, cy, 0, finalRadius);
        anim.setDuration(600);

        // make the view visible and start the animation
        revealLayout.setVisibility(View.VISIBLE);
        anim.start();
    }
}

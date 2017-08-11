package dagorik.mariachi.com.mvpretrofitrxjava.views.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import dagorik.mariachi.com.mvpretrofitrxjava.R;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfaceMain;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfacePresenter;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Presenter.PresenterImp;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity implements InterfaceMain {

    private EditText user;
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    private InterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        textView = (TextView) findViewById(R.id.repos);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        presenter = new PresenterImp(this);

    }


    @Override
    public void showProgressBar(boolean option) {
        if (option) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageGit(String messaage) {
        textView.setText(messaage);
    }


    public void Click(View view) {
        presenter.getDataGit(user.getText().toString());
    }
}

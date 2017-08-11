package dagorik.mariachi.com.mvplogin.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import dagorik.mariachi.com.mvplogin.R;
import dagorik.mariachi.com.mvplogin.interfaces.LoginPresenter;
import dagorik.mariachi.com.mvplogin.interfaces.LoginView;
import dagorik.mariachi.com.mvplogin.presenter.LoginPresenterImp;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText user,password;
    private Button okidoki;
    private ProgressBar progressBar;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterImp(this);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void erroLogin() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successLogin() {
        //PASAR DE ACTIVIDAD
        Toast.makeText(this,"Deberias de pasar de actividad",Toast.LENGTH_SHORT).show();
    }

    public void okidoki(View view) {
        loginPresenter.validarCredenciales(user.getText().toString(),password.getText().toString());
    }
}

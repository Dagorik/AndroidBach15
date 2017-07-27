package dagorik.mariachi.com.facebooklogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions(Arrays.asList("email","public_profile","user_photos"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Bundle params = new Bundle();
                params.putString("fields","id,name,email,last_name,first_name,picture");
                GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback()
                {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.e("MyLog",object+"");

                        try {
                            String name = object.getString("name");
                            Log.e("MyLogName",name);

                            Profile profile = Profile.getCurrentProfile();
                            String nameProfile = profile.getFirstName();
                            String picture = String.valueOf(profile.getProfilePictureUri(300,300));
                            Log.e("MyLogNameP",picture);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                graphRequest.setParameters(params);
                graphRequest.executeAsync();


                goLoginScreen();

            }

            @Override
            public void onCancel() {
                Log.e("Cancel","Cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("Error",error.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

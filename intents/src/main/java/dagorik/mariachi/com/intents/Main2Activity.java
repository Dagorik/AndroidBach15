package dagorik.mariachi.com.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            String user = extras.getString(Constants.INTENT_KEY_USERNAME);
            TextView username = (TextView) findViewById(R.id.tvUser);
            username.setText(user);

        }

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.INTENT_KEY_SALUDO,"HOLA");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}

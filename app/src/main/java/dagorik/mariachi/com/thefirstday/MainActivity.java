package dagorik.mariachi.com.thefirstday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText dolares,pesos;
    private Button convertir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dolares = (EditText) findViewById(R.id.dolares);
        pesos = (EditText) findViewById(R.id.pesos);

        convertir= (Button) findViewById(R.id.button);

        convertir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(this, "Dolares a pesoso", Toast.LENGTH_SHORT).show();
//                double dolar = Double.parseDouble(dolares.getText().toString());
//                double conversion = dolar * 17.8;
                double var = 122332.32423;

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra",var);
                startActivity(intent);

                break;
        }
    }


}

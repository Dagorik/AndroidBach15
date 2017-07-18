package dagorik.mariachi.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescripcionActivity extends AppCompatActivity {

    TextView peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        String mPeso = getIntent().getStringExtra("PESO");
        peso = (TextView) findViewById(R.id.peso);
        peso.setText(mPeso);
    }
}

package dagorik.mariachi.com.intents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.editText);


        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLink(v);
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerLlamada(v);
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarStreetView(v);
            }
        });

        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escogerApp(v);
            }
        });

        Button btn5 = (Button) findViewById(R.id.btnLogin);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = user.getText().toString();

                if (txt.isEmpty()) {

                    Toast.makeText(v.getContext(), "NOP", Toast.LENGTH_SHORT).show();

                } else {

                    Intent intent = new Intent(v.getContext(), Main2Activity.class);
                    intent.putExtra(Constants.INTENT_KEY_USERNAME, txt);
                    startActivityForResult(intent, Constants.REQUEST_CODE_SECOND_ACTIVITY);

                }


            }
        });

        Button btn6 = (Button) findViewById(R.id.bntFoto);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarFoto(v);
            }
        });

    }

    public void tomarFoto(View v) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Constants.REQUEST_CODE_FOTO);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Constants.REQUEST_CODE_SECOND_ACTIVITY == requestCode) {

            if (resultCode == RESULT_OK) {
                String resultTxt = data.getStringExtra(Constants.INTENT_KEY_SALUDO);
                Toast.makeText(MainActivity.this, "Request Code: " + requestCode + resultTxt, Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(MainActivity.this, "LE DI BACK", Toast.LENGTH_LONG).show();

            }


        } else if (Constants.REQUEST_CODE_FOTO == requestCode) {

            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitMap = (Bitmap) extras.get("data");
                ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setImageBitmap(imageBitMap);

            } else {
                Toast.makeText(MainActivity.this, ":(", Toast.LENGTH_LONG).show();
            }

        }

    }

    public void abrirLink(View view) {

        String url = "http://google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }

    public void hacerLlamada(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555055650"));
        startActivity(intent);

    }

    public void mostrarStreetView(View view) {

        Uri gmm = Uri.parse("google.streetview:cbll=19.332273,-99.190092");
        Intent intent = new Intent(Intent.ACTION_VIEW, gmm);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);


    }

    public void escogerApp(View view) {

        String texto = "este es el texto que quieres mandar";

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_TEXT, texto);
        intent.setType("text/plain");
        Intent chooser = Intent.createChooser(intent, "Escoge un app");
        if (intent.resolveActivity(getPackageManager()) != null) {//package manager es el menu que sale para escoger apps
            startActivity(chooser);
        }
    }

}


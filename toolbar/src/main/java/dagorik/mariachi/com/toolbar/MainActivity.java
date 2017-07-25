package dagorik.mariachi.com.toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mi primera toolbar");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(this, "Action 1", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;

            case R.id.action2:
                if(item.isChecked()){
                    item.setChecked(false);
                    Toast.makeText(this, "Action 2", Toast.LENGTH_SHORT).show();
                } else{
                    item.setChecked(true);
                }
                break;

            case R.id.action3:
                Toast.makeText(this, "Action 3", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}



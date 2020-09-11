package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private Button startSpill;
    private Button statistikk;
    private Button preferanser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSpill = findViewById(R.id.startSpill);
        startSpill.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, StartSpill.class);
                startActivity(intent);
            }
        });

        statistikk = findViewById(R.id.seStatistikk);
        statistikk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Statistikk.class);
                    startActivity(intent);
            }
        });

        preferanser = findViewById(R.id.preferanser);
        preferanser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Preferanser.class);
                startActivity(intent);
            }
        });


    }
}
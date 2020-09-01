package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private Button startSpill;
    private Button seStatistikk;
    private Button preferanser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSpill = (Button)findViewById(R.id.startSpill);
        startSpill.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                åpneStartSpill();
            }
        });

        seStatistikk = (Button)findViewById(R.id.seStatistikk);
        seStatistikk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                åpneSeStatistikk();
            }
        });

        seStatistikk = (Button)findViewById(R.id.preferanser);
        seStatistikk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                åpnePreferanser();
            }
        });


    }

        public void åpneStartSpill(){
        Intent intent = new Intent(MainActivity.this, StartSpill.class);
        startActivity(intent);
    }

        public void åpneSeStatistikk(){
        Intent intent = new Intent(MainActivity.this, Statistikk.class);
        startActivity(intent);
    }

    public void åpnePreferanser(){
        Intent intent = new Intent(MainActivity.this, Preferanser.class);
        startActivity(intent);
    }


}

/**
 *
 button = (Button) findViewById(R.id.button);

 button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
åpnePreferanser();
}
});
 }

 public void åpnePreferanser(){
 Intent intent = new Intent(this, Preferanser.class);
 startActivity(intent);
 }
 }
 **/
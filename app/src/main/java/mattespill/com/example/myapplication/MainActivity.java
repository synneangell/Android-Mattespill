package mattespill.com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ViewAnimator;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button startSpill;
    private Button statistikk;
    private Button preferanser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String språk = pref.getString("velgSpråk_preference", "no");
        settLand(språk);

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
    public void settLand(String landskode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration cf = res.getConfiguration();
        cf.setLocale(new Locale(landskode));
        res.updateConfiguration(cf, dm);
    }

    public void tysk(View v){
        settLand("de");
        recreate();
    }

    public void norsk(View v){
        settLand("no");
        recreate();
    }
}
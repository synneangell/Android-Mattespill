package mattespill.com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Locale;

public class Preferanser extends AppCompatActivity {
    RadioGroup radiogroup;
    RadioButton radio5Opg;
    RadioButton radio10Opg;
    RadioButton radio25Opg;

    RadioButton valgt;

    Integer antallStykker;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferanser);

        radiogroup = findViewById(R.id.radiogroup);
        radio5Opg = findViewById(R.id.radio5Opg);
        radio10Opg = findViewById(R.id.radio10Opg);
        radio25Opg = findViewById(R.id.radio25Opg);

        antallStykker = radioValgt();

        sharedPreferences = getSharedPreferences("Preferanser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("radioValgt", antallStykker);
        editor.apply();

    }

    public int radioValgt(){
        int antallValgt = 3;


        // Bruke noe annet enn radiobuttons!! Får ikke hentet ut verdien til radiobutton

        /*int valgtRadio = radiogroup.getCheckedRadioButtonId();
        valgt = (RadioButton) findViewById(valgtRadio);

        Log.d("Valgt", valgt.toString() );*/
        /*
        if(valgt.toString().equals(5)){
            antallValgt = 5;
        }

        else if(valgt.toString().equals(10)){
            antallValgt = 10;
        }
        else {
            antallValgt = 25;
        }*/
        return antallValgt;
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

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("radio5Opg", radio5Opg.isChecked());
        savedInstanceState.putBoolean("radio10Opg", radio10Opg.isChecked());
        savedInstanceState.putBoolean("radio25Opg", radio25Opg.isChecked());
        savedInstanceState.putInt("radioValgt", radioValgt());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        radio5Opg.setChecked(savedInstanceState.getBoolean("task5", false));
        radio5Opg.setChecked(savedInstanceState.getBoolean("task10", false));
        radio5Opg.setChecked(savedInstanceState.getBoolean("task25", false));
        antallStykker = savedInstanceState.getInt("radioValgt");
    }
}
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
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class Preferanser extends PreferenceActivity {
    RadioGroup radiogroup;
    RadioButton radioButton;
    Integer antallStykker = 3;
    SharedPreferences sp;
    SharedPreferences sp2;
    TextView antallVunnet, antallTapt;
    Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferanser);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferanseFragment()).commit();

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String språk = pref.getString("velgSpråk_preference", "no");
        settLand(språk);

        //addListenerOnButton();


       /* sp = getSharedPreferences("Preferanser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("radioValgt", antallStykker);
        editor.apply();*/

/*        sp2 = getSharedPreferences("PreferanserSpråk", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp.edit();
        editor2.putInt("sprakValgt", );
        editor2.commit();*/

    }
/*

    public Integer addListenerOnButton(){
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        btnDisplay = (Button) findViewById(R.id.btn);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
                int selectedId = radiogroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Log.d("Valgt i pref", radioButton.getText().toString());
                antallStykker = Integer.valueOf(radioButton.getText().toString());

            }
        });
        return antallStykker;
    }
*/

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
/*
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("radioValgt", antallStykker);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        antallStykker = savedInstanceState.getInt("radioValgt");
    }*/
}
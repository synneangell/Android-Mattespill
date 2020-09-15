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
import android.preference.Preference;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferanseFragment()).commit();

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String språk = pref.getString("velgSpråk_preference", "no");
        settLand(språk);
    }

    public void onClick (Preference preference) {
        if (preference.getKey().equals("no")) {
            Log.d("toString",preference.toString());
            Log.d("getKey", preference.getKey());
            settLand("no");
        } else {
            Log.d("toString",preference.toString());
            Log.d("getKey", preference.getKey());
            settLand("de");
        }
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
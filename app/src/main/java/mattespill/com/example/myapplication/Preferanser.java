package mattespill.com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

public class Preferanser extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SetPreferanseActivity.PrefsFragment()).commit();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
/*
        String defaultSprak = "no";
        String valgtSprak = pref.getString("velgSprak_preference", "feil");
        Log.d("Sprak", valgtSprak);

        settLand(valgtSprak);*/


        /* Obs!! Den utkommenterte koden nedenfor fungerte til en viss grad. Men preferansefragmentet får ikke oppdatert språk
        før man har gått ut av preferanser!*/

       /* Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = pref.getString("velgSprak_preference", "feil");
        Log.d("Config sprak", config.locale.getLanguage());
        if (!config.locale.getLanguage().equals(lang))
        {
            Resources res = getResources();
            DisplayMetrics dm =  res.getDisplayMetrics();
            Configuration cf = res.getConfiguration();
            Locale locale = new Locale(lang);
            cf.locale = locale;
            res.updateConfiguration(cf, dm);
            recreate();
            Log.d("Sprakvalgt", lang);
        }*/
    }

    public void settLand(String landskode){
        Resources res = getResources();
        DisplayMetrics dm =  res.getDisplayMetrics();
        Configuration cf = res.getConfiguration();
        Locale locale = new Locale(landskode);
        cf.locale = locale;
        res.updateConfiguration(cf, dm);
        recreate();
    }
}


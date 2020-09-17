package mattespill.com.example.myapplication;


import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import java.util.Locale;

public class Preferanser extends PreferenceActivity {
    String aktland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String valgtSprak = pref.getString("velgSprak_preference", "no");
        settLand(valgtSprak);
        aktland=valgtSprak;

        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
    }

    public static class PrefsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

        }
    }


    public void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String valgtSprak = pref.getString("velgSprak_preference", "no");
        if (valgtSprak.equals(aktland)==false) {
            recreate();
            aktland=valgtSprak;
        }
    }


    public void settLand(String landskode){
        Resources res = getResources();
        DisplayMetrics dm =  res.getDisplayMetrics();
        Configuration cf = res.getConfiguration();
        Locale locale = new Locale(landskode);
        cf.locale = locale;
        res.updateConfiguration(cf, dm);

    }
}


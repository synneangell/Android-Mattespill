package mattespill.com.example.myapplication;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import java.util.Locale;

public class Preferanser extends PreferenceActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

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

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if(s.equals("no")){
            settLand("no");
            recreate();
        }
        else{
            settLand("de");
            recreate();
        }
    }
}
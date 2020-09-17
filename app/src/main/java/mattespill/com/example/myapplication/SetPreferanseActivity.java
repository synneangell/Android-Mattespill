package mattespill.com.example.myapplication;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.Locale;

public class SetPreferanseActivity extends PreferenceActivity {

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
        }

        public static class PrefsFragment extends PreferenceFragment {
            @Override
            public void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.xml.preferences);

            }
        }

}



package mattespill.com.example.myapplication;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PreferanseFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
}



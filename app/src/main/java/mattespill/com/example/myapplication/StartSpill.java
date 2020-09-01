package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

public class StartSpill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spill);
    }

    Resources res = getResources();
    int [] regnestykker1 = res.getIntArray(R.array.regnestykker1);
    int [] regnestykker2 = res.getIntArray(R.array.regnestykker2);
    int [] resultat;

    public int[] regnestykkeResultat (regnestykker1[], )

    for(int i = 0; i<regnestykker1.length; i++){
        for(int j = 0; j<regnestykker2.length; j++) {
            result[i] = regnestykker1[i] + regnestykker2[j];
            regnestykker1++;
            regnestykker2++;
            resultat++;
        }
    }



}
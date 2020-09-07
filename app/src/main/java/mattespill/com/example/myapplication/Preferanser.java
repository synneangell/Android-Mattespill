package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class Preferanser extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton oppg5;
    RadioButton oppg10;
    RadioButton oppg25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferanser);
    }

    //INNHOLD I PREFERANSER

    /**
     * Metode som gjør at brukeren kan velge mellom 5, 10 eller 25 oppgaver.
     */

    /**
     * Metode som gjør at brukeren kan velge mellom norsk og tysk språk
     */

    //Velger språk fra biltet og bytter på språket i hele appen med setLocale
/*    public void valgtSpråk(View v){
        if (v == findViewById(R.id.tyskFlagg)){
            setLocale(LocaleManager.TYSK);
        } else if(v == findViewById(R.id.norskFlagg)){
            setLocale(LocaleManager.NORSK);
        }
    }*/

    //Setter språket og restarter aktiviteten
    /*private void settSpråk(@LocaleManager.LocaleDef String språk){
        LocaleManager.setNewLocale(this, language);
        recreate();
    }*/
}
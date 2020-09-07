package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartSpill extends AppCompatActivity {

    List<String> oppgArray;
    List<String> oppgSvar;
    TextView brukerSvar;
    TextView textRegnestykket;
    TextView textAntallRiktig;
    TextView oppgaverIgjen;
    Random index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spill);

        oppgArray = Arrays.asList(getResources().getString(R.array.regnestykker));
        oppgSvar = Arrays.asList(getResources().getString(R.array.regnestykkerSvar));
        int antallRiktige = 0;
        textAntallRiktig.setText(String.valueOf(antallRiktige));

        index = new Random();

        randomGenerator();


/*        int i = 0;
        for(int i = 0; i<oppgSvar.size(); i++){
            Log.d(" "+oppgSvar[i]);
        }*/

        //INNHOLD I SPILLET

        /**
         * Må hente arrayet med regnestykkene og arrayet med svarene.
         * Må hente input fra brukeren som inneholder svaret på regnestykkene
         * Må sette antall poeng brukren har, starter på null når spiller starter
         * Må hente vindu hvor brukeren får tilbakemelding om svaret var riktig eller galt.
         * Må sette de forskjellige knappene til å inneholde faktiske tallverdier
         **/


        /*public void numbersOnClick(View v){

        }*/

        /**
         * Metode som går tilbake til forside og spør om man er sikker på om man vil
         * avslutte spillet og resultatet blir da ikke lagret i statistikken.
         */

        /**
         * Meode som randomiserer regnestykkene slik at de kommer i forskjellig
         * rekkefølge hver gang et nytt spill starter
         */

        /**
         * Metode som beregner hvilken oppgave man er på og hvor mange det er igjen og
         * viser det i en textView
         */

        /**
         * Metode som viser hvor mange riktive svar det er enn så lenge ift. hvor mange
         * spørsmål/regnestykker det er igjen. F.eks. 5 av 10 riktige. Så kun de riktige
         * svarene blir registrert i det textView-et
         */

        /**
         * Metode hvor feil input fra bruker kan bli fjernet og skrevet inn
         * på nytt. En clear-metode som sletter det som står i EditText (C)
         */

        /**
         * Må ha en metode som sjekker input fra bruker mot det faktiske svaret på
         * regnestykket i arrayet med korrekte svar og gi tilbakemelding på om svaret
         * var riktig eller ikke + ta brukeren til neste regnestykket. Svaret skal
         * sjekkes i det brukeren trykker på "Svar" knappen?
         */

        /**
         * Metode som sier at max tallet man kan skrive inn i EditText er 2 tall, ellers
         * får brukeren en alert
         */
    }

    public void randomGenerator(){
        int n  = (int)(Math.random() * (24 - 0) + 24); //får ut random tall fra 0 til 24 (index størrelsen)
        textRegnestykket.setText(oppgArray.get(n));

    }

    public void ikkeGjentagende(){

    }


    public void maxNummer(){
        int sjekkNr = brukerSvar.length();
        if(sjekkNr > 2){
            Log.d("ALERT", "Maks 2 tall");
        }
    }

/*    public void knappNummer(View v){
        switch (v.getId()){
            case R.id.btn1 :
                setNumber(1);
                maxNummer();
        }
    }*/


}
package mattespill.com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartSpill extends AppCompatActivity {

    List<String> oppgArray;
    List<String> svarArray;
    List<Integer> indekserBrukt = new ArrayList<>(25);
    TextView textBrukersvar;
    TextView textRegnestykket;
    TextView textAntallRiktig;
    TextView oppgaverIgjen;
    Integer antallRiktig;
    Integer antallStykker = 0;
    Integer teller = 3;
    Integer indeks = -1;
    Random random;
    String brukersvar;
    String textSvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spill);

        oppgArray = Arrays.asList(getResources().getStringArray(R.array.regnestykker));
        svarArray = Arrays.asList(getResources().getStringArray(R.array.regnestykkerSvar));

        textRegnestykket = (TextView)findViewById(R.id.textRegnestykket);
        textBrukersvar = (TextView)findViewById(R.id.textBrukerSvar);
        textAntallRiktig = (TextView)findViewById(R.id.textAntallRiktig);
        brukersvar = "";
        random = new Random();
        antallRiktig = 0;

        randomGenerator();


        //Lytter på knappene
        final Button btn1 = (Button)findViewById(R.id.btn1);
        final Button btn2 = (Button)findViewById(R.id.btn2);
        final Button btn3 = (Button)findViewById(R.id.btn3);
        final Button btn4 = (Button)findViewById(R.id.btn4);
        final Button btn5 = (Button)findViewById(R.id.btn5);
        final Button btn6 = (Button)findViewById(R.id.btn6);
        final Button btn7 = (Button)findViewById(R.id.btn7);
        final Button btn8 = (Button)findViewById(R.id.btn8);
        final Button btn9 = (Button)findViewById(R.id.btn9);
        final Button btn0 = (Button)findViewById(R.id.btn0);
        final Button btnOk = (Button)findViewById(R.id.btnOk);
        final Button btnC = (Button)findViewById(R.id.btnC);


        btnOk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ok();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                settNummer(0);
            }
        });

    }

    public void randomGenerator(){
        if(teller == antallStykker){ //Avslutter spillet dersom antall stykker er nådd
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.nyttSpill))
                        .setCancelable(false)
                        .setPositiveButton(getResources().getString(R.string.ja), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                StartSpill.this.finish();
                                Intent intent = new Intent(StartSpill.this, StartSpill.this.getClass());
                                StartSpill.this.startActivity(intent);
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.nei), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                StartSpill.this.finish();
                            }
                        })
                        .show();
            }
        else { //Spillet fortsetter, nytt regnestykke gis ut
            antallStykker += 1;
            int øvreGrense = 25;
            int forrigeIndeks = indeks;
            indeks = random.nextInt(øvreGrense); //får ut random tall fra 0 til 24 som er indeks i arrayet med regnestykker

            while (indeks == forrigeIndeks) {
                indeks = random.nextInt(øvreGrense);
            }

            Log.d("Verdien til n i random", String.valueOf(indeks));

            textRegnestykket.setText(oppgArray.get(indeks));
            Log.d("Stykke", oppgArray.get(indeks));
        }
    }

    public void resetSvar(View v){
        textBrukersvar.setText("");
    }

    //Metode som setter brukerens svar i applikasjonen
    public void settNummer(int nummer){
        String input = String.valueOf(nummer);
        brukersvar = brukersvar + input;
        textBrukersvar.setText(brukersvar);
        Log.d("Test", brukersvar);
    }

    //Metode som sjekker om svar er riktig/feil
    public void ok(){
        String svar = textBrukersvar.getText().toString();
        String riktigSvar = svarArray.get(indeks);
        Log.d("n i ok-metoden", String.valueOf(indeks));
        if(svar.equals(riktigSvar)){
            Toast.makeText(StartSpill.this, "Riktig!", Toast.LENGTH_SHORT).show();
            antallRiktig = antallRiktig +  1;
            textAntallRiktig.setText(antallRiktig.toString());
            brukersvar = "";
            textBrukersvar.setText(brukersvar);
            randomGenerator();
        }
        else{
            Toast.makeText(StartSpill.this, "Feil!", Toast.LENGTH_SHORT).show();
            brukersvar = "";
            textBrukersvar.setText(brukersvar);
            textAntallRiktig.setText(antallRiktig.toString());
            randomGenerator();
        }
    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);


    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }
*/
}

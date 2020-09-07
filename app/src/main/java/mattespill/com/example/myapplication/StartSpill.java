package mattespill.com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
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
    List<String> oppgSvar;
    List<Integer> indekserBrukt = new ArrayList<>(24);
    TextView textBrukerSvar;
    TextView textRegnestykket;
    TextView textAntallRiktig;
    Integer antallRiktig;
    TextView oppgaverIgjen;
    Random index;
    String brukerSvar;
    Integer n;
    String textSvar;
    Integer antallStykker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spill);

        oppgArray = Arrays.asList(getResources().getStringArray(R.array.regnestykker));
        oppgSvar = Arrays.asList(getResources().getStringArray(R.array.regnestykkerSvar));

        textRegnestykket = (TextView)findViewById(R.id.textRegnestykket);
        textBrukerSvar = (TextView)findViewById(R.id.textBrukerSvar);
        textAntallRiktig = (TextView)findViewById(R.id.textAntallRiktig);
        brukerSvar = "";
        index = new Random();
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
        int øvreGrense = 25;
        n  = index.nextInt(øvreGrense); //får ut random tall fra 0 til 24 (index størrelsen)

        int i =0;
        while(i < indekserBrukt.size()){
            if(n==indekserBrukt.get(i)){
                n  = index.nextInt(øvreGrense); //får ut random tall fra 0 til 24 (index størrelsen)

            }
        }
        indekserBrukt.add(n);
        Log.d("Verdien til n i random", String.valueOf(n));

        textRegnestykket.setText(oppgArray.get(n));
    }

    public void resetSvar(View v){
        textBrukerSvar.setText("");
    }

    public void ikkeGjentagende(){

    }

    public void settNummer(int nummer){
        String input = String.valueOf(nummer);
        brukerSvar = brukerSvar + input;
        textBrukerSvar.setText(brukerSvar);
        Log.d("BrukerInput", brukerSvar);
    }

    public void ok(){
        String svar = textBrukerSvar.getText().toString();
        String riktigSvar = oppgSvar.get(n);
        Log.d("Verdien til n i ok-metoden", String.valueOf(n));
        if(svar.equals(riktigSvar)){
            Toast.makeText(StartSpill.this, "Riktig!", Toast.LENGTH_SHORT).show();
            antallRiktig = antallRiktig +  1;
            textAntallRiktig.setText(antallRiktig.toString());
            brukerSvar = "";
            textBrukerSvar.setText("");
            randomGenerator();
        }
        else{
            Toast.makeText(StartSpill.this, "Feil!", Toast.LENGTH_SHORT).show();
            brukerSvar = "";
            textBrukerSvar.setText("");
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

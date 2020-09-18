package mattespill.com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class StartSpill extends AppCompatActivity {
    List<String> oppgArray;
    List<String> svarArray;
    List<String> fullførteRiktigeSvar = new ArrayList<>();
    List<String> fullførteFeilSvar = new ArrayList<>();
    TextView textBrukersvar;
    TextView textRegnestykket;
    TextView textOppgaverIgjen;
    Integer oppgaverUtført = 0;
    Integer antallRiktig = 0;
    Integer antallFeil = 0;
    Integer antallStykker;
    Integer teller = 0;
    Integer indeks = -1;
    Random random;
    String brukersvar = "";
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String valgtSprak = pref.getString("velgSprak_preference", "no");
        settLand(valgtSprak);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spill);

        //-------Setter variabler-----
        SharedPreferences pref2 = PreferenceManager.getDefaultSharedPreferences(this);
        String antall = pref2.getString("antallstykker_preference", "0");
        antallStykker = Integer.valueOf(antall);

        oppgArray = Arrays.asList(getResources().getStringArray(R.array.regnestykker));
        svarArray = Arrays.asList(getResources().getStringArray(R.array.regnestykkerSvar));
        textRegnestykket = (TextView) findViewById(R.id.textRegnestykket);
        textBrukersvar = (TextView) findViewById(R.id.textBrukerSvar);
        textOppgaverIgjen = (TextView) findViewById(R.id.textOppgaverIgjen);
        fullførteRiktigeSvar = new ArrayList<>();
        fullførteFeilSvar = new ArrayList<>();

        random = new Random();
        randomGenerator();

        //-------Henter ut og lytter på knappene-----
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);
        final Button btn8 = (Button) findViewById(R.id.btn8);
        final Button btn9 = (Button) findViewById(R.id.btn9);
        final Button btn0 = (Button) findViewById(R.id.btn0);


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(1);
                } else {
                    alert();
                }
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(2);
                } else {
                    alert();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(3);
                } else {
                    alert();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(4);
                } else {
                    alert();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(5);
                } else {
                    alert();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(6);
                } else {
                    alert();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(7);
                } else {
                    alert();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(8);
                } else {
                    alert();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(9);
                } else {
                    alert();
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBrukersvar.length() < 4) {
                    settNummer(0);
                } else {
                    alert();
                }
            }
        });
    }

    public void settLand(String landskode) {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration cf = res.getConfiguration();
        Locale locale = new Locale(landskode);
        cf.locale = locale;
        res.updateConfiguration(cf, dm);

    }

    //-------Metoder knyttet til spillogikk-----
    public void randomGenerator() {
        if (teller == antallStykker) { //Avslutter spillet dersom antall stykker er nådd

            sp = getSharedPreferences("Statistikk", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("antallRiktig", antallRiktig);
            editor.putInt("antallFeil", antallFeil);
            editor.commit();

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage(getResources().getString(R.string.nyttSpill))
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
            teller += 1;
            int øvreGrense = 25;
            int forrigeIndeks = indeks;
            indeks = random.nextInt(øvreGrense);

            while (indeks == forrigeIndeks) {
                indeks = random.nextInt(øvreGrense);
            }
            textRegnestykket.setText(oppgArray.get(indeks) + " = ");
        }
    }

    public void resetSvar(View v){
        brukersvar = "";
        textBrukersvar.setText(brukersvar);
    }

    public void alert(){
        Toast.makeText(StartSpill.this, getResources().getString(R.string.forMangeSiffer), Toast.LENGTH_SHORT).show();
    }

    //Metode som setter brukerens svar i applikasjonen
    public void settNummer(int nummer){
        String input = String.valueOf(nummer);
        brukersvar = brukersvar + input;
        textBrukersvar.setText(brukersvar);
    }

    //Metode som sjekker om svar er riktig/feil
    public void ok(View v){
        String svar = textBrukersvar.getText().toString();
        String riktigSvar = svarArray.get(indeks);
        Log.d("n i ok-metoden", String.valueOf(indeks));

        if(svar.equals(riktigSvar)){
            Toast.makeText(StartSpill.this, getResources().getString(R.string.riktig), Toast.LENGTH_SHORT).show();
            fullførteRiktigeSvar.add(oppgArray.get(indeks));
            antallRiktig = antallRiktig +  1;
            oppgaverUtført = oppgaverUtført + 1;
            brukersvar = "";
            textBrukersvar.setText(brukersvar);
            randomGenerator();
        }
        else{
            Toast.makeText(StartSpill.this, getResources().getString(R.string.feil), Toast.LENGTH_SHORT).show();
            brukersvar = "";
            fullførteFeilSvar.add(oppgArray.get(indeks));
            antallFeil = antallFeil + 1;
            oppgaverUtført = oppgaverUtført + 1;
            textBrukersvar.setText(brukersvar);
            randomGenerator();
        }
        textOppgaverIgjen.setText(oppgaverUtført.toString() + "/" + antallStykker);
    }



    //-------Metoder knyttet til tilstander-----
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(StartSpill.this);
        builder.setMessage(getResources().getString(R.string.slettFremgang));
        builder.setCancelable(true);
        builder.setNegativeButton(getResources().getString(R.string.nei), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ja), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                antallRiktig = 0;
                antallFeil = 0;
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("antallRiktig", antallRiktig);
        savedInstanceState.putInt("antallFeil", antallFeil);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        antallRiktig = savedInstanceState.getInt("antallRiktig");
        antallFeil = savedInstanceState.getInt("antallFeil");
    }
}



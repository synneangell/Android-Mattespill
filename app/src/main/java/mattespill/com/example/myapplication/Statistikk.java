package mattespill.com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Statistikk extends AppCompatActivity {
    TextView antallRiktig, antallFeil;
    Integer totaltAntallRiktige, totaltAntallFeil, antallRiktigeTotalt, antallFeilTotalt;
    SharedPreferences sp;
    private String riktig, feil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistikk);

        antallRiktig = findViewById(R.id.txtStat_vunnet_svar);
        antallFeil = findViewById(R.id.txtStat_tapt_svar);

        sp = getApplicationContext().getSharedPreferences("Statistikk", Context.MODE_PRIVATE);
        totaltAntallRiktige = sp.getInt("antallRiktig", 0);
        totaltAntallFeil = sp.getInt("antallFeil", 0);

        antallRiktigeTotalt = sp.getInt("totaltAntallRiktig", 0);
        antallFeilTotalt = sp.getInt("totaltAntallFeil", 0);

        totaltAntallRiktige += antallRiktigeTotalt;
        totaltAntallFeil += antallFeilTotalt;

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("totaltAntallRiktige", totaltAntallRiktige);
        editor.putInt("totaltAntallFeil", totaltAntallFeil);
        editor.apply();



        antallRiktig.setText(" "+ totaltAntallRiktige);
        antallFeil.setText(" "+ totaltAntallFeil);
    }
    public void slett(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.stat_slettBtn))
                .setPositiveButton(getResources().getString(R.string.ja), (dialogInterface, i) -> slettStatistikken())
                .setNegativeButton(getResources().getString(R.string.nei), null)
                .show();
    }
    public void slettStatistikken(){
        totaltAntallRiktige = 0;
        totaltAntallFeil = 0;
        antallRiktig.setText(""+ totaltAntallRiktige);
        antallFeil.setText(""+ totaltAntallFeil);
    }
    @Override
    protected void onSaveInstanceState (Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("totaltAntallRiktig", totaltAntallRiktige);
        saveInstanceState.putInt("totaltAntallFeil", totaltAntallFeil);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        totaltAntallRiktige = savedInstanceState.getInt("totaltAntallRiktig");
        totaltAntallFeil = savedInstanceState.getInt("totaltAntallFeil");
    }
}
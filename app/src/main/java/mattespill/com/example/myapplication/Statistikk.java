package mattespill.com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Statistikk extends AppCompatActivity {
    TextView antallRiktig, antallFeil;
    Integer totaltAntallRiktige, totaltAntallFeil, currentAntallRiktig, currentAntallFeil;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistikk);
        antallRiktig = findViewById(R.id.txtStat_vunnet_svar);
        antallFeil = findViewById(R.id.txtStat_tapt_svar);

        hentVerdier();
        utVerdier();
    }

    public void hentVerdier(){
        sp = getApplicationContext().getSharedPreferences("Statistikk", Context.MODE_PRIVATE);
        currentAntallRiktig = sp.getInt("antallRiktig", 0);
        currentAntallFeil = sp.getInt("antallFeil", 0);

        totaltAntallRiktige = sp.getInt("totaltAntallRiktige", 0);
        totaltAntallFeil = sp.getInt("totaltAntallFeil", 0);

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("totaltAntallRiktige", totaltAntallRiktige);
        editor.putInt("totaltAntallFeil", totaltAntallFeil);
        editor.apply();
    }

    public void utVerdier(){
        totaltAntallRiktige += currentAntallRiktig;
        totaltAntallFeil += currentAntallFeil;

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
        currentAntallRiktig = 0;
        currentAntallFeil = 0;

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("totaltAntallRiktige", totaltAntallRiktige);
        editor.putInt("totaltAntallFeil", totaltAntallFeil);
        editor.putInt("antallRiktig", currentAntallRiktig);
        editor.putInt("antallFeil", currentAntallFeil);

        editor.apply();

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
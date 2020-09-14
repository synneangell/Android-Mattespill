package mattespill.com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Statistikk extends AppCompatActivity {
    TextView txtStat_vunnet_svar, txtStat_tapt_svar;
    TextView antallVunnet, antallTapt;
    Integer vunnet, tapt;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistikk);

        antallVunnet = findViewById(R.id.txtStat_vunnet_svar);
        antallTapt = findViewById(R.id.txtStat_tapt_svar);

        sp = getApplicationContext().getSharedPreferences("Statistikk", Context.MODE_PRIVATE);
        vunnet = sp.getInt("antallVunnet", 0);
        tapt = sp.getInt("antallTapt", 0);
        antallVunnet.setText(" "+vunnet);
        antallTapt.setText(" "+tapt);
    }

    public void slett(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.stat_slettBtn))
                .setPositiveButton(getResources().getString(R.string.ja), (dialogInterface, i) -> slettStatistikken())
                .setNegativeButton(getResources().getString(R.string.nei), null)
                .show();
    }

    public void slettStatistikken(){
        antallVunnet.setText(""+0);
        antallTapt.setText(""+0);
        vunnet = 0;
        tapt = 0;
    }

    @Override
    protected void onSaveInstanceState (Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("antallVunnet", vunnet);
        saveInstanceState.putInt("antallTapt", tapt);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        vunnet = savedInstanceState.getInt("antallVunnet");
        tapt = savedInstanceState.getInt("antallTapt");
    }
}
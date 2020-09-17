package mattespill.com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    private DialogClickListener callback;

    public interface DialogClickListener{
        public void onYesClick();
        public void onNoClick();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
            callback = (DialogClickListener)getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException("Kallende klasse må implenetere interfacet");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.ok).setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                    callback.onYesClick();
                    }
                }
        )
                .setNegativeButton(R.string.ikkeok,
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        callback.onNoClick();
                    }
                }
        )
                .create(); }
    }



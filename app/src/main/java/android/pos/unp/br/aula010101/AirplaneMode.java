package android.pos.unp.br.aula010101;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneMode extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

            Toast.makeText(context, "Airplane Mode Mudou!", Toast.LENGTH_SHORT).show();
        }
    }
}

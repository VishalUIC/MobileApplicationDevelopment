package edu.vishal.cs478.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        Intent myIntent = new Intent(context.getApplicationContext(), MainActivity.class);
        Bundle bundle = new Bundle();
        myIntent.putExtras(bundle);
        myIntent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.getApplicationContext().startActivity(myIntent);

    }
}

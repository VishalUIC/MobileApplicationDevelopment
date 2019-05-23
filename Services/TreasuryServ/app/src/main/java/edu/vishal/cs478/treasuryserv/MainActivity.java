package edu.vishal.cs478.treasuryserv;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

import edu.vishal.cs478.project5Common.project5;


import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class MainActivity extends Activity {

    TextView tv;
    BroadcastReceiver listener = new BroadcastReceiver() {
        @Override
        public void onReceive( Context context, Intent intent ) {
            String data = intent.getStringExtra("status");
            tv.setText(data);
            Log.i("new status",data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv.setText("Service is not started");
        LocalBroadcastManager.getInstance(this).registerReceiver(listener,new IntentFilter("send_status"));




        /*Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                String stat = "unbound";
                while (true) {
                    if (stat != status) {
                        stat = status;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("Current status",status);
                                tv.setText(status);

                            }
                        });
                    }
                    else{
                        Log.i("Current status",status);
                    }
                }
            }
        });
        t.start();
*/
        //if(Status_Service.status.equals("unbound"))
        // tv.setText("Service is ");



            /*if (isInstanceCreated()) {
                tv.setText("Service is running");
            } else
                tv.setText("Service is not running");
            //sleep(5000);
*/

       /* if (isMyServiceRunning(MyTreasuryService.class)) {
                tv.setText("Service is running");

            } else
                tv.setText("Service is unbound");*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        BroadcastReceiver listener = new BroadcastReceiver() {
            @Override
            public void onReceive( Context context, Intent intent ) {
                String data = intent.getStringExtra("status");
                tv.setText(data);
                Log.i("new status",data);
            }
        };
    }

   /* private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }*/
}


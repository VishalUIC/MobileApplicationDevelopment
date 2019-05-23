package edu.vishal.cs478.gridviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by visha on 10/6/2017.
 */

public class ContextMenuViewCar extends AppCompatActivity {
    int cars[]={R.drawable.acura, R.drawable.audi, R.drawable.civic,
            R.drawable.porsche, R.drawable.mercedes, R.drawable.camry,
            R.drawable.lexus, R.drawable.chevrolet, R.drawable.jaguar};
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_view_car);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("position",0);

        //Getting the image position and setting the image view with corresponding image
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(cars[pos]);


    }
}
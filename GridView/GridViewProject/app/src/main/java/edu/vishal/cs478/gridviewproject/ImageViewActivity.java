package edu.vishal.cs478.gridviewproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.thumbPosition;

/**
 * Created by visha on 10/5/2017.
 */

public class ImageViewActivity extends Activity {

    private ArrayList<Uri> mUriList = new ArrayList<Uri>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Get the Intent to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, id));

        final int PosImgView = intent.getIntExtra("Position",0);

        setContentView(imageView);

        int imagePoistion=imageView.getId();
        GridView gridView = (GridView)findViewById(R.id.grid);
        //setting listener for image view
        imageView.setOnClickListener(new View.OnClickListener (){
            public void onClick(View V)
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(intent.CATEGORY_BROWSABLE);
                //Based on the item click it will open the browser
                switch (PosImgView)
                {
                    case 0:
                        intent.setData(Uri.parse("https://www.acura.com/"));
                        break;

                    case 1:
                        intent.setData(Uri.parse("https://www.audiusa.com/"));
                        break;

                    case 2:
                        intent.setData(Uri.parse("http://www.honda.com/"));
                        break;

                    case 3:
                        intent.setData(Uri.parse("https://www.porsche.com/"));
                        break;

                    case 4:
                        intent.setData(Uri.parse("https://www.mbusa.com/mercedes/index"));
                        break;

                    case 5:
                        intent.setData(Uri.parse("https://www.toyota.com/"));
                        break;

                    case 6:
                        intent.setData(Uri.parse("http://www.lexus.com/"));
                        break;

                    case 7:
                        intent.setData(Uri.parse("http://www.chevrolet.com/"));
                        break;

                    case 8:
                        intent.setData(Uri.parse("https://www.jaguarusa.com/index.html"));
                        break;
                }
                startActivity(intent);
            }

        });
    }
}

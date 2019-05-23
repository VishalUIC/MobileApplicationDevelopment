package edu.vishal.cs478.gridviewproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    protected static final String EXTRA_RES_ID = "POS";

    private static String web []  = {"acura", "audi", "civic", "porsche", "mercedes", "camry",
            "lexus", "chevrolet","jaguar"};

    private static int imageId []  = {R.drawable.acura, R.drawable.audi, R.drawable.civic,
            R.drawable.porsche, R.drawable.mercedes, R.drawable.camry,
            R.drawable.lexus, R.drawable.chevrolet, R.drawable.jaguar};
    int position1;
    public boolean onContextItemSelected(MenuItem item) {
        //This switch case is to perform appropriate function based on context menu click
        switch (item.getItemId())
        {
            case R.id.menu_option1:
                Intent intent1 = new Intent(MainActivity.this,ContextMenuViewCar.class); //creating intent to open ContextMenuViewCar activity

                intent1.putExtra(EXTRA_RES_ID,imageId[position1]);
                intent1.putExtra("position",position1);

                startActivity(intent1);
                break;

            case R.id.menu_option2:
                Intent intent2 = new Intent(MainActivity.this,ContextMenuWebPage.class); //creating intent to open ContextMenuWebPage activity
                intent2.putExtra("position",position1);
                startActivity(intent2);
                break;

            case R.id.menu_option3:
                Intent intent3 = new Intent(MainActivity.this,ContextMenuCarDealer.class); //creating intent to open ContextMenuCarDealer activity
                intent3.putExtra("position",position1);
                startActivity(intent3);
                break;
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu); //Inflating the menu
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageAdapter adapter = new ImageAdapter(MainActivity.this, web, imageId);

        grid = (GridView) findViewById(R.id.grid);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);   //creating intent to open ImageViewActivity activity

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, imageId[position]);
                intent.putExtra("Position",position);
                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
         //setting listener for grid view
        grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                position1 = position;
                registerForContextMenu(grid);
                return false;
            }
        });
    }
}

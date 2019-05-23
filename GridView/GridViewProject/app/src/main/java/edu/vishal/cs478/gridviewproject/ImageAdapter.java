package edu.vishal.cs478.gridviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by visha on 10/5/2017.
 */

public class ImageAdapter extends BaseAdapter {

    private static final int PADDING = 8;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private Context mContext;
    private final String [] web;
    private final int [] Imageid;


    // Save the list of image IDs and the context
    public ImageAdapter(Context c, String [] web, int [] Imageid) {
        this.mContext=c;
        this.web=web;
        this.Imageid = Imageid;
    }

    // Now the methods inherited from abstract superclass BaseAdapter

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return web.length;
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return null;
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            grid = new View(mContext); //inflating the grid view
            grid = inflater.inflate(R.layout.activity_image_view, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(web[position]);  //According to url, we are setting corresponding car name
            imageView.setImageResource(Imageid[position]); //According to url, we are setting corresponding car image
        }
        else
        {
            grid = (View) convertView;
        }
        return grid;
    }
}

package edu.vishal.cs478.gallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import static android.support.v7.widget.TintTypedArray.obtainStyledAttributes;



public class Adapclass extends BaseAdapter{
    private Context context;
    private int itemBackground;
    private Integer[] Imgid;
    public Adapclass(Context c, Integer[] Imgid)
    {
        context = c;
        this.Imgid=Imgid;
        TypedArray a =c.obtainStyledAttributes(R.styleable.MyGallery);
        itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
        a.recycle();
    }
    public int getCount() {
        return Imgid.length;
    }
    // returns the ID of an item
    public Object getItem(int position) {
        return position;
    }
    // returns the ID of an item
    public long getItemId(int position) {
        return position;
    }
    // returns an ImageView view
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(Imgid[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
        imageView.setBackgroundResource(itemBackground);
        return imageView;
    }

}

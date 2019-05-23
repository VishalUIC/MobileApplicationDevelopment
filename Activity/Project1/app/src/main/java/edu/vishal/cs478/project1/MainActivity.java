package edu.vishal.cs478.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/** This is the main class which extends the AppCompatActivity class **/
public class MainActivity extends AppCompatActivity
{

    @Override
    /** This is the onCreate method. This were we initialize our activity**/
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button_id);
        button.setText("Click to open next Activity");
        /** Java interface View.OnClickListener is used to open the second activity **/
        button.setOnClickListener(new View.OnClickListener()
        {
            /** This is the button onClick() method which responds to click of the first button  **/
            public void onClick(View v)
            {
                sendMessage(v);      /** The sendMessage() method is called to open the next activity **/

            }
        }
        );

    }
    /** Below method is to open the next activity. Here the intent is passed to start the next activity**/
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
}

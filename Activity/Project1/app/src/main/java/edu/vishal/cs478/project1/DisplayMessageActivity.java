package edu.vishal.cs478.project1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/** This is the main class which extends the AppCompatActivity class **/
public class DisplayMessageActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        /** This is the onCreate method. This were we initialize our activity**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        /** Below code is to get Intent from the parent activity **/
        Intent intent = getIntent();
        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContacts(v);
            }
        });
    }
    /** Below method is to open the contacts app**/
    public void openContacts(View view)
    {
        String errorMessage;
        errorMessage = "Please enter both First Name and Last Name";
        TextView tv = (TextView)findViewById(R.id.textView); /** TextView is invoked to display error/success messages **/
        int SAVE_CONTACT_REQUEST = 1;
        Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
        contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        EditText editText = (EditText) findViewById(R.id.editText3);
        String name = editText.getText().toString();
        String [] splitter = null;
        splitter = name.trim().split("\\s++");
        /** Below condition is to validate if the input from the users**/
        if(splitter.length!=2)
        {
            /** If the validation fails, a error message is displayed **/
            tv.setTextColor(Color.RED);
            tv.setText(errorMessage);
            return;

        }
        else
        {
            /** If the validation is success. then the inbuild contacts app is opened where user can save/edit contact **/
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,editText.getText().toString());
            contactIntent.putExtra("finishActivityOnSaveCompleted", true);
            startActivityForResult(contactIntent, SAVE_CONTACT_REQUEST);
        }
    }
    /**Below method is inform the user about the status of the contact being saved **/
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String conSucess = "The contact has been saved successfully";
        String conFailure = "The contact has not been saved";
        EditText editText = (EditText) findViewById(R.id.editText3);
        TextView tv = (TextView)findViewById(R.id.textView); /** TextView is invoked to display error/success messages **/
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //Toast.makeText(this, "Contact has been saved successful", Toast.LENGTH_LONG).show();
                tv.setText(conSucess);
                tv.setTextColor(Color.GREEN);
                editText.setText("");
            } else if (resultCode == RESULT_CANCELED) {
                //Toast.makeText(this, "Contact has not been saved", Toast.LENGTH_LONG).show();
                tv.setText(conFailure);
                tv.setTextColor(Color.RED);
                editText.setText("");
            }
        }
    }
}

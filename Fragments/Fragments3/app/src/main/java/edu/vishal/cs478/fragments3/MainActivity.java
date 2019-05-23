package edu.vishal.cs478.fragments3;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

//Several Activity lifecycle methods are instrumented to emit LogCat output
//so you can follow this class' lifecycle
public class MainActivity extends AppCompatActivity implements TitlesFragment.ListSelectionListener {

    public static String[] mTitleArray;
    public static String[] mWebsiteArray;


    private final WebViewFragment mWebViewFragment = new WebViewFragment();
    private  static TitlesFragment mTitlesFragment;
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mWebViewFrameLayout;

    private static WebViewFragment mQF;

    private static final String TAG_RETAINED_FRAGMENT = "TitlesRetainedFragment";
    private static final String TAG_RETAINED_FRAGMENT2 = "WebsiteRetainedFragment";
    private int mCurrIdx ;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String TAG = "MainActivity";

    private static final String TOAST_INTENT = "edu.vishal.cs478.gallery";
    private static final String VISHALS_PERMISSION = "edu.vishal.cs478.vishalsPermission";

    private int mPosition;
    private final String SELECTED_ITEM_POSITION = "someValueToSave";

    final private int REQUEST_CODE_ASK_PERMISSIONSA1 = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");

        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and qutoes
        mTitleArray = getResources().getStringArray(R.array.Titles);
        mWebsiteArray = getResources().getStringArray(R.array.WebLinks);

        setContentView(R.layout.activity_main);

        // Get references to the TitleFragment and to the QuotesFragment
        mTitleFrameLayout = (FrameLayout) findViewById(R.id.title_fragment_container);
        mWebViewFrameLayout = (FrameLayout) findViewById(R.id.webView_fragment_container);

        // Get a reference to the FragmentManager
        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Add the TitleFragment to the layout
        // UB: 10/2/2016 Changed add() to replace() to avoid overlapping fragments
        fragmentTransaction.replace(R.id.title_fragment_container,
                new TitlesFragment());

        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {

                        setLayout();
                    }
                });

    }

    private void setLayout() {

        // Determine whether the QuoteFragment has been added
        if (!mWebViewFragment.isAdded()) {

            // Make the TitleFragment occupy the entire layout
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT));
            mWebViewFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
        } else {
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                // Make the TitleLayout take 1/3 of the layout's width
                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));

                // Make the QuoteLayout take 2/3's of the layout's width
                mWebViewFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 2f));
            }
            else
            {
                // Make the TitleLayout take 1/3 of the layout's width
                mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 0f));

                // Make the QuoteLayout take 2/3's of the layout's width
                mWebViewFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 3f));
            }
        }
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {

        // If the QuoteFragment has not been added, add it now
        if (!mWebViewFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the QuoteFragment to the layout
            fragmentTransaction.add(R.id.webView_fragment_container,
                    mWebViewFragment);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (mWebViewFragment.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            mWebViewFragment.showQuoteAtIndex(index);

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.title_menu, menu);
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                /*Toast.makeText(getApplicationContext(), "you've been helped",
                        Toast.LENGTH_LONG).show();*/
                return true;

            case R.id.new_app:
                if (ContextCompat.checkSelfPermission(MainActivity.this, "edu.vishal.cs478.vishalsPermission")
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"edu.vishal.cs478.vishalsPermission"},
                            REQUEST_CODE_ASK_PERMISSIONSA1);
                    return true;
                }
                else {
                    Intent intent = new Intent();
                    intent.setAction(TOAST_INTENT);
                    intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    sendOrderedBroadcast(intent,VISHALS_PERMISSION);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONSA1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.length > 0) {
                    // Permission Granted
                    Intent intent = new Intent();
                    intent.setAction(TOAST_INTENT);
                    intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    sendOrderedBroadcast(intent,VISHALS_PERMISSION);
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "Gallery application denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}

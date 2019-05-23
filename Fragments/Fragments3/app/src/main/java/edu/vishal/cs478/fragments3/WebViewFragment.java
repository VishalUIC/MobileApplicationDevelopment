package edu.vishal.cs478.fragments3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

//Several Activity and Fragment lifecycle methods are instrumented to emit LogCat output
//so you can follow the class' lifecycle
public class WebViewFragment extends Fragment {

    private static final String TAG = "WebViewFragment";

    private WebView mQuoteView = null;
    private int mCurrIdx = -1;
    private int mQuoteArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }

    // Show the Quote string at position newIndex
    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrLen)
            return;
        mCurrIdx = newIndex;
//		mQuoteView.setText(QuoteViewerActivity.mWebsiteArray[mCurrIdx]);
        mQuoteView = (WebView) getActivity().findViewById(R.id.webView);
        WebSettings webSettings = mQuoteView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mQuoteView.loadUrl(MainActivity.mWebsiteArray[mCurrIdx]);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout defined in quote_fragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.webview_fragment,
                container, false);
    }

    // Set up some information about the mQuoteView TextView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mQuoteView = (WebView) getActivity().findViewById(R.id.webView);
        mQuoteArrLen = MainActivity.mWebsiteArray.length;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
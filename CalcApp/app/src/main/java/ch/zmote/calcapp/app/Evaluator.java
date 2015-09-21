package ch.zmote.calcapp.app;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class Evaluator {

    interface Callback<T> {
        void apply(T t);
    }

    private Activity activity;
    private Callback<String> callback;
    private WebView webView;

    public Evaluator(Activity activity, Callback<String> callback) {
        this.activity = activity;
        this.callback = callback;

        webView = new WebView(activity);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(this, "Evaluator");
    }

    public void evaluate(String calculation) {
        String js = "javascript: var result = (" + calculation + "); Evaluator.returnResult(result)";
        webView.loadUrl(js);
    }

    @JavascriptInterface
    public void returnResult(final String s) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callback.apply(s);
            }
        });
    }
}

package mad.game105sports.onesignal;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class EventPromotion extends AppCompatActivity {
    private String promotionURL;
    private WebView inAppPromotion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_promotion);

        Intent inAppIntent = getIntent();
        promotionURL = inAppIntent.getStringExtra("promotionalURL");

        if((TextUtils.isEmpty(promotionURL)|| promotionURL == null)) {
            finish();
        }
        inAppPromotion = findViewById(R.id.inAppPromotion);


        inAppPromotion.getSettings().setJavaScriptEnabled(true);
        inAppPromotion.getSettings().setDomStorageEnabled(true);
        inAppPromotion.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        inAppPromotion.getSettings().setSupportMultipleWindows(true);
        inAppPromotion.getSettings().setLoadsImagesAutomatically(true);
        inAppPromotion.getSettings().setSafeBrowsingEnabled(true);

        inAppPromotion.setWebViewClient(new WebViewClient());
        inAppPromotion.setWebChromeClient(new WebChromeClient());

        inAppPromotion.loadUrl(promotionURL);

    }
}
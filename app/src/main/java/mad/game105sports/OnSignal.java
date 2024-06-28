package mad.game105sports;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;

import java.util.Arrays;

import mad.game105sports.onesignal.EventPromotion;
import mad.game105sports.onesignal.R;

public class OnSignal extends AppCompatActivity {

    private static final String ONESIGNAL_APP_ID = "e745daa6-a0cc-4a04-8369-a87c6c684619";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_signal);
        OneSignalInitialization();
    }

    private void OneSignalInitialization() {
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);
        OneSignal.initWithContext(this, ONESIGNAL_APP_ID);

        OneSignal.getInAppMessages().addClickListener(new IInaAppMessageClickListener() {
        @Override
            public void onClick(@NonNull IInAppMessageClickEvent iInAppMessageClickEvent) {
                Log.w("onesignal", iInAppMessageClickEvent.getResult().getActionId());

                String[] inAppEvent = iInAppMessageClickEvent.getResult().getActionId().split("\\|");

                Intent openAppPromotion = new Intent(OnSignal.this, EventPromotion.class);
                 openAppPromotion.putExtra("promotionalURL", inAppEvent[1]);
                 startActivity(openAppPromotion);

            }
        });
    }
}
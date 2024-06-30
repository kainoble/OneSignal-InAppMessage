
 
 
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

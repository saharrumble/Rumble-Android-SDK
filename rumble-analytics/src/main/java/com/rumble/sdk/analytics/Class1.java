package com.rumble.sdk.analytics;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.rumble.sdk.core.LogMessage;
import com.rumble.sdk.core.RumbleEventBus;

/**
 * Created by saharkroglen on 6/1/15.
 */
public class Class1 {

    public Class1()
    {
        RumbleEventBus.getRumbleInstance().register(this);

        Spannable message = new SpannableString(String.format("Analytics-SDK plugged-in successfully"));
        message.setSpan(new ForegroundColorSpan(Color.BLUE), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        RumbleEventBus.getRumbleInstance().post(new LogMessage("eventBus", message));

    }

//    public void post() {
//        RumbleEventBus.getRumbleInstance().post("event from class 2");
//    }

    public void onEvent(String event) {
        Spannable message = new SpannableString(String.format("Analytics-SDK got message:,'%s' ", event));
        message.setSpan(new ForegroundColorSpan(Color.GREEN), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        RumbleEventBus.getRumbleInstance().post(new LogMessage("eventBus",message ));
    }
}

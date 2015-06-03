package com.rumble.sdk.core;

import android.text.Spannable;

public class LogMessage {
    String mTag;
    Spannable mText;
    public Spannable getText() {
        return mText;
    }

    public void setText(Spannable mText) {
        this.mText = mText;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

    public LogMessage(String tag, Spannable text)
    {
        mTag = tag;
        mText = text;
    }

}

package com.example.lmsmobileapp.View.Widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.lmsmobileapp.Controller.Utils.FontConstants;

public class LMSOpenSansRegularTextView extends AppCompatTextView {
    public LMSOpenSansRegularTextView(Context context) {
        super(context);
        init(null);
    }

    public LMSOpenSansRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LMSOpenSansRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        // Just Change your font name
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), FontConstants.OPENSANS_REGULAR);
        setTypeface(myTypeface);
    }

}

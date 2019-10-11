package com.example.lmsmobileapp.View.Widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.lmsmobileapp.Controller.Utils.FontConstants;

public class LMSOpenSansRegularEdittext extends AppCompatEditText {

    public LMSOpenSansRegularEdittext(Context context) {
        super(context);
        init(null);
    }

    public LMSOpenSansRegularEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LMSOpenSansRegularEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        // Just Change your font name
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), FontConstants.OPENSANS_REGULAR);
        setTypeface(myTypeface);
    }
}

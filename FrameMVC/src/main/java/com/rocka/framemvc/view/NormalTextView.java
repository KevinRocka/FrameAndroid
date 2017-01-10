package com.rocka.framemvc.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Rocka on 2016/12/12.
 */

public class NormalTextView extends TextView {

    public NormalTextView(Context context) {
        super(context);
        init();
    }

    public NormalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NormalTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.setBackgroundColor(Color.RED);
        //..other
    }
}

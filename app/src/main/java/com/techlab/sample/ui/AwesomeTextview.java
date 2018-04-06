package com.techlab.sample.ui;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import com.techlab.awesomefont.BootstrapText;
import com.techlab.awesomefont.BootstrapTextView;
import com.techlab.awesomefont.IconResolver;
import com.techlab.awesomefont.TypefaceProvider;
import com.techlab.sample.R;


public class AwesomeTextview extends AppCompatTextView implements BootstrapTextView {

    private BootstrapText bootstrapText;

    public AwesomeTextview(Context context) {
        super(context);
    }

    public AwesomeTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AwesomeTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypefaceProvider.registerDefaultIconSets();
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AwesomeTextview);
        String markdownText;

        try {
            markdownText = typedArray.getString(R.styleable.AwesomeTextview_awesome_text);
        } finally {
            typedArray.recycle();
        }
        if (markdownText != null) {
            setMarkdownText(markdownText);
        }
        updateBootstrapState();
    }

    @Override
    public void setBootstrapText(@Nullable BootstrapText bootstrapText) {
        this.bootstrapText = bootstrapText;
        updateBootstrapState();
    }

    @Nullable
    @Override
    public BootstrapText getBootstrapText() {
        return bootstrapText;
    }

    @Override
    public void setMarkdownText(@Nullable String text) {
        String textSpace = text + " ";
        setBootstrapText(IconResolver.resolveMarkdown(getContext(), textSpace, isInEditMode()));
    }

    protected void updateBootstrapState() {
        if (bootstrapText != null) {
            bootstrapText.setSpan(new RelativeSizeSpan(1.2f),0,2,0);
            setText(bootstrapText);
        }
    }
}

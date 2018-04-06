package com.techlab.sample.ui;

/**
 * Created by DEVUSER97 on 11/7/2017.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.techlab.sample.R;

public class Wavelayout extends RelativeLayout {
    private int waveheight;
    private Paint paint;
    private Xfermode pdMode;
    private Path path;

    public Wavelayout(Context context) {
        super(context);
    }

    public Wavelayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Wavelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Wavelayout, defStyleAttr, 0);
        waveheight = a.getDimensionPixelSize(R.styleable.Wavelayout_waveheight, 20);
        a.recycle();
        init();

    }
   /* @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Wavelayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Wavelayout, defStyleAttr, 0);
        waveheight = a.getDimensionPixelSize(R.styleable.Wavelayout_waveheight, 20);
        a.recycle();
        init();
    }*/

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pdMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        path = new Path();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.dispatchDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        paint.setXfermode(pdMode);

        path.moveTo(0, height - waveheight );
        path.quadTo(width/4,height- 2*waveheight, width/2, height -waveheight);
        path.quadTo(width/4 * 3, height, width, height-waveheight);
        path.lineTo(width,height);
        path.lineTo(0,height);

        canvas.drawPath(path, paint);
        canvas.restoreToCount(saveCount);
    }

   /* @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        int width = getWidth();
        int height = getHeight();
        paint.setXfermode(pdMode);

        path.moveTo(0, height - waveheight );
        path.quadTo(width/4,height- 2*waveheight, width/2, height -waveheight);
        path.quadTo(width/4 * 3, height, width, height-waveheight);
        path.lineTo(width,height);
        path.lineTo(0,height);

        canvas.drawPath(path, paint);
        canvas.restoreToCount(saveCount);
    }
*/


}

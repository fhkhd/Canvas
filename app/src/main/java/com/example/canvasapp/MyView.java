package com.example.canvasapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

public class MyView extends View
{

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mRect = new Rect();
    private Rect mBounds = new Rect();
    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;
    private int mColorBackground;
    private int mColorRectangle;
    private int mColorAccent;
    Drawable mCustomImage , image;





    Paint paint = null;
    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
        mCustomImage = context.getResources().getDrawable(R.drawable.shaparak);
        image = context.getResources().getDrawable(R.drawable.irankish);

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 200;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        paint.setStrokeWidth(5);

//        canvas.translate(getWidth()/2f,getHeight()/2f);
//        canvas.drawCircle(0,0, radius, paint);
//        canvas.drawCircle(x/2f, (2*y) /3 , radius, paint);

        canvas.drawLine(50,y/3f, x-50 , y/3f,paint);

        canvas.drawLine(50,(y*2)/3f, x-50 , (y*2)/3f,paint);

        canvas.drawLine(50,(y*11)/18f, x-50 , (y*11)/18f,paint);


//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.shaparak);
//        paint.setColor(Color.RED);
//
//        canvas.drawBitmap(bitmap, getLeft()/2, getTop()/2, paint);


        // for image
        Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
        imageBounds.set((3*x)/4 ,y/6,x-50 , (y/3)-50);
        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        // for image
//        Rect imageBounds2 = canvas.getClipBounds();  // Adjust this for where you want it
        imageBounds.set(50 ,y/6,x/4 , (y/3)-50);
        image.setBounds(imageBounds);
        image.draw(canvas);


        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(100);
        canvas.drawText("عنوان",x/2, y/4 ,paint);



//        mColorBackground = ResourcesCompat.getColor(getResources(),
//                R.color.purple_200, null);
//        mColorRectangle = ResourcesCompat.getColor(getResources(),
//                R.color.purple_500, null);
//        mColorAccent = ResourcesCompat.getColor(getResources(),
//                R.color.purple_700, null);
//
//
//        mPaint.setColor(mColorBackground);
//        mPaintText.setTextSize(70);
//        mImageView = (ImageView) findViewById(R.id.irankish);



    }

//    public void drawSomething(View view) {
//
//        int vWidth = view.getWidth();
//        int vHeight = view.getHeight();
//        int halfWidth = vWidth / 2;
//        int halfHeight = vHeight / 2;
//
//        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
//        mImageView.setImageBitmap(mBitmap);
//
//        mCanvas = new Canvas(mBitmap);
//        mCanvas.drawColor(mColorBackground);
//        mCanvas.drawText("programchi.ir", 100, 100, mPaintText);
//        mOffset += OFFSET;
//
//        view.invalidate();
//
//    }
}

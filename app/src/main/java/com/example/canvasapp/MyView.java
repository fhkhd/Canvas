package com.example.canvasapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Arrays;

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
    private Typeface typeface;




    Paint paint = null;
    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
        mCustomImage = context.getResources().getDrawable(R.drawable.ic_shaparak);
        image = context.getResources().getDrawable(R.drawable.ic_irankish);
        Typeface typeface = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);


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
        paint.setColor(Color.parseColor("#252525"));
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
        imageBounds.set((3*x)/4 ,y/5,x-50 , (y/3)-(y/18));
        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        // for image
//        Rect imageBounds2 = canvas.getClipBounds();  // Adjust this for where you want it
        imageBounds.set(50 ,y/5,x/4 , (y/3)-(y/18));
        image.setBounds(imageBounds);
        image.draw(canvas);


        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(80);
        canvas.drawText("عنوان",x/2, y/4 ,paint);

        paint.setTextSize(80);
        canvas.drawText("77110" , x/2 ,(7*y)/24 , paint);


        setText(Color.BLACK,25, Paint.Align.CENTER, typeface,"کارت اعتباری ایران کیش" ,x/2 , (y*3)/18 , paint, canvas);
        setText(Color.BLACK,25, Paint.Align.CENTER, typeface,"1688" ,x/2 , (y* 5.5f)/18, paint, canvas);

        setText(Color.BLACK,25, Paint.Align.RIGHT, typeface,"تست شاپرک" ,x-20 , (y*5.5f)/18, paint, canvas);
        setText(Color.BLACK,25, Paint.Align.LEFT, typeface,"Tel : 0251556787" ,20 , (y*5.5f)/18, paint, canvas);


        setText(Color.BLACK,28, Paint.Align.RIGHT, typeface,"خرید" ,x-20 , (y*6.5f)/18, paint, canvas);
        setText(Color.BLACK,28, Paint.Align.LEFT, typeface,"رسید مشتری" ,20 , (y*6.5f)/18, paint, canvas);
        setText(Color.BLACK,28, Paint.Align.RIGHT, typeface,"پایانه" ,x-20 , (y*7.5f)/18, paint, canvas);
        setText(Color.BLACK,28, Paint.Align.RIGHT, typeface,"بانک مسکن" ,x-20 , (y*8.5f)/18, paint, canvas);
        setText(Color.BLACK,28, Paint.Align.RIGHT, typeface,"1401/1/29" ,x-20 , (y*9.5f)/18, paint, canvas);
        setText(Color.BLACK,28, Paint.Align.RIGHT, typeface,"پیگیری" ,x-20 , (y*10.5f)/18, paint, canvas);

        setText(Color.BLACK,25, Paint.Align.LEFT, typeface,"98088" ,20 , (y*7.5f)/18, paint, canvas);
        setText(Color.BLACK,25, Paint.Align.LEFT, typeface,"0574446876" ,20 , (y*8.5f)/18, paint, canvas);
        setText(Color.BLACK,25, Paint.Align.LEFT, typeface,"16:54" ,20 , (y*9.5f)/18, paint, canvas);
        setText(Color.BLACK,25, Paint.Align.LEFT, typeface,"109" ,20 , (y*10.5f)/18, paint, canvas);

        setText(Color.BLACK,25, Paint.Align.CENTER, typeface,"تراکنش نامعتبر است (91)" ,x/2 , (y*11.6f)/18, paint, canvas);





        int max_word = 50;
        int max_sum = 5;

        String string = "در صورت کسر وجه از حساب شما مبلغ مذکور ظرف 72 ساعت به حساب شما عودت خواهد شد در غیر اینصورت جهت پیگیری لطفا با شماره تلفن 1688 تماس حاصل کنید";

//        String string = "اگر می خواهید نمای سفارشی خود را در اندروید از صفر ایجاد کنید، دانستن اینکه چه توابعی برای رسم در موجود است بسیار مفید است.";

        String[] kalameh = string.split(" ");

        ArrayList<String> s = new ArrayList<>(Arrays.asList(kalameh));
        ArrayList<String> line = new ArrayList<>();


//        ArrayList<String> k = new ArrayList<>();

        String[] k = new String[kalameh.length/10];
        for (int i = 0; i < k.length; i++) {
            for (int j = i*10 ; j < 10*(i+1); j++) {
                k[i] += kalameh[j] +" ";
                if(i == (k.length-1) && j == ((10*(i+1))-1)){
                    for (int z = j+1 ; z < kalameh.length; z++) {
                        k[i] += kalameh[z];
                    }
                }
            }
        }





//        for (int i = 0; i < kalameh.length; i++) {
//            if (i < 7){
//                Log.e("qqqqssssp", "onDraw: "+i+" - "+kalameh[i] );
//                k[0] = k[0] +" "+ kalameh[i];
//            }else if (i < 14){
//                k[1] = k[1] +" "+ kalameh[i];
//            }else {
//                k[2] = k[2] +" "+ kalameh[i];
//            }
//        }

//        for (int i = 0; i < s.size(); i++) {
//            if (line.isEmpty()){
//                line.add(s.get(i));
//            }else {
//                String[] k = line.get(i).split(" ");
//                if (line.get(i).length() < max_word && k.length < max_sum){
//                    String l = line.get(i) + s.get(i);
//                    line.set(i, l);
//                }else {
//                    line.add(s.get(i));
//                }
//            }
//        }

        for (int i = 0; i < k.length; i++) {
            Log.e("qqqqsss", "onDraw: "+ k[i] );
            setText(Color.BLACK,28, Paint.Align.RIGHT, typeface, k[i] ,x-20 , (y*1.5f)/18, paint, canvas);


        }


//        String[] stringArray = null;
////        String[] strArr = null;
//
//        for (int i = 1; i < 3; i++) {
//            stringArray = string.split(String.valueOf(string.charAt(i*47)) );
//
//        }
//        for (int i = 0; i < stringArray.length ; i++) {
//            Log.e("arrr", "onDraw: " + i +"  :"+ stringArray[i] );
//        }



//        //Get post text
//
//        //Get weight of space character in px
//        float spaceWeight = paint.measureText(" ");
//
//        //Start main algorithm of drawing words on canvas
//        //Split text to words
//        for (String line : string.split(" ")) {
//            //If we had empty space just continue
//            if (line.equals("")) continue;
//            //Get weight of the line
//            float lineWeight = paint.measureText(line);
//            //If our word(line) doesn't have any '\n' we do next
//            if (line.indexOf('\n') == -1) {
//                //If word can fit into current line
//                if (canvas.getWidth() - pxx - defaultMargin >= lineWeight) {
//                    //Draw text
//                    canvas.drawText(line, pxx, pxy, paint);
//                    //Move start x point to word weight + space weight
//                    pxx += lineWeight + spaceWeight;
//                } else {
//                    //If word can't fit into current line
//                    //Move x point to start
//                    //Move y point to the next line
//                    pxx = defaultMargin;
//                    pxy += paint.descent() - paint.ascent();
//                    //Draw
//                    canvas.drawText(line, pxx, pxy, paint);
//                    //Move x point to word weight + space weight
//                    pxx += lineWeight + spaceWeight;
//                }
//                //If line contains '\n'
//            } else {
//                //If '\n' is on the start of the line
//                if (line.indexOf('\n') == 0) {
//                    pxx = defaultMargin;
//                    pxy += paint.descent() - paint.ascent();
//                    cnv.drawText(line.replaceAll("\n", ""), pxx, pxy, paint);
//                    pxx += lineWeight + spaceWeight;
//                } else {
//                    //If '\n' is somewhere in the middle
//                    //and it also can contain few '\n'
//                    //Split line to sublines
//                    String[] subline = line.split("\n");
//                    for (int i = 0; i < subline.length; i++) {
//                        //Get weight of new word
//                        lineWeight = paint.measureText(subline[i]);
//                        //If it's empty subline that's mean that we have '\n'
//                        if (subline[i].equals("")) {
//                            pxx = defaultMargin;
//                            pxy += paint.descent() - paint.ascent();
//                            canvas.drawText(subline[i], pxx, pxy, paint);
//                            continue;
//                        }
//                        //If we have only one word
//                        if (subline.length == 1 && i == 0) {
//                            if (canvas.getWidth() - pxx >= lineWeight) {
//                                canvas.drawText(subline[0], pxx, pxy, paint);
//                                pxx = defaultMargin;
//                                pxy += paint.descent() - paint.ascent();
//                            } else {
//                                pxx = defaultMargin;
//                                pxy += paint.descent() - paint.ascent();
//                                canvas.drawText(subline[0], pxx, pxy, paint);
//                                pxx = defaultMargin;
//                                pxy += paint.descent() - paint.ascent();
//                            }
//                            continue;
//                        }
//                        //If we have set of words separated with '\n'
//                        //it is the first word
//                        //Make sure we can put it into current line
//                        if (i == 0) {
//                            if (canvas.getWidth() - pxx >= lineWeight) {
//                                cnv.drawText(subline[0], pxx, pxy, paint);
//                                pxx = defaultMargin;
//                            } else {
//                                pxx = defaultMargin;
//                                pxy += paint.descent() - paint.ascent();
//                                canvas.drawText(subline[0], pxx, pxy, paint);
//                                pxx = defaultMargin;
//                            }
//                        } else {
//                            pxx = defaultMargin;
//                            pxy += paint.descent() - paint.ascent();
//                            cnv.drawText(subline[i], pxx, pxy, paint);
//                            pxx += lineWeight + spaceWeight;
//                        }
//                    }
//
//                }
//            }
//        }

//
//            for (int i = 1; i < stringArray.length ; i++) {
//            setText(Color.BLACK ,50 , Paint.Align.CENTER,stringArray[i] ,x/2 ,((12.5f+i)*y)/18 ,paint ,canvas );
//        }

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

    public void setText(int color, int size, Paint.Align align, Typeface typeface, String text, int x, float y, Paint paint , Canvas canvas ){
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setTextAlign(align);
        paint.setTypeface(typeface);
        canvas.drawText(text, x, y, paint);}
}

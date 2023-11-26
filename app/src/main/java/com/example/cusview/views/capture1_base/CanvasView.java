package com.example.cusview.views.capture1_base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

import androidx.annotation.Nullable;

/**
 * @autor sts
 * @date 2023/11/26 13:57
 * @description 画布的变换和裁剪等
 */
public class CanvasView extends View {
    Paint paintGreen = new Paint();
    Paint paintRed = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        generatePaint(paintRed, Color.RED, Paint.Style.FILL);
        generatePaint(paintGreen, Color.GREEN, Paint.Style.FILL);
        /**
         * 画布平移，坐标系也同样会被平移
         */
//        canvas.translate(100, 100);
//        canvas.drawRect(new Rect(0, 0, 500, 200), paintGreen);
        /**
         * 每次才canvas上画图就会产生一个透明图层，然后在这个图层上画图，画完之后覆盖在屏幕上显示
         * 每次调用drawXXX（Path,Rec等）都会产生一个新的图层，在图层translate后，以后的操作是在此次translate基础上的操作
         */
//        canvas.translate(100, 100);
//        canvas.drawRect(new Rect(0, 0, 200, 100), paintRed);
//        canvas.translate(100, 100);
//        canvas.drawRect(new Rect(0, 0, 200, 100), paintGreen);

        /**
         * 一旦画布被裁剪也是不可恢复
         * 在裁剪画布系列函数时要禁用硬件加速
         */
//        setLayerType(LAYER_TYPE_SOFTWARE, null);//没搞懂，不起作用
//        canvas.drawColor(Color.RED);
//        canvas.clipRect(new Rect(100, 100, 400, 400));
//        canvas.drawColor(Color.GREEN);

        /**
         * 画布的保存与恢复save restore
         * 对画布save后进行操作（如clip、translate）然后进行restore恢复为操作前的canvas
         * sava会保存当前画布的状态，然后将其放入特定的栈中，每次restore会把栈中最顶层的画布状态取出来恢复
         */
        canvas.drawColor(Color.RED);//1
        canvas.save();//2
        canvas.clipRect(new Rect(200, 200, 700, 500));//2
        canvas.drawColor(Color.GREEN);//2
        canvas.restore();//3
        canvas.drawColor(Color.BLUE);//3

    }

    private void generatePaint(Paint paint, int color, Paint.Style style) {
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(2);
    }


    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

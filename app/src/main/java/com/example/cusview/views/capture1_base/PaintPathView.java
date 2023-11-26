package com.example.cusview.views.capture1_base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @autor sts
 * @date 2023/11/9 00:30
 * @description paint
 */
public class PaintPathView extends View {
    /**
     * 重绘时会调用onDraw，因此不建议在oDraw中创建paint等对象。应该在初始化时一次性创建
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(50);
//        canvas.drawCircle(190, 200, 150, paint);

//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setColor(0x7effff00);
//        canvas.drawCircle(190, 200, 100, paint);

        /**
         * 画直线,setStrokeWidth在style起作用时用于设置描边的宽度，在style不起作用时设置画笔的宽度
         */
//        canvas.drawLine(100, 100, 200, 200, paint);

        /**
         * 画点
         */
//        paint.setStrokeWidth(15);
//        canvas.drawPoint(100, 100, paint);

        /**
         * 矩形
         */
//        paint.setStrokeWidth(5);
//        Rect rect = new Rect(10, 10, 100, 100);
//        canvas.drawRect(rect, paint);

//        paint.setStyle(Paint.Style.FILL);
//        Rect rect = new Rect(10, 10, 100, 100);
//        canvas.drawRect(rect, paint);

        /**
         *路径Path
         */
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        Path path=new Path();
//        path.moveTo(10,10);//设置起点
//        path.lineTo(10,100);//第一条直线的终点也是第二条直线的起点
//        path.lineTo(300,100);
//        path.close();
//        canvas.drawPath(path,paint);

        /**
         * 弧线，弧线是从椭圆路径上截取一部分
         */
//        Path path = new Path();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(1);
//        path.moveTo(10,10);
//        RectF rectF = new RectF(10, 10, 100, 50);
//        canvas.drawRect(rectF,paint);
//        path.arcTo(rectF,0,90,false);
//        canvas.drawPath(path,paint);

        /**
         * 区域region（一块任意形状的封闭图形）
         */
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
//        Region region = new Region(new Rect(10, 10, 200, 200));
//        RegionIterator regionIterator = new RegionIterator(region);
//        Rect rect = new Rect();
//        while (regionIterator.next(rect)) {
//            canvas.drawRect(rect, paint);
//        }

//region的setPath函数用来实现两个区域取交集
//        paint.setStyle(Paint.Style.FILL);
//        paint.setStrokeWidth(2);
//        Path path = new Path();
//        RectF rectF = new RectF(50, 50, 200, 500);
//        path.addOval(rectF, Path.Direction.CCW);//绘制椭圆区域
//        Region region = new Region();
//        region.setPath(path, new Region(new Rect(50, 50, 200, 200)));
//        drawRegion(canvas, paint, region);

        /**
         * 区域并集region
         */
//        paint.setStyle(Paint.Style.FILL);
//        Region region=new Region(20,20,200,200);
//        region.union(new Rect(100,200,300,300));
//        drawRegion(canvas,paint,region);
        /**
         * 交集，并集,补集，替换，反转补集，异并集
         */
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        Rect rect = new Rect(100, 100, 400, 200);
        Rect rect2 = new Rect(200, 0, 300, 300);
        canvas.drawRect(rect, paint);
        canvas.drawRect(rect2, paint);
        Region region = new Region(rect);
        Region region2 = new Region(rect2);
        region.op(region2, Region.Op.INTERSECT);
        Paint paint1 = new Paint();
        paint1.setColor(Color.GREEN);
        paint1.setStyle(Paint.Style.FILL);
        drawRegion(canvas, paint1, region);


    }

    private static void drawRegion(Canvas canvas, Paint paint, Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }

    public PaintPathView(Context context) {
        super(context);
    }

    public PaintPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PaintPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

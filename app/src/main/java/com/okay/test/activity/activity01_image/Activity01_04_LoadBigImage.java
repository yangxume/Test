package com.okay.test.activity.activity01_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.okay.test.R;
import com.okay.test.utils.LogUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/30
 * @Description:  Android中加载高清大图及图片压缩方式
 */

public class Activity01_04_LoadBigImage extends AppCompatActivity implements View.OnClickListener {

    private String TAG = Activity01_04_LoadBigImage.class.getSimpleName();

    Button btn_load;
    ImageView iv_big_image;

    int Width, Height;//屏幕宽高
    int ImWidth, ImHeight;//图片宽高


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_04_loadbigimage);

        initViews();

        getScreenWidthAndHeiht();

    }

    private void initViews() {

        btn_load = (Button) findViewById(R.id.btn_load);
        btn_load.setOnClickListener(this);
        iv_big_image = (ImageView) findViewById(R.id.iv_big_image);
    }

    /**
     * 获取当前手机屏幕的高度和宽度
     */

    public void getScreenWidthAndHeiht() {

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Width = metrics.widthPixels;
        Height = metrics.heightPixels;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_load:

                loadBigImage(iv_big_image);

                break;
        }

    }

    private void loadBigImage(ImageView iv_big_image) {


        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            String path = Environment.getExternalStorageDirectory() + "/Pictures/big_image.jpg";

            LogUtils.d(TAG, path);

            BitmapFactory.Options options = new BitmapFactory.Options();

            /**
             * 思考：如何合理设置inSampleSize来针对不同分辨率的手机，从而得到一个更佳的图片压缩方案呢？？
             * 分析：
             * 由于图片大多数都是位图显示，即具体个数的像素点来显示的，在不同分辨率的手机屏幕显示图片
             * 说白就是在不同像素点的总数的屏幕中显示，很容易理解，当我有个很大的图片，所谓很很大的图片
             * 就是总的像素点数很多，并且在低分辨（总的像素点少显示）肯定有问题，只能显示部分，所以需要
             * 根据当前的手机分辨率的大小，来适当压缩图片的大小比例，然后来显示在相应分辨率的屏幕上
             * 当我通过某个方式拿到一张图片会有如下几种情况:
             *       图片宽度（ImWidth）,图片高度(ImHeight),屏幕宽度(Width),屏幕高度(Height)
             *       一、根据SD卡路径加载图片的大小比例压缩
             *              1、若图片的宽度大于图片高度（即横向图片）,且宽度大于屏幕宽度：Size=ImWidth/Width
             *              2、若图片的高度大于图片宽度(即纵向图片)，且高度大于屏幕高度:Size=ImHeight/Height;
             *              3、就是根据一个图片压缩比例算法公式：取图片宽度压缩倍数和图片高度的压缩倍数的平均值:Size=(ImWidth/Width+ImHeight/Height)/2;
             *       二、图片的质量的压缩
             *       三、根据Bitmap来压缩图片大小比例
             * */
            Bitmap bitmap;
            //图片质量压缩
//            bitmap = getImageCompress(BitmapFactory.decodeFile(path));
            //图片大小压缩一
            bitmap = getImageByScaleSize(path);
            //图片大小压缩二
//            bitmap = getImageByScaleSizeByTec(path);
            iv_big_image.setImageBitmap(bitmap);

        }

    }

    /**
     * 根据SD卡路径加载图片的大小比例压缩
     */
    public Bitmap getImageByScaleSize(String path) {
        int scaleSize = 1;//1就表示不压缩
        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;//只读取图片的信息，不读取图片的具体数据
//        ImWidth = options.outWidth;
//        ImHeight = options.outHeight;
        getImageWidthAndHeight(path);//得到图片的高度和宽度
        if (ImWidth > ImHeight && ImWidth > Width) {
            scaleSize = (int) (ImWidth * 1.0f / Width + 0.5f);//加0.5是为了四舍五入，取一个很好的精度
        } else if (ImHeight > ImWidth && ImHeight > Height) {
            scaleSize = (int) (ImHeight * 1.0f / Height + 0.5f);
        } else {//其他情况表示，就是当是横向或者纵向图片时，它的长度和宽度都大于屏幕
            scaleSize = (int) (ImWidth * 1.0f / Width + ImHeight * 1.0f / Height + 0.5f) / 2;
        }
        //设置图片的采样率
        options.inSampleSize = scaleSize;//针对不同的手机分辨率，设置的缩放比也不一样，这里的值可能是不一样的
        Bitmap bitmap2 = BitmapFactory.decodeFile(path, options);
        return bitmap2;
    }


    /**
     * 图片的质量压缩:
     * 图片质量的压缩思想大致如下:
     * 先将一张图片到一个字节数组输出流对象保存，
     * 然后通过不断压缩数据，直到图片大小压缩到某个具体大小时，然后再把
     * 字节数组输出流对象作为一个字节数组输入流参数对象传入得到一个字节数组输入流
     * 最后再将字节数组输入流得到Bitmap对象，最终拿到图片质量压缩后的图片
     */
    public Bitmap getImageCompress(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 1, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到字节数组输出流中。
        int options = 10;
        while (baos.toByteArray().length / 1024 > 100) {    //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            options -= 10;//每次都减少10
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap2 = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap2;
    }

    /**
     * 公式法
     */
    public Bitmap getImageByScaleSizeByTec(String path) {
        int scaleSize = 1;//1就表示不压缩
        getImageWidthAndHeight(path);
        LogUtils.d(TAG, "-screenW-" + Width + "-screenH-" + Height);
        LogUtils.d(TAG, "-imWidth-" + ImWidth + "-imHeight-" + ImHeight);
        int WidthScaleSize = (int) (ImWidth * 1.0f / Width * 1.0f + 0.5f);
        int HeightScaleSize = (int) (ImHeight * 1.0f / Height * 1.0f + 0.5f);
//        -screenW-768-screenH-1184
//         -imWidth-1024-imHeight-768
        scaleSize = (int) (Math.sqrt(WidthScaleSize * WidthScaleSize + HeightScaleSize * HeightScaleSize) + 0.5f);
        LogUtils.d(TAG, scaleSize+"");
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置图片的采样率
        options.inSampleSize = scaleSize;//针对不同的手机分辨率，设置的缩放比也不一样，这里的值可能是不一样的
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return bitmap;
    }

    //得到原图的高度和宽度
    private void getImageWidthAndHeight(String path) {
        try {
            ExifInterface exifInterfece = new ExifInterface(path);
            ImWidth = exifInterfece.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
            ImHeight = exifInterfece.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
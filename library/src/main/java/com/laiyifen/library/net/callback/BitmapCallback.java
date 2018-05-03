package com.laiyifen.library.net.callback;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.laiyifen.library.net.convert.BitmapConvert;

import okhttp3.Response;

/**
 * Created by Wisn on 2018/5/3 上午10:34.
 */

public abstract class BitmapCallback extends AbsCallback<Bitmap> {

    private BitmapConvert convert;

    public BitmapCallback() {
        convert = new BitmapConvert();
    }

    public BitmapCallback(int maxWidth, int maxHeight) {
        convert = new BitmapConvert(maxWidth, maxHeight);
    }

    public BitmapCallback(int maxWidth, int maxHeight, Bitmap.Config decodeConfig, ImageView.ScaleType scaleType) {
        convert = new BitmapConvert(maxWidth, maxHeight, decodeConfig, scaleType);
    }

    @Override
    public Bitmap convertResponse(Response response) throws Throwable {
        Bitmap bitmap = convert.convertResponse(response);
        response.close();
        return bitmap;
    }
}

package com.laiyifen.library.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.laiyifen.library.R;


public class GlideUtil {

    private static RequestOptions options;

    public static String getUrl(String url, int width) {
        if (url != null && url.contains("cdn.oudianyun")) {
            if (url.contains("@base@tag=imgScale")) {
                if (width > 0) {
                    url += "&w=" + width;
                }
                url += "&F=webp";
            } else {
                url += "@base@tag=imgScale";
                if (width > 0) {
                    url += "&w=" + width;
                }
                url += "&F=webp";
            }
        }
        return url;
    }

    public static void load(Context context, RequestOptions options, String url, int width, ImageView imageView) {
        Glide.with(context)
                .load(getUrl(url, width))
                .apply(options).into(imageView);
    }

    public static void load(Context context, String url, ImageView imageView) {
        load(context, getRequestOptions(), url, 0, imageView);
    }

    private static RequestOptions getRequestOptions() {
        if (options == null) {
            synchronized (GlideUtil.class) {
                if (options != null) {
                    options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.replactimage)
                            .error(R.drawable.replactimage)
                            .fallback(R.drawable.replactimage).diskCacheStrategy(DiskCacheStrategy.ALL);
                }
            }
        }
        return options;
    }

}

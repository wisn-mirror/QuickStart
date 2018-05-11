package debug;

import android.util.Log;

import com.laiyifen.library.base.BaseApplication;
import com.laiyifen.library.net.Net;
import com.laiyifen.library.net.callback.StringCallback;
import com.laiyifen.library.net.model.Response;

/**
 * Created by Wisn on 2018/5/5 下午9:16.
 */

public class CommonApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }

    public void login() {
        Net.<String>get("https://api.douban.com/v2/movie/top250?start=0&count=10")
                .execute( new StringCallback(){
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("test",response+response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }
}

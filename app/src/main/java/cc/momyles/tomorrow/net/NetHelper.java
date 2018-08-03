package cc.momyles.tomorrow.net;

import com.cetcme.m.net.MNetHelperAbstract;

import okhttp3.OkHttpClient;

public class NetHelper extends MNetHelperAbstract {

    private static NetHelper instance;

    public static NetHelper instance() {
        return NetHelperHolder.instance;
    }

    @Override
    protected OkHttpClient getOkHttpClient() {
        return null;
    }

    @Override
    protected String getBaseUrl() {
        return "";
    }

    public ApiService service() {
        return createService(ApiService.class);
    }

    private static class NetHelperHolder {
        static final NetHelper instance = new NetHelper();
    }
}

package cc.momyles.tomorrow.net;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/")
    Observable<String> baidu();
}

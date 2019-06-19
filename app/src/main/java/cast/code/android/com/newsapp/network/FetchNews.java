package cast.code.android.com.newsapp.network;

import cast.code.android.com.newsapp.models.NewsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchNews {
    @GET("top-headlines")
    Call<NewsModel> getNews(
            @Query("country") String country ,
            @Query("pageSize") int pageSize ,
            @Query("page") int page ,
            @Query("apiKey") String apiKey
    );
}

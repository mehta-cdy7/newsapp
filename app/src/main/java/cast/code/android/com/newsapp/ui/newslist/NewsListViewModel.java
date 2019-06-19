package cast.code.android.com.newsapp.ui.newslist;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import cast.code.android.com.newsapp.models.ArticleModel;

public class NewsListViewModel extends AndroidViewModel  {

    private MutableLiveData<List<ArticleModel>> newsLiveData;
    private NewsListRepository newsListRepository;


    public NewsListViewModel(@NonNull Application application) {
        super( application );
        newsListRepository = NewsListRepository.getInstance( application.getApplicationContext() );
        newsLiveData = new MutableLiveData<>();
    }


    LiveData<List<ArticleModel>> getArticles() {
        newsLiveData = newsListRepository.getArticles();
        return newsLiveData;
    }



}

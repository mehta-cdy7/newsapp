package cast.code.android.com.newsapp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

class NewsListViewModel extends AndroidViewModel{

    private MutableLiveData<List<ArticleModel>> newsLiveData;
    private NewsListRepository newsListRepository;

    public NewsListViewModel(@NonNull Application application) {
        super(application);
        newsListRepository = NewsListRepository.getInstance(application.getApplicationContext());
        newsLiveData = new MutableLiveData<>();
    }


    LiveData<List<ArticleModel>> getArticles() {
        newsLiveData = newsListRepository.getArticles();
        return newsLiveData;
    }
}

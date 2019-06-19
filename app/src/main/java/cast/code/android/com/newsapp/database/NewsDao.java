package cast.code.android.com.newsapp.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import cast.code.android.com.newsapp.models.ArticleModel;

//this is data access object class of room
//here we implement
//ANY UPDATE OR SQL QUERY TO THE TABLE
//all queries related to table enter here

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArticleModel news);

    @Query("DELETE FROM news_table")
    void deleteAllNews();

    @Query("SELECT * FROM news_table")
    List<ArticleModel> getAllNews();
}

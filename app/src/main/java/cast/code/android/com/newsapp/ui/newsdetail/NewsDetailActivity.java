package cast.code.android.com.newsapp.ui.newsdetail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import cast.code.android.com.newsapp.R;
import cast.code.android.com.newsapp.constants.IntentConstants;
import cast.code.android.com.newsapp.utils.Utils;

public class NewsDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivNewsImage;
    private TextView tvNewsTitle, tvNewsContent;
    private Button btnGoToSource;
    private Context context;


    private String newsTitle, newsContent, newsDescription, author, publishedAt, sourceURL, imageURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        context = this;

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            newsTitle = intent.getStringExtra( IntentConstants.NEWS_TITLE);
            newsContent = intent.getStringExtra(IntentConstants.NEWS_CONTENT);
            newsDescription = intent.getStringExtra(IntentConstants.NEWS_DESCRIPTION);
            author = intent.getStringExtra(IntentConstants.AUTHOR);
            publishedAt = intent.getStringExtra(IntentConstants.PUBLISHED_AT);
            sourceURL = intent.getStringExtra(IntentConstants.SOURCE_URL);
            imageURL = intent.getStringExtra(IntentConstants.IMAGE_URL);
        }

        initViews();
    }

    private void initViews() {
        ivNewsImage = findViewById(R.id.iv_news_image);
        tvNewsTitle = findViewById(R.id.tv_news_title);
        tvNewsContent = findViewById(R.id.tv_news_content);
        btnGoToSource = findViewById(R.id.btn_go_to_source);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (author != null && !author.trim().equalsIgnoreCase("")) {
                getSupportActionBar().setTitle(author);

            } else {
                getSupportActionBar().setTitle(getString(R.string.unknown_source));
            }

        }

        Picasso.with(context).load(imageURL).placeholder(R.drawable.placeholder_big).into(ivNewsImage);

        tvNewsTitle.setText(newsTitle);
        tvNewsContent.setText(newsContent);

        btnGoToSource.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go_to_source:
                if (!Utils.isNetworkAvailable()) {
                    Utils.showToast(context, getString(R.string.please_connect_to_internet));
                    return;
                }
                if (sourceURL != null && !sourceURL.trim().equalsIgnoreCase("")) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData( Uri.parse(sourceURL));
                    startActivity(i);
                } else {
                    Utils.showToast(context, getString(R.string.something_went_wrong));
                }
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

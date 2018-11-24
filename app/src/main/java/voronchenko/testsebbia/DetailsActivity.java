package voronchenko.testsebbia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import voronchenko.testsebbia.pojo.Details;
import voronchenko.testsebbia.rest.NetworkService;

public class DetailsActivity extends AppCompatActivity {

    private int newsID;
    private Intent intent;
    TextView tvTitleDetail;
    TextView tvDetailsShortNews;
    TextView tvDetailsNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        intent = getIntent();

        tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvDetailsShortNews = findViewById(R.id.tvDetailsShortNews);
        tvDetailsNews = findViewById(R.id.tvDetailsNews);

        tvTitleDetail.setText(intent.getStringExtra("Title"));
        tvDetailsShortNews.setText(intent.getStringExtra("ShortDescription"));

        newsID = intent.getIntExtra("id", 0);
        getData(newsID);
    }

    private void getData(int newsID) {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(newsID)
                .enqueue(new Callback<Details>() {
                    @Override
                    public void onResponse(Call<Details> call, Response<Details> response) {
                        tvDetailsNews.setText(Html.fromHtml(response.body().getNews().getFullDescription()));
                        tvDetailsNews.setMovementMethod(LinkMovementMethod.getInstance());
                    }

                    @Override
                    public void onFailure(Call<Details> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }
}

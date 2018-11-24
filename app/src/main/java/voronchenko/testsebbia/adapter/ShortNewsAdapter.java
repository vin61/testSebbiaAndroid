package voronchenko.testsebbia.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import voronchenko.testsebbia.DetailsActivity;
import voronchenko.testsebbia.R;
import voronchenko.testsebbia.pojo.ShortNews;

public class ShortNewsAdapter extends PagedListAdapter<ShortNews, ShortNewsAdapter.ShortNewsViewHolder> {

    private Context mCtx;


    public ShortNewsAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }


    @NonNull
    @Override
    public ShortNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx)
                .inflate(R.layout.short_news_item_view, parent, false);
        return new ShortNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortNewsViewHolder holder, int position) {

        final ShortNews shortNews = getItem(position);

        if (shortNews != null) {
            holder.tvTitle.setText(shortNews.getTitle());
            holder.tvShortNews.setText(shortNews.getShortDescription());

            String newsData = "das";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"); //2016-08-25T19:19:19.104Z
            try {
                Date date = simpleDateFormat.parse(shortNews.getDate());
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
                newsData= simpleDateFormat1.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            holder.tvDate.setText(newsData);
            holder.llShortNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                    intent.putExtra("id", shortNews.getId());
                    intent.putExtra("Title", shortNews.getTitle());
                    intent.putExtra("ShortDescription", shortNews.getShortDescription());
                    view.getContext().startActivity(intent);
                }
            });
        } else {
            Toast.makeText(mCtx, "Поля пустые", Toast.LENGTH_SHORT).show();
        }
    }

    private static DiffUtil.ItemCallback<ShortNews> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ShortNews>() {
                @Override
                public boolean areItemsTheSame(ShortNews oldItem, ShortNews newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(ShortNews oldItem, ShortNews newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class ShortNewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvShortNews;
        TextView tvDate;
        LinearLayout llShortNews;

        public ShortNewsViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvShortNews = itemView.findViewById(R.id.tvShortNews);
            tvDate = itemView.findViewById(R.id.tvDate);
            llShortNews = itemView.findViewById(R.id.llShortNews);
        }
    }
}

package voronchenko.testsebbia.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import voronchenko.testsebbia.R;
import voronchenko.testsebbia.ShortNewsActivity;
import voronchenko.testsebbia.pojo.Categories;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Categories> categoriesList = new ArrayList<>();

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item_view, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categoriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public void setItems(Collection<Categories> categories) {
        categoriesList.addAll(categories);
        notifyDataSetChanged();
    }

    public void clearItems() {
        categoriesList.clear();
        notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);

        }

        public void bind(final Categories categories) {
            tvName.setText(categories.getName());
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ShortNewsActivity.class);
                    intent.putExtra("id", categories.getId());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }


}

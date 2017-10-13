package com.digiduka.digiduka.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.digiduka.digiduka.R;
import com.digiduka.digiduka.models.Category;

import java.util.ArrayList;

/**
 * Created by victor on 10/11/17.
 */

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesViewHolder> implements View.OnClickListener{
    private Context mContext;
    private TextView gridText;
    private ConstraintLayout gridViewHolder;
    private ArrayList<Category> categories;
    public CategoriesRecyclerViewAdapter(Context context, ArrayList<Category> categories){
        mContext = context;
        this.categories = categories;
    }
    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_item, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        Log.d("this", "wah wah");
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        holder.bindCategory();
        Log.d("position", Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder{

        public CategoriesViewHolder(View itemView) {
            super(itemView);
            gridText = itemView.findViewById(R.id.gridText);
            gridViewHolder = itemView.findViewById(R.id.gridViewHolder);
        }
        public void bindCategory(){
            gridText.setText("category.getCategoryTitle()");
        }
    }
    @Override
    public void onClick(View view) {

    }
}

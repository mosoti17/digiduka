package com.digiduka.digiduka.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.digiduka.digiduka.R;
import com.digiduka.digiduka.models.Category;
import com.digiduka.digiduka.ui.AddProductFragment;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by mosoti on 10/13/17.
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private Context mContext;
    private ArrayList<Category> mCategorys=new ArrayList<>();

    public CategoryListAdapter(Context context,ArrayList<Category> categories) {
        mContext = context;
        mCategorys = categories;
    }
    @Override
    public CategoryListAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryListAdapter.CategoryViewHolder holder, int position) {
        holder.bindCategory(mCategorys.get(position));
    }

    @Override
    public int getItemCount() {
        // Log.v("items",mItems.get(0).getName());
        return mCategorys.size();
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView gridText;
        private ConstraintLayout categoryProductsHolder;
        private ImageView dropDownImage;
        private ConstraintLayout gridViewHolder;
        private Button addProductButton;
        private Context mContext;

        public CategoryViewHolder(View itemView){
            super(itemView);
            mContext = itemView.getContext();
            gridText = itemView.findViewById(R.id.gridText);
            categoryProductsHolder = itemView.findViewById(R.id.categoryProductsHolder);
            dropDownImage = itemView.findViewById(R.id.dropDownImage);
            gridViewHolder = itemView.findViewById(R.id.gridViewHolder);
            addProductButton = itemView.findViewById(R.id.addProductButton);

            categoryProductsHolder.setVisibility(View.GONE);
            gridViewHolder.setOnClickListener(this);
            dropDownImage.setOnClickListener(this);
        }

        public void bindCategory(final Category category){
            gridText.setText(category.getCategoryTitle());
            addProductButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddProductFragment fragment = new AddProductFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("category", Parcels.wrap(category));
                    fragment.setArguments(bundle);

                    FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
                    android.app.FragmentManager fm = ((Activity) mContext).getFragmentManager();
                    fragment.show(fm, "dialog");
                }
            });

        }
        @Override
        public void onClick(View view) {
            if (view == dropDownImage || view == gridViewHolder){
                if (categoryProductsHolder.getVisibility()==View.VISIBLE){
                    categoryProductsHolder.setVisibility(View.GONE);
                }else{
                    categoryProductsHolder.setVisibility(View.VISIBLE);
                }
            }
        }


    }
}

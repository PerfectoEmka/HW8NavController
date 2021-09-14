package com.example.hm8navcontroller.ui.fragments.location;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hm8navcontroller.databinding.ItemLocationBinding;
import com.example.hm8navcontroller.models.LocationModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<LocationModel> list = new ArrayList<>();
    OnClick onClick;

    public void setList(ArrayList<LocationModel> list, MainAdapter.OnClick onClick) {
        this.list = list;
        this.onClick = onClick;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemLocationBinding binding;

        public ViewHolder(@NonNull ItemLocationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(LocationModel locationModel) {
            binding.titleTv.setText(locationModel.getTitle());
            binding.typeTv.setText(locationModel.getType());
            binding.getRoot().setOnClickListener(v -> {
                onClick.onItemClick(locationModel);
            });
        }
    }

    public interface OnClick {
        public  void  onItemClick(LocationModel model);
    }

}


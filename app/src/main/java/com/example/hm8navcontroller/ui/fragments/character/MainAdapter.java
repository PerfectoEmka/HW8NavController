package com.example.hm8navcontroller.ui.fragments.character;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hm8navcontroller.R;
import com.example.hm8navcontroller.databinding.ItemCharacterBinding;
import com.example.hm8navcontroller.models.CharacterModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    OnClick onClick;
    ArrayList<CharacterModel> list = new ArrayList<>();

    public void setList(ArrayList<CharacterModel> list, OnClick onClick) {
        this.list = list;
        this.onClick = onClick;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)); // Привязка дизайн к логике

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

        ItemCharacterBinding binding;

        public ViewHolder(@NonNull ItemCharacterBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(CharacterModel characterModel) {
            binding.deadAliveStatusTv.setText(characterModel.getDeadAliveStatus());
            binding.nameTv.setText(characterModel.getName());
            Glide.with(binding.imageV
                    .getContext())
                    .load(characterModel.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.imageV);
            binding.getRoot().setOnClickListener(v ->{
                onClick.OnItemClick(characterModel);
            });
        }
    }
    public interface OnClick{
        public void OnItemClick(CharacterModel model);
    }
}

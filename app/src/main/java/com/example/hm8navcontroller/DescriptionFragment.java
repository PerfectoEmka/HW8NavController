package com.example.hm8navcontroller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hm8navcontroller.databinding.FragmentDescriptionBinding;
import com.example.hm8navcontroller.models.CharacterModel;
import com.example.hm8navcontroller.models.LocationModel;

public class DescriptionFragment extends Fragment {

    FragmentDescriptionBinding binding;
    CharacterModel characterModel;
    LocationModel locationModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContent();
    }

    private void setContent() {
        if(getArguments() != null){
            if (getArguments().containsKey("location")){
                locationModel = (LocationModel) getArguments().getSerializable("location");
                binding.nameTv.setText(locationModel.getTitle());
                binding.deadAliveStatusTv.setText(locationModel.getType());
                Glide.with(binding.imageV
                        .getContext())
                        .load(locationModel.getImage())
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(binding.imageV);
            }
            else if (getArguments().containsKey("character")){
                characterModel = (CharacterModel) getArguments().getSerializable("character");
                binding.nameTv.setText(characterModel.getName());
                binding.deadAliveStatusTv.setText(characterModel.getDeadAliveStatus());
                Glide.with(binding.imageV
                        .getContext())
                        .load(characterModel.getImage())
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(binding.imageV);
            }
        }
    }
}
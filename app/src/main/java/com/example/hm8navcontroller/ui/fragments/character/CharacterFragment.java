package com.example.hm8navcontroller.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hm8navcontroller.R;
import com.example.hm8navcontroller.data.CharacterData;
import com.example.hm8navcontroller.databinding.FragmentCharacterBinding;
import com.example.hm8navcontroller.models.CharacterModel;

public class CharacterFragment extends Fragment implements MainAdapter.OnClick{

    private FragmentCharacterBinding binding;
    private CharacterData data = new CharacterData();
    private MainAdapter adapter;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new MainAdapter();
        adapter.setList(data.getList(), this);
        binding.characterRecyclerV.setAdapter(adapter);
    }

    @Override
    public void OnItemClick(CharacterModel model) {
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container_view_tag);
        Bundle b = new Bundle();
        b.putSerializable("character", model);
        navController.navigate(R.id.descriptionFragment,b);
    }
}
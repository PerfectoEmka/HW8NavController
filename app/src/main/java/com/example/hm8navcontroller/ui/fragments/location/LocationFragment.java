package com.example.hm8navcontroller.ui.fragments.location;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hm8navcontroller.DescriptionFragment;
import com.example.hm8navcontroller.R;
import com.example.hm8navcontroller.databinding.FragmentLocationBinding;
import com.example.hm8navcontroller.models.CharacterModel;
import com.example.hm8navcontroller.models.LocationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class LocationFragment extends Fragment implements MainAdapter.OnClick{

    private FragmentLocationBinding binding;
    private ArrayList<LocationModel> list = new ArrayList<>();
    private MainAdapter adapter = new MainAdapter();
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler();
    }

    private void createList() {
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
        list.add(new LocationModel("Planet", "Earth (C-137)", "https://static.wikia.nocookie.net/rickandmorty/images/d/da/S4e3_2019-11-28-13h18m09s324.png/revision/latest?cb=20191128184508"));
    }

    private void initRecycler() {
        adapter.setList(list, this);
        binding.locationRecyclerV.setAdapter(adapter);
    }

    @Override
    public void onItemClick(LocationModel model) {
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container_view_tag);
        Bundle b = new Bundle();
        b.putSerializable("location", model);
        navController.navigate(R.id.descriptionFragment,b);
    }
}
package com.shoffers.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shoffers.R;
import com.shoffers.child.ChildSelection;
import com.shoffers.mens.MenSelection;
import com.shoffers.women.WomenSelection;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Button mens,womens,child;

        View root = inflater.inflate(R.layout.fragment_home, container, false);
         mens=root.findViewById(R.id.men);
         womens=root.findViewById(R.id.women);
         child=root.findViewById(R.id.child);
        mens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getActivity(),MenSelection.class);
               startActivity(intent);

            }
        });
        womens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), WomenSelection.class);
                startActivity(intent);

            }
        });
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChildSelection.class);
                startActivity(intent);

            }
        });

    return root;

    }
}

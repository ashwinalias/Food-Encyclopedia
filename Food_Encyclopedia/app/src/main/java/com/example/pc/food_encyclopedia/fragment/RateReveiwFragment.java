package com.example.pc.food_encyclopedia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.pc.food_encyclopedia.R;

public class RateReveiwFragment extends Fragment {

    AutoCompleteTextView mSearchBar;
    String[] mDummyData = { "abc","ash", "alm","pqr States","Parana,Brazil",
            "Padua,Italy", "Pasadena,CA,United States"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_rate_reveiw,
                container, false);
        initialse(view);
        return view;
    }

    private void initialse(View view) {
        mSearchBar = view.findViewById(R.id.autoCompleteTextView1);
        loadSearchBar();

    }

    private void loadSearchBar() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), R.layout.dropdown_item_wrap_line, R.id.autoCompleteItem, mDummyData);
        mSearchBar.setThreshold(2);
        mSearchBar.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

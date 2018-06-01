package com.coolzhye.androidexercise1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StorageFragment extends Fragment {

    private final String KEY_NUMBER = "number";
    private int number = 0;

    public StorageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_storage, container, false);

        rootView.findViewById(R.id.btnMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(--number);
            }
        });

        rootView.findViewById(R.id.btnPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(++number);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getActivity().getPreferences(getContext().MODE_PRIVATE);
        number = sharedPreferences.getInt(KEY_NUMBER, 0);
        updateNumber(number);
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getActivity().getPreferences(getContext().MODE_PRIVATE);
        sharedPreferences.edit().putInt(KEY_NUMBER, number).commit();
    }

    private void updateNumber(int newNumber) {
        number = newNumber;

        TextView textViewNumber = getView().findViewById(R.id.textViewNumber);
        textViewNumber.setText(Integer.toString(newNumber));
    }
}

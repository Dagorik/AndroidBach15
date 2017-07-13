package dagorik.mariachi.com.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import dagorik.mariachi.com.fragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    Button boton;
    private String title;
    private TextView tvTitle;

    public BlankFragment() {
        // Required empty public constructor
    }
    public BlankFragment(String title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        return view;
    }



}

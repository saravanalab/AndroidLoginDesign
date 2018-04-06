package com.techlab.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techlab.sample.ProfileActivity;
import com.techlab.sample.R;

/**
 * Created by DEVUSER97 on 11/9/2017.
 */

public class Signin extends Fragment {
    private TextView login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin_fragment,null);
        login = (TextView)view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startprofile = new Intent(getActivity(), ProfileActivity.class);
                startActivity(startprofile);
            }
        });
        return view;

    }
}

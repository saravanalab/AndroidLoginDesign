package com.techlab.sample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techlab.sample.fragment.Signin;
import com.techlab.sample.fragment.Signup;

public class LoginActivity extends AppCompatActivity {
    private TabLayout tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pages);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            String[] titles ={"Signin", "Signup"};

            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return  new Signin();
                }else {
                    return new Signup();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabs.setupWithViewPager(pager);
    }
}

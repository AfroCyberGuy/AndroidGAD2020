package com.example.mytablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    MyAdapter mAdapter;
    ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mAdapter = new MyAdapter(getSupportFragmentManager(), 2);

       mPager = findViewById(R.id.pager);

       mPager.setAdapter(mAdapter);



        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Learning Leaders"));
        tabLayout.addTab(tabLayout.newTab().setText("Skill IQ Learners"));

        // Now we have tabs, NOTE: I am hardcoding the order, you'll want to do something smarter

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        mPager.regi(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        });

        // And now we have tabs that, when clicked, navigate to the correct page
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.submit_btn:

             Intent intent = new Intent(this, SubmitFormActivity.class);
             startActivity(intent);

             return  true;


            default:

        }


        return super.onOptionsItemSelected(item);
    }

    private class MyAdapter extends FragmentStatePagerAdapter {

        int numberOfTabs;

        public MyAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

            this.numberOfTabs = numberOfTabs;
        }



        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {


                case 0:

                    return new LearningLeadersFragment();

                case 1:

                    return new SkillsIQLeadersFragment();

                default:

                    return null;


            }
        }

        @Override
        public int getCount() {
            return numberOfTabs;
        }
    }
}

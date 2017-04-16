package com.example.android.missoulahoodguide;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ShowableListMenu;
import android.widget.Toast;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity
        implements ParksFragment.OnFragmentInteractionListener,
        SchoolsFragment.OnFragmentInteractionListener,
        DiningFragment.OnFragmentInteractionListener,
        ShoppingFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        int tabIcons[] = { R.drawable.ic_parks_white, R.drawable.ic_school_white,R.drawable.ic_dining_white,R.drawable.ic_shopping_white};
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "Interaction", Toast.LENGTH_LONG).show();
    }
}

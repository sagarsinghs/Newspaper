package sangamsagar.newspapertime.PopularChannels.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.TabFragments.Celebrities;

public class ChannelsExpand extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main_expand);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FragmentManager fragmentManager;
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();

        final Fragment[] fragment={null};

        fragment[0] = new Celebrities();


        if (fragment[0] != null) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment[0]).commit();
        }

    }
    }
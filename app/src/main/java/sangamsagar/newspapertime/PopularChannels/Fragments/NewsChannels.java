package sangamsagar.newspapertime.PopularChannels.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sangamsagar.newspapertime.PopularChannels.Fragments.Fragment.FragmentChannels;
import sangamsagar.newspapertime.R;

public class NewsChannels extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_channels);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment[] fragment1={null};
        fragment1[0] = new FragmentChannels();
        if (fragment1[0] != null) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment1[0]).commit();
        }
    }
}

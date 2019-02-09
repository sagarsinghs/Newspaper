package sangamsagar.newspapertime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import sangamsagar.newspapertime.TabFragments.Fortune;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   //startActivity(new Intent(BottomActivity.this,MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                   // startActivity(new Intent(BottomActivity.this,India.class));
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    final Fragment[] fragment1={null};
                    fragment1[0] = new Fortune();
                    setTitle("My Services");
                    if (fragment1[0] != null) {
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment1[0]).commit();
                    }
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(BottomActivity.this,MainActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

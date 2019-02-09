package sangamsagar.newspapertime.RoomDatabase;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import sangamsagar.newspapertime.R;

public class RoomMainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
   public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_main);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();
        fragmentManager = getSupportFragmentManager();
        final Fragment[] fragment = {null};
        fragment[0] = new FragmentClass();
        setTitle("No Internet");

        if (fragment[0] != null) {
            fragmentManager.beginTransaction().replace(R.id.container, fragment[0]).commit();
        }
    }
}
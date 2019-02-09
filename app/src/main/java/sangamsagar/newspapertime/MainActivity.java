package sangamsagar.newspapertime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import sangamsagar.newspapertime.Adapter.DrawerItemCustomerAdapter;
import sangamsagar.newspapertime.Adapter.TabPagerAdapter;
import sangamsagar.newspapertime.Countries.India;
import sangamsagar.newspapertime.Model.DataModel;
import sangamsagar.newspapertime.PopularChannels.Fragments.NewsChannels;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] mNavigationDrawerItemTitles;
    private CharSequence  mTitle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    TabLayout tabLayout;
    public  static   int position_clicked;
    Toolbar toolbar;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    BottomNavigationView navigationView;
    private final int[] colors = {R.color.bottomtab_0, R.color.bottomtab_1, R.color.bottomtab_2};


    private static final String URL_FOR_REGISTRATION = "https://newsapi.org/v2/top-headlines?sources=cbc-news&apiKey=dd58977a4b15400da37c91936335d8dd";

    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // get_method();
        /* ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout)).setTitle("NewspaperTime");*/



        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        mTitle = getTitle();

       /* navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) MainActivity.this);*/

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("News"));


        tabLayout.addTab(tabLayout.newTab().setText("Sports"));

        tabLayout.addTab(tabLayout.newTab().setText("Entertainment"));

        tabLayout.addTab(tabLayout.newTab().setText("Celebrities"));
        tabLayout.addTab(tabLayout.newTab().setText("Nature"));
        tabLayout.addTab(tabLayout.newTab().setText("Science"));
        tabLayout.addTab(tabLayout.newTab().setText("Gadgets"));
        tabLayout.addTab(tabLayout.newTab().setText("Culture"));
        tabLayout.addTab(tabLayout.newTab().setText("Gaming"));
        tabLayout.addTab(tabLayout.newTab().setText("Fortune 500 companies"));
        tabLayout.addTab(tabLayout.newTab().setText("StockMarkets"));
        tabLayout.addTab(tabLayout.newTab().setText("Technology"));
        tabLayout.addTab(tabLayout.newTab().setText("art"));

        DataModel[] drawerItem = new DataModel[3];

        drawerItem[0] = new DataModel(R.drawable.ic_notifications_black_24dp, "India");
        drawerItem[1] = new DataModel(R.drawable.ic_notifications_black_24dp, "News Channels");
        drawerItem[2] = new DataModel(R.drawable.ic_notifications_black_24dp, "Hot News");

      /*  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        DrawerItemCustomerAdapter adapter = new DrawerItemCustomerAdapter(this, R.layout.list_view_item, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();


        final ViewPager viewPager =
                (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter1 = new TabPagerAdapter
                (getSupportFragmentManager(),
                        tabLayout.getTabCount());
        viewPager.setAdapter(adapter1);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("FindingThePosition",Integer.toString(tab.getPosition()));
                position_clicked = tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //position_clicked = tab.getPosition();
                Log.d("FindingThePosition",Integer.toString(tab.getPosition()));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d("FindingThePosition",Integer.toString(tab.getPosition()));
            }

        });


     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }



    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
               /* FragmentManager fragmentManager = getSupportFragmentManager();

                final Fragment[] fragment1={null};
                fragment1[0] = new Fortune();
                setTitle("My Services");
                if (fragment1[0] != null) {
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment1[0]).commit();
                }*/
                startActivity(new Intent(MainActivity.this,India.class));
                //fragment = new Tab1Fragment();
                break;
            case 1:
                startActivity(new Intent(MainActivity.this,NewsChannels.class));
                //fragment = new Tab1Fragment();
                break;
            case 2:
                startActivity(new Intent(MainActivity.this,NewActivityCreatedTesting.class));
                //fragment = new Tab1Fragment();
                break;

            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.notification) {
            startActivity(new Intent(this, India.class));
        } else if (itemId == R.id.search) {
            startActivity(new Intent(this, MainActivity.class));
        }

        return true;
    }

    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }


    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = navigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }*/
   /* @Override
    int getNavigationMenuItemId() {
        return R.id.notification;
    }*/
    int getContentViewId() {
        return 0;
    }

    int getNavigationMenuItemId() {
        return 0;
    }


}

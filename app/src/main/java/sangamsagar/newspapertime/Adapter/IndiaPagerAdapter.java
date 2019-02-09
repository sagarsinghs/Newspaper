package sangamsagar.newspapertime.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class IndiaPagerAdapter  extends FragmentPagerAdapter {

    int tabCount;

    public IndiaPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        /* tabLayout.addTab(tabLayout.newTab().setText("Headlines"));
        tabLayout.addTab(tabLayout.newTab().setText("Business"));
        tabLayout.addTab(tabLayout.newTab().setText("Entertainment"));
        tabLayout.addTab(tabLayout.newTab().setText("Health"));
        tabLayout.addTab(tabLayout.newTab().setText("Science"));
        tabLayout.addTab(tabLayout.newTab().setText("Sports"));
        tabLayout.addTab(tabLayout.newTab().setText("Technology"));
*/
        Log.d("Findingtheposition",Integer.toString(position));
        switch (position) {
            case 0:
                sangamsagar.newspapertime.Countries.headlines tab1 = new sangamsagar.newspapertime.Countries.headlines();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                // Toast.makeText(,"clicked this part",Toast.LENGTH_SHORT).show();
                return tab1;
            case 1:
                sangamsagar.newspapertime.Countries.Business tab2 = new sangamsagar.newspapertime.Countries.Business();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                return tab2;
            case 2:
                sangamsagar.newspapertime.Countries.Entertainment tab3 = new sangamsagar.newspapertime.Countries.Entertainment();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                return tab3;
            case 3:
                sangamsagar.newspapertime.Countries.Health tab4 = new sangamsagar.newspapertime.Countries.Health();
                return tab4;

            case 4:
                sangamsagar.newspapertime.Countries.Science tab5 = new sangamsagar.newspapertime.Countries.Science();
                return tab5;

            case 5:
                sangamsagar.newspapertime.Countries.Sports tab6 = new sangamsagar.newspapertime.Countries.Sports();
                return tab6;

            case 6:
                sangamsagar.newspapertime.Countries.Technology tab7 = new sangamsagar.newspapertime.Countries.Technology();
                return tab7;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

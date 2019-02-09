package sangamsagar.newspapertime.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import sangamsagar.newspapertime.PopularChannels.Fragments.Fragment.FragmentChannels;
import sangamsagar.newspapertime.TabFragments.Celebrities;
import sangamsagar.newspapertime.TabFragments.Culture;
import sangamsagar.newspapertime.TabFragments.EntertainmentFragments;
import sangamsagar.newspapertime.TabFragments.Fortune;
import sangamsagar.newspapertime.TabFragments.Gadgets;
import sangamsagar.newspapertime.TabFragments.Gaming;
import sangamsagar.newspapertime.TabFragments.Nature;
import sangamsagar.newspapertime.TabFragments.Science;
import sangamsagar.newspapertime.TabFragments.SportsFragment;
import sangamsagar.newspapertime.TabFragments.StockMarkets;
import sangamsagar.newspapertime.TabFragments.Tab1Fragment;
import sangamsagar.newspapertime.TabFragments.Technology;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        Log.d("Findingtheposition",Integer.toString(position));
        switch (position) {
            case 0:
                FragmentChannels tab1 = new FragmentChannels();
                Log.d("CheckingtheCCLickedPart","clcicked this");
               // Toast.makeText(,"clicked this part",Toast.LENGTH_SHORT).show();
                return tab1;
            case 1:
                SportsFragment tab2 = new SportsFragment();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                return tab2;
            case 2:
                EntertainmentFragments tab3 = new EntertainmentFragments();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                return tab3;
            case 3:
                Celebrities tab4 = new Celebrities();
                return tab4;

            case 4:
                Nature tab5 = new Nature();
                return tab5;

            case 5:
                Science tab6 = new Science();
                return tab6;

            case 6:
                Tab1Fragment tab7 = new Tab1Fragment();
                return tab7;

            case 7:
                Gadgets tab8 = new Gadgets();
                return tab8;

            case 8:
                Culture tab9 = new Culture();
                return tab9;

            case 9:
                Gaming tab10 = new Gaming();
                return tab10;
            case 10:
                Fortune tab11 = new Fortune();
                return tab11;
            case 11:
                StockMarkets tab12 = new StockMarkets();
                return tab12;
            case 12:
                Technology tab13 = new Technology();
                return tab13;
           /* case 13:
                Tab1Fragment tab14 = new Tab1Fragment();
                return tab14;*/

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

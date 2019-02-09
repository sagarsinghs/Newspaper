package sangamsagar.newspapertime.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import sangamsagar.newspapertime.stockmarkets.Fragments.StockPriceNifty;
import sangamsagar.newspapertime.stockmarkets.Fragments.StockPriceSensex;

public class StockPriceAdapter extends FragmentPagerAdapter {

    int tabCount;

    public StockPriceAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

      Log.d("Findingtheposition",Integer.toString(position));
        switch (position) {
            case 0:
                StockPriceSensex tab1 = new StockPriceSensex();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                // Toast.makeText(,"clicked this part",Toast.LENGTH_SHORT).show();
                return tab1;
            case 1:
                StockPriceNifty tab2 = new StockPriceNifty();
                Log.d("CheckingtheCCLickedPart","clcicked this");
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}


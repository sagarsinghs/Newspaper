package sangamsagar.newspapertime.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sangamsagar.newspapertime.Model.DataModel;
import sangamsagar.newspapertime.R;

public class DrawerItemCustomerAdapter extends ArrayAdapter<DataModel> {

    Typeface typeface;
    Context mContext;
    int layoutResourceId;
    DataModel data[] = null;

    public DrawerItemCustomerAdapter(Context mContext, int layoutResourceId, DataModel[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/sairaextralight.ttf");
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        textViewName.setTypeface(typeface);

        DataModel folder = data[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
package sangamsagar.newspapertime.PopularChannels.Fragments.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import sangamsagar.newspapertime.PopularChannels.Fragments.ChannelsExpand;
import sangamsagar.newspapertime.PopularChannels.Fragments.Model.Channel;
import sangamsagar.newspapertime.R;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.EmployeeViewHolder> {

    public  static String position_channels;
    Typeface face1, face2;
    private Context context;
    String utl_data;
    WebView webview;

    private ArrayList<Channel> employees;

    FragmentManager fragmentManager;

    public ChannelAdapter(Context context, ArrayList<Channel> employees) {
        this.context = context;
        this.employees = employees;

    }

    @NonNull
    @Override
    public ChannelAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChannelAdapter.EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.channel_adapter,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.EmployeeViewHolder holder, int position) {
        final Channel employee = employees.get(position);


        //holder.imageView.setImageBitmap(employee.getImage());
        holder.index.setText(employee.getIndex());
        holder.channel_name.setText(employee.getName());
       holder.imageView.setImageResource(employee.getImage());


        face1 = Typeface.createFromAsset(context.getAssets(), "fonts/sairasemibold.ttf");
        face2 = Typeface.createFromAsset(context.getAssets(), "fonts/sairaregular.ttf");



      /*  String url = employee.getUrl_image();*/
      //  Picasso.get().load(url).centerCrop().fit().into(holder.imageView);
      /*  Picasso.with(this.getContext())
                .load(url)
                .centerCrop()
                .fit()
                .into(image);*/
        /*holder.imageView.*/

    }

    @Override
    public int getItemCount() {
        return employees != null ? employees.size() : 0;
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        String url1;
        @BindView(R.id.image)
        ImageView imageView;

        @BindView(R.id.index)
        TextView index;

        @BindView(R.id.channel_name)
        TextView channel_name;


        public EmployeeViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Channel employee = employees.get(position);
            if (employee != null) {

            context.startActivity(new Intent(context,ChannelsExpand.class));
                //context.startActivity(intent);
                //context.startActivity(new Intent(context, DisplayingTheDetails.class));
            }
        }}}


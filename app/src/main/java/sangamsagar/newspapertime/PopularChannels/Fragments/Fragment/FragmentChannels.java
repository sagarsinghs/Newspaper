package sangamsagar.newspapertime.PopularChannels.Fragments.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import sangamsagar.newspapertime.PopularChannels.Fragments.Adapter.ChannelAdapter;
import sangamsagar.newspapertime.PopularChannels.Fragments.Model.Channel;
import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.URL;

public class FragmentChannels extends Fragment {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    ChannelAdapter tab1PageAdapter;

    RecyclerView recyclerView;
    ArrayList<Channel> channelArrayList;

    public static  String URL_FOR_REGISTRATION;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        channelArrayList=  new ArrayList<>();
        recyclerView =  (RecyclerView) view.findViewById(R.id.recycler_view);

        setting_the_urls();
        get_news();



        tab1PageAdapter = new ChannelAdapter(getContext(),channelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       //  recyclerView.setLayoutManager(new VegaLayoutManager());
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(tab1PageAdapter);
        tab1PageAdapter.notifyDataSetChanged();
    }

    public  void  setting_the_urls() {
        URL_FOR_REGISTRATION = URL.celebrities;

    }
    public  void  get_news()
    {

        Channel channel = new Channel("1",R.drawable.abcnews,"ABC News");
        channelArrayList.add(channel);

        channel = new Channel("2",R.drawable.alljazeera,"All Jazeera");
        channelArrayList.add(channel);

        channel = new Channel("3",R.drawable.bbc,"BBC News");
        channelArrayList.add(channel);

        channel = new Channel("4",R.drawable.buzzfeed,"Buzzfeed");
        channelArrayList.add(channel);

        channel = new Channel("5",R.drawable.cnbc,"CNBC");
        channelArrayList.add(channel);

        channel = new Channel("6",R.drawable.cnn,"CNN");
        channelArrayList.add(channel);

        channel = new Channel("7",R.drawable.cryptocurrency,"Crytpo Currency");
        channelArrayList.add(channel);

        channel = new Channel("8",R.drawable.daily_mail,"Daily Mail");
        channelArrayList.add(channel);

        channel = new Channel("9",R.drawable.entertainment_weekly,"Entertainment Weekly");
        channelArrayList.add(channel);

        channel = new Channel("10",R.drawable.espn,"ESPN Cricket");
        channelArrayList.add(channel);

        channel = new Channel("11",R.drawable.fox_news,"Fox News");
        channelArrayList.add(channel);

        channel = new Channel("12",R.drawable.fox_sports,"Fox Sports");
        channelArrayList.add(channel);

        channel = new Channel("13",R.drawable.google,"Google");
        channelArrayList.add(channel);

        channel = new Channel("14",R.drawable.metro,"Metro");
        channelArrayList.add(channel);

        channel = new Channel("15",R.drawable.mtv,"MTV News");
        channelArrayList.add(channel);

        channel = new Channel("16",R.drawable.news24,"News24");
        channelArrayList.add(channel);

        channel = new Channel("17",R.drawable.the_hindu,"The Hindu");
        channelArrayList.add(channel);

        channel = new Channel("18",R.drawable.time,"Time");
        channelArrayList.add(channel);

        channel = new Channel("19",R.drawable.timesofindia,"Times Of India");
        channelArrayList.add(channel);

        channel = new Channel("20",R.drawable.washington_times,"Washington Times");
        channelArrayList.add(channel);

        }
}


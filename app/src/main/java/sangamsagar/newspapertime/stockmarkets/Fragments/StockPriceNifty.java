package sangamsagar.newspapertime.stockmarkets.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import sangamsagar.newspapertime.Adapter.StockPriceDataAdapter;
import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.stockmarkets.Model.StockPriceObject;

public class StockPriceNifty extends Fragment {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    StockPriceDataAdapter tab1PageAdapter;

    RecyclerView recyclerView;
    ArrayList<StockPriceObject> stockPriceObjects;
    public  static  String URL_FOR_REGISTRATION,URL_FOR_REGISTRATION_ADAPTER;

    TextView time,change,percentchange,open,todayshigh,todayslow,weekhigh,weeklow,previousclose,declines,advances;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stock_price_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        stockPriceObjects = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        setting_the_urls(view);

    }
    public  void  setting_the_urls(View view) {

        time =(TextView) view.findViewById(R.id.time);
        open =(TextView) view.findViewById(R.id.open);
        change =(TextView) view.findViewById(R.id.change);
        percentchange =(TextView) view.findViewById(R.id.percentchange);
        todayshigh =(TextView) view.findViewById(R.id.todayshigh);
        todayslow =(TextView) view.findViewById(R.id.todayslow);
        weekhigh =(TextView) view.findViewById(R.id.weekhigh);
        weeklow =(TextView) view.findViewById(R.id.weeklow);
        previousclose =(TextView) view.findViewById(R.id.previousclose);
        declines =(TextView) view.findViewById(R.id.declines);
        advances =(TextView) view.findViewById(R.id.advances);
        URL_FOR_REGISTRATION = "http://appfeeds.moneycontrol.com/jsonapi/market/indices&ind_id=9";
        URL_FOR_REGISTRATION_ADAPTER="https://appfeeds.moneycontrol.com/jsonapi/market/marketmap&format=&type=0&ind_id=9";

        get_news();
        get_news_companies();

        tab1PageAdapter = new StockPriceDataAdapter(getContext(),stockPriceObjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(tab1PageAdapter);
        tab1PageAdapter.notifyDataSetChanged();

    }
    public  void  get_news()
    { mRequestQueue = Volley.newRequestQueue(getContext());
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject j1 = null;
                try {
                    JSONObject jObj = new JSONObject(response.trim());
                    JSONObject jsonArray =   jObj.getJSONObject("indices");

                    String stkexchg1 = jsonArray.getString("stkexchg");
                    String exchange1 = jsonArray.getString("exchange");
                    String lastprice1 = jsonArray.getString("lastprice");
                    String change1 = jsonArray.getString("change");
                    String percentage1 = jsonArray.getString("percentchange");
                    String direction1 = jsonArray.getString("direction");
                    String open1 = jsonArray.getString("open");
                    String high1 = jsonArray.getString("high");
                    String low1 = jsonArray.getString("low");
                    String prevclose1 = jsonArray.getString("prevclose");
                    String yearlyhigh1 = jsonArray.getString("yearlyhigh");
                    String yearlylow1 = jsonArray.getString("yearlylow");
                    String ytd1 = jsonArray.getString("ytd");
                    String lastupdated1 = jsonArray.getString("lastupdated");

                    change.setText(change1);
                    previousclose.setText(prevclose1);
                    percentchange.setText(percentage1);
                    todayshigh.setText(high1);
                    todayslow.setText(low1);
                    time.setText(lastupdated1);
                    open.setText(open1);

                }catch (JSONException e1) {
                    e1.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),"You have got the error here", Toast.LENGTH_LONG).show();//display the response on screen

                Log.i("Findingtheerroe","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
    public  void get_news_companies()
    {
        mRequestQueue = Volley.newRequestQueue(getContext());
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION_ADAPTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject j1 = null;
                try {
                    JSONObject jObj = new JSONObject(response.trim());
                    JSONArray jsonArray =   jObj.getJSONArray("item");

                    for(int i=0;i<jsonArray.length();i++) {

                        JSONObject  jj = jsonArray.getJSONObject(i);
                        String company = jj.getString("shortname");
                        String price = jj.getString("lastvalue");
                        String change = jj.getString("change");
                        String percent_change = jj.getString("percentchange");

                        StockPriceObject stockPriceObject1 = new StockPriceObject(company,price,change,percent_change);
                        stockPriceObjects.add(stockPriceObject1);

                    }
                    Log.d("StockPriceSensex",Integer.toString(jsonArray.length()));
                    tab1PageAdapter = new StockPriceDataAdapter(getContext(),stockPriceObjects);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(tab1PageAdapter);
                    tab1PageAdapter.notifyDataSetChanged();

                }
                catch (JSONException e1) {
                    e1.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),"You have got the error here", Toast.LENGTH_LONG).show();//display the response on screen

                Log.i("Findingtheerroe","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
}


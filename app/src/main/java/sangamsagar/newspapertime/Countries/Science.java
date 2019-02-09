package sangamsagar.newspapertime.Countries;

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

import sangamsagar.newspapertime.Adapter.Tab1PageAdapter;
import sangamsagar.newspapertime.Model.Tab1Object;
import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.URL;

public class Science extends Fragment {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    Tab1PageAdapter tab1PageAdapter;

    RecyclerView recyclerView;
    ArrayList<Tab1Object> locations;

    public static  String URL_FOR_REGISTRATION;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        locations=  new ArrayList<>();
        recyclerView =  (RecyclerView) view.findViewById(R.id.recycler_view);

        setting_the_urls();
        get_news();



        tab1PageAdapter = new Tab1PageAdapter(getContext(), locations);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(tab1PageAdapter);
        tab1PageAdapter.notifyDataSetChanged();
    }

    public  void  setting_the_urls() {
        URL_FOR_REGISTRATION = URL.science_india;

    }
    public  void  get_news()
    {
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(getContext());

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject j1 = null;
                try {
                    JSONObject jObj = new JSONObject(response.trim());
                    JSONArray jsonArray =   jObj.getJSONArray("articles");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jj = jsonArray.getJSONObject(i);
                        String author = jj.getString("author");
                        String title = jj.getString("title");
                        String description = jj.getString("description");
                        String published = jj.getString("publishedAt");
                        String content = jj.getString("content");
                        String url_image= jj.getString("urlToImage");
                        String url = jj.getString("url");



                        Tab1Object tab1Object = new Tab1Object(author,title,description,published,content,url_image,url);
                        locations.add(tab1Object);

                        Log.d("MainActivitySuccess11",content);
                    }
                    tab1PageAdapter = new Tab1PageAdapter(getContext(), locations);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                    recyclerView.setAdapter(tab1PageAdapter);
                    tab1PageAdapter.notifyDataSetChanged();
                }catch (JSONException e1) {
                    e1.printStackTrace();

                }


                //   Toast.makeText(getContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen



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



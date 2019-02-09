package sangamsagar.newspapertime;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewActivityCreatedTesting extends AppCompatActivity implements OnChartGestureListener,OnChartValueSelectedListener {
    private RecyclerView mRecyclerView;
    private LineChart lineChart;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    RadioGroup radioGroup;
    RadioButton c1,c2,c3,c4,c5,c6,c7,c8,c9;


    public String URL_FOR_REGISTRATION ;
    public NewActivityCreatedTesting() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_graphs_realtime);

        //methods
         set_urls();
        // plotting_graph();
         clicking_any_checkboxes();


    }

    public  void set_urls()
    {

        radioGroup =(RadioGroup)  findViewById(R.id.radioGroup);

        c1 =(RadioButton)  findViewById(R.id.c1);
        c2 =(RadioButton)  findViewById(R.id.c2);
        c3 =(RadioButton)  findViewById(R.id.c3);
        c4 =(RadioButton)  findViewById(R.id.c4);
        c5 =(RadioButton)  findViewById(R.id.c5);
        c6 =(RadioButton)  findViewById(R.id.c6);
        c7 =(RadioButton)  findViewById(R.id.c7);
        c8 =(RadioButton)  findViewById(R.id.c8);
        c9 =(RadioButton)  findViewById(R.id.c9);



        URL_FOR_REGISTRATION= URL.sensex;



      /*  lineChart.setOnChartGestureListener(this);
        lineChart.setOnChartValueSelectedListener(this);*/

        lineChart =(LineChart) findViewById(R.id.linecharts);

        lineChart.setOnChartGestureListener((this));
        lineChart.setOnChartValueSelectedListener((this) );

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
/*
        AsyncTaskRunner runner = new AsyncTaskRunner();
        String sleepTime = "1";
        runner.execute(sleepTime);*/
        new AsyncTaskRunner().execute();
    }
    public void plotting_graph()
    {

        //RequestQueue initialized
        final ArrayList<Entry> yvalues = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject j1 = null;
                try {
                    JSONObject jObj = new JSONObject(response.trim());
                    JSONObject jj1 = jObj.getJSONObject("graph");
                    JSONArray jsonArray =   jj1.getJSONArray("values");
                    for(int i=0;i<10;i++)
                    {
                        JSONObject jj = jsonArray.getJSONObject(i);
                        String time = jj.getString("_time");
                        time = time.replace(':','.');
                        String value = jj.getString("_value");
                        Log.d("newActivityCreatedTesti", value);

                        yvalues.add(new Entry(Float.valueOf(time), Float.valueOf(value)));
                    }
                        LineDataSet set1 = new LineDataSet(yvalues, "Data Set 1");
                        set1.setFillAlpha(110);
                        set1.setColor(Color.RED);
                        set1.setLineWidth(3f);
                        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
                        lineDataSets.add(set1);

                        LineData data = new LineData(lineDataSets);
                        lineChart.setData(data);
                        //
                }catch (JSONException e1) {
                    e1.printStackTrace();

                }


                //   Toast.makeText(getContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(NewActivityCreatedTesting.this,"You have got the error here", Toast.LENGTH_LONG).show();//display the response on screen

                Log.i("Findingtheerroe","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
        }
        public  void clicking_any_checkboxes()
        {
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_1day;
                    plotting_graph();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_5days;
                    plotting_graph();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_1month;
                    plotting_graph();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_3months;
                    plotting_graph();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_6months;
                    plotting_graph();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_1year;
                    plotting_graph();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_2years;
                    plotting_graph();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_5years;
                    plotting_graph();
                }
            });
            c9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    URL_FOR_REGISTRATION = URL.sensex_max;
                    plotting_graph();
                }
            });
        }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.d("ChartEstureStart","");

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.d("ChartEstureStart","");
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        Log.d("ChartGestureEnd","");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        Log.d("ChartDoubleTapped","");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        Log.d("ChartSingleTap","");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        Log.d("OnChartFilling","");
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        Log.d("OnChartScale","");
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        Log.d("OnChartTranslate","");
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.d("onValueSelected","");
    }

    @Override
    public void onNothingSelected() {
        Log.d("onNothingSelected","");
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;
                plotting_graph();

            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
          //  finalResult.setText(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(NewActivityCreatedTesting.this,
                    "ProgressDialog",
                    "Wait for "+"5" + "seconds");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            //finalResult.setText(text[0]);

        }
    }

}
package sangamsagar.newspapertime.stockmarkets.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import sangamsagar.newspapertime.R;

public class StockGraphsRealtime extends Fragment {

    private LineChart lineChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stock_graphs_realtime, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(),"Entering here",Toast.LENGTH_SHORT).show();
        lineChart =(LineChart) view.findViewById(R.id.linecharts);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        ArrayList<Entry> yvalues = new ArrayList<>();

        yvalues.add(new Entry(0,60f));
        yvalues.add(new Entry(1,50f));
        yvalues.add(new Entry(2,40f));
        yvalues.add(new Entry(3,80f));
        yvalues.add(new Entry(4,100f));
        yvalues.add(new Entry(5,90f));
        yvalues.add(new Entry(6,80f));
        yvalues.add(new Entry(7,40f));

        LineDataSet set1 = new LineDataSet(yvalues, "Data Set 1");
        set1.setFillAlpha(110);

        set1.setColor(Color.RED);
        set1.setLineWidth(3f);
        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        lineDataSets.add(set1);

        LineData data = new LineData(lineDataSets);
        lineChart.setData(data);

        }

    public  void  get_news()
    {

    }
}

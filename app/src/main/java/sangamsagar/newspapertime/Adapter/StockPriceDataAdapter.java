package sangamsagar.newspapertime.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.stockmarkets.Model.StockPriceObject;

public class StockPriceDataAdapter extends RecyclerView.Adapter<StockPriceDataAdapter.EmployeeViewHolder> {

    Typeface face1, face2;
    private Context context;

    private ArrayList<StockPriceObject> employees;
    public StockPriceDataAdapter(Context context, ArrayList<StockPriceObject> employees) {
        this.context = context;
        this.employees = employees;

    }

    @NonNull
    @Override
    public StockPriceDataAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StockPriceDataAdapter.EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.company_details_stock_price_adapter,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StockPriceDataAdapter.EmployeeViewHolder holder, int position) {
        final StockPriceObject employee = employees.get(position);

        holder.company1.setText(employee.getComapny());
        holder.price.setText(employee.getPrice());
        holder.charge.setText(employee.getChange());
        holder.charge_percent.setText(employee.getPercentchange());

        face1 = Typeface.createFromAsset(context.getAssets(), "fonts/sairasemibold.ttf");
        face2 = Typeface.createFromAsset(context.getAssets(), "fonts/sairaregular.ttf");

       /* holder.company1.setTypeface(face2);
        holder.price.setTypeface(face2);
        holder.charge_percent.setTypeface(face2);
        holder.charge.setTypeface(face2);*/

    }

    @Override
    public int getItemCount() {
        return employees != null ? employees.size() : 0;
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        String url1;

        @BindView(R.id.company1)
        TextView company1;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.charge)
        TextView charge;

        @BindView(R.id.charge_percent)
        TextView charge_percent;


        public EmployeeViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            StockPriceObject employee = employees.get(position);
            if (employee != null) {

            }
        }


    }       }
package sangamsagar.newspapertime.Adapter;

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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import sangamsagar.newspapertime.Model.Tab1Object;
import sangamsagar.newspapertime.R;
import sangamsagar.newspapertime.TabFragments.DisplayingTheDetails;

public class Tab1PageAdapter extends RecyclerView.Adapter<Tab1PageAdapter.EmployeeViewHolder> {

    Typeface face1, face2;
    private Context context;
    String utl_data;
    WebView webview;

    private ArrayList<Tab1Object> employees;

    FragmentManager fragmentManager;

    public Tab1PageAdapter(Context context, ArrayList<Tab1Object> employees) {
        this.context = context;
        this.employees = employees;

    }

    @NonNull
    @Override
    public Tab1PageAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Tab1PageAdapter.EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.tab1_adapter,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final Tab1Object employee = employees.get(position);
        holder.content.setText(employee.getContent());
        holder.title.setText(employee.getTitle());
        holder.author.setText(employee.getAuthor());
        holder.description.setText(employee.getDescription());
        utl_data = employee.getUrl();

        String des = employee.getPublished();
        String s = des.substring(0, des.indexOf('T'));
//        s = s + "\n" + des.substring(des.indexOf('T') + 1, des.indexOf('.'));

        holder.published.setText(s);

        holder.published.setTypeface(face2);

        face1 = Typeface.createFromAsset(context.getAssets(), "fonts/sairasemibold.ttf");
        face2 = Typeface.createFromAsset(context.getAssets(), "fonts/sairaregular.ttf");

        holder.title.setTypeface(face1);
        holder.description.setTypeface(face2);
        holder.content.setTypeface(face2);

        String url = employee.getUrl_image();
        Picasso.get().load(url).centerCrop().fit().into(holder.imageView);
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
        @BindView(R.id.content)
        TextView content;

        @BindView(R.id.author)
        TextView author;

        @BindView(R.id.description)
        TextView description;

        @BindView(R.id.published)
        TextView published;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.image)
        ImageView imageView;

       /* @BindView(R.id.webview)
        WebView webview;*/

        public EmployeeViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Tab1Object employee = employees.get(position);
            if (employee != null) {


                Intent intent = new Intent(context, DisplayingTheDetails.class);
                intent.putExtra("url", utl_data);

                // callint_webview(utl_data);
                context.startActivity(intent);
                //context.startActivity(new Intent(context, DisplayingTheDetails.class));
            }
        }


      /*  public void callint_webview(String url1) {
            this.url1 = url1;
            WebSettings webSettings = webview.getSettings();
            webSettings.setJavaScriptEnabled(false);
            //improve webView performance
            webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webview.getSettings().setAppCacheEnabled(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setSaveFormData(true);
            webSettings.setEnableSmoothTransition(true);
            webview.loadUrl(url1);
            //force links open in webview only
            webview.setWebViewClient(new MyWebviewClient());
        }

        public class MyWebviewClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().equals(url1.substring(url1.indexOf('w'), url1.lastIndexOf('/')))) {
                    Toast.makeText(context, "enteted here", Toast.LENGTH_SHORT).show();
                    // mwebView.loadUrl(url1);
                    //open url contents in webview
                    return false;
                } else {
                    //here open external links in external browser or app
                    //  mwebView.loadUrl(url1);
                    // mwebView.loadUrl(url1);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                    return true;
                }

            }

            //ProgressDialogue
            ProgressDialog pd = null;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pd = new ProgressDialog(context);
                pd.setTitle("Please Wait..");
                pd.setMessage("Website is Loading..");
                pd.show();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();
                super.onPageFinished(view, url);
           *//* startActivity(new Intent(DisplayingTheDetails.this,MainActivity.class));
            finish();*//*
            }
        }
        //goto previous page when pressing back button

   *//* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        Toast.makeText(this,"yes you have entered here",Toast.LENGTH_SHORT).show();
                        webview.goBack();
                    } else {
                        context.finish();
                    }
                    return true;
            }
        }
        //return super.conKeyDown(keyCode, event);
    }*//*
    }*/
    }
}
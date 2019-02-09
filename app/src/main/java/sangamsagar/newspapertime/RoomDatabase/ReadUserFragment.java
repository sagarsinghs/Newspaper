package sangamsagar.newspapertime.RoomDatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sangamsagar.newspapertime.R;

public class ReadUserFragment extends Fragment {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.read_user_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        textView = view.findViewById(R.id.text);

        List<User> users =RoomMainActivity.myAppDatabase.myDataAccessObject().getUsers();

        String info =" ";
        for (User users1: users)
        {
            String id= users1.getId();

            String name=  users1.getName();
            String marks =  users1.getEmail();

            info = info + "\n\n" + id+ "\n\n" + name +"\n\n" + marks;
            Log.d("ReadinguserFragments",info);

            textView.setText(info);
        }

    }
}

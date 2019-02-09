package sangamsagar.newspapertime.RoomDatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sangamsagar.newspapertime.R;

public class DeleteFragment  extends Fragment {

    EditText delete;
    Button  delete_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.delete_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        delete = (EditText) view.findViewById(R.id.id);
        delete_btn =(Button) view.findViewById(R.id.delete);

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String id =delete.getText().toString();

                User user = new User();
                user.setId(id);

                RoomMainActivity.myAppDatabase.myDataAccessObject().deleteUser(user);
                Toast.makeText(getContext(),"user deleted from the list",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

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

public class AddUserFragment  extends Fragment {

    EditText name,surname,marks;
    Button add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.add_user_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        add = (Button) view.findViewById(R.id.add);
        name = (EditText) view.findViewById(R.id.name);
        surname = (EditText) view.findViewById(R.id.surname);
        marks = (EditText) view.findViewById(R.id.marks);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user =  new User();

                user.setId((surname.getText().toString()));
                user.setName(name.getText().toString());
                user.setEmail(marks.getText().toString());

                RoomMainActivity.myAppDatabase.myDataAccessObject().addUser(user);
                Toast.makeText(getContext(),"data added successfully",Toast.LENGTH_SHORT).show();

                name.setText("");
                surname.setText("");
                marks.setText("");



            }
        });


    }


}

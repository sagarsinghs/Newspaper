package sangamsagar.newspapertime;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseMainClass extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    EditText name,surname,marks,id;
    Button done,view,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_main_class);

        name = (EditText) findViewById(R.id.name);
        surname = (EditText) findViewById(R.id.surname);
        marks = (EditText) findViewById(R.id.marks);
        done = (Button) findViewById(R.id.done);
        view =(Button)  findViewById(R.id.view_all_button);
        update =(Button) findViewById(R.id.update);
        id = (EditText) findViewById(R.id.id);

        databaseHelper =  new DatabaseHelper(DatabaseMainClass.this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  boolean inserted =databaseHelper.insertData(name.getText().toString(),surname.getText().toString(),marks.getText().toString());

                  if(inserted== true)
                      Toast.makeText(DatabaseMainClass.this,"ddata is isnerted",Toast.LENGTH_SHORT).show();

                  else
                      Toast.makeText(DatabaseMainClass.this,"ddata is not inserted",Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor  res=  databaseHelper.getAllData();
                if(res.getCount()==0)
                {
                    return;
                }
                StringBuffer stringBuffer =new StringBuffer();
                while (res.moveToNext())
                {
                    stringBuffer.append("Id : " + res.getString(0));
                    stringBuffer.append("Name : " + res.getString(1));
                    stringBuffer.append("Surname : " + res.getString(2));
                    stringBuffer.append("Marks : " + res.getString(3));

                    Log.d("Showing the data" ,stringBuffer.toString());

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean  b = databaseHelper.updatedata(id.getText().toString(),name.getText().toString(),surname.getText().toString(),marks.getText().toString());

                if(b== true)
                    Toast.makeText(DatabaseMainClass.this,"ddata is updatd",Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(DatabaseMainClass.this,"ddata is not updated",Toast.LENGTH_SHORT).show();

            }
        });

    }
}

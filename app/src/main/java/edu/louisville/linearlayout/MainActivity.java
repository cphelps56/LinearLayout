package edu.louisville.linearlayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        EditText etName = (EditText) findViewById(R.id.editTextName);
        EditText etCity = (EditText) findViewById(R.id.editTextCity);
        EditText etState = (EditText) findViewById(R.id.editTextState);
        EditText etZip = (EditText) findViewById(R.id.editTextZip);

        String Name = etName.getText().toString();
        String City = etCity.getText().toString();
        String State = etState.getText().toString();
        String Zip = etZip.getText().toString();

        String[] ProfileStrings = {Name, City, State, Zip};

        String filename = "myfile";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            for (String S: ProfileStrings) {
                Log.d("file",S);
               outputStream.write(S.getBytes());
            }
            outputStream.close();

            Toast toast = Toast.makeText(this, "Data was submitted",Toast.LENGTH_SHORT);
            toast.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package my.assignment.employeeapp;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Employee emp;
    SQLiteHelper db;
    EditText edText,edText2;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new SQLiteHelper(this);
        // drop this database if already exists
        db.onUpgrade(db.getWritableDatabase(), 1, 2);


        edText=(EditText) findViewById(R.id.editText);
        edText2=(EditText) findViewById(R.id.editText2);
        imageView=(ImageView)findViewById(R.id.imageView);

        emp=new Employee("Jhon Doe",28, BitmapFactory.decodeResource(
                getResources(), R.drawable.employee));
        db.insertEmployee(emp);

        emp=null;
        emp=db.getEmployee();
        edText.setText(emp.getName());
        edText2.setText(emp.getAge()+"");
        imageView.setImageBitmap(emp.getPhoto());




    }
}
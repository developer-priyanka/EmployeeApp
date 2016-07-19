package my.assignment.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 7/18/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="employeeDB";
    private static final String TB_NAME="employee";
    private static final String COL_ID="id";
    private static final String COL_NAME="empName";
    private static final String COL_AGE="empAge";
    private static final String COL_IMAGE="image";
    public String [] columns=new String[]{COL_ID,COL_NAME,COL_AGE,COL_IMAGE};


    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="Create Table "+TB_NAME+"("+COL_ID+"  Integer Primary Key AutoIncrement,"+ COL_NAME+"  Text NOT NULL ,"+COL_AGE+"  Integer" +
                " NOT NULL,"+COL_IMAGE+" BLOB)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TB_NAME);
        this.onCreate(sqLiteDatabase);


    }


    public void insertEmployee(Employee emp) {
        // get reference of the EmployeeDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(COL_NAME, emp.getName());
        values.put(COL_AGE, emp.getAge());
        values.put(COL_IMAGE,Utility.getBytes(emp.getPhoto()));


        // insert employee
        db.insert(TB_NAME, null, values);

        // close database transaction
        db.close();
    }
    public void updateEmployee(){

    }

    public  Employee getEmployee(){
        String select="select * from "+TB_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        Employee emp=null;

        if (cursor.moveToFirst()) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(COL_IMAGE));
            String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(COL_AGE));
            cursor.close();
            return new Employee(name, age,Utility.getPhoto(blob));
        }
        return emp;


    }

}

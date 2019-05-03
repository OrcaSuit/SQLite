package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView titleView=(TextView)findViewById(R.id.read_title);
        TextView contentview=(TextView)findViewById(R.id.read_content);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor= db.rawQuery("select title, content from tb_memo order by _id desc limit 1", null);

        while(((Cursor) cursor).moveToNext()){
            titleView.setText(cursor.getString(0));
            contentview.setText(cursor.getString(1));
        }
        db.close();
    }
}

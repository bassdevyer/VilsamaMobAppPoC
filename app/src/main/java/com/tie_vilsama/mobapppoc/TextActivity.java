package com.tie_vilsama.mobapppoc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tie_vilsama.mobapppoc.db.TestDBContract;
import com.tie_vilsama.mobapppoc.db.TestDBHelper;

import java.util.logging.Logger;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Logger logger = Logger.getLogger(TextActivity.class.getName());

        // Recuperar informacion de la base
        TestDBHelper testDBHelper = new TestDBHelper(this);
        SQLiteDatabase db = testDBHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TestDBContract.TestTable._ID, 1);
        contentValues.put(TestDBContract.TestTable.COLUMN_NAME_TEXT, "Esto es una prueba");
        Long affectedRows = db.insert(TestDBContract.TestTable.TABLE_NAME, null, contentValues);
        logger.info(affectedRows + " columnas insertadas!!!!!!!!!");
        String[] columns = {TestDBContract.TestTable.COLUMN_NAME_TEXT};
        Cursor cursor = db.query(TestDBContract.TestTable.TABLE_NAME, columns, null, null, null, null, null, null);
        cursor.moveToFirst();
        String retrievedText = cursor.getString(cursor.getColumnIndex(TestDBContract.TestTable.COLUMN_NAME_TEXT));

        if(retrievedText != null && !retrievedText.isEmpty()){
            TextView textView = (TextView) findViewById(R.id.activity_text_text_textview);
            textView.setText(retrievedText);
        }
    }
}

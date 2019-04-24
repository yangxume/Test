package com.xy.test_contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText ageText;
    private EditText heightText;
    private EditText idEntry;

    private TextView labelView;
    private TextView displayView;

    private ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.name);
        ageText = (EditText) findViewById(R.id.age);
        heightText = (EditText) findViewById(R.id.hight);
        idEntry = (EditText) findViewById(R.id.id);

        labelView = (TextView) findViewById(R.id.label);
        displayView = (TextView) findViewById(R.id.display);
        Button addButton = (Button) findViewById(R.id.button1);
        Button queryAllButton = (Button) findViewById(R.id.button2);
        Button clearButton = (Button) findViewById(R.id.button3);
        Button queryButton = (Button) findViewById(R.id.button6);
        Button deleteButton = (Button) findViewById(R.id.button5);
        Button updateButton = (Button) findViewById(R.id.button7);

        resolver = this.getContentResolver();

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ContentValues values = new ContentValues();

                values.put(People.KEY_NAME, nameText.getText().toString());
                values.put(People.KEY_AGE,
                        Integer.parseInt(ageText.getText().toString()));
                values.put(People.KEY_HEIGHT,
                        Float.parseFloat(heightText.getText().toString()));

                Uri newUri = resolver.insert(People.CONTENT_URI, values);
                labelView.setText("添加成功，URI:" + newUri);

            }
        });
        queryAllButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Cursor cursor = resolver.query(People.CONTENT_URI,
                        new String[]{People.KEY_ID, People.KEY_NAME,
                                People.KEY_AGE, People.KEY_HEIGHT}, null,
                        null, null);
                if (cursor == null) {
                    labelView.setText("数据库中没有数据");
                    return;
                }
                labelView.setText("数据库：" + String.valueOf(cursor.getCount())
                        + "条记录");

                String msg = "";
                if (cursor.moveToFirst()) {
                    do {
                        msg += "ID："
                                + cursor.getInt(cursor
                                .getColumnIndex(People.KEY_ID)) + "，";
                        msg += "姓名："
                                + cursor.getString(cursor
                                .getColumnIndex(People.KEY_NAME)) + "，";
                        msg += "年龄："
                                + cursor.getInt(cursor
                                .getColumnIndex(People.KEY_AGE)) + "， ";
                        msg += "身高："
                                + cursor.getFloat(cursor
                                .getColumnIndex(People.KEY_HEIGHT))
                                + "\n";
                    } while (cursor.moveToNext());
                }

                displayView.setText(msg);

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                displayView.setText("");
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/"
                        + idEntry.getText().toString());
                Cursor cursor = resolver.query(uri, new String[]{
                        People.KEY_ID, People.KEY_NAME, People.KEY_AGE,
                        People.KEY_HEIGHT}, null, null, null);
                if (cursor == null) {
                    labelView.setText("数据库中没有数据");
                    return;
                }

                String msg = "";
                if (cursor.moveToFirst()) {
                    msg += "ID："
                            + cursor.getInt(cursor
                            .getColumnIndex(People.KEY_ID)) + "，";
                    msg += "姓名："
                            + cursor.getString(cursor
                            .getColumnIndex(People.KEY_NAME)) + "，";
                    msg += "年龄："
                            + cursor.getInt(cursor
                            .getColumnIndex(People.KEY_AGE)) + "， ";
                    msg += "身高："
                            + cursor.getFloat(cursor
                            .getColumnIndex(People.KEY_HEIGHT)) + "\n";
                }

                labelView.setText("数据库：");
                displayView.setText(msg);

            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/"
                        + idEntry.getText().toString());
                int result = resolver.delete(uri, null, null);
                String msg = "删除ID为" + idEntry.getText().toString() + "的数据"
                        + (result > 0 ? "成功" : "失败");
                labelView.setText(msg);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ContentValues values = new ContentValues();
                values.put(People.KEY_NAME, nameText.getText().toString());
                values.put(People.KEY_AGE,
                        Integer.parseInt(ageText.getText().toString()));
                values.put(People.KEY_HEIGHT,
                        Float.parseFloat(heightText.getText().toString()));

                Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/"
                        + idEntry.getText().toString());
                int result = resolver.update(uri, values, null, null);

                String msg = "更新ID为" + idEntry.getText().toString() + "的数据"
                        + (result > 0 ? "成功" : "失败");
                labelView.setText(msg);

            }
        });
    }
}

package com.example.playmaker.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayat);

        Intent data = getIntent();
        int homeItem = data.getExtras().getInt("Home");
        if (homeItem == 0) {
            ListView listView = (ListView) findViewById(R.id.listHayat);
            String[] array = getResources().getStringArray(R.array.hayatArray);

            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row_item, R.id.textItem, array);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("Home2", position);
                    startActivity(intent);
                }
            });
        }
    }
}

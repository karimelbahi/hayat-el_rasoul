package com.example.playmaker.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////////////
        ListView listView = (ListView) findViewById(R.id.list);
        String[] array = getResources().getStringArray(R.array.HomeArray);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row_item, R.id.textItem, array);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position < 1) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("Home", position);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                    intent.putExtra("Home", position + 10);
                    startActivity(intent);
                }
            }
        });
    }

    public void imagShare(View view) {
        String txtShare = "مقتطفات من سيرة الرسول";
        String shareLinke = "https://drive.google.com/open?id=1z0F_e5Cqt1bWWgYz9npIc-MZUqhbgwjn";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, txtShare + "\n" + shareLinke);
        startActivity(share);
    }

    public void imagMore(View view) {
        Intent moreApp = new Intent(Intent.ACTION_VIEW);
        moreApp.setData(Uri.parse("https://drive.google.com/open?id=1sprNJE__2r7HuChNDTDwIcbFV9rPzJ8L"));
        startActivity(moreApp);
    }

    public void imagMessage(View view) {
        try {
            String txt = "السلام عليكم ورحمه الله وبركاته" + "\n" + "اقتراحي هو :";
            Intent sendEmail = new Intent(Intent.ACTION_SEND);
            sendEmail.setData(Uri.parse("mailto:"));
            sendEmail.setType("message/rfc822");
            sendEmail.putExtra(Intent.EXTRA_EMAIL, "karimmaster333@gmail.com");
            sendEmail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق عن حياه الرسول");
            sendEmail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendEmail);
        } catch (Exception e) {
            Toast.makeText(this, "عذرا لايوجد بريد الكتروني", Toast.LENGTH_SHORT).show();
        }
    }

    public void imagClose(View view) {
        Toast.makeText(this, "جميع البيانات منقوله عبر الانترنت ", Toast.LENGTH_SHORT).show();
        finish();
    }
}
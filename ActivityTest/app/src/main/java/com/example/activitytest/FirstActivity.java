package com.example.activitytest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class FirstActivity extends BaseActivity {

    private String url = "http://dl.stream.qqmusic.qq.com/M8000036g6g628i2gI" +
            ".mp3?vkey=5F9F8DB8D4F9E61C9209C097B8195C4356004BA1F63BA68A2FD518230E46D1798106DB821DE5941EDBB5B0E1CFB1F9EE8A5F2C6B10C25EA5&guid=5150825362&fromtag=1";

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is " + getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast.makeText(FirstActivity.this,"You clicked Button One",Toast.LENGTH_SHORT).show();
//              finish();
//              Intent intent = new Intent("com.example.activitytest.ACTION_START");
//              Intent intent = new Intent(Intent.ACTION_VIEW);
//              intent.setData(Uri.parse("http://www.baidu.com"));
//              intent.addCategory("com.example.activitytest.MY_CATEGORY");
//              startActivity(intent);
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mediaPlayer.setDataSource(url);
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart: ");
    }
}

package com.example.qmuipractice;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qmuipractice.model.lesson;
import com.example.qmuipractice.util.GsonUtil;
import com.example.qmuipractice.util.HttpUtil;
import com.example.qmuipractice.util.MyContants;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StartActivity extends AppCompatActivity {

    private ListView listView;
    private List<lesson> list;
    private int id;
    private String url;
    private Map<String, String> getIdInfo = new HashMap<String, String>();
    private Map<String, String> getLessonInfo = new HashMap<String, String>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        listView=(ListView) findViewById(R.id.ListView);
        try{
            String result= HttpUtil.getRequest(MyContants.BASE_URL+"LessonServlet");
            if(result==null)
            {
                Toast.makeText(StartActivity.this, "没有信息或网络出现问题", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                list = GsonUtil.getGson().fromJson(result, new TypeToken<List<lesson>>(){}.getType());
                List<String> InfoList = new ArrayList<String>();
                for (lesson d:list){
                    InfoList.add("编号："+d.getId()+"课程："+d.getLesson()+"\n标题："+d.getTittle());
                }
                listView.setAdapter(new MyAdapter(InfoList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                        id = list.get(position).getId();
                        url = list.get(position).getUrl();
                        System.out.println("--2--" + url);

                        MediaPlayer mediaPlayer = MediaPlayer.create(StartActivity.this, Uri.parse(url));
                        mediaPlayer.setLooping(false); // Loop
                        mediaPlayer.start(); // Play Sound
                    }
                });
            }
    } catch (Exception e) {
            Toast.makeText(StartActivity.this, "缃戠粶鍑虹幇闂", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }
    }

    class MyAdapter extends BaseAdapter {
        private List<String> list;

        public MyAdapter(List<String> list){
            this.list = list;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return list.get(arg0);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(StartActivity.this);
            textView.setTextSize(20);
            textView.setText(list.get(position));
            return textView;
        }

    }
}



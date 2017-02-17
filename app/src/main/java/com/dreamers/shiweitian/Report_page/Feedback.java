package com.dreamers.shiweitian.Report_page;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.R;

import java.util.ArrayList;

/**
 * Created by stzha on 2017/1/9.
 */

public class Feedback extends AppCompatActivity {
    // 声明ListView控件
    private ListView mListView,mListView2;
    // 声明数组链表，其装载的类型是ListItem(封装了一个Drawable和一个String的类)
    private ArrayList<Feedback.ListItem> mList, mList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.back);
        actionBar.setTitle("             举报跟踪");


        // 通过findviewByID获取到ListView对象
        mListView=(ListView)findViewById(R.id.listView1);
        mListView.setEnabled(false);//xiugai
        // 获取Resources对象
        Resources res = this.getResources();
        mList = new ArrayList<Feedback.ListItem>();
        // 初始化data，装载八组数据到数组链表mList中
        Feedback.ListItem item = new Feedback.ListItem();
        //  item.setImage(res.getDrawable(R.drawable.jubao_chanpin));
        item.setTitle("处理中");
        mList.add(item);
        // 获取MainListAdapter对象
        Feedback.MainListViewAdapter adapter = new Feedback.MainListViewAdapter();
        // 将MainListAdapter对象传递给ListView视图
        mListView.setAdapter(adapter);

        // 通过findviewByID获取到ListView对象
        mListView2=(ListView)findViewById(R.id.listView2);
        // 获取Resources对象
        Resources res2 = this.getResources();
        mList2 = new ArrayList<Feedback.ListItem>();
        // 初始化data，装载八组数据到数组链表mList中
        Feedback.ListItem item2 = new Feedback.ListItem();
        item2.setImage(res2.getDrawable(R.drawable.jubao_chanpin));
        item2.setTitle("华莱士");
        mList2.add(item2);
        // 获取MainListAdapter对象
        Feedback.MainListViewAdapter adapter2 = new Feedback.MainListViewAdapter();
        // 将MainListAdapter对象传递给ListView视图
        mListView2.setAdapter(adapter2);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Feedback.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    /**
     * 定义ListView适配器MainListViewAdapter
     */
    class MainListViewAdapter extends BaseAdapter {

        /**
         * 返回item的个数
         */
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mList.size();
        }

        /**
         * 返回item的内容
         */
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return mList.get(position);
        }

        /**
         * 返回item的id
         */
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        /**
         * 返回item的视图
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Feedback.ListItemView listItemView;

            // 初始化item view
            if (convertView == null) {
                // 通过LayoutInflater将xml中定义的视图实例化到一个View中
                convertView = LayoutInflater.from(Feedback.this).inflate(
                        R.layout.items, null);

                // 实例化一个封装类ListItemView，并实例化它的两个域
                listItemView = new Feedback.ListItemView();
                listItemView.imageView = (ImageView) convertView
                        .findViewById(R.id.image);
                listItemView.textView = (TextView) convertView
                        .findViewById(R.id.title);

                // 将ListItemView对象传递给convertView
                convertView.setTag(listItemView);
            } else {
                // 从converView中获取ListItemView对象
                listItemView = (Feedback.ListItemView) convertView.getTag();
            }
            // 获取到mList中指定索引位置的资源
            Drawable img = mList.get(position).getImage();
            String title = mList.get(position).getTitle();

            // 将资源传递给ListItemView的两个域对象
            listItemView.imageView.setImageDrawable(img);
            listItemView.textView.setText(title);
            // 返回convertView对象
            return convertView;
        }
    }

    /**
     * 封装两个视图组件的类
     */
    class ListItemView {
        ImageView imageView;
        TextView textView;
    }
    /**
     * 封装了两个资源的类
     */
    class ListItem {
        private Drawable image;
        private String title;
        public Drawable getImage() {
            return image;
        }
        public void setImage(Drawable image) {
            this.image = image;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }




}

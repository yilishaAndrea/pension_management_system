package yilisha.andrea.pda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yilisha.andrea.pda.R;
import yilisha.andrea.pda.transport.Operator;

public class TabManyActivity extends AppCompatActivity{
    private TabLayout tabLayout = null;
    private ViewPager vp_pager;
    private List<View> view_list = new ArrayList<>();
    private Button addPackage;
    private Button reducePackage;
    private Button smartCreatePackage;
    private Button packageQuery;
    private Button exit;

    private Operator operator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.car);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_layout);
        operator = (Operator) getIntent().getSerializableExtra("operator");
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        vp_pager = (ViewPager) findViewById(R.id.tab_viewpager);
        initView();
    }
    private void initView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //添加页面
        View v = getLayoutInflater().inflate(R.layout.item,null);
        view_list.add(v);
        v = getLayoutInflater().inflate(R.layout.other,null);
        view_list.add(v);

        //绑定适配器
        vp_pager.setAdapter(new MorePagerAdapter());
        tabLayout.setupWithViewPager(vp_pager);
    }
    //设置监听
    public void addPackageClick(View view){
        //1.加包
        Intent intent = new Intent(TabManyActivity.this, AddPackageActivity.class);
        intent.putExtra("operator", operator);
        startActivity(intent);
    }

    public void reducePackageClick(View view){
        //2.减包
        Intent intent = new Intent(TabManyActivity.this, DropPackageActivity.class);
        intent.putExtra("operator", operator);
        startActivity(intent);
    }
    public void smartCreatePackageClick(View view){
        //3.智能建包
        Intent intent = new Intent(TabManyActivity.this, SmartCreatePackageActivity.class);
        intent.putExtra("operator", operator);
        startActivity(intent);

    }
    public void packageQueryClick(View view){
        //4.集包（面单）查询
        Intent intent = new Intent(TabManyActivity.this, PackageQueryActivity.class);
        intent.putExtra("operator", operator);
        startActivity(intent);
    }
    public void exitClick(View view){
        //5.注销
        finish();
    }

    final class MorePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if(position==0){
                View v = view_list.get(position);

                container.addView(v);
                return  v;
            }
            else {
                View v = view_list.get(position);
                container.addView(v);
                return v;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0){
                return "常用功能";
            }
            else {
                return "特殊功能";
            }
        }
    }
}
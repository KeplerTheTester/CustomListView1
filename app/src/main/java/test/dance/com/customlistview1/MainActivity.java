package test.dance.com.customlistview1;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    static List<TestClass> testClassList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        testClassList = new ArrayList<>();
        testClassList.add(new TestClass("The title1","The description1", false));
        testClassList.add(new TestClass("Title2", "Description2 ", true));
        testClassList.add(new TestClass("Title2", "Description2 ", false));
        testClassList.add(new TestClass("Title2", "Description2 ", true));
        testClassList.add(new TestClass("Title2", "Description2 ", false));
        testClassList.add(new TestClass("Title2", "Description2 ", true));
        TestClass pool = new TestClass("trial for ", "Seeing if sign up can change");
        Toast.makeText(this, ""+pool.getSignedUp(), Toast.LENGTH_SHORT).show();
        //pool.setSignedUp(true);
        testClassList.add(pool);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);

        final CustomListAdapter adapter = new CustomListAdapter(this, R.layout.customlayout, testClassList, testClassList);
        //adapter.setColor(true);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "works", Toast.LENGTH_SHORT).show();
                String something = ((TextView) view.findViewById(R.id.title_textView)).getText().toString();
                Toast.makeText(MainActivity.this, something, Toast.LENGTH_SHORT).show();
                adapter.setColor(true);
                if(i ==0)
                {
                    Intent intent = new Intent(MainActivity.this, RefreshTest.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ControlMusic.class);
                    startActivity(intent);
                }
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "It refreshed", Toast.LENGTH_SHORT).show();
                changeStuff();
            }


        });
        if(swipeRefreshLayout.isRefreshing() == true)
        {
            Toast.makeText(this, "is not refreshing", Toast.LENGTH_SHORT).show();
        }
    }
    private void changeStuff()
    {
        testClassList.add(new TestClass("Yep ", "yo", true));
    }
}

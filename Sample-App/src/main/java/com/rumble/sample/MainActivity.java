package com.rumble.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.rumble.sdk.analytics.Class1;
import com.rumble.R;
import com.rumble.sdk.core.LogMessage;
import com.rumble.sdk.core.RumbleEventBus;
import com.rumble.sdk.push.Class2;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
//import javax.inject.Inject;

@EActivity
public class MainActivity extends ActionBarActivity {

    @Bean
    public MyClass dependency;
    private ArrayAdapter<Spannable> mConsoleAdapter;
    @ViewById(R.id.consoleList)
    ListView mConsole;
    private ArrayList<Spannable> mConsoleMessagesList;
    private Class2 c2;
    private Class1 c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RumbleEventBus.getRumbleInstance().register(this);

        initToolbar();
        initConsoleList();
        classInjectionExample();


    }

    public void onEvent(LogMessage event) {
        Log.i(event.getTag(), event.getText().toString());
        mConsoleMessagesList.add(0, event.getText());
        mConsoleAdapter.notifyDataSetChanged();
    }


    private void classInjectionExample() {
        //injection of instance of "dependency" member by androidAnnotations
        int x = dependency.doSomething();
        Log.v("tag", String.valueOf(x));
    }

    private void initConsoleList() {
        mConsoleMessagesList = new ArrayList<Spannable>();

        mConsoleAdapter = new ListAdapter(this,R.layout.item_console,mConsoleMessagesList);//new ArrayAdapter<Spannable>(this,R.layout.item_console, mConsoleMessagesList);
        mConsole.setAdapter(mConsoleAdapter);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);

        //Title and subtitle
        toolbar.setTitle("Rumble SDK");
        toolbar.setSubtitle("Let us show you how it's done...");
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                return true;
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_launcher);


        // Inflate a menu to be displayed in the toolbar
        toolbar.inflateMenu(R.menu.menu_main);
    }


    @Click(R.id.btnAnalyticsSDK)
    void initAnalyticsSDK() {
        c1 = new Class1();
    }

    @Click(R.id.btnPushSDK)
    void initPushSDK() {
        c2 = new Class2();
    }
    @Click(R.id.btnDoSomething)
        // When R.id.doTranslate button is clicked
    void doSomething() {
        RumbleEventBus.getRumbleInstance().post("do something");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

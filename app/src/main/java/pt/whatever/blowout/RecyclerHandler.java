package pt.whatever.blowout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;

public class RecyclerHandler extends Activity implements Runnable {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private HashMap<Integer, Event> events;

    public RecyclerHandler(HashMap<Integer, Event> events) {
        this.events = events;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blowout);
        mRecyclerView = (RecyclerView) findViewById(R.id.cards);

    }

    public void downloadItems(){
        events.put(1,new Event(1, "13 Nov", "https://images.sftcdn.net/images/t_app-cover-l,f_auto/p/ce2ece60-9b32-11e6-95ab-00163ed833e7/260663710/the-test-fun-for-friends-screenshot.jpg"
                , "200m", "0.5Km"));
        events.put(1,new Event(2, "15 Nov", "https://images.sftcdn.net/images/t_app-cover-l,f_auto/p/ce2ece60-9b32-11e6-95ab-00163ed833e7/260663710/the-test-fun-for-friends-screenshot.jpg"
                , "200m", "2Km"));
        events.put(1,new Event(3, "18 Nov", "https://images.sftcdn.net/images/t_app-cover-l,f_auto/p/ce2ece60-9b32-11e6-95ab-00163ed833e7/260663710/the-test-fun-for-friends-screenshot.jpg"
                , "200m", "15Km"));
        events.put(1,new Event(4, "20 Nov", "https://images.sftcdn.net/images/t_app-cover-l,f_auto/p/ce2ece60-9b32-11e6-95ab-00163ed833e7/260663710/the-test-fun-for-friends-screenshot.jpg"
                , "200m", "15Km"));
    }

    @Override
    public void run() {
        downloadItems();
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(events);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }
    // ...
}

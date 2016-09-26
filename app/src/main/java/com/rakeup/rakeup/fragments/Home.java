package com.rakeup.rakeup.fragments;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

import com.rakeup.rakeup.R;
import com.rakeup.rakeup.adapters.CustomEventAdapter;
import com.rakeup.rakeup.objects.Event;
import com.rakeup.rakeup.tools.PullToRefreshListView;

import java.util.ArrayList;

public class Home extends Fragment {


    private PullToRefreshListView lv;
    private CustomEventAdapter customEventAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lv = (PullToRefreshListView) getActivity().findViewById(R.id.lv1);


        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(123, "Conference Meeting Tester Fear About", "ABC Company", 123, 1474370000));
        events.add(new Event(124, "Meeting", "MNB Company", 124, 1474331000));
        events.add(new Event(123, "Conference", "ABC Company", 125, 1474381834));
        events.add(new Event(124, "Meeting", "MNB Company", 126, 1471300000));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));
        events.add(new Event(123, "Conference", "ABC Company"));
        events.add(new Event(124, "Meeting", "MNB Company"));

        customEventAdapter = new CustomEventAdapter(getActivity(), R.layout.custom_event_list, events);

        lv.setAdapter(customEventAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Event e = (Event) adapterView.getItemAtPosition(position);
                Toast.makeText(getActivity(), e.getEventName() + " " + e.getCreatorName(),  Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                customEventAdapter.loadData(events);
                lv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lv.onRefreshComplete();
                    }
                }, 10);
            }
        });

    }

}

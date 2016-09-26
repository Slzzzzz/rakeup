package com.rakeup.rakeup.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakeup.rakeup.R;
import com.rakeup.rakeup.adapters.CustomEventAdapter;
import com.rakeup.rakeup.objects.Event;
import com.rakeup.rakeup.objects.User;
import com.rakeup.rakeup.tools.PullToRefreshListView;

import java.util.ArrayList;

public class Profile extends Fragment {

    User mUser = new User(124, "emre", "emre");    // Get user from remote server !! Update this line

    String username;
    String name;
    byte[] picture;
    TextView tvUsername;
    TextView tvName;
    ImageView ivPicture;

    private PullToRefreshListView lv;
    private CustomEventAdapter customEventAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mUser != null){
            username = mUser.getUsername();
            name = mUser.getName();
            picture = mUser.getPicture();
        }
        return inflater.inflate(R.layout.activity_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvUsername = (TextView) getActivity().findViewById(R.id.txtUsername);
        tvName = (TextView) getActivity().findViewById(R.id.txtName);
        ivPicture = (ImageView) getActivity().findViewById(R.id.profilePicture);

        tvUsername.setText(username);
        tvName.setText(name);

        lv = (PullToRefreshListView) getActivity().findViewById(R.id.lv2);

        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(123, "Conference", "ABC Company", 123));
        events.add(new Event(124, "Meeting", "MNB Company", 124));

        final ArrayList<Event> mEvents = new ArrayList<Event>();
        for (Event e : events) {
            if(e.getUser() == mUser.getId())
                mEvents.add(e);
        }

        customEventAdapter = new CustomEventAdapter(getActivity(), R.layout.custom_event_list, mEvents);

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
                customEventAdapter.loadData(mEvents);
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

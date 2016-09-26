package com.rakeup.rakeup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rakeup.rakeup.R;
import com.rakeup.rakeup.methods.PublicModules;
import com.rakeup.rakeup.objects.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emre on 4.08.16.
 */
public class CustomEventAdapter extends ArrayAdapter<Event> {

    public CustomEventAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CustomEventAdapter(Context context, int resource, List<Event> items) {
        super(context, resource, items);
    }

    public void loadData(ArrayList<Event> events) {
        events.add(0, new Event(123, "Alabama", "AVC Company"));
        events.add(0, new Event(124, "M-ing", "LNB Company"));
        events.add(0, new Event(123, "Con-M", "VVG Company"));
        events.add(0, new Event(124, "MgvC", "MKK Company"));

        // MANDATORY: Notify that the data has changed
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater;

        if (v == null) {
            inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.custom_event_list, null);
        }

        Event e = (Event) getItem(position);

        if (e != null) {
            TextView tvEventName = (TextView) v.findViewById(R.id.txtEventName);
            TextView tvCreatorName = (TextView) v.findViewById(R.id.txtCreatorName);
            TextView tvPassingTime = (TextView) v.findViewById(R.id.passingTime);

            if (tvEventName != null) {
                tvEventName.setText(e.getEventName());
            }

            if (tvCreatorName != null) {
                tvCreatorName.setText(e.getCreatorNameWithByTag());
            }

            if(tvPassingTime != null){
                tvPassingTime.setText(PublicModules.calculatePassingTime(e.getCreateDate(),
                        getContext().getResources().getString(R.string.second),
                        getContext().getResources().getString(R.string.minute),
                        getContext().getResources().getString(R.string.hour),
                        getContext().getResources().getString(R.string.day)));
            }
        }

        return v;
    }

}

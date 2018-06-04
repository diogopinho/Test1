package com.example.diogopinho.test1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;


class Adptr extends ArrayAdapter<String> {

    private ArrayList<String> tvText;

    Adptr(@NonNull Context context, int resource, @NonNull ArrayList<String> tvText) {
        super(context, resource, tvText);
        this.tvText = new ArrayList<>(tvText);
    }

    @NonNull
    @Override
    public Filter getFilter() {

        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence != null) {
                    ArrayList<String> suggestions = new ArrayList<>();
                    String filterPattern = charSequence.toString().toLowerCase().trim();
                    for (String temp : tvText) {
                        if (temp.toLowerCase().contains(filterPattern)) {
                            suggestions.add(temp);
                        }
                    }
                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                }
                return filterResults;
            }

            @Override
            @SuppressWarnings("unchecked")
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults!=null && filterResults.count > 0) {
                    clear();
                    addAll((ArrayList)filterResults.values);
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }
}

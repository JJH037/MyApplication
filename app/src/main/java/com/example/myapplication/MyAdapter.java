package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter implements Filterable {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList (원본 데이터 리스트)
    private ArrayList<Building> listViewItemList = new ArrayList<Building>() ;
    // 필터링된 결과 데이터를 저장하기 위한 ArrayList
    ArrayList<Building> filteredItemList = listViewItemList ;

    @Override
    public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new MyAdapter.ListFilter() ;
        }
        return listFilter ;
    }

    Context context;
    int layout;
    Filter listFilter ;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<Building> building) {
        this.context = context;
        this.layout = layout;
        this.listViewItemList=building;
        this.filteredItemList=building;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return filteredItemList.size();
    }
    @Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent, false);
            //convertView = inf.inflate(layout, null);
        }
        ImageView iv = (ImageView)convertView.findViewById(R.id.BuildingImage);
        TextView BuildingName = (TextView)convertView.findViewById(R.id.BuildingName);
        TextView BuildingNumber = (TextView)convertView.findViewById(R.id.BuildingNumber);
        TextView BuildingInfo = (TextView)convertView.findViewById(R.id.BuildingInfo);
        TextView BuildingOther = (TextView)convertView.findViewById(R.id.BuildingTag);

        Building b = filteredItemList.get(position);
        iv.setImageResource(b.img);
        BuildingName.setText(b.name);
        BuildingNumber.setText(b.num);
        BuildingInfo.setText(b.info);
        BuildingOther.setText(b.tag);

        return convertView;
    }

    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults() ;

            if (constraint == null || constraint.length() == 0) {
                results.values = listViewItemList ;
                results.count = listViewItemList.size() ;
            } else {
                ArrayList<Building> itemList = new ArrayList<Building>() ;

                for (Building item : listViewItemList) {
                    if (item.getName().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                            item.getNum().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                                item.getOther().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item) ;
                    }
                }
                results.values = itemList ;
                results.count = itemList.size() ;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            // update listview by filtered data list.
            filteredItemList = (ArrayList<Building>) results.values ;

            // notify
            if (results.count > 0) {
                notifyDataSetChanged() ;
            } else {
                notifyDataSetInvalidated() ;
            }
        }
    }


}
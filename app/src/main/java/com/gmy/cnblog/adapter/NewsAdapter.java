package com.gmy.cnblog.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmy.cnblog.R;
import com.gmy.cnblog.entity.News;
import com.gmy.cnblog.util.StringUtil;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2015/7/15.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> datas;

    public NewsAdapter(List<News> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_news, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(datas.get(position).getTitle());
        holder.sourceName.setText("出处:"+datas.get(position).getSourceName());
        holder.summary.setText("    "+datas.get(position).getSummary());
        try {
            holder.date.setText(StringUtil.getDateString(datas.get(position).getUpdated()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;//标题
        public TextView sourceName;//出处
        public TextView summary;//简略总结
        public TextView date;//发表日期

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.item_news_title);
            sourceName = (TextView) v.findViewById(R.id.item_news_sourcename);
            summary = (TextView) v.findViewById(R.id.item_news_summary);
            date=(TextView)v.findViewById(R.id.item_news_date);
        }
    }
}

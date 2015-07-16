package com.gmy.cnblog.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmy.cnblog.R;
import com.gmy.cnblog.entity.Blog;
import com.gmy.cnblog.entity.News;
import com.gmy.cnblog.util.StringUtil;
import com.gmy.cnblog.view.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2015/7/15.
 */
public class BlogsAdapter extends RecyclerView.Adapter<BlogsAdapter.ViewHolder> {
    private List<Blog> datas;
    private Context context;

    public BlogsAdapter(Context context, List<Blog> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_blogs, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(Html.fromHtml(datas.get(position).getTitle()));
        holder.sourceName.setText(Html.fromHtml("博主:" + datas.get(position).getUser().getTitle()));
        holder.summary.setText(Html.fromHtml("    " + datas.get(position).getSummary()));
        try {
            holder.date.setText(StringUtil.getDateString(datas.get(position).getPublished()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!datas.get(position).getUser().getAvatar().equals("")) {
            Picasso.with(context).load(datas.get(position).getUser().getAvatar()).into(holder.avator);
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
        public RoundedImageView avator;//博主头像

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.item_news_title);
            sourceName = (TextView) v.findViewById(R.id.item_news_sourcename);
            summary = (TextView) v.findViewById(R.id.item_news_summary);
            date = (TextView) v.findViewById(R.id.item_news_date);
            avator = (RoundedImageView) v.findViewById(R.id.item_news_avator);
        }
    }
}

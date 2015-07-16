package com.gmy.cnblog.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gmy.cnblog.R;
import com.gmy.cnblog.entity.News;
import com.gmy.cnblog.util.StringUtil;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2015/7/15.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements View.OnClickListener {
    private List<News> datas;
    private OnItemClickListener onItemClickListener;

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
        holder.title.setText(Html.fromHtml(datas.get(position).getTitle()));
        holder.sourceName.setText(Html.fromHtml("出处:" + datas.get(position).getSourceName()));
        holder.summary.setText(Html.fromHtml("    " + datas.get(position).getSummary()));
        try {
            holder.date.setText(StringUtil.getDateString(datas.get(position).getPublished()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.reply.setTag(position);
        holder.reply.setOnClickListener(this);
        holder.retweet.setTag(position);
        holder.retweet.setOnClickListener(this);
        holder.favourite.setTag(position);
        holder.favourite.setOnClickListener(this);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            switch (v.getId()) {
                case R.id.item_news_favourite:
                    onItemClickListener.onFavouriteClick(v, (Integer) v.getTag());
                    break;
                case R.id.item_news_reply:
                    onItemClickListener.onReplyClick(v, (Integer) v.getTag());
                    break;
                case R.id.item_news_retweet:
                    onItemClickListener.onRetweetClick(v);
                    break;
            }
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;//标题
        public TextView sourceName;//出处
        public TextView summary;//简略总结
        public TextView date;//发表日期
        public ImageButton retweet;//分享
        public ImageButton reply;//评论
        public ImageButton favourite;//赞，收藏

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.item_news_title);
            sourceName = (TextView) v.findViewById(R.id.item_news_sourcename);
            summary = (TextView) v.findViewById(R.id.item_news_summary);
            date = (TextView) v.findViewById(R.id.item_news_date);
            retweet = (ImageButton) v.findViewById(R.id.item_news_retweet);
            reply = (ImageButton) v.findViewById(R.id.item_news_reply);
            favourite = (ImageButton) v.findViewById(R.id.item_news_favourite);
        }
    }

    public interface OnItemClickListener {
        public void onReplyClick(View v, int position);

        public void onFavouriteClick(View v, int position);

        public void onRetweetClick(View v);
    }
}

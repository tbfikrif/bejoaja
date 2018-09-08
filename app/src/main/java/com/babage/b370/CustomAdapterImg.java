package com.babage.b370;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.library.bubbleview.BubbleImageView;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

public class CustomAdapterImg extends BaseAdapter{
    private List<ChatModel> lstChat;
    private Context context;
    private LayoutInflater inflater;

    public CustomAdapterImg(List<ChatModel> lstChat, Context context){
        this.lstChat=lstChat;
        this.context=context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        return IGNORE_ITEM_VIEW_TYPE;
    }

    @Override
    public int getCount() {
        return lstChat.size();
    }

    @Override
    public Object getItem(int position){
        return lstChat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi;

        if (convertView==null){
            if (lstChat.get(position).isSend())
                vi=inflater.inflate(R.layout.list_send, null);
            else
                vi=inflater.inflate(R.layout.list_recv,null);


        } else {

             vi = convertView;

        }

        BubbleTextView bubbleTextView = (BubbleTextView)vi.findViewById(R.id.bubbleChat);
        BubbleImageView bubbleImageView = (BubbleImageView)vi.findViewById(R.id.bubbleImage);
        bubbleTextView.setText(lstChat.get(position).chatMessage);

        if (position==18){
            bubbleImageView.setImageResource(R.drawable.lv2_gedung);
            bubbleImageView.getLayoutParams().width=420;
            bubbleImageView.getLayoutParams().height=230;
            bubbleImageView.requestLayout();
        }else if (position==58){
            bubbleImageView.setImageResource(R.drawable.lv2_reuni);
            bubbleImageView.getLayoutParams().width=315;
            bubbleImageView.getLayoutParams().height=420;
            bubbleImageView.requestLayout();
        }else if (position==74){
            bubbleImageView.setImageResource(R.drawable.client);
            bubbleImageView.getLayoutParams().width=420;
            bubbleImageView.getLayoutParams().height=230;
            bubbleImageView.requestLayout();
        }else if (position==77){
            bubbleImageView.setImageResource(R.drawable.lv2_video_thumbnail);
            bubbleImageView.getLayoutParams().width=420;
            bubbleImageView.getLayoutParams().height=230;
            bubbleImageView.requestLayout();
        }else if (position==78){
            bubbleImageView.setImageResource(R.drawable.lv2_victim);
            bubbleImageView.getLayoutParams().width=315;
            bubbleImageView.getLayoutParams().height=420;
            bubbleImageView.requestLayout();
        }else {

            bubbleImageView.getLayoutParams().width=0;
            bubbleImageView.getLayoutParams().height=0;
            bubbleImageView.requestLayout();
        }

        return vi;

    }


}


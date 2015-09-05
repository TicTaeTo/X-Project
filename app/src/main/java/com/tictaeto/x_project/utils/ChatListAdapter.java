package com.tictaeto.x_project.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tictaeto.x_project.R;
import com.tictaeto.x_project.items.ChatItem;

import java.util.ArrayList;

/**
 * Created by Denis Ligin on 06.09.2015.
 */
public class ChatListAdapter extends BaseAdapter {
    ArrayList<ChatItem> chatItems;
    Context context;
    LayoutInflater layoutInflater;

    public ChatListAdapter(Context context, ArrayList<ChatItem> chatItems) {
        this.context = context;
        this.chatItems = chatItems;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return chatItems.size();
    }

    @Override
    public Object getItem(int position) {
        return chatItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout, parent, false);
        }

        ChatItem chatItem = (ChatItem) getItem(position);

        TextView name = (TextView) view.findViewById(R.id.chatName);
        TextView lastMessage = (TextView) view.findViewById(R.id.messageText);
        name.setText(chatItem.getName());
        lastMessage.setText(chatItem.getLastMessage());

        return view;
    }
}

package com.tictaeto.x_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.tictaeto.x_project.db.ChatManager;
import com.tictaeto.x_project.items.ChatItem;
import com.tictaeto.x_project.utils.ChatListAdapter;

import java.util.ArrayList;

public class ChatListView extends Activity {

    ChatListAdapter chatListAdapter;
    ArrayList<ChatItem> chatItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list_view);

        chatItems = ChatManager.get().getChatList();
        chatListAdapter = new ChatListAdapter(this, chatItems);
        ListView chatListView = (ListView) findViewById(R.id.listView);
        chatListView.setAdapter(chatListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

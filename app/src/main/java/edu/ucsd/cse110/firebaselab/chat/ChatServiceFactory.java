package edu.ucsd.cse110.firebaselab.chat;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ChatServiceFactory {
    private static final String TAG = ChatServiceFactory.class.getSimpleName();

    private Map<String, Blueprint> blueprints = new HashMap<>();

    public void put(String key, Blueprint blueprint) {
        blueprints.put(key, blueprint);
    }

    public ChatService create(String key, String chatId) {
        Log.i(TAG, String.format("Creating ChatService with key '%s' and chatId '%s'", key, chatId));
        return blueprints.get(key).create(chatId);
    }

    public interface Blueprint {
        ChatService create(String chatId);
    }
}

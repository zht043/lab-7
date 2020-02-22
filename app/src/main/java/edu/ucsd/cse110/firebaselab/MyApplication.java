package edu.ucsd.cse110.firebaselab;

import android.app.Application;

import edu.ucsd.cse110.firebaselab.chat.ChatServiceFactory;

public class MyApplication extends Application {
    private static ChatServiceFactory chatServiceFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        chatServiceFactory = new ChatServiceFactory();
    }

    public static ChatServiceFactory getChatServiceFactory() {
        return chatServiceFactory;
    }

    public static ChatServiceFactory setChatServiceFactory(ChatServiceFactory csf) {
        return chatServiceFactory = csf;
    }
}

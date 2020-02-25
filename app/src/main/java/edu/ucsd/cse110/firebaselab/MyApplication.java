package edu.ucsd.cse110.firebaselab;

import android.app.Application;

import edu.ucsd.cse110.firebaselab.ChatServiceFactory;

public class MyApplication extends Application {
    private static ChatServiceFactory chatServiceFactory;

    public static NotificationServiceFactory getNotificationServiceFactory() {
        return notificationServiceFactory;
    }

    public static NotificationServiceFactory setNotificationServiceFactory(NotificationServiceFactory nsf) {
        return notificationServiceFactory = nsf;
    }

    private static NotificationServiceFactory notificationServiceFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        chatServiceFactory = new ChatServiceFactory();
        notificationServiceFactory = new NotificationServiceFactory();
    }

    public static ChatServiceFactory getChatServiceFactory() {
        return chatServiceFactory;
    }

    public static ChatServiceFactory setChatServiceFactory(ChatServiceFactory csf) {
        return chatServiceFactory = csf;
    }
}
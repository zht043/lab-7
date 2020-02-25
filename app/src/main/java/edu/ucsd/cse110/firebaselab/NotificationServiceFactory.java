package edu.ucsd.cse110.firebaselab;

import android.content.Context;

import com.google.firebase.messaging.FirebaseMessaging;

public class NotificationServiceFactory {
    public FirebaseMessaging getFirebaseMessaging() {
        if (firebaseMessaging != null)
            return firebaseMessaging;
        else
            return FirebaseMessaging.getInstance();
    }

    public void setFirebaseMessaging(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    FirebaseMessaging firebaseMessaging;

    public NotificationService createFirebaseMessagingNotificationService(String chatId, String tag, Context context) {
        return new FirebaseMessagingAdapter(chatId, tag, context, getFirebaseMessaging());
    }
}

package edu.ucsd.cse110.firebaselab;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class FirebaseMessagingAdapter implements NotificationService {
    String chatId;
    String tag;
    Context context;
    FirebaseMessaging firebaseMessaging;
    public FirebaseMessagingAdapter(String chatId, String tag, Context context, FirebaseMessaging firebaseMessaging) {
        this.chatId = chatId;
        this.tag = tag;
        this.context = context;
        this.firebaseMessaging = firebaseMessaging;
    }
    @Override
    public void subscribeToNotificationsTopic() {
        firebaseMessaging.subscribeToTopic(chatId)
                .addOnCompleteListener(task -> {
                            String msg = "Subscribed to notifications";
                            if (!task.isSuccessful()) {
                                msg = "Subscribe to notifications failed";
                            }
                            Log.d(tag, msg);
                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                        }
                );
    }
}

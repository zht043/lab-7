package edu.ucsd.cse110.firebaselab;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChatServiceFactory {
    FirebaseFirestore firebaseFirestore;

    public void setFirebaseFirestore(FirebaseFirestore firebaseFirestore) {
        this.firebaseFirestore = firebaseFirestore;
    }

    public FirebaseFirestore getFirebaseFirestore() {
        if (firebaseFirestore != null)
            return firebaseFirestore;
        else
            return FirebaseFirestore.getInstance();
    }
    public ChatService createFirebaseFirestoreChatService(String collectionKey, String chatId, String messagesKey, String fromKey, String textKey, String timeStampKey) {
        return new FirebaseFirestoreAdapter(collectionKey, chatId, messagesKey, fromKey, textKey, timeStampKey, getFirebaseFirestore());
    }
}

package edu.ucsd.cse110.firebaselab.chat;

public class ChatServiceFactory {
    public ChatService createFirebaseFirestoreChatService(String collectionKey, String chatId, String messagesKey, String fromKey, String textKey, String timeStampKey) {
        return new FirebaseFirestoreAdapter(collectionKey, chatId, messagesKey, fromKey, textKey, timeStampKey);
    }
}

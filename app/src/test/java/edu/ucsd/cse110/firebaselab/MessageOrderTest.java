package edu.ucsd.cse110.firebaselab;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.messaging.FirebaseMessaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(AndroidJUnit4.class)
public class MessageOrderTest {

    @Test
    public void testMessagesDisplayedInOrder() {
        FirebaseFirestore firebaseFirestore = Mockito.mock(FirebaseFirestore.class);
        FirebaseMessaging firebaseMessaging = Mockito.mock(FirebaseMessaging.class);
        CollectionReference chat = Mockito.mock(CollectionReference.class);
        DocumentReference documentReference = Mockito.mock(DocumentReference.class);
        Query query = Mockito.mock(Query.class);
        Task task = Mockito.mock(Task.class);

        Mockito.when(firebaseFirestore.collection(anyString())).thenReturn(chat);
        Mockito.when(chat.document(anyString())).thenReturn(documentReference);
        Mockito.when(documentReference.collection(anyString())).thenReturn(chat);
        Mockito.when(chat.orderBy(anyString(), any())).thenReturn(query);
        Mockito.when(firebaseMessaging.subscribeToTopic(anyString())).thenReturn(task);

        ChatServiceFactory chatServiceFactory = new ChatServiceFactory();
        NotificationServiceFactory notificationServiceFactory = new NotificationServiceFactory();
        chatServiceFactory.setFirebaseFirestore(firebaseFirestore);
        notificationServiceFactory.setFirebaseMessaging(firebaseMessaging);

        MyApplication.setChatServiceFactory(chatServiceFactory);
        MyApplication.setNotificationServiceFactory(notificationServiceFactory);

        ActivityScenario.launch(MainActivity.class);

        Mockito.verify(chat).orderBy(anyString(), eq(Query.Direction.ASCENDING));
    }
}

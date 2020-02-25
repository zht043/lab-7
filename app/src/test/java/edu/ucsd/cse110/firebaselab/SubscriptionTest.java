package edu.ucsd.cse110.firebaselab;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import edu.ucsd.cse110.firebaselab.ChatService;
import edu.ucsd.cse110.firebaselab.ChatServiceFactory;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(AndroidJUnit4.class)
public class SubscriptionTest {

    @Test
    public void testSubscribeToChat() {
        ChatService chatService = Mockito.mock(ChatService.class);
        ChatServiceFactory chatServiceFactory = Mockito.mock(ChatServiceFactory.class);
        NotificationService notificationService = Mockito.mock(NotificationService.class);
        NotificationServiceFactory notificationServiceFactory = Mockito.mock(NotificationServiceFactory.class);

        Mockito.when(chatServiceFactory.createFirebaseFirestoreChatService(anyString(), anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(chatService);
        Mockito.when(notificationServiceFactory.createFirebaseMessagingNotificationService(anyString(), anyString(), any()))
                .thenReturn(notificationService);

        MyApplication.setChatServiceFactory(chatServiceFactory);
        MyApplication.setNotificationServiceFactory(notificationServiceFactory);

        ActivityScenario.launch(MainActivity.class);

        Mockito.verify(chatServiceFactory).createFirebaseFirestoreChatService(anyString(), eq("chat1"), anyString(), anyString(), anyString(), anyString());
    }
}
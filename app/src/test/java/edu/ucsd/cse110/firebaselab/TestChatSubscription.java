package edu.ucsd.cse110.firebaselab;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.shadows.ShadowLog;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import edu.ucsd.cse110.firebaselab.chat.ChatMessage;
import edu.ucsd.cse110.firebaselab.chat.ChatService;
import edu.ucsd.cse110.firebaselab.chat.ChatServiceFactory;

import static com.google.common.truth.Truth.assertThat;


@RunWith(AndroidJUnit4.class)
public class TestChatSubscription {
    @Test
    public void testSubscribeToChat1() {
        ShadowLog.stream = System.out;
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), MainActivity.class);
        intent.putExtra(MainActivity.CHAT_MESSAGE_SERVICE_EXTRA, "TEST_CHAT_SERVICE");

        ChatServiceFactory chatServiceFactory = MyApplication.getChatServiceFactory();
        chatServiceFactory.put("TEST_CHAT_SERVICE", chatId -> {
            assertThat(chatId).isEqualTo("chat1");
            return new TestChatService();
        });

        ActivityScenario.launch(intent);
    }


    class TestChatService implements ChatService {
        @Override
        public Task<?> addMessage(Map<String, String> message) {
            return new Task<Object>() {
                @Override
                public boolean isComplete() {
                    return false;
                }

                @Override
                public boolean isSuccessful() {
                    return false;
                }

                @Override
                public boolean isCanceled() {
                    return false;
                }

                @Nullable
                @Override
                public Object getResult() {
                    return null;
                }

                @Nullable
                @Override
                public <X extends Throwable> Object getResult(@NonNull Class<X> aClass) throws X {
                    return null;
                }

                @Nullable
                @Override
                public Exception getException() {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnSuccessListener(@NonNull OnSuccessListener<? super Object> onSuccessListener) {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super Object> onSuccessListener) {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super Object> onSuccessListener) {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
                    return null;
                }

                @NonNull
                @Override
                public Task<Object> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
                    return null;
                }
            };
        }

        @Override
        public void subscribeToMessages(Consumer<List<ChatMessage>> listener) {
        }
    }

}

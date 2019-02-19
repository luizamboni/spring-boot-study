package com.example.poller.infraestructure.binders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessagesProcessor {
    String MESSAGES_CHANNEL_IN = "chatMessagesInput";
    String MESSAGES_CHANNEL_OUT = "chatMessagesOutput";


    @Input(MESSAGES_CHANNEL_IN)
    SubscribableChannel getMessages();

    @Output(MESSAGES_CHANNEL_OUT)
    MessageChannel pollerOut();

}

package com.example.web.infrastructure.binders;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessagesSource {
    String MESSAGES_CHANNEL_OUT = "chatMessagesFromApi";

    @Output(MESSAGES_CHANNEL_OUT)
    MessageChannel pollerOut();

}

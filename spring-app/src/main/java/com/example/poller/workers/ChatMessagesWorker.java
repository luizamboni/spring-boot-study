package com.example.poller.workers;

import com.example.commons.domain.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import com.example.poller.infraestructure.binders.MessagesProcessor;
import org.springframework.scheduling.annotation.Async;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Random;

@EnableBinding(value = { MessagesProcessor.class })
@EnableAutoConfiguration
@Slf4j
public class ChatMessagesWorker {

    Random rand = new Random();


    @Async
    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void receiveWithAsync(ChatMessage chatMessage) throws Exception {

        log.info("Thread name is: " + Thread.currentThread().getName());

        log.info(" -> processing");
        log.info(chatMessage.toString());
        randomError();
    }

    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void regularReceive(ChatMessage chatMessage) throws Exception {

        log.info("Thread name is: " + Thread.currentThread().getName());

        log.info(" -> processing");
        log.info(chatMessage.toString());
        randomError();
    }


    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
//    @Output(MessagesProcessor.MESSAGES_CHANNEL_OUT)
    public void receiveWithFlux(Flux<ChatMessage> messages) {
        log.info("Thread name is: " + Thread.currentThread().getName());

        messages
            .subscribeOn(Schedulers.parallel())
            .map(chatMessage -> {

                log.info(" -> processing");

                log.info(chatMessage.toString());

//                randomError();

            return chatMessage;
        }).subscribe(
            chatMessage -> {
                log.info( " -> ssussucesso");
            },

            ex -> {
                log.info(" -> errão");

            },
            () -> {
                log.info(" -> completed");

            }
        );
    }


    private void randomError() throws Exception {


        if(rand.nextInt(100) < 60) {
            throw new Exception("random Error !");
        }
    }
}

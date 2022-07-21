package org.main;

import org.main.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.trimming.annotation.EnableStringTrimming;

@EnableStringTrimming
public class DemoApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("org.main", "org.trimming");
        var messageService = context.getBean(MessageService.class);
        String messageWithoutSpaces = "Message";
        String messageWithSpaces = "  Message  ";

        System.out.println("[" + messageService.addSpaceAfter(messageWithoutSpaces) + "]");
        System.out.println("[" + messageService.addSpaceBefore(messageWithoutSpaces) + "]");
        System.out.println("[" + messageService.doNothing(messageWithSpaces) + "]");

    }
}

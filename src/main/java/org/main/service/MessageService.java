package org.main.service;

import org.springframework.stereotype.Service;
import org.trimming.annotation.Trimmed;

@Trimmed
@Service
public class MessageService {
    private final String SPACES = "   ";
    public String addSpaceAfter(String message) {
        return message + SPACES;
    }

    public String addSpaceBefore(String message) {
        return SPACES + message;
    }

    public String doNothing(String message) {
        return message;
    }
}

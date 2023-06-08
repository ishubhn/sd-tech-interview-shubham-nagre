package io.sdtech.notepad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    LocalDateTime timestamp;
    String message;

    public MessageResponse(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}

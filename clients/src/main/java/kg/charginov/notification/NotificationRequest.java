package kg.charginov.notification;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NotificationRequest(
        String message,
        String sender,
        LocalDateTime sentAt,
        String toCustomerEmail,
        Long toCustomerId
) {
}

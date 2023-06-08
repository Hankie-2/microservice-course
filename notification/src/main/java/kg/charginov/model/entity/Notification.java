package kg.charginov.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class Notification {

    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    Long id;

    String message;
    String sender;
    LocalDateTime sentAt;
    String toCustomerEmail;
    Long toCustomerId;

}

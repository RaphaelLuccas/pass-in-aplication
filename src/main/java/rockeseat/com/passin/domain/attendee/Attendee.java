package rockeseat.com.passin.domain.attendee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import rockeseat.com.passin.domain.event.Event;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendees")
@Getter
@Setter
@AllArgsConstructor
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

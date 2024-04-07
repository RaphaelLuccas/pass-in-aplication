package rockeseat.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rockeseat.com.passin.domain.checkin.CheckIn;

import java.util.Optional;

public interface CheckinRepository extends JpaRepository<CheckIn, Integer> {
    Optional<CheckIn> findByAttendeeId(String attendeeId);
}

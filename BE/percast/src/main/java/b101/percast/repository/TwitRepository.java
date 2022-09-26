package b101.percast.repository;

import b101.percast.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitRepository extends JpaRepository<Twit, Long> {
}

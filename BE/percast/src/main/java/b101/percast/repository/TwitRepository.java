package b101.percast.repository;

import b101.percast.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TwitRepository extends JpaRepository<Twit, Long> {
    List<Twit> findTop10ByDiseaseOrderByCountDesc(String disease);
}

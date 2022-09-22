package b101.percast.repository;

import b101.percast.entity.MessageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageServiceRepository extends JpaRepository<MessageService, Long> {
    @Query("SELECT DISTINCT m.tel FROM MessageService m")
    List<String> findDistinctTelAll();
    List<MessageService> findMessageServiceByTel(String tel);
}

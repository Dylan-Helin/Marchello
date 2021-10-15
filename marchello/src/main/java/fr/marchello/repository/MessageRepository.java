package fr.marchello.repository;

import fr.marchello.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer>{

    List<Message> findAllBySenderName(String senderName);

    List<Message> findAllBySenderNameAndDate (String senderName, Date date);

    List<Message> findAllByDate(Date date);

    Optional<Message> findById(Integer Id);
}

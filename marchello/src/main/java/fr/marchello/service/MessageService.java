package fr.marchello.service;

import fr.marchello.entity.Message;
import fr.marchello.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public String createMessage(Message message){
        try {
            message.fixDate();
            messageRepository.save(message);
            return "Message created successfully";
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Transactional
    public List<Message> getAllMessagesByDate(Date date) {
        System.out.println(date);
        return messageRepository.findAllByDate(date);
    }

    @Transactional
    public List<Message> getAllMessagesBySenderName(String senderName) {
        return messageRepository.findAllBySenderName(senderName);
    }

    @Transactional
    public List<Message> getAllMessagesSenderNameAndDate(String senderName, Date date) {
        return messageRepository.findAllBySenderNameAndDate(senderName,date);
    }

    public Optional<Message> findById(Integer id) {
        return messageRepository.findById(id);
    }
}

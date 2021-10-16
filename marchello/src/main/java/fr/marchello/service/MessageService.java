package fr.marchello.service;

import fr.marchello.Log;
import fr.marchello.MarchelloApplication;
import fr.marchello.entity.Message;
import fr.marchello.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public String createMessage(Message message) throws IOException {
        try {
            Log log = new Log("log.txt");
            message.fixDate();
            messageRepository.save(message);
            log.logger.info("created : " + message.toString());
            return "Message created successfully";
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public List<Message> getAllMessages() {
        List<Message> results = messageRepository.findAll();
        for (Message m : results){
            try {
                Log log = new Log("log.txt");
                log.logger.info("sent : " + m.toString());
            }catch (Exception e){

            }
        }
        return results;
    }

    @Transactional
    public List<Message> getAllMessagesByDate(Date date) {
        List<Message> results = messageRepository.findAllByDate(date);
        for (Message m : results){
            try {
                Log log = new Log("log.txt");
                log.logger.info("sent : " + m.toString());
            }catch (Exception e){

            }
        }
        return results;
    }

    @Transactional
    public List<Message> getAllMessagesBySenderName(String senderName) {
        List<Message> results = messageRepository.findAllBySenderName(senderName);
        for (Message m : results){
            try {
                Log log = new Log("log.txt");
                log.logger.info("sent : " + m.toString());
            }catch (Exception e){

            }
        }
        return results;
    }

    @Transactional
    public List<Message> getAllMessagesSenderNameAndDate(String senderName, Date date) {
        List<Message> results = messageRepository.findAllBySenderNameAndDate(senderName,date);
        for (Message m : results){
            try {
                Log log = new Log("log.txt");
                log.logger.info("sent : " + m.toString());
            }catch (Exception e){

            }
        }
        return results;
    }

    public Optional<Message> findById(Integer id) {
        Optional<Message> result = messageRepository.findById(id);
        if (result.isPresent()){
            try {
                Log log = new Log("log.txt");
                log.logger.info("sent : " + result.toString());
            }catch (Exception e){

            }
        }
        return result;
    }
}

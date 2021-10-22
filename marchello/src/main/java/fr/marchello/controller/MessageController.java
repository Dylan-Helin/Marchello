package fr.marchello.controller;

import fr.marchello.entity.Message;
import fr.marchello.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * Create a new message.
     * @param message the new message to add to the database.
     * @return "Message created successfully" if the message is created.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("messages")
    public String createMessage(@RequestBody Message message) throws IOException {
        return messageService.createMessage(message);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("messages/params")
    public String createMessageWithParams(@RequestParam String senderName, @RequestParam String message, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws IOException {
        System.out.println("test");
        return messageService.createMessage(senderName,message,date);
    }

    /**
     * Get a message by its ID.
     * @param id the ID of the message.
     * @return the Message with the corresponding ID.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("messages/{id}")
    public Optional<Message> getMessageById(@PathVariable Integer id){
        return messageService.findById(id);
    }

    /**
     * Get all the messages Marchello sent or received.
     * @return all the messages.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    /**
     * Get all the messages sent by a certain robot.
     * @param senderName the name of the sender.
     * @return all the messages from a certain robot.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("messages/name")
    public List<Message> getAllMessagesBySenderName(@RequestParam String senderName){
        return messageService.getAllMessagesBySenderName(senderName);
    }

    /**
     * Return all the messages sent at a certain date.
     * @param date the date of the messages.
     * @return all the messages sent at a certain date.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("messages/date")
    public List<Message> getAllMessagesbyDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return messageService.getAllMessagesByDate(date);

    }

    /**
     * All the messages of a certain date sent by a certain sender.
     * @param date the date of the messages.
     * @param senderName the name of the sender.
     * @return the messages sent at a certain date by a certain sender.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("messages/nameanddate")
    public List<Message> getAllMessagesBy(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String senderName){
        return messageService.getAllMessagesSenderNameAndDate(senderName,date);
    }
}

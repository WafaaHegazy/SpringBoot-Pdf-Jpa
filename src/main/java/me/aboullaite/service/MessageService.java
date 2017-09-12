package me.aboullaite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.aboullaite.model.MessageHeader;
import me.aboullaite.repo.MessageRepo;

@Service
public class MessageService {

    @Autowired
    MessageRepo repo;

    public List<MessageHeader> findAll() {
        final List<MessageHeader> messages = new ArrayList<MessageHeader>();
        repo.findAll().forEach((e) -> messages.add(e));
        return messages;

    }
}

package me.aboullaite.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.aboullaite.model.MessageHeader;

@Repository
public interface MessageRepo extends CrudRepository<MessageHeader, Integer> {

}

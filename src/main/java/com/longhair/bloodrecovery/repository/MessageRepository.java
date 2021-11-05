package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByConsumer(String consumer);
    List<Message> findAllByProducer(String producer);
    List<Message> findAllByConsumerAndRead(String consumer, boolean isRead);
    void deleteAllByConsumer(String consumer);
    void deleteAllByConsumerAndRead(String consumer, boolean isRead);
}

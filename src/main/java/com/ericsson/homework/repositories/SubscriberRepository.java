package com.ericsson.homework.repositories;

import com.ericsson.homework.entities.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubscriberRepository {

    private final DataRepository dataRepository;

    public SubscriberRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Subscriber> getSubscribers() {
        return dataRepository.getData().getSubscribers();
    }

    public Optional<Subscriber> getSubscriberById(String id) {
        return getSubscribers().stream().filter(subscriber -> subscriber.getId().equals(id)).findFirst();
    }

    public Subscriber saveSubscriber(Subscriber subscriber) {
        getSubscribers().add(subscriber);
        return subscriber;
    }

    public void removeSubscriber(String id) {
        getSubscribers().removeIf(subscriber -> subscriber.getId().equals(id));
    }
}

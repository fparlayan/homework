package com.ericsson.homework.services;

import com.ericsson.homework.entities.Subscriber;
import com.ericsson.homework.exceptions.BaseException;
import com.ericsson.homework.exceptions.BaseExceptionType;
import com.ericsson.homework.repositories.SubscriberRepository;
import com.ericsson.homework.services.dtos.SubscriberDto;
import com.ericsson.homework.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {

    private final SubscriberRepository repository;

    public SubscriberService(SubscriberRepository repository) {
        this.repository = repository;
    }

    public SubscriberDto createSubscriber(SubscriberDto dto) {
        Subscriber subscriber = MapperUtil.map(dto, Subscriber.class);
        subscriber = repository.saveSubscriber(subscriber);
        return MapperUtil.map(subscriber, SubscriberDto.class);
    }

    public List<SubscriberDto> getAllSubscribers() {
        List<Subscriber> subscribers = repository.getSubscribers();
        return MapperUtil.mapAll(subscribers, SubscriberDto.class);
    }

    public SubscriberDto getSubscriber(String id) {
        return MapperUtil.map(getById(id), SubscriberDto.class);
    }

    private Subscriber getById(String id) {
        return repository.getSubscriberById(id)
                .orElseThrow(new BaseException("Subscriber not found", BaseExceptionType.NOT_FOUND));
    }

    public SubscriberDto updateSubscriber(SubscriberDto dto) {
        Subscriber subscriber = getById(dto.getId());
        subscriber.setName(dto.getName());
        subscriber.setMsisdn(dto.getMsisdn());
        return MapperUtil.map(subscriber, SubscriberDto.class);
    }

    public void removeSubscriber(String id) {
        Subscriber subscriber = getById(id);
        repository.removeSubscriber(subscriber.getId());
    }
}

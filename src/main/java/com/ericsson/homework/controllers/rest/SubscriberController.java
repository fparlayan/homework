package com.ericsson.homework.controllers.rest;

import com.ericsson.homework.services.SubscriberService;
import com.ericsson.homework.services.dtos.SubscriberDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    private final SubscriberService service;

    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @GetMapping(value = "")
    public List<SubscriberDto> getAllSubscribers() {
        return service.getAllSubscribers();
    }

    @GetMapping(value = "/{id}")
    public SubscriberDto getSubscriberById(@PathVariable String id) {
        return service.getSubscriber(id);
    }

    @PostMapping(value = "")
    public SubscriberDto newSubscriber(@RequestBody SubscriberDto dto) {
        return service.createSubscriber(dto);
    }

    @PutMapping(value = "")
    public SubscriberDto updateSubscriber(@RequestBody SubscriberDto dto) {
        return service.updateSubscriber(dto);
    }

    @DeleteMapping(value = "")
    public void removeSubscriber(@RequestBody SubscriberDto dto) {
        service.removeSubscriber(dto.getId());
    }
}

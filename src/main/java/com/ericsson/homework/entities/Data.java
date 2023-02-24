package com.ericsson.homework.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Data {
    private List<Subscriber> subscribers = new ArrayList<>();
}

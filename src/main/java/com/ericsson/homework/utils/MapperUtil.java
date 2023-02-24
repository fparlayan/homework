package com.ericsson.homework.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapperUtil {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private MapperUtil() {
    }

    public static <D, T> D map(final T source, Class<D> target) {
        return modelMapper.map(source, target);
    }

    public static <D, T> List<D> mapAll(final Collection<T> sourceCollection, Class<D> targetCollection) {
        return sourceCollection.stream()
                .map(entity -> map(entity, targetCollection))
                .collect(Collectors.toList());
    }
}
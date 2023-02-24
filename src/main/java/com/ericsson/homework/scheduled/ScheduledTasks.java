package com.ericsson.homework.scheduled;

import com.ericsson.homework.entities.Data;
import com.ericsson.homework.repositories.DataRepository;
import com.ericsson.homework.utils.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledTasks {

    private final DataRepository dataRepository;
    @Value("${dataPath}")
    private String dataPath;

    public ScheduledTasks(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Scheduled(fixedRate = 1000 * 60) // each minute
    public void writeDataToFile() throws IOException {
        Data data = dataRepository.getData();
        String dataAsJson = new Gson().toJson(data);
        FileUtil.writeFile(dataPath, dataAsJson);
    }
}

package com.ericsson.homework.repositories;

import com.ericsson.homework.entities.Data;
import com.ericsson.homework.utils.FileUtil;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Getter
@Setter
@Repository
public class DataRepository {

    private Data data;
    @Value("${dataPath}")
    private String dataPath;

    @PostConstruct
    public void loadDataFromFile() throws IOException {
        String dataAsString = FileUtil.readFile(dataPath);
        data = new Gson().fromJson(dataAsString, Data.class);
        if (data == null)
            data = new Data();
    }
}

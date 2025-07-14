package io.projects.spotify_to_kafka_service.listener;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
public class MockSpotifyRunner {

    public List<String[]> readCSVData() throws IOException, CsvException {
        File file = ResourceUtils.getFile("classpath:data/dataset.csv");
        CSVReader csvReader = new CSVReaderBuilder(new FileReader((file))).withSkipLines(1).build();
        return csvReader.readAll();
    }

    public String convertToJson() throws IOException, CsvException {
        Gson gson = new Gson();
        List<String[]> csvData = readCSVData();
        return gson.toJson(csvData);
    }


}

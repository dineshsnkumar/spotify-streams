package io.projects.spotify_to_kafka_service.listener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

@Configuration
public class MockSpotifyRunner {

    private final Gson gson;
    private final Logger LOG = LoggerFactory.getLogger(MockSpotifyRunner.class);
    private final Random random = new Random();

    public MockSpotifyRunner(Gson gson ) {
        this.gson = gson;
    }

    public List<String[]> readCSVData() throws IOException, CsvException {
        File file = ResourceUtils.getFile("classpath:data/dataset.csv");
        CSVReader csvReader = new CSVReaderBuilder(new FileReader((file))).withSkipLines(1).build();
        return csvReader.readAll();
    }

    public JsonArray convertToJson() throws IOException, CsvException {
        List<String[]> csvData = readCSVData();
        return gson.toJsonTree(csvData).getAsJsonArray();
    }

    public void mockRandomSpotifyTrack() throws IOException, CsvException {
        LOG.info("--Started Mocking Spotify streaming --");
        JsonArray jsonArray = convertToJson();
        Executors.newSingleThreadExecutor().submit(
                () -> {
                    try {
                        while (true) {
                            int randomElement = random.nextInt(jsonArray.size());
                            System.out.println(jsonArray.get(randomElement));
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        LOG.error("Error creating the stream");
                    }
                }
        );
    }

}

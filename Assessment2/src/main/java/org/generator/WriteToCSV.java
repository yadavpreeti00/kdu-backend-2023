package org.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteToCSV {

    private static final Logger logger = LoggerFactory.getLogger(WriteToCSV.class);

    public static void writeToCSV(List<Match> data, String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            for (Match match : data) {
                String[] row = {String.valueOf(match.getMatchNumber()), String.valueOf(match.getMatchDate()), String.valueOf(match.getMatchTime()), match.getTeamHome(), match.getTeamAway(),match.getGround()};
                writer.writeNext(row);
            }
            logger.info("Writing to CSV file is completed");
            //System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            //System.exit(1);
        }
    }
}

package Logs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

public class Logs {

    public static void printLogs(WebDriver driver){

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for(LogEntry logEntry : logEntries){
            System.out.println(new Date(logEntry.getTimestamp() + " " + logEntry.getLevel() + " " + logEntry.getMessage()));
        }

    }

    public static void writeLogsToFile(WebDriver driver, String file, Level level){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        File savelogs = new File(file+".log");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(savelogs);

            for (LogEntry logEntry : logEntries){
                if(logEntry.getLevel().getName().equals(level.getName().toUpperCase()) || level.getName().toUpperCase().equals("ALL")){
                    fileWriter.write(logEntry.toString()+"\n");
                }
            fileWriter.flush();
            fileWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

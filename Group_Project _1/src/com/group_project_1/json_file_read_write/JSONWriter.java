package com.group_project_1.json_file_read_write;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group_project_1.accept_file.*;
import com.group_project_1.collection.*;
import com.group_project_1.json_file_read_write.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * The writer class for the json file.
 *
 * @author Amadeus
 */
public class JSONWriter {

    public void writeToJSON(List<Site> siteReadings) {
        // reading from the reader
        JSONReader Jreader = new JSONReader();
        
        Readings reading = new Readings();
        // setting the layout of the json file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Site site = writerInterface();
        // as you can see it's using the reader class 
        
       
        
        for (Site site : siteReadings) {
            reading.setSiteReadings(siteReadings);
            String json = gson.toJson(reading);
            try {
                // the file writer for writing into the json file
                FileWriter writer = new FileWriter("example.json");
                writer.write(json);
                writer.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
		}
    }

    // this method is just to display what the interface questions for adding onto the JSON file
    public Site writerInterface() {
        Site site = new Site();
        Scanner stdin = new Scanner(System.in);
        String input = "";
        System.out.println("enter in site_id: ");
        input = stdin.nextLine();
        site.setSiteID(input);
        System.out.println("enter in reading_type: ");
        input = stdin.nextLine();
        site.setReadingType(input);
        System.out.println("enter in reading_id: ");
        input = stdin.nextLine();
        site.setReadingID(input);
        System.out.println("enter in reading_value: ");
        input = stdin.nextLine();
        site.setReadingValue(input);
        System.out.println("enter in reading_date: ");
        input = stdin.nextLine();
        site.setReadingDate(input);
        return site;
    }
}
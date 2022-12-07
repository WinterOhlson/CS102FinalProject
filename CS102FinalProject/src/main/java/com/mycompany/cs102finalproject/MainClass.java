/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cs102finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jehuv
 */
public class MainClass {

    public static void main(String[] args) throws FileNotFoundException {
        File csvFile = new File("C:\\Users\\jehuv\\Documents\\NetBeansProjects\\CS102FinalProject\\CS102FinalProject\\src\\main\\java\\com\\mycompany\\cs102finalproject\\listings-small.csv");
        Scanner s = new Scanner(csvFile);
        
        int currentStationID = -1;
        ArrayList<LocalCommodityData> currentCommodities = new ArrayList();
        ArrayList<Station> stations = new ArrayList();
        
        s.nextLine();
        while(s.hasNextLine())
        {
            String currentLine = s.nextLine();
            Scanner subScanner = new Scanner(currentLine);
            subScanner.useDelimiter(",");
            subScanner.next();
            int newStationID = Integer.parseInt(subScanner.next());
            if(newStationID == currentStationID)
            {
                int firstInt = Integer.parseInt(subScanner.next());
                LocalCommodityData newCommodity = new LocalCommodityData(firstInt, Integer.parseInt(subScanner.next()), Integer.parseInt(subScanner.next()), Integer.parseInt(subScanner.next()), Integer.parseInt(subScanner.next()), Integer.parseInt(subScanner.next()), Integer.parseInt(subScanner.next()));
                currentCommodities.add(newCommodity);
            }
            else
            {
                if(currentStationID != -1)
                {
                    Station newStation = new Station(currentStationID, currentCommodities);
                    stations.add(newStation);
                    currentCommodities = new ArrayList();
                    currentStationID = newStationID;
                }
                else
                {
                    currentStationID = newStationID;
                }
            }
        }
        
        FinalProjectUI finalProjectUI = new FinalProjectUI();
        finalProjectUI.setStations(stations);
        finalProjectUI.setVisible(true);
        
        s.reset();
    }
    
    public static int getMostPopularCommodity(ArrayList<Station> stations)
    {
        ArrayList<UniversalCommodityData> commodityList = new ArrayList();
        for(Station station : stations)
        {
            for(LocalCommodityData commodity : station.getCommodityData())
            {
                boolean inList = false;
                for(UniversalCommodityData uCommodity : commodityList)
                {
                    if(uCommodity.getId() == commodity.getCommodityID())
                    {
                        uCommodity.setTotalValue(uCommodity.getTotalValue() + commodity.getDemand());
                        inList = true;
                    }
                }
                if(inList == false)
                {
                    UniversalCommodityData newCommodity = new UniversalCommodityData(commodity.getCommodityID(), commodity.getDemand());
                    commodityList.add(newCommodity);
                }
            }
        }
        
        int maxValue = 0;
        int mostPopularID = -1;
        
        for(UniversalCommodityData commodity : commodityList)
        {
            if(commodity.getTotalValue() > maxValue)
            {
                maxValue = commodity.getTotalValue();
                mostPopularID = commodity.getId();
            }
        }
        
        return mostPopularID;
    }
}
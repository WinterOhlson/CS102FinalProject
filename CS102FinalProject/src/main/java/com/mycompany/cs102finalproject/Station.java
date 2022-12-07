/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs102finalproject;

import java.util.ArrayList;

/**
 *
 * @author jehuv
 */
public class Station {
    private int id;
    private LocalCommodityData[] commodityData;
    
    private long totalSaleValue;
    private long totalPurchaseValue;
    
    public Station(int stationID, ArrayList<LocalCommodityData> commodities)
    {
        this.id = stationID;
        this.commodityData = new LocalCommodityData[commodities.size()];
        int i = 0;
        
        this.totalSaleValue = 0;
        this.totalPurchaseValue = 0;
        
        for(LocalCommodityData commodity : commodities)
        {
            commodityData[i] = commodity;
            i++;
            
            int commoditySaleValue = commodity.getBuyPrice() * commodity.getSupply();
            this.totalSaleValue += commoditySaleValue;
            
            int commodityPurchaseValue = commodity.getSellPrice() * commodity.getDemand();
            this.totalPurchaseValue += commodityPurchaseValue;
        }
    }
    
    public int getUniqueCommodityCount()
    {
        int count = 0;
        for(LocalCommodityData commodity : commodityData)
        {
            if(commodity.getSupply() > 0)
            {
                count++;
            }
        }
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalCommodityData[] getCommodityData() {
        return commodityData;
    }

    public void setCommodityData(LocalCommodityData[] commodityData) {
        this.commodityData = commodityData;
    }

    public long getTotalSaleValue() {
        return totalSaleValue;
    }

    public void setTotalSaleValue(long totalSaleValue) {
        this.totalSaleValue = totalSaleValue;
    }

    public long getTotalPurchaseValue() {
        return totalPurchaseValue;
    }

    public void setTotalPurchaseValue(long totalPurchaseValue) {
        this.totalPurchaseValue = totalPurchaseValue;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs102finalproject;

/**
 *
 * @author jehuv
 */
public class LocalCommodityData {
    private int commodityID;
    private int supply;
    private int supplyBracket;
    private int demand;
    private int demandBracket;
    private int buyPrice;
    private int sellPrice;
    
    public LocalCommodityData(int id, int supply, int sBracket, int bPrice, int sPrice, int demand, int dBracket)
    {
        this.commodityID = id;
        this.supply = supply;
        this.supplyBracket = sBracket;
        this.demand = demand;
        this.demandBracket = dBracket;
        this.buyPrice = bPrice;
        this.sellPrice = sPrice;
    }

    public int getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getSupplyBracket() {
        return supplyBracket;
    }

    public void setSupplyBracket(int supplyBracket) {
        this.supplyBracket = supplyBracket;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getDemandBracket() {
        return demandBracket;
    }

    public void setDemandBracket(int demandBracket) {
        this.demandBracket = demandBracket;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    
}

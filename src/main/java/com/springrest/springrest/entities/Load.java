package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Load {
  @Id
  private long loadId;
  private String unloadingPoint;
  private String productType;
  private String truckType;
  private int noOfTrucks;
  private int weight;
  private String comment;
  private long shipperId;
  private String date;

  // Parameterized constructor
  public Load(long loadId, long shipperId, String unloadingPoint, String productType, String truckType, int noOfTrucks,
      int weight, String comment, String date) {
    this.loadId = loadId;
    this.unloadingPoint = unloadingPoint;
    this.productType = productType;
    this.truckType = truckType;
    this.noOfTrucks = noOfTrucks;
    this.weight = weight;
    this.comment = comment;
    this.shipperId = shipperId;
    this.date = date;
  }

  public Load() {
    super();
  }

  // Getter
  public long getLoadId() {
    return loadId;
  }

  public String getUnloadingPoint() {
    return unloadingPoint;
  }

  public String getProductType() {
    return productType;
  }

  public String getTruckType() {
    return truckType;
  }

  public int getNoOfTrucks() {
    return noOfTrucks;
  }

  public int getWeight() {
    return weight;
  }

  public String getComment() {
    return comment;
  }

  public long getShipperId() {
    return shipperId;
  }

  public String getDate() {
    return date;
  }

  // Setter
  public void setUnloadingPoint(String unloadingPoint) {
    this.unloadingPoint = unloadingPoint;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public void setTruckType(String truckType) {
    this.truckType = truckType;
  }

  public void setNoOfTrucks(int noOfTrucks) {
    this.noOfTrucks = noOfTrucks;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setShipperId(long shipperId) {
    this.shipperId = shipperId;
  }

  public void setDate(String date) {
    this.date = date;
  }

  // toString() method
  @Override
  public String toString() {
    return "Load{" +
        "loadId=" + loadId +
        ", shipperId=" + shipperId +
        ", unloadingPoint='" + unloadingPoint + '\'' +
        ", productType='" + productType + '\'' +
        ", truckType='" + truckType + '\'' +
        ", noOfTrucks=" + noOfTrucks +
        ", weight=" + weight +
        ", comment='" + comment + '\'' +
        ", date='" + date + '\'' +
        '}';
  }
}

package com.project.devweek.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Double price;

  @Column(name = "variation")
  private Double variation;

  @Column(name = "date")
  private LocalDate date;

  /**
   * @return Long return the id
   */
  public Long getId() {
      return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
      this.id = id;
  }

  /**
   * @return String return the name
   */
  public String getName() {
      return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
      this.name = name;
  }

  /**
   * @return Double return the price
   */
  public Double getPrice() {
      return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(Double price) {
      this.price = price;
  }

  /**
   * @return Double return the variation
   */
  public Double getVariation() {
      return variation;
  }

  /**
   * @param variation the variation to set
   */
  public void setVariation(Double variation) {
      this.variation = variation;
  }

  /**
   * @return LocalDate return the date
   */
  public LocalDate getDate() {
      return date;
  }

  /**
   * @param date the date to set
   */
  public void setDate(LocalDate date) {
      this.date = date;
  }

}

package com.springrest.springrest.entities;

public class Course {
  private long id;
  private String title;
  private String description;

  // Parameterized Constructor
  public Course(long id, String title, String description) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
  }

  public Course() {
    super();
  }

  // Getters
  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  // Setters
  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // toString() method
  @Override
  public String toString() {
    return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
  }
}

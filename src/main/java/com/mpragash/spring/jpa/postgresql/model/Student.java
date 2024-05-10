package com.mpragash.spring.jpa.postgresql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "dateofbirth")
  private String dateofbirth;

  @Column(name = "dateofjoining")
  private String dateofjoining;
  
  @Column(name = "classes")
  private String classes;

  public Student() {

  }

  public Student(Long id,String name, String dateofbirth, String dateofjoining, String classes) {
	this.id = id;
    this.name = name;
    this.dateofbirth = dateofbirth;
    this.dateofjoining = dateofjoining;
    this.classes = classes;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDateofbirth() {
    return dateofbirth;
  }

  public void setDateofbirth(String dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  public String getDateofjoining() {
    return dateofjoining;
  }

  public void setDateofjoining(String dateofjoining) {
    this.dateofjoining = dateofjoining;
  }
  
  public String getclasses() {
	  return classes;
  }

public void setClasses(String classes) {
	    this.classes = classes;
}

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + ", dateofjoining=" + dateofjoining + ",classes=" + classes + " ]";
  }

}

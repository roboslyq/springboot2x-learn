package com.jpa.domain.secondary;

import javax.persistence.*;

/**
 * @author luo.yongqian
 */
@Entity
@Table
public class UserSecondary {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;

  public UserSecondary(){}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserSecondary(String username, String password) {
    this.username = username;
    this.password = password;
  }
}

package com.faforever.server.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Player extends Login {

  private Ladder1v1Rating ladder1v1Rating;
  private GlobalRating globalRating;

  @OneToOne(mappedBy = "player")
  public Ladder1v1Rating getLadder1v1Rating() {
    return ladder1v1Rating;
  }

  public void setLadder1v1Rating(Ladder1v1Rating ladder1v1Rating) {
    this.ladder1v1Rating = ladder1v1Rating;
  }

  @OneToOne(mappedBy = "player")
  public GlobalRating getGlobalRating() {
    return globalRating;
  }

  public void setGlobalRating(GlobalRating globalRating) {
    this.globalRating = globalRating;
  }
}

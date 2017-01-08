package com.faforever.server.entity;

import com.faforever.server.game.GameState;
import com.faforever.server.integration.session.ClientConnection;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "login")
@Setter
public class Player extends Login {

  private Ladder1v1Rating ladder1v1Rating;
  private GlobalRating globalRating;
  private Game currentGame;
  private GameState gameState;
  private ClientConnection clientConnection;

  @OneToOne(mappedBy = "player")
  public Ladder1v1Rating getLadder1v1Rating() {
    return ladder1v1Rating;
  }

  @OneToOne(mappedBy = "player")
  public GlobalRating getGlobalRating() {
    return globalRating;
  }

  @Transient
  public GameState getGameState() {
    return gameState;
  }

  @Transient
  public Game getCurrentGame() {
    return currentGame;
  }

  @Transient
  public ClientConnection getClientConnection() {
    return clientConnection;
  }
}

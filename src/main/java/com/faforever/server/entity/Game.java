package com.faforever.server.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "game_stats")
public class Game {

  private int id;
  private Timestamp startTime;
  private VictoryCondition victoryCondition;
  private byte gameMod;
  private Player host;
  private MapVersion map;
  private String gameName;
  private byte validity;
  private List<GamePlayerStats> playerStats;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "startTime")
  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  @Basic
  @Column(name = "gameType")
  public VictoryCondition getVictoryCondition() {
    return victoryCondition;
  }

  public void setVictoryCondition(VictoryCondition gameType) {
    this.victoryCondition = gameType;
  }

  @Basic
  @Column(name = "gameMod")
  public byte getGameMod() {
    return gameMod;
  }

  public void setGameMod(byte gameMod) {
    this.gameMod = gameMod;
  }

  @ManyToOne
  @JoinColumn(name = "host")
  public Player getHost() {
    return host;
  }

  public void setHost(Player host) {
    this.host = host;
  }

  @ManyToOne
  @JoinColumn(name = "mapId")
  public MapVersion getMap() {
    return map;
  }

  public void setMap(MapVersion map) {
    this.map = map;
  }

  @Basic
  @Column(name = "gameName")
  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  @Basic
  @Column(name = "validity")
  public byte getValidity() {
    return validity;
  }

  public void setValidity(byte validity) {
    this.validity = validity;
  }

  @OneToMany(mappedBy = "game")
  public List<GamePlayerStats> getPlayerStats() {
    return playerStats;
  }

  public void setPlayerStats(List<GamePlayerStats> playerStats) {
    this.playerStats = playerStats;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startTime, victoryCondition, gameMod, host, map, gameName, validity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Game that = (Game) o;
    return id == that.id &&
        gameMod == that.gameMod &&
        validity == that.validity &&
        Objects.equals(startTime, that.startTime) &&
        Objects.equals(victoryCondition, that.victoryCondition) &&
        Objects.equals(host, that.host) &&
        Objects.equals(map, that.map) &&
        Objects.equals(gameName, that.gameName);
  }
}

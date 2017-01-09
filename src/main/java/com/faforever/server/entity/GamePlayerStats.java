package com.faforever.server.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "game_player_stats")
@Immutable
public class GamePlayerStats {

  private long id;
  private Player player;
  private byte ai;
  private byte faction;
  private byte color;
  private byte team;
  private byte place;
  private Double mean;
  private Double deviation;
  private Double afterMean;
  private Double afterDeviation;
  private byte score;
  private Timestamp scoreTime;
  private Game game;

  @Id
  @Column(name = "id")
  @GeneratedValue
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "playerId")
  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  @Basic
  @Column(name = "AI")
  public byte getAi() {
    return ai;
  }

  public void setAi(byte ai) {
    this.ai = ai;
  }

  @Basic
  @Column(name = "faction")
  public byte getFaction() {
    return faction;
  }

  public void setFaction(byte faction) {
    this.faction = faction;
  }

  @Basic
  @Column(name = "color")
  public byte getColor() {
    return color;
  }

  public void setColor(byte color) {
    this.color = color;
  }

  @Basic
  @Column(name = "team")
  public byte getTeam() {
    return team;
  }

  public void setTeam(byte team) {
    this.team = team;
  }

  @Basic
  @Column(name = "place")
  public byte getPlace() {
    return place;
  }

  public void setPlace(byte place) {
    this.place = place;
  }

  @Basic
  @Column(name = "mean")
  public Double getMean() {
    return mean;
  }

  public void setMean(Double mean) {
    this.mean = mean;
  }

  @Basic
  @Column(name = "deviation")
  public Double getDeviation() {
    return deviation;
  }

  public void setDeviation(Double deviation) {
    this.deviation = deviation;
  }

  @Basic
  @Column(name = "after_mean")
  public Double getAfterMean() {
    return afterMean;
  }

  public void setAfterMean(Double afterMean) {
    this.afterMean = afterMean;
  }

  @Basic
  @Column(name = "after_deviation")
  public Double getAfterDeviation() {
    return afterDeviation;
  }

  public void setAfterDeviation(Double afterDeviation) {
    this.afterDeviation = afterDeviation;
  }

  @Basic
  @Column(name = "score")
  public byte getScore() {
    return score;
  }

  public void setScore(byte score) {
    this.score = score;
  }

  @Basic
  @Column(name = "scoreTime")
  public Timestamp getScoreTime() {
    return scoreTime;
  }

  public void setScoreTime(Timestamp scoreTime) {
    this.scoreTime = scoreTime;
  }

  @ManyToOne
  @JoinColumn(name = "gameId")
  public Game getGame() {
    return game;
  }

  public void setGame(Game replay) {
    this.game = replay;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, game, player, ai, faction, color, team, place, mean, deviation, afterMean, afterDeviation, score, scoreTime);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GamePlayerStats that = (GamePlayerStats) o;
    return id == that.id &&
      ai == that.ai &&
      faction == that.faction &&
      color == that.color &&
      team == that.team &&
      place == that.place &&
      score == that.score &&
      Objects.equals(game, that.game) &&
      Objects.equals(player, that.player) &&
      Objects.equals(mean, that.mean) &&
      Objects.equals(deviation, that.deviation) &&
      Objects.equals(afterMean, that.afterMean) &&
      Objects.equals(afterDeviation, that.afterDeviation) &&
      Objects.equals(scoreTime, that.scoreTime);
  }
}

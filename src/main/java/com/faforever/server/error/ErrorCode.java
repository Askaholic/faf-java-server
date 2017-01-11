package com.faforever.server.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
  INVALID_LOGIN(100, "Invalid login credentials", "Please check your username and or password."),
  ALREADY_IN_GAME(101, "Already in game", "You can't join a game while you are still in another one."),
  NOT_IN_A_GAME(102, "Not in a game", "You are currently not associated with a game. This can happen if you got disconnected from the server."),
  CANT_JOIN_RUNNING_GAME(103, "Can't join running game", "The game you tried to join has already started and can't be joined anymore."),
  COOP_CANT_REPORT_NOT_IN_GAME(104, "Can't report Co-Op result", "Your game result could not be reported since you are not associated with a game. This may happen if you got disconnected from the server.");

  private final int code;
  private final String title;
  private final String detail;

  ErrorCode(int code, String title, String detail) {
    this.code = code;
    this.title = title;
    this.detail = detail;
  }
}

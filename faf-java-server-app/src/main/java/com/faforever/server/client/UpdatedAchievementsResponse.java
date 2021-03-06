package com.faforever.server.client;

import com.faforever.server.api.dto.AchievementState;
import com.faforever.server.common.ServerMessage;
import lombok.Data;

import java.util.List;

/**
 * Tells the client that the list of achievements has been updated.
 */
@Data
public class UpdatedAchievementsResponse implements ServerMessage {
  private final List<UpdatedAchievement> updatedAchievements;

  @Data
  public static class UpdatedAchievement {
    private final String achievementId;
    private final Integer currentSteps;
    private final AchievementState currentState;
    private final boolean newlyUnlocked;
  }
}

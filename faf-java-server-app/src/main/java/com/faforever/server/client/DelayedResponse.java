package com.faforever.server.client;

import com.faforever.server.common.ServerMessage;
import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiFunction;

/**
 * Hold a response as well as information about when the it was created or updated. This information can be used to
 * determine whether or not a response should be processed.
 */
@Getter
public class DelayedResponse<T extends ServerMessage> {

  /**
   * The instant when this instance of {@link DelayedResponse} was created.
   */
  private final Instant createTime;
  /**
   * Minimum time to wait since the last {@code updateTime} before the object is allowed to be sent.
   */
  private final Duration minDelay;
  /**
   * Maximum time to wait since {@code createTime} until the object has to be sent.
   */
  private final Duration maxDelay;
  /**
   * Function to use to calculate the new value when the response is being updated.
   */
  private final BiFunction<T, T, T> aggregateFunction;
  /**
   * The response object.
   */
  private T response;
  /**
   * The instant when this {@link DelayedResponse} was updated.
   */
  private Instant updateTime;

  public DelayedResponse(T response, Duration minDelay, Duration maxDelay, BiFunction<T, T, T> aggregateFunction) {
    this.response = response;
    this.minDelay = minDelay;
    this.maxDelay = maxDelay;
    this.aggregateFunction = aggregateFunction;
    createTime = Instant.now();
    updateTime = createTime;
  }

  public void onUpdated(T object) {
    updateTime = Instant.now();
    if (object == this.response) {
      return;
    }
    this.response = aggregateFunction.apply(this.response, object);
  }

  @SuppressWarnings("unchecked")
  public Class<T> getType() {
    return (Class<T>) response.getClass();
  }
}

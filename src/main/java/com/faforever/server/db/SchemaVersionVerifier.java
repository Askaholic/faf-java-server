package com.faforever.server.db;

import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class SchemaVersionVerifier implements PriorityOrdered {

  private static final String DB_COMPATIBILITY_VERSION = "43";

  private final SchemaVersionRepository schemaVersionRepository;

  public SchemaVersionVerifier(SchemaVersionRepository schemaVersionRepository) {
    this.schemaVersionRepository = schemaVersionRepository;
  }

  @PostConstruct
  public void postConstruct() {
    String maxVersion = schemaVersionRepository.findMaxVersion()
      .orElseThrow(() -> new IllegalStateException("No database version is available"));

    Assert.state(Objects.equals(DB_COMPATIBILITY_VERSION, maxVersion),
      String.format("Database version is '%s' but this software requires '%s'", maxVersion, DB_COMPATIBILITY_VERSION));
  }

  @Override
  public int getOrder() {
    return HIGHEST_PRECEDENCE;
  }
}

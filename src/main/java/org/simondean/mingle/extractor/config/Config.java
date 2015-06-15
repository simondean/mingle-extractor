package org.simondean.mingle.extractor.config;

import java.util.List;

public class Config {
  private final List<Server> servers;

  public Config(List<Server> servers) {
    this.servers = servers;
  }

  public List<Server> servers() {
    return servers;
  }
}

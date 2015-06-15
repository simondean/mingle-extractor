package org.simondean.mingle.extractor.config;

import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class ConfigFactory {
  public Config load(JsonObject config) {
    return new Config(
      getServers(config));
  }

  private List<Server> getServers(JsonObject config) {
    JsonArray servers = config.getArray("servers");
    ArrayList<Server> loadedServers = new ArrayList<>();

    if (servers == null) {
      return loadedServers;
    }

    servers.forEach(serverObject -> {
      JsonObject server = (JsonObject) serverObject;
      loadedServers.add(getServer(server));
    });

    return loadedServers;
  }

  private Server getServer(JsonObject server) {
    return new Server(
      server.getString("name"),
      server.getString("host"),
      server.getInteger("port"),
      server.getString("path"),
      server.getBoolean("ssl"),
      server.getString("username"),
      server.getString("password"));
  }
}

package org.simondean.mingle.extractor;

import org.vertx.java.core.Future;
import org.vertx.java.platform.Verticle;

public class MainVerticle extends Verticle {
  public void start(Future<Void> startFuture) {
    startFuture.setResult(null);
  }
}

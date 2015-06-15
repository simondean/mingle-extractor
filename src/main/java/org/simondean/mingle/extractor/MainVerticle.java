package org.simondean.mingle.extractor;

import org.simondean.mingle.extractor.config.Config;
import org.simondean.mingle.extractor.config.ConfigFactory;
import org.simondean.vertx.async.Async;
import org.simondean.vertx.async.DefaultAsyncResult;
import org.vertx.java.core.Future;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

public class MainVerticle extends Verticle {
  private Logger logger;
  private Config config;

  public void start(Future<Void> startFuture) {
    logger = container.logger();
    config = new ConfigFactory().load(container.config());
    startFuture.setResult(null);

    Async.forever()
      .task(handler -> {
        // TODO: Call the Mingle Events API

        handler.handle(DefaultAsyncResult.succeed());
      })
      .run(vertx, result -> {
        // Never called
        logger.fatal("Failed", result.cause());
      });
  }
}

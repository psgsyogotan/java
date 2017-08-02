package java8.ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModifyLogger {
	Logger logger;

	public ModifyLogger(Logger logger, Level level) {
		this.logger = logger;
		logger.setLevel(level);
	}

	public void logIf(Level level, BooleanSupplier condition, String message) {
		if (logger.isLoggable(level)) {
			if (condition.getAsBoolean()) {
				logger.log(level, message);
			}
		}
	}

	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();

		ModifyLogger mLogger = new ModifyLogger(logger, Level.FINER);
		mLogger.logIf(Level.FINE, () -> true, "FINE");
		mLogger.logIf(Level.INFO, () -> true, "INFO");
		mLogger.logIf(Level.SEVERE, () -> true, "SEVERE");

	}

}

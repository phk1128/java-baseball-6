package baseball.util;

import java.util.function.Supplier;

public class LoopTemplate {

	private LoopTemplate() {

	}

	public static <T> T tryCatchTemplate(Supplier<T> supplier) {
		while (true) {
			try {
				return supplier.get();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

package de.fseebach.eventsourcing;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Functions {


	public static <K, V> BiFunction<K, V, V> useExistingOrCreate(Supplier<V> newSupplier) {
		return (k, v) -> v == null ? newSupplier.get() : v;
	}
}
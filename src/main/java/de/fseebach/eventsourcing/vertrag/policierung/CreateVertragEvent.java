package de.fseebach.eventsourcing.vertrag.policierung;

import de.fseebach.eventsourcing.Event;
import de.fseebach.eventsourcing.vertrag.Vertrag;

public class CreateVertragEvent implements Event<Vertrag> {

	@Override
	public Vertrag apply(Vertrag aggregate) {
		return new Vertrag();
	}

}

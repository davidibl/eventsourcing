package de.fseebach.eventsourcing.vertrag.policierung;

import java.util.UUID;

import de.fseebach.eventsourcing.Event;
import de.fseebach.eventsourcing.vertrag.Vertrag;

public class CreateVNREvent implements Event<Vertrag> {

	@Override
	public Vertrag apply(Vertrag aggregate) {
		aggregate.setVnr(UUID.randomUUID().toString());
		return aggregate;
	}

}

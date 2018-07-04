package de.fseebach.eventsourcing.vertrag.policierung;

import java.util.List;

import de.fseebach.eventsourcing.Command;
import de.fseebach.eventsourcing.Event;
import de.fseebach.eventsourcing.vertrag.Vertrag;

public class PolicierungsCommand implements Command<Vertrag> {

	@Override
	public List<Event<Vertrag>> getEvents() {
		// TODO Auto-generated method stub
		return List.of(new CreateVertragEvent(), new CreateVNREvent());
	}

}

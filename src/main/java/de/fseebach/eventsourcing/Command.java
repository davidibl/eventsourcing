package de.fseebach.eventsourcing;

import java.util.List;

public interface Command<AggregateType> {

	public List<Event<AggregateType>> getEvents();
	
}

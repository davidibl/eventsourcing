package de.fseebach.eventsourcing;

public interface Event<AggregateType> {

	
	public AggregateType apply(AggregateType aggregate);
	
}

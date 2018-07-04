package de.fseebach.eventsourcing;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AggregateManager {

	
	@Autowired
	private CommandStore commandStore;
	
	public <T> T getAggregate(Long id, Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		List<Command<T>> commandSet = commandStore.getCommandSet(clazz, id);
		
		List<Event<T>> events = commandSet.stream().flatMap(c -> c.getEvents().stream()).collect(Collectors.toList());
		
		T aggregate = null;
		
		for (Event<T> event : events) {
			aggregate = event.apply(aggregate);
		}
		
		return aggregate;
	};
	
}

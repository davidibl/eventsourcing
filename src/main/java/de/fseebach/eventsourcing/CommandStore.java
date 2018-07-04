package de.fseebach.eventsourcing;

import static de.fseebach.eventsourcing.Functions.useExistingOrCreate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommandStore {

	public Map<Class<?>, HashMap<Long, List<Command<?>>>> store = new HashMap<>();

	@SuppressWarnings("unchecked")
	public <T extends List<?>> T getCommandSet(Class<?> aggregateType, Long aggregateId){
		return (T) store.get(aggregateType).get(aggregateId);
	}
	
	public void appendCommand(Class<?> aggregateType, Long aggregateId, Command<?> command) {
		
		store
			.compute(aggregateType, useExistingOrCreate(HashMap::new))
			.compute(aggregateId, useExistingOrCreate(ArrayList::new))
			.add(command);
		
	}
	

	
}

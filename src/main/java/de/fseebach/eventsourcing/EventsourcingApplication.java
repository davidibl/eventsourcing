package de.fseebach.eventsourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.fseebach.eventsourcing.vertrag.Vertrag;
import de.fseebach.eventsourcing.vertrag.policierung.PolicierungsCommand;
import de.fseebach.eventsourcing.vertrag.zuzahlung.ZuzahlungCommand;

@SpringBootApplication
public class EventsourcingApplication implements CommandLineRunner {

	@Autowired
	AggregateManager am;
	
	@Autowired
	CommandStore cs;
	
	public static void main(String[] args) {
		SpringApplication.run(EventsourcingApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		cs.appendCommand(Vertrag.class, 1L, new PolicierungsCommand());
		cs.appendCommand(Vertrag.class, 1L, new ZuzahlungCommand(10000L));
		
		Vertrag aggregate = am.getAggregate(1L, Vertrag.class);
		
	}
	
	
}

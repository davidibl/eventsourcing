package de.fseebach.eventsourcing.vertrag.zuzahlung;

import de.fseebach.eventsourcing.Event;
import de.fseebach.eventsourcing.vertrag.Vertrag;

public class ZuzahlungEvent implements Event<Vertrag> {

	private Long zuzahlungsBetrag;
	
	public ZuzahlungEvent(Long zuzahlungsBetrag) {
		this.zuzahlungsBetrag = zuzahlungsBetrag;
	}


	@Override
	public Vertrag apply(Vertrag aggregate) {
		aggregate.einzahlen(zuzahlungsBetrag);
		return aggregate;
	}

}

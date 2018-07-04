package de.fseebach.eventsourcing.vertrag;

import de.fseebach.eventsourcing.Event;

public class KostenentnahmeEvent implements Event<Vertrag> {

	private Long kostenHoehe;
	
	public KostenentnahmeEvent(Long kostenHoehe) {
		super();
		this.kostenHoehe = kostenHoehe;
	}

	@Override
	public Vertrag apply(Vertrag aggregate) {
		aggregate.auszahlen(kostenHoehe);
		return aggregate;
	}

}

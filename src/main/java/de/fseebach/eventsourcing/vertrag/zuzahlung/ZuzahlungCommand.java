package de.fseebach.eventsourcing.vertrag.zuzahlung;

import java.util.List;

import de.fseebach.eventsourcing.Command;
import de.fseebach.eventsourcing.Event;
import de.fseebach.eventsourcing.vertrag.KostenentnahmeEvent;
import de.fseebach.eventsourcing.vertrag.Vertrag;

public class ZuzahlungCommand implements Command<Vertrag> {

	private Long zuzahlungsHoehe;
	private Long pauschalKosten = 500L;
	
	public ZuzahlungCommand(Long zuzahlungsHoehe) {
		super();
		this.zuzahlungsHoehe = zuzahlungsHoehe;
	}



	@Override
	public List<Event<Vertrag>> getEvents() {
		return List.of(new ZuzahlungEvent(zuzahlungsHoehe), new KostenentnahmeEvent(pauschalKosten));
	}


}

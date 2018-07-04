package de.fseebach.eventsourcing.vertrag;

import de.fseebach.eventsourcing.Aggregate;

public class Vertrag implements Aggregate {

	private Long id;
	private String vnr;
	
	private Long vermoegen = 0L;

	
	
	public Vertrag() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public String getVnr() {
		return vnr;
	}

	public void setVnr(String vnr) {
		this.vnr = vnr;
	}

	public Long getVermoegen() {
		return vermoegen;
	}

	public void einzahlen(Long betrag) {
		this.vermoegen+=betrag;
	}
	
	public void auszahlen(Long betrag) {
		this.vermoegen-=betrag;
	}
	
	

}

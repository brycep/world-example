package com.servolabs.world.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="continent")

// Uncomment these lines to get L2 Cache capabilities
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY	)
public class Continent {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	public Continent() {	
	}

	public Continent(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

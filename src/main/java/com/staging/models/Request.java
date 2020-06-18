package com.staging.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="request")
public class Request {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	private String sport_type;
	private int player;
	private int skill_level;
	private String time_schedule;
	private String address;
	
	@OneToMany(mappedBy = "request", cascade = { CascadeType.ALL })
	private Set<Participant> participant;
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Request(int id, Account account, String sport_type, int player, int skill_level, String time_schedule,
			String address) {
		super();
		this.id = id;
		this.account = account;
		this.sport_type = sport_type;
		this.player = player;
		this.skill_level = skill_level;
		this.time_schedule = time_schedule;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSport_type() {
		return sport_type;
	}


	public void setSport_type(String sport_type) {
		this.sport_type = sport_type;
	}


	public int getPlayer() {
		return player;
	}


	public void setPlayer(int player) {
		this.player = player;
	}


	public int getSkill_level() {
		return skill_level;
	}


	public void setSkill_level(int skill_level) {
		this.skill_level = skill_level;
	}


	public String getTime_schedule() {
		return time_schedule;
	}


	public void setTime_schedule(String time_schedule) {
		this.time_schedule = time_schedule;
	}
	
	
	

}

package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long id;
	    private String first_name;
	    private String Last_Name;
	    private String mobile_number;
	    private String source;
	    private String destination;
	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private String dateOfJourney;
	    private String seat;
	    private String meal;
	    private String baggage;
	    private String callforService;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_Name() {
			return Last_Name;
		}
		public void setLast_Name(String last_Name) {
			Last_Name = last_Name;
		}
		public String getMobile_number() {
			return mobile_number;
		}
		public void setMobile_number(String mobile_number) {
			this.mobile_number = mobile_number;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getDateOfJourney() {
			return dateOfJourney;
		}
		public void setDateOfJourney(String dateOfJourney) {
			this.dateOfJourney = dateOfJourney;
		}
		public String getSeat() {
			return seat;
		}
		public void setSeat(String seat) {
			this.seat = seat;
		}
		public String getMeal() {
			return meal;
		}
		public void setMeal(String meal) {
			this.meal = meal;
		}
		public String getBaggage() {
			return baggage;
		}
		public void setBaggage(String baggage) {
			this.baggage = baggage;
		}
		
		
		
		public String getCallforService() {
			return callforService;
		}
		public void setCallforService(String callforService) {
			this.callforService = callforService;
		}
		public Client(long id, String first_name, String last_Name, String mobile_number, String source,
				String destination, String dateOfJourney, String seat, String meal, String baggage,String callforService) {
			super();
			this.id = id;
			this.first_name = first_name;
			Last_Name = last_Name;
			this.mobile_number = mobile_number;
			this.source = source;
			this.destination = destination;
			this.dateOfJourney = dateOfJourney;
			this.seat = seat;
			this.meal = meal;
			this.baggage = baggage;
			this.callforService=callforService;
		}
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}

	
}
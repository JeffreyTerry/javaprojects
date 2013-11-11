package Daniel;

import java.io.Serializable;

public class Location implements Serializable{
	private static final long serialVersionUID = 1L;
	private String city;
	private String stateOrProvince;
	private String country;
	public Location(String city, String country){
		this.city = city;
		this.country = country;
	}
	public Location(String city, String stateOrProvince, String country){
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateOrProvence() {
		return stateOrProvince;
	}
	public void setStateOrProvence(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String toString(){
		if(stateOrProvince != null){
			return city + ", " + stateOrProvince + ", " + country;
		}
		else{
			return city + ", " + country;
		}
	}
}

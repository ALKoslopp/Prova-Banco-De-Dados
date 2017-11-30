package TestesEperimento;

public class ManipulaDado {
	
	private String idTaxi;
	private String dataTime;
	private String longitude;
	private String latitude;
	
	
	public ManipulaDado() {
		
	}

	public String getIdTaxi() {
		return idTaxi;
	}

	public void setIdTaxi(String idTaxi) {
		this.idTaxi = idTaxi;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "ManipulaDado [idTaxi=" + idTaxi + ", dataTime=" + dataTime + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}
	
	

}

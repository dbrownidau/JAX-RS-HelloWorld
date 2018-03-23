package au.id.dbrown.example.helloworld.servlets.hellojson.simplemodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleModel {

	public SimpleModel(int id, String string) {
		this.id = id;
		this.string = string;
	}

	private int id;
	private String string;

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("string")
	public String getString() {
		return string;
	}

	@JsonProperty("string")
	public void setString(String string) {
		this.string = string;
	}

}

package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Result {

	private String ahlete;


	private List<String> resultOfEvents;
	private int totalScore;

	public String getAhlete() {
		return ahlete;
	}

	public void setAhlete(String ahlete) {
		this.ahlete = ahlete;
	}


	@XmlElementWrapper(name = "resultOfEvents")
	@XmlElement(name = "resultOfEvent")
	public List<String> getResultOfEvents() {
		return resultOfEvents;
	}

	public void addResultOfEvent(String resultOfEvent) {
		if (resultOfEvents == null) {
			resultOfEvents = new ArrayList<>();
		}
		resultOfEvents.add(resultOfEvent);
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}

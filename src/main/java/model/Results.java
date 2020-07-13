package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "results")
public class Results {


	private List<Result> results;

	public Results() {
	}

	public Results(List<Result> results) {
		this.results = results;
	}

	@XmlElement(name = "result")
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}

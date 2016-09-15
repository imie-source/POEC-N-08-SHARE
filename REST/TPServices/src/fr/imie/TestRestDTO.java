package fr.imie;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="testDTO")
public class TestRestDTO implements Serializable {
	private String text = "hello";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

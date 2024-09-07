package com.loyalistcollege.com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Table(name = "wikimedia_recentChange")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WikimediaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Lob
	private String WikiEventData;
	public String getWikiEventData() {
		return WikiEventData;
	}
	public void setWikiEventData(String wikiEventData) {
		WikiEventData = wikiEventData;
	}

}

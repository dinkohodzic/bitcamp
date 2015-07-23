package ba.bitcamp.test;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		// Testing Showpiece class
		Showpiece sp1 = new Showpiece("SP01", "showpiece1", "description1");
		Showpiece sp2 = new Showpiece("SP02", "showpiece2", "description2");
		Showpiece sp3 = new Showpiece("SP03", "showpiece3", "description3");
		Showpiece sp4 = new Showpiece("SP04", "showpiece4", "description4");
		Showpiece sp5 = new Showpiece("SP05", "showpiece5", "description5");
		Showpiece sp6 = new Showpiece("SP06", "showpiece6", "description6");
		Showpiece sp7 = new Showpiece("SP07", "showpiece7", "description7");

		ArrayList<Showpiece> showPieces = new ArrayList<>();

		showPieces.add(sp1);
		showPieces.add(sp2);
		showPieces.add(sp3);
		showPieces.add(sp4);
		showPieces.add(sp5);
		showPieces.add(sp6);
		showPieces.add(sp7);
		
		

		// Testing ArtPiece class
		ArtPiece ap1 = new ArtPiece("AP01", "artpiece1", "description1", "author1", Epochs.CLASSIC);
		ArtPiece ap2 = new ArtPiece("AP02", "artpiece2", "description2", "author2", Epochs.CONTEMPORARY);
		ArtPiece ap3 = new ArtPiece("AP03", "artpiece3", "description3", "author3", Epochs.MODERN);
		ArtPiece ap4 = new ArtPiece("AP04", "artpiece4", "description4", "author4", Epochs.NEOCLASSICS);
		ArtPiece ap5 = new ArtPiece("AP05", "artpiece5", "description5", "author5", Epochs.RENESANCE);
		ArtPiece ap6 = new ArtPiece("AP06", "artpiece6", "description6", "author6", Epochs.CLASSIC);
		ArtPiece ap7 = new ArtPiece("AP07", "artpiece7", "description7", "author7", Epochs.MODERN);

		ArrayList<ArtPiece> artPieces = new ArrayList<>();

		artPieces.add(ap1);
		artPieces.add(ap2);
		artPieces.add(ap3);
		artPieces.add(ap4);
		artPieces.add(ap5);
		artPieces.add(ap6);
		artPieces.add(ap7);
		
		//Testing Historical artifacts class
		HistoricalArtifact ha1 = new HistoricalArtifact("HA01", "artifact1", "description1", "origin1",
				TimePeriod.PRE_HISTORY);
		HistoricalArtifact ha2 = new HistoricalArtifact("HA02", "artifact2", "description2", "origin2",
				TimePeriod.ANCIENT_HISTORY);
		HistoricalArtifact ha3 = new HistoricalArtifact("HA03", "artifact3", "description3", "origin3",
				TimePeriod.MIDDLE_AGES);
		HistoricalArtifact ha4 = new HistoricalArtifact("HA04", "artifact4", "description4", "origin4",
				TimePeriod.MODERN_HISTORY);
		HistoricalArtifact ha5 = new HistoricalArtifact("HA05", "artifact5", "description5", "origin5",
				TimePeriod.ANCIENT_HISTORY);
		HistoricalArtifact ha6 = new HistoricalArtifact("HA06", "artifact6", "description6", "origin6",
				TimePeriod.MIDDLE_AGES);
		HistoricalArtifact ha7 = new HistoricalArtifact("HA07", "artifact7", "description7", "origin7",
				TimePeriod.PRE_HISTORY);
		
		ArrayList<HistoricalArtifact> artifacts = new ArrayList<>();
		
		artifacts.add(ha1);
		artifacts.add(ha2);
		artifacts.add(ha3);
		artifacts.add(ha4);
		artifacts.add(ha5);
		artifacts.add(ha6);
		artifacts.add(ha7);
		
		
		Employee emp1 = new Employee("John", "Doe", 31, Employee.MALE, 2000);
		Employee emp2 = new Employee("Jane", "Doe", 24, Employee.FEMALE, 3000);
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(emp1);
		employees.add(emp2);
		
		
		Museum museum = new Museum(showPieces, artPieces, artifacts, employees);
		
		System.out.println(museum);
		
		
	

	}

}

package ba.bitcamp.test;

import java.util.ArrayList;

public class Museum {
	//Attributes
	private ArrayList<Showpiece> showPieces;
	private ArrayList<ArtPiece> artPieces;
	private ArrayList<HistoricalArtifact> artifacts;
	private ArrayList<Employee> employees;
	//Constructor
	public Museum(ArrayList<Showpiece> showPieces, ArrayList<ArtPiece> artPieces,
			ArrayList<HistoricalArtifact> artifacts, ArrayList<Employee> employees) {
		super();
		this.showPieces = showPieces;
		this.artPieces = artPieces;
		this.artifacts = artifacts;
		this.employees = employees;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Museum: ");
		sb.append("\nShowpieces: " + showPieces);
		sb.append("\nArtpieces: " + artPieces);
		sb.append("\nHistorical Artifacts: " + artifacts);
		sb.append("\nEmployees: " + employees);
		return sb.toString();
	}

	
	

}

package ba.bitcamp.test;

public class ArtPiece extends Showpiece implements Searchable {

	// Attributes
	private String nameOfAuthor;
	private Epochs epoch;

	// Default constructor
	public ArtPiece(String id, String name, String description, String nameOfAuthor, Epochs epoch) {
		super(id, name, description);
		this.nameOfAuthor = nameOfAuthor;
		this.epoch = epoch;
	}

	/**
	 * @return the nameOfAuthor
	 */
	public String getNameOfAuthor() {
		return nameOfAuthor;
	}

	/**
	 * @param nameOfAuthor
	 *            the nameOfAuthor to set
	 */
	public void setNameOfAuthor(String nameOfAuthor) {
		this.nameOfAuthor = nameOfAuthor;
	}

	/**
	 * @return the epoch
	 */
	public Epochs getEpoch() {
		return epoch;
	}

	/**
	 * @param epoch
	 *            the epoch to set
	 */
	public void setEpoch(Epochs epoch) {
		this.epoch = epoch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((epoch == null) ? 0 : epoch.hashCode());
		result = prime * result + ((nameOfAuthor == null) ? 0 : nameOfAuthor.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ArtPiece))
			return false;
		ArtPiece other = (ArtPiece) obj;
		if (epoch != other.epoch)
			return false;
		if (nameOfAuthor == null) {
			if (other.nameOfAuthor != null)
				return false;
		} else if (!nameOfAuthor.equals(other.nameOfAuthor))
			return false;
		return true;
	}

	// toString method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nArtpiece: ");
		sb.append("\nAuthor: " + nameOfAuthor);
		if (epoch == Epochs.CLASSIC) {
			sb.append("\nEpoch :  Classic Art");
		} else if (epoch == Epochs.CONTEMPORARY) {
			sb.append("\nEpoch : Contemporary Art");
		} else if (epoch == Epochs.MODERN) {
			sb.append("\nEpoch : Modern Art");
		} else if (epoch == Epochs.NEOCLASSICS) {
			sb.append("\nEpoch : Neoclassic Art");
		} else if (epoch == Epochs.RENESANCE) {
			sb.append("\nEpoch : Renesance Art");
		}

		return sb.toString();
	}

	@Override
	public boolean fitsSearch(String s) {
		if (nameOfAuthor.contains(s) || epoch.toString().contains(s)) {
			return true;
		}
		return false;
	}

}

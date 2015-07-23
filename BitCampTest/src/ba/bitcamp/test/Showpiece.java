package ba.bitcamp.test;

public class Showpiece implements Comparable<Showpiece>, Searchable {

	// Attributes
	private String id;
	private String name;
	private String description;

	/**
	 * Default constructor
	 * 
	 * @param id
	 *            The ID as Integer
	 * @param name
	 *            The name of a Showpiece
	 * @param description
	 *            The description of the Showpiece
	 */
	public Showpiece(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// Standard toString method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nShow Piece:");
		sb.append("\nID: " + id);
		sb.append("\nName: " + name);
		sb.append("\nDescription: " + description + "\n");

		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (obj == null)
			return false;
		if (!(obj instanceof Showpiece))
			return false;
		Showpiece other = (Showpiece) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * This method compares 2 names
	 */
	@Override
	public int compareTo(Showpiece o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public boolean fitsSearch(String s) {
		if (name.contains(s) || id.contains(s) || description.contains(s)) {
			return true;
		}
		return false;
	}

}

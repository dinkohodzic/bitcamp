package ba.bitcamp.test;

public class HistoricalArtifact extends Showpiece implements Searchable {

	// Attributes
	private String origin;
	private TimePeriod period;

	// Default constructor
	public HistoricalArtifact(String id, String name, String description, String origin, TimePeriod period) {
		super(id, name, description);
		this.origin = origin;
		this.period = period;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin
	 *            the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the period
	 */
	public TimePeriod getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(TimePeriod period) {
		this.period = period;
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
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		if (!(obj instanceof HistoricalArtifact))
			return false;
		HistoricalArtifact other = (HistoricalArtifact) obj;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (period != other.period)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nHistorical Artifact: ");
		sb.append("\nOrigin: " + origin);
		if (period == TimePeriod.PRE_HISTORY) {
			sb.append("\nHistorical Time Period : Pre History");
		} else if (period == TimePeriod.ANCIENT_HISTORY) {
			sb.append("\nHistorical Time Period : Ancient History");
		} else if (period == TimePeriod.MIDDLE_AGES) {
			sb.append("\nHistorical Time Period : Middle Ages");
		} else if (period == TimePeriod.MODERN_HISTORY) {
			sb.append("\nHistorical Time Period : Modern History");
		}
		return sb.toString();
	}

	@Override
	public boolean fitsSearch(String s) {
		if (origin.contains(s) || period.toString().contains(s)) {
			return true;
		}
		return false;
	}

}

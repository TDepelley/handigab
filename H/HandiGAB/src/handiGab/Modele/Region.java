package handiGab.Modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "REGION")

public class Region
{

	@Id
	@Column(name = "CODE", nullable = false, length=5)
	private String id;

	@OrderBy
	@Column(nullable=false, length=35 , name = "NAME")
	private String libelleRegion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PAYS", nullable = false)
	private Pays codePays;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelleRegion() {
		return libelleRegion;
	}
	public void setLibelleRegion(String libelleRegion) {
		this.libelleRegion = libelleRegion;
	}
	public Pays getCodePays() {
		return codePays;
	}
	public void setCodePays(Pays codePays) {
		this.codePays = codePays;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Region)) {
			return false;
		}
		Region rhs = (Region) object;
		return new EqualsBuilder()
		.append(this.codePays, rhs.codePays)
		.append(this.libelleRegion, rhs.libelleRegion)
		.append(this.id,rhs.id)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1132758497, -2095107083)
		.append(this.codePays)
		.append(this.libelleRegion)
		.append(this.id)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("codePays", this.codePays)
		.append("id", this.id)
		.append("libelleRegion",this.libelleRegion)
		.toString();
	}
}

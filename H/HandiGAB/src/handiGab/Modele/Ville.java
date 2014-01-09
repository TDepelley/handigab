package handiGab.Modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "VILLE")
public class Ville  {

	/**
	 * 
	 */

	@Id
	@Column(name = "CODE", nullable = false, length=5)
	private String id;
	
	@Column(nullable = false, length=50, name = "NAME")
	private String libelleVille;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "REGION", nullable = false)
	private Region codeRegion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelleVille() {
		return libelleVille;
	}
	public void setLibelleVille(String libelleVille) {
		this.libelleVille = libelleVille;
	}
	public Region getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(Region codeRegion) {
		this.codeRegion = codeRegion;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Ville)) {
			return false;
		}
		Ville rhs = (Ville) object;
		return new EqualsBuilder()
		.append(this.codeRegion, rhs.codeRegion)
		.append(this.libelleVille, rhs.libelleVille)
		.append(this.id,rhs.id)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1132758497, -2095107083)
		.append(this.codeRegion)
		.append(this.libelleVille)
		.append(this.id)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("codeRegion", this.codeRegion)
		.append("id", this.id)
		.append("libelleVille",this.libelleVille)
		.toString();
	}
}

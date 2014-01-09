package handiGab.Modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name = "DEVISE")
public class Devise {


	@Id
	@Column(name = "CODE", nullable = false, length = 3)
	private String codeDevIsoNum;
	
	@OrderBy
	@Column(nullable=false, length=35, name = "LIBELLE")
	private String libelle;
	
	@Column(name = "CODEISO",nullable=false, length=3)
	private String codeDevIsoAlpha;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libellevip) {
		this.libelle = libellevip;
	}
	public String getCodeDevIsoNum() {
		return codeDevIsoNum;
	}
	public void setCodeDevIsoNum(String codeDevIsoNum) {
		this.codeDevIsoNum = codeDevIsoNum;
	}
	public String getCodeDevIsoAlpha() {
		return codeDevIsoAlpha;
	}
	public void setCodeDevIsoAlpha(String codeDevIsoAlpha) {
		this.codeDevIsoAlpha = codeDevIsoAlpha;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Devise)) {
			return false;
		}
		Devise rhs = (Devise) object;
		return new EqualsBuilder()
		.append(this.codeDevIsoAlpha, rhs.codeDevIsoAlpha)
		.append(this.libelle, rhs.libelle)
		.append(this.codeDevIsoNum, rhs.codeDevIsoNum)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1480625977, 1935591155)
		.append(this.codeDevIsoAlpha)
		.append(this.libelle)
		.append(this.codeDevIsoNum)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("libelle", this.libelle)
		.append("codeDevIsoNum", this.codeDevIsoNum)
		.toString();
	}
}
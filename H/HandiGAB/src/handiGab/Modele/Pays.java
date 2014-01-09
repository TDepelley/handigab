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
@Table(name = "PAYS")
public class Pays {


	@Id
	@Column(name = "CODE", nullable = false,length=3)
	private String codeIsoNum;
	
	@OrderBy
	@Column(nullable=false, length=50, name = "NAME")
	private String libellePays;
	
	@Column(nullable=false, length=50, name = "NATIONALITE")
	private String nationalite;
	
	@Column(nullable = true, length=3, name = "CODEISO")
	private String codeIsoAlpha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVISE", nullable = false)
	private Devise idDevise;
		
	public Devise getIdDevise() {
		return idDevise;
	}
	public void setIdDevise(Devise idDevise) {
		this.idDevise = idDevise;
	}
	public String getLibellePays() {
		return libellePays;
	}
	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getCodeIsoNum() {
		return codeIsoNum;
	}
	public void setCodeIsoNum(String codeIsoNum) {
		this.codeIsoNum = codeIsoNum;
	}
	public String getCodeIsoAlpha() {
		return codeIsoAlpha;
	}
	public void setCodeIsoAlpha(String codeIsoAlpha) {
		this.codeIsoAlpha = codeIsoAlpha;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Pays)) {
			return false;
		}
		Pays rhs = (Pays) object;
		return new EqualsBuilder()
				.append(this.codeIsoAlpha, rhs.codeIsoAlpha)
				.append(this.libellePays, rhs.libellePays)
				.append(this.codeIsoNum, rhs.codeIsoNum)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1480625977, 1935591155)
			.append(this.codeIsoAlpha)
			.append(this.libellePays)
			.append(this.codeIsoNum)
			.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("libelle", this.libellePays)
			.append("id", this.codeIsoNum)
			.append("codeIso", this.codeIsoAlpha)
			.toString();
	}
}

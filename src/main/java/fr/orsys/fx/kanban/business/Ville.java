package fr.orsys.fx.kanban.business;

public class Ville {

	// On ne peut pas utiliser le codeInsee comme clé car certaines communes
	// partagent le même code Insee
	private Long id;
		
	private String codeInsee;
	private String nom;
	private String codePostal;
	private double longitude;
	private double latitude;
	private String complement;
	
	public Ville(String codeInsee, String nom, String codePostal) {
		this.codeInsee = codeInsee;
		this.nom = nom;
		this.codePostal = codePostal;
	}

	public Ville(String nomCommune, String codePostal) {
		nom = nomCommune;
		this.codePostal = codePostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	private String getDepartement() {
		if (codePostal.length()==5) {
			return codePostal.substring(0, 2);	
		}
		return codePostal.substring(0, 1);
	}
	
	public String getNomDepartementComplement() {
		return nom + getDepartement() + complement;
	}

	@Override
	public String toString() {
		return "Ville [codeInsee=" + codeInsee + ", nom=" + nom + ", codePostal=" + codePostal + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

	
}

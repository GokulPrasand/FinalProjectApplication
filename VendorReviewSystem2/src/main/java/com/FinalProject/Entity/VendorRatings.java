package com.FinalProject.Entity;

public class VendorRatings {
	
	private String vendorname;
	private int noofreviews;
	private int noofones;
	private int nooftwos;
	private int noofthrees;
	private int nooffours;
	private int nooffives;
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public int getNoofreviews() {
		return noofreviews;
	}
	public void setNoofreviews(int noofreviews) {
		this.noofreviews = noofreviews;
	}
	public int getNoofones() {
		return noofones;
	}
	public void setNoofones(int noofones) {
		this.noofones = noofones;
	}
	public int getNooftwos() {
		return nooftwos;
	}
	public void setNooftwos(int nooftwos) {
		this.nooftwos = nooftwos;
	}
	public int getNoofthrees() {
		return noofthrees;
	}
	public void setNoofthrees(int noofthrees) {
		this.noofthrees = noofthrees;
	}
	public int getNooffours() {
		return nooffours;
	}
	public void setNooffours(int nooffours) {
		this.nooffours = nooffours;
	}
	public int getNooffives() {
		return nooffives;
	}
	public void setNooffives(int nooffives) {
		this.nooffives = nooffives;
	}
	public VendorRatings(String vendorname, int noofreviews, int noofones, int nooftwos, int noofthrees, int nooffours,
			int nooffives) {
		super();
		this.vendorname = vendorname;
		this.noofreviews = noofreviews;
		this.noofones = noofones;
		this.nooftwos = nooftwos;
		this.noofthrees = noofthrees;
		this.nooffours = nooffours;
		this.nooffives = nooffives;
	}
	public VendorRatings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

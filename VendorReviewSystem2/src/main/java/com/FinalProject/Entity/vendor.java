package com.FinalProject.Entity;
import java.sql.Blob;

public class vendor {
	
	private String vendorid;
	private String vendorname;
	private String email;
	private String password;
	private String location;
	private String websiteid;
	private String vendortype;
	private String cusinetype;
	private byte[] uploadmenucard;
	private byte[] uploadphoto;
	private String reqstatus;
	
	private String activestatus;

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsiteid() {
		return websiteid;
	}

	public void setWebsiteid(String websiteid) {
		this.websiteid = websiteid;
	}

	public String getVendortype() {
		return vendortype;
	}

	public void setVendortype(String vendortype) {
		this.vendortype = vendortype;
	}

	public String getCusinetype() {
		return cusinetype;
	}

	public void setCusinetype(String cusinetype) {
		this.cusinetype = cusinetype;
	}

	public byte[] getUploadmenucard() {
		return uploadmenucard;
	}

	public void setUploadmenucard(byte[] uploadmenucard) {
		this.uploadmenucard = uploadmenucard;
	}

	public byte[] getUploadphoto() {
		return uploadphoto;
	}

	public void setUploadphoto(byte[] uploadphoto) {
		this.uploadphoto = uploadphoto;
	}

	public String getReqstatus() {
		return reqstatus;
	}

	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}

	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}

	public vendor(String vendorid, String vendorname, String email, String password, String location, String websiteid,
			String vendortype, String cusinetype, byte[] uploadmenucard, byte[] uploadphoto, String reqstatus,
			String activestatus) {
		super();
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.email = email;
		this.password = password;
		this.location = location;
		this.websiteid = websiteid;
		this.vendortype = vendortype;
		this.cusinetype = cusinetype;
		this.uploadmenucard = uploadmenucard;
		this.uploadphoto = uploadphoto;
		this.reqstatus = reqstatus;
		this.activestatus = activestatus;
	}

	public vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
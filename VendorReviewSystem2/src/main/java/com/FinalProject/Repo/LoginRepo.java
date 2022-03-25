package com.FinalProject.Repo;

import java.sql.Blob;
import java.util.List;

import com.FinalProject.Entity.UserDetails;
import com.FinalProject.Entity.accounts;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;

public interface LoginRepo {
	
	public boolean validateAdmin(String username,String password);
	public vendor validatevendor(String vendorid,String password);
	public foodie validatefoodie(String foodieid,String password);
    public boolean addvendor (vendor ven);
    public String addfoodie (foodie fod);
    public boolean makepayment(accounts acc);
    public String transcationAdmin(String vendorid, int amount);
    public String transcationVendor(String vendorid, int amount);
    public String getVendorId(String name);
    public String addToTransact(String user);
    public String addUserDetails(UserDetails ud);
    public List<String> getAllEmailsOfVendors();
    public List<String> getAllEmailsOfFoodies();
    public Blob getVendorPhotoById(int id);
    public Blob getMenuPhotoById(int id);
    public vendor getUernameVendor(String name, String email);
    public foodie getUernameFoodie(String name, String email);
   
    
    
}

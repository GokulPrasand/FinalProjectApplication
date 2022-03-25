package com.FinalProject.Repo;

import java.util.List;

import com.FinalProject.Entity.FoodieReviews;
import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;

public interface VendorRepo {
	
	public vendor getVendorById(String vendorid);
	public List<Reviews> viewReview(String vendorid);
	public String updateComplaint( String comp,String review);
	public String updateVendorProfile(vendor v);
	public List<FoodieReviews> getFoodieDetails(String vendorid);

}

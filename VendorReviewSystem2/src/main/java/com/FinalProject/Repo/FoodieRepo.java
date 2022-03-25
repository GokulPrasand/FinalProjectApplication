package com.FinalProject.Repo;

import java.util.List;

import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;

public interface FoodieRepo {
	
	public String addReview(Reviews obr);
	public List<vendor> showActivatedVendor();
	public vendor getVendorByName(String vendorname);
	public foodie getFoodieById(String foodieid);
	public void setFoodieId(String fid);
	public String getFoodieId();
	public List<Reviews> viewReview(String foodieid);
	public String deleteReview(String fid,String vid);
	public String updateReview(String fid,String vid,String review);
	public Reviews getReviewByIds(String fid,String vid);
	public Reviews getReviewByReview(String review);
	public List<vendor> getVendorsByName(String name);
	public List<vendor> getVendorByLocation(String location);
	public List<vendor> getVendorByRating(String rating);
	public String updateProfile(foodie f);

}

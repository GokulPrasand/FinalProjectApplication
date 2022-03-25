package com.FinalProject.Repo;

import java.util.List;

import com.FinalProject.Entity.VendorRatings;

public interface VendorReviewRepo {
	
	public int countNumberOfReview(String name);
	public int countRatingOfOne(String name);
	public int countRatingOfTwo(String name);
	public int countRatingOfThree(String name);
	public int countRatingOfFour(String name);
	public int countRatingOfFive(String name);
	public List<VendorRatings> getRatingList();

}


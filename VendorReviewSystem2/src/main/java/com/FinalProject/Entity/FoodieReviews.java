package com.FinalProject.Entity;

/*select f.foodieid,f.firstname,f.mobile,r.dateofvisit,r.dateofreview,r.review,r.ratings
from foodie f join reviews r on f.foodieid=r.foodieid;*/


public class FoodieReviews {
	
	private String foodieid;
	private String firstname;
	private String mobile;
	private String dateofvisit;
	private String dateofreview;
	private String review;
	private String ratings;
	public String getFoodieid() {
		return foodieid;
	}
	public void setFoodieid(String foodieid) {
		this.foodieid = foodieid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDateofvisit() {
		return dateofvisit;
	}
	public void setDateofvisit(String dateofvisit) {
		this.dateofvisit = dateofvisit;
	}
	public String getDateofreview() {
		return dateofreview;
	}
	public void setDateofreview(String dateofreview) {
		this.dateofreview = dateofreview;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public FoodieReviews(String foodieid, String firstname, String mobile, String dateofvisit, String dateofreview,
			String review, String ratings) {
		super();
		this.foodieid = foodieid;
		this.firstname = firstname;
		this.mobile = mobile;
		this.dateofvisit = dateofvisit;
		this.dateofreview = dateofreview;
		this.review = review;
		this.ratings = ratings;
	}
	public FoodieReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

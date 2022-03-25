package com.FinalProject.RepoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.FinalProject.Entity.FoodieReviews;
import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.Repo.VendorRepo;

@Component
public class VendorRepoImpl implements VendorRepo {
	
	@Autowired
	JdbcTemplate jt;
	
	private String vendorid;

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	
	@Override
	public vendor getVendorById(String vendorid) {
		// TODO Auto-generated method stub
		String sql = "Select * from vendor where vendorid=?;";
		try
		{
			vendor x=(vendor) jt.queryForObject(sql, new Object[] {vendorid}, new BeanPropertyRowMapper(vendor.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
		
	}
	
	@Override
	public List<Reviews> viewReview(String vendorid) {
		// TODO Auto-generated method stub
		String vid=getVendorid();
		String sql = "Select * from reviews where vendorid='"+vid+"' and review is not null;";
		try {
			List<Reviews> reviewVAll = jt.query(sql, new BeanPropertyRowMapper(Reviews.class));
			if(reviewVAll.isEmpty()) {
				System.out.println("list is empty");
			}
			else
				System.out.println("list is not empty");
			return reviewVAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
		
	}

	@Override
	public String updateComplaint( String comp,String review) {
		// TODO Auto-generated method stub
		String str = "update reviews set complaint=? where review=?;";
		try
		{
			//int r=jt.update(str,comp,review);
			int r=jt.update(str,new Object[] {comp,review});
			if(r>=1)
			{
				return "Complaint Submitted Succesfully";
			}
			else
		       return "Error in Complaint Submission";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}finally {
			
		}
		
		return null;
	}
	
	@Override
	public String updateVendorProfile(vendor v) {
		// TODO Auto-generated method stub
		String sql="UPDATE vendor SET vendorname=?,password=?,email=?,location=?, websiteid=?,vendortype=?, cusinetype=?,uploadmenucard=?,uploadphoto=? WHERE vendorid=?;";
		try
		{
			int r=jt.update(sql, new Object[] {v.getVendorname(),v.getPassword(),v.getEmail(),v.getLocation(),v.getWebsiteid(),v.getVendortype(),v.getCusinetype(),v.getUploadmenucard(),v.getUploadphoto(),v.getVendorid()});
			if(r>=1)
			{
				return "Profile Updated Succesfully";
			}
			else
		       return "Error in profile updation";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}	
		return null;
	}

	@Override
	public List<FoodieReviews> getFoodieDetails(String vendorid) {
		// TODO Auto-generated method stub
		String vid=getVendorid();
		String sql = "select f.foodieid,f.firstname,f.mobile,r.dateofvisit,r.dateofreview,r.review,r.ratings from foodie f join reviews r on f.foodieid=r.foodieid where vendorid='"+vid+"' and review is not null;";
		try {
			List<FoodieReviews> reviewVAll = jt.query(sql ,new BeanPropertyRowMapper(FoodieReviews.class));
			if(reviewVAll.isEmpty()) {
				System.out.println("review list is empty");
			}
			else
				System.out.println("review list is not empty");
			return reviewVAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	
}

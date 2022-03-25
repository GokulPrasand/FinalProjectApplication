package com.FinalProject.RepoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.Repo.FoodieRepo;

@Component
public class FoodieRepoImpl implements FoodieRepo {
	
	@Autowired
	JdbcTemplate jt;
	
	private String foodieid;

	@Override
	public String addReview(Reviews obr) {
		// TODO Auto-generated method stub
		String str = "insert into reviews(vendorid,vendorname,location,foodieid,dateofvisit,dateofreview,review,ratings,complaint) values(?,?,?,?,?,?,?,?,?);";
		try
		{
			int r=jt.update(str, new Object[] {obr.getVendorid(),obr.getVendorname(),obr.getLocation(),obr.getFoodieid(),obr.getDateofvisit(),obr.getDateofreview(),obr.getReview(),obr.getRatings(),obr.getComplaint()});
			if(r>=1)
			{
				return "Review added Succesfully";
			}
			else
		       return "Error in review addition";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<vendor> showActivatedVendor() {
		// TODO Auto-generated method stub
		String sql = "Select * from vendor where reqstatus='approved' and activestatus='activated';";
		try {
		List<vendor> venderacAll = jt.query(sql, new BeanPropertyRowMapper(vendor.class));
		return venderacAll;
		}
		catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
		return null;
	
	}

	@Override
	public vendor getVendorByName(String vendorname) {
		// TODO Auto-generated method stub
		String sql = "Select * from vendor where vendorname=?;";
		try
		{
			vendor x=(vendor) jt.queryForObject(sql, new Object[] {vendorname}, new BeanPropertyRowMapper(vendor.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	
	}

	@Override
	public void setFoodieId(String foodieid) {
		// TODO Auto-generated method stub
		this.foodieid=foodieid;
		
		
	}

	@Override
	public String getFoodieId() {
		// TODO Auto-generated method stub
		return foodieid;
	}

	@Override
	public foodie getFoodieById(String foodieid) {
		// TODO Auto-generated method stub
		String sql = "Select * from foodie where foodieid=?;";
		try
		{
			foodie x=(foodie) jt.queryForObject(sql, new Object[] {foodieid}, new BeanPropertyRowMapper(foodie.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
		
	}

	@Override
	public List<Reviews> viewReview(String foodieid) {
		// TODO Auto-generated method stub
		String fid=getFoodieId();
		String sql = "Select * from reviews where foodieid='"+fid+"' and review is not null;";
		try {
			List<Reviews> reviewfAll = jt.query(sql, new BeanPropertyRowMapper(Reviews.class));
			if(reviewfAll.isEmpty()) {
				System.out.println("list is empty");
			}
			else
				System.out.println("list is not empty");
			return reviewfAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
		
	}

	@Override
	public String deleteReview(String fid, String vid) {
		// TODO Auto-generated method stub
		String str = "delete from reviews where foodieid=? and vendorid=?;";
		try
		{
			int r=jt.update(str, new Object[] {fid,vid});
			if(r>=1)
			{
				return "Review deleted Succesfully";
			}
			else
		       return "Error in review deletion";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public String updateReview(String fid, String vid, String review) {
		// TODO Auto-generated method stub
		String str = "update reviews set review=? where foodieid=? and vendorid=?;";
		try
		{
			int r=jt.update(str, new Object[] {review,fid,vid});
			if(r>=1)
			{
				return "Review Updated Succesfully";
			}
			else
		       return "Error in review Updation";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Reviews getReviewByIds(String fid, String vid) {
		// TODO Auto-generated method stub
		String sql = "Select * from reviews where foodieid=? and vendorid=?;";
		try
		{
			Reviews x=(Reviews) jt.queryForObject(sql, new Object[] {fid,vid}, new BeanPropertyRowMapper(Reviews.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Reviews getReviewByReview(String review) {
		// TODO Auto-generated method stub
		String sql = "Select * from reviews where review=?;";
		try
		{
			Reviews x=(Reviews) jt.queryForObject(sql, new Object[] {review}, new BeanPropertyRowMapper(Reviews.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
		
	}

	@Override
	public List<vendor> getVendorsByName(String name) {
		// TODO Auto-generated method stub
		String sql = "Select * from vendor where reqstatus='approved' and activestatus='activated' and vendorname=?;";
		try {
			List<vendor> vendernAll = jt.query(sql,new Object[] {name}, new BeanPropertyRowMapper(vendor.class));
			return vendernAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<vendor> getVendorByLocation(String location) {
		// TODO Auto-generated method stub
		String sql = "Select * from vendor where reqstatus='approved' and activestatus='activated' and location=?;";
		try {
			List<vendor> venderlAll = jt.query(sql,new Object[] {location}, new BeanPropertyRowMapper(vendor.class));
			return venderlAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<vendor> getVendorByRating(String rating) {
		// TODO Auto-generated method stub
		//String sql = "Select * from vendor where reqstatus='approved' and activestatus='activated' and rating=?;";
		String sql="select * from vendor where reqstatus='approved' and activestatus='activated' and vendorname in (select vendorname from reviews where ratings=?);";
		try {
			List<vendor> venderrAll = jt.query(sql,new Object[] {rating}, new BeanPropertyRowMapper(vendor.class));
			return venderrAll;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public String updateProfile(foodie f) {
		// TODO Auto-generated method stub
		String sql="UPDATE foodie SET firstname=?, lastname=?,password=?,confirmpassword=?,emailid=?,dob=?, gender=?,mobile=?, address=? WHERE foodieid=?;";
		try
		{
			int r=jt.update(sql, new Object[] {f.getFirstname(),f.getLastname(),f.getPassword(),f.getConfirmpassword(),f.getEmailid(),f.getDob(),f.getGender(),f.getMobile(),f.getAddress(),f.getFoodieid()});
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
	

}






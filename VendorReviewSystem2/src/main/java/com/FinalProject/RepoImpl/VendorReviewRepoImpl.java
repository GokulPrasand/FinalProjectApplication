package com.FinalProject.RepoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.FinalProject.Entity.VendorRatings;
import com.FinalProject.Entity.vendor;
import com.FinalProject.Repo.VendorReviewRepo;

@Component
public class VendorReviewRepoImpl implements VendorReviewRepo {
	
	@Autowired
	JdbcTemplate jt;
	
	@Autowired
	AdminRepoImpl ar;

	@Override
	public int countNumberOfReview(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(vendorname) from reviews where vendorname=?;";
		try
		{
			
			int vcount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return vcount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return 0;
	
	}
	
	@Override
	public int countRatingOfOne(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(ratings) from reviews where vendorname=? and ratings=1;";
		try
		{
			
			int twocount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return twocount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return 0;
	}

	@Override
	public int countRatingOfTwo(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(ratings) from reviews where vendorname=? and ratings=2;";
		try
		{
			
			int twocount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return twocount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return 0;
	}
	
	@Override
	public int countRatingOfThree(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(ratings) from reviews where vendorname=? and ratings=3;";
		try
		{
			
			int twocount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return twocount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return 0;
		
	}

	@Override
	public int countRatingOfFour(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(ratings) from reviews where vendorname=? and ratings=4;";
		try
		{
			
			int fourcount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return fourcount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return 0;
	}
	
	@Override
	public int countRatingOfFive(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(ratings) from reviews where vendorname=? and ratings=5;";
		try
		{
			
			int twocount=(int) jt.queryForObject(sql, new Object[] {name}, int.class);
			return twocount;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return 0;
		
	}

	@Override
	public List<VendorRatings> getRatingList() {
		// TODO Auto-generated method stub
		List<VendorRatings> vr=new ArrayList<VendorRatings>();
		
		List<vendor> vlist=ar.showAllApprovedvendor();
		
		for(vendor v:vlist) {
			String vname=v.getVendorname();
			int c=countNumberOfReview(vname);
			int c1=countRatingOfOne(vname);
			int c2=countRatingOfTwo(vname);
			int c3=countRatingOfThree(vname);
			int c4=countRatingOfFour(vname);
			int c5=countRatingOfFive(vname);
			
			VendorRatings ob=new VendorRatings(vname,c,c1,c2,c3,c4,c5);
			vr.add(ob);
			
		}
		
		return vr;
	}

	

	

	

}

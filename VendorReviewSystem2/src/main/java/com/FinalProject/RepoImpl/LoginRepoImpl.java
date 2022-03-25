package com.FinalProject.RepoImpl;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.FinalProject.Entity.UserDetails;
import com.FinalProject.Entity.accounts;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.Repo.LoginRepo;

@Component
public class LoginRepoImpl implements LoginRepo {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public boolean validateAdmin(String username, String password) {
		if(username.equals("Admin")&&password.equals("123"))
		{
			return true;
		}
		return false;
	}

	@Override
	public vendor validatevendor(String vendorid, String password) {
		String str="select*from vendor where vendorid=? and password=?;";
		try
		{
			vendor x=(vendor) jt.queryForObject(str, new Object[] {vendorid,password}, new BeanPropertyRowMapper(vendor.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public foodie validatefoodie(String foodieid, String password) {
		String str="select*from foodie where foodieid=? and password=?;";
		try
		{
			foodie x=(foodie) jt.queryForObject(str, new Object[] {foodieid,password}, new BeanPropertyRowMapper(foodie.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return null;
	}

	@Override
	public boolean addvendor(vendor ven) {
		String str = "insert into vendor(vendorname,email,location,websiteid,vendortype,cusinetype,uploadmenucard,uploadphoto,password) values(?,?,?,?,?,?,?,?,?);";
		try 
		{
			int r = jt.update(str, new Object[] {ven.getVendorname(),ven.getEmail(),ven.getLocation(),ven.getWebsiteid(),ven.getVendortype(),ven.getCusinetype(),ven.getUploadmenucard(),ven.getUploadphoto(),ven.getPassword()});
			if(r>=1)
			{
				return true;
			}
		
		else
		 	return false;
		}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			
		return false;
		}

	@Override
	public String addfoodie(foodie fod) {
		String str = "insert into foodie(firstname,lastname,password,confirmpassword,emailid,dob,gender,mobile,address) values(?,?,?,?,?,?,?,?,?);";
		try
		{
			int r=jt.update(str, new Object[] {fod.getFirstname(),fod.getLastname(),fod.getPassword(),fod.getConfirmpassword(),fod.getEmailid(),fod.getDob(),fod.getGender(),fod.getMobile(),fod.getAddress()});
			if(r>=1)
			{
				return "Foodie Added Successfully";
			}
			else
		       return "failed in Registration";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	return "failed";
	}

	@Override
	public boolean makepayment(accounts acc) {
		// TODO Auto-generated method stub
		String str="insert into accounts (vendorid,subscription,paidamount) values(?,?,?);";
		try
		{
			int r=jt.update(str, new Object[] {acc.getVendorid(),acc.getSubscription(),  acc.getPaidamount()});
			if(r>=1)
			{
				return true;
			}
			else
		       return false;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
		
	}

	@Override
	public String transcationAdmin(String vendorid, int amount) {
		// TODO Auto-generated method stub
		String str="update transact set balance=balance+? Where user='admin';";
		int r=jt.update(str,new Object[] {amount});
		if(r>=1)
		return "Amount transferred Succesfully";
		else
		return "Error Occured";
	}

	@Override
	public String transcationVendor(String vendorid, int amount) {
		// TODO Auto-generated method stub
		String str="update transact set balance=balance-? Where user=?;";
		int r=jt.update(str,new Object[] {amount,vendorid});
		if(r>=1)
		return "Amount transferred Succesfully";
		else
		return "Error Occured";
	}

	@Override
	public String getVendorId(String name) {
		String str="select vendorid from vendor where vendorname=?;";
		try
		{
		vendor x=(vendor) jt.queryForObject(str, new Object[] {name}, new BeanPropertyRowMapper(vendor.class));
		return x.getVendorid();
		}
		catch(Exception ex)
		{
		System.out.println(ex.getMessage());
		}



		return null;
	}

	@Override
	public String addToTransact(String user) {
		// TODO Auto-generated method stub
		String str="insert into transact (user) values(?);";
		try
		{
		int r=jt.update(str, new Object[] {user});
		if(r>=1)
		{
		return "Added";
		}
		else
		return "Error";
		}
		catch(Exception ex)
		{
		System.out.println(ex.getMessage());
		}

		return null;
	}

	@Override
	public String addUserDetails(UserDetails ud) {
		// TODO Auto-generated method stub
		String str="insert into userdetails (firstname,lastname,email,username,password,sq1,sq2,sq3 ) values(?,?,?,?,?,?,?,?);";
		try
		{
			int r=jt.update(str, new Object[] {ud.getFirstname(),ud.getLastname(),ud.getEmail(),ud.getUsername(),ud.getPassword(),ud.getSq1(),ud.getSq2(),ud.getSq3()});
			if(r>=1)
			{
				return "Added to userdetails";
			}
			else
		       return "fail in addition";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<String> getAllEmailsOfVendors() {
		// TODO Auto-generated method stub
		String sql = "Select email from vendor;";
		try {
		List<String> vmailAll = jt.query(sql, new BeanPropertyRowMapper(String.class));
		return vmailAll;
		}
		catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
		
		return null;
	}

	@Override
	public List<String> getAllEmailsOfFoodies() {
		// TODO Auto-generated method stub
		String sql = "Select emailid from foodie;";
		try {
		List<String> fmailAll = jt.query(sql, new BeanPropertyRowMapper(String.class));
		return fmailAll;
		}
		catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Blob getVendorPhotoById(int id) {

		String query = "select uploadphoto from vendor where vendorid=?";

		@SuppressWarnings("deprecation")
		Blob photo = jt.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}
	
	@Override
	public Blob getMenuPhotoById(int id) {

		String query = "select uploadmenucard from vendor where vendorid=?";

		@SuppressWarnings("deprecation")
		Blob photo = jt.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

	 @Override
		public vendor getUernameVendor(String name, String email) {
			// TODO Auto-generated method stub
			String str="select*from vendor where vendorname=? and email=?;";
			try
			{
				vendor x=(vendor) jt.queryForObject(str, new Object[] {name,email}, new BeanPropertyRowMapper(vendor.class));
				return x;
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			return null;
		}

		@Override
		public foodie getUernameFoodie(String name, String email) {
			// TODO Auto-generated method stub
			String str="select*from foodie where firstname=? and emailid=?;";
			try
			{
				foodie x=(foodie) jt.queryForObject(str, new Object[] {name,email}, new BeanPropertyRowMapper(foodie.class));
				return x;
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			return null;
		}

	
	}
		
	
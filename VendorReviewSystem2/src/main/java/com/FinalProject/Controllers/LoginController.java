package com.FinalProject.Controllers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.UserDetails;
import com.FinalProject.Entity.accounts;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.RepoImpl.AdminRepoImpl;
import com.FinalProject.RepoImpl.FoodieRepoImpl;
import com.FinalProject.RepoImpl.LoginRepoImpl;
import com.FinalProject.RepoImpl.VendorRepoImpl;

@Controller
public class LoginController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	LoginRepoImpl lr;
	
	@Autowired
	AdminRepoImpl ar;
	
	@Autowired
	FoodieRepoImpl fr;
	
	@Autowired
	VendorRepoImpl vr;
	
	@GetMapping("ab")
	public String loginpage()
	{
		return "Login/LoginPage";
	}
	
	@PostMapping("loginprocess")
	public String logIn(@RequestParam String txtuser,@RequestParam String txtpass,@RequestParam String usertype,Model m)
	{
		if(usertype.equals("Admin"))
		{
			
			return "Admin/HomePage";
			
		}
		else if(usertype.equals("Vendor"))
		{
			vendor v = lr.validatevendor(txtuser, txtpass);
			if(v==null) {
				m.addAttribute("msg","Wrong username/password");
				return "Login/LoginPage";
			}
			else if((v.getReqstatus().equals("approved"))&& (v.getActivestatus().equals("activated")))
			{
				vr.setVendorid(v.getVendorid());
				m.addAttribute("v", v);
				return "vendor/vendorhome";
			}
			else if(v.getReqstatus().equals("pending"))
			{
				return "vendor/pending";
			}
			else if(v.getActivestatus().equals("deactivated"))
			{
				return "vendor/deactivatevendor";
			}
			else
				m.addAttribute("msg","Wrong username/password");
				return "Login/LoginPage";
		}
	
		else if(usertype.equals("Foodie"))
		{
			foodie f = lr.validatefoodie(txtuser, txtpass);
			if (f!=null)
			{
				fr.setFoodieId(f.getFoodieid());
				m.addAttribute("f", f);
				return "Foodie/foodiehome";
			}
			else
				m.addAttribute("msg","Wrong username/password");
				return "Login/LoginPage";
		}
	
		else
			m.addAttribute("msg","Wrong username/password");
			return "Login/LoginPage";

	}

	
	@GetMapping("vendorReg")
	public String getvendorregpage()
	{
		return "Login/vendorRegi";
	}
	
	@GetMapping("foodieReg")
	public String getfoodieregpage()
	{
		return "Login/foodieRegi";
	}
	
	@PostMapping("addvendor")
	public String addNewVendor(@RequestParam String vendorname,@RequestParam String email,@RequestParam String websiteid,@RequestParam String location,@RequestParam String password,@RequestParam String vendortype,
			@RequestParam String cusinetype,@RequestParam MultipartFile uploadmenucard,@RequestParam MultipartFile uploadimage ,Model m) throws IOException
	{
		String name=vendorname;
		String mail=email;
		int n=0;
		List<String> vmailList=lr.getAllEmailsOfVendors();
		for(String e:vmailList) {
			if(mail.equals(e))
				n=1;
		}
		
		if(name.length()>=3 && name.length()<=50) {
			if((email.contains("@")) && n==0) {
				
					vendor v = new vendor();
					v.setVendorname(vendorname);
					v.setEmail(email);
					v.setWebsiteid(websiteid);
					v.setLocation(location);
					v.setPassword(password);
					v.setVendortype(vendortype);
					v.setCusinetype(cusinetype);
					byte[] bt = uploadimage.getBytes();
					byte[] bm=uploadmenucard.getBytes();
					v.setUploadphoto(bt);
					v.setUploadmenucard(bm);
					boolean r = lr.addvendor(v);
					m.addAttribute("msg",r);
					String vid=lr.getVendorId(vendorname);
					
					String transadd=lr.addToTransact(vid);
					m.addAttribute("vid", vid);
					return "Login/payment";
			
				
			}
			else {
				m.addAttribute("msg", "Check Email format or email avilablity");
				return "Login/vendorRegi";
			}
			
		}
		else {
			m.addAttribute("msg", "Name lenght should be 3-50");
			return "Login/vendorRegi";
		}
			
	}
	
	@PostMapping("sub")
	public String makePayment(@RequestParam String vendorid,@RequestParam String subsc,Model M) {
		accounts ac=new accounts();
		ac.setVendorid(vendorid);
		ac.setSubscription(subsc);
		if(subsc.equals("one")) {
			ac.setPaidamount(1000);
			String ms=lr.transcationAdmin(vendorid,1000);
			lr.transcationVendor(vendorid, 1000);
			M.addAttribute("ms",ms);
			
		}
		else if(subsc.equals("three")) {
			ac.setPaidamount(2000);
			String ms=lr.transcationAdmin(vendorid,2000);
			lr.transcationVendor(vendorid, 2000);
			M.addAttribute("ms",ms);
		}
		else if(subsc.equals("six")) {
			ac.setPaidamount(5000);
			String ms=lr.transcationAdmin(vendorid,5000);
			lr.transcationVendor(vendorid, 5000);
			M.addAttribute("ms",ms);
		}
		else if(subsc.equals("twelve")) {
			ac.setPaidamount(9000);
			String ms=lr.transcationAdmin(vendorid,9000);
			lr.transcationVendor(vendorid, 9000);
			M.addAttribute("ms",ms);
		}
		lr.makepayment(ac);
		
		M.addAttribute("msg","Succcesfull Payment");
		return "Login/payment";
		
	}
	
	@GetMapping("getVendorPhoto/{id}")
	public void getVendorPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = lr.getVendorPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@GetMapping("getMenuPhoto/{id}")
	public void getMenuPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = lr.getMenuPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("addfoodie")
	public String addNewFoodie(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String password,@RequestParam String confirmpassword,@RequestParam String emailid,@RequestParam String dob,
			@RequestParam String gender,@RequestParam String address,@RequestParam String mobile,Model m)
	{
		String fn=firstname;
		String ln=lastname;
		String mn=mobile;
		String ps=password;
		String cps=confirmpassword;
		String email=emailid;
		int n=0;
		List<String> fmailList=lr.getAllEmailsOfFoodies();
		
		for(String e:fmailList) {
			if(e.equals(email))
				n++;
		}
		int diff = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date convertedDate = sdf.parse(dob);
			//Date d1=new SimpleDateFormat("yyyy/MM/dd").parse(dob);
			convertedDate.getYear();
			if(convertedDate.getYear()<=103)
				diff=1;
			//System.out.println("year is "+convertedDate.getYear());
			//LocalDate d2=LocalDate.now();
			//System.out.println("birth date is "+d1);
			//ystem.out.println("current date is "+d2);
			//diff=d1.getYear()-d2.getYear();
			//System.out.println("dif is "+diff);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(fn.length()<=15 && fn.length()>=3 && ln.length()<=15 && ln.length()>=3) {
			if(mn.matches("^\\d{10}$")) {
				if(ps.equals(cps)) {
					if(email.contains("@") || n==0) {
						if(diff==1) {
							foodie f = new foodie();
							f.setFirstname(firstname);
							f.setLastname(lastname);
							System.out.println("last name is"+lastname);
							f.setPassword(password);
							f.setConfirmpassword(confirmpassword);
							f.setEmailid(emailid);
							f.setDob(dob);
							f.setGender(gender);
							f.setAddress(address);
							f.setMobile(mobile);
							String r = lr.addfoodie(f);
							m.addAttribute("msg", r);
						}
						else {
							m.addAttribute("msg", "Age should greater than 18");
						}
						
					}
					else
						m.addAttribute("msg", "Check Email Format or email is not Availabele");
				}
				else {
					m.addAttribute("msg", "Password and Confirm Password Should be Same ");
				}	
			}
			else {
				m.addAttribute("msg", "Check the Phone Number ");
			}
		}
		else {
			m.addAttribute("msg", "Check the length of name ");
		}
		
		
		return "Login/foodieRegi";
		
	}
	
	@PostMapping("addfoodieuser")
	public String addFoodieDetails(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,
			@RequestParam String sq1,@RequestParam String sq2,@RequestParam String sq3,Model m)
	{
		UserDetails ud=new UserDetails();
		ud.setFirstname(firstname);
		ud.setLastname(lastname);
		ud.setEmail(email);
		ud.setUsername("no");
		ud.setPassword("yes");
		ud.setSq1(sq1);
		ud.setSq2(sq2);
		ud.setSq3(sq3);
		String msg=lr.addUserDetails(ud);
		m.addAttribute("msg", msg);	
		return "Login/FoodieReg";
		
	}
	
	@GetMapping("viewReviewLogin")
	public String viewReview(Model m) {
		List<Reviews> rlist=ar.showAllReview();
		m.addAttribute("rlist", rlist);
		return "Login/viewReviewsLog";
	}
	
	@GetMapping("search")
	public String searchDeatil(Model m)
	{
		
		return "Login/searchDetails";

	}
	
	@GetMapping("forgotuserid")
	public String forgorUserID(Model m)
	{
		
		return "Login/RestoreUserid";

	}
	
	@PostMapping("restoreusernamem")
	public String restireUserId(@RequestParam String usertype,@RequestParam String name,@RequestParam String email,
			@RequestParam String sq1,@RequestParam String sq2,Model m)
	{
		String usid;
		if(sq1.equals("12345")  && sq2.equals("98765")) {
			
			try {
				if(usertype.equals("Vendor")) {
					vendor v=lr.getUernameVendor(name, email);
					usid=v.getVendorid();
				}
				else {
					foodie f=lr.getUernameFoodie(name, email);
					usid=f.getFoodieid();
				}
				m.addAttribute("msg", "Your user id is "+usid);	
			}
			catch(Exception e) {
				m.addAttribute("msg", "Wrong inputs");
			}		
		}
		else
			m.addAttribute("msg", "Wrong answers");
		
		
		return "Login/RestoreUserid";
		
	}
	
	@GetMapping("forgotpassword")
	public String forgorPassword(Model m)
	{
		
		return "Login/RestorePassw";

	}
	
	
	@PostMapping("restorepassword")
	public String restorePassword(@RequestParam String usertype,@RequestParam String name,@RequestParam String email,
			@RequestParam String id,@RequestParam String sq1,@RequestParam String sq2,Model m)
	{
		String pass=null;
		if(sq1.equals("12345")  && sq2.equals("98765")) {
			
			try {
				if(usertype.equals("Vendor")) {
					vendor v=lr.getUernameVendor(name, email);
				
					pass=v.getPassword();
				}
				else if(usertype.equals("Foodie")){
					foodie f=lr.getUernameFoodie(name, email);
				
					pass=f.getPassword();
				}
				m.addAttribute("msg", "Your password is "+pass);
			}catch(Exception e) {
				m.addAttribute("msg", "Wrong inputs");
			}
			
				
			
		}
		else
			m.addAttribute("msg", "Wrong answers");
	
		return "Login/RestorePassw";
		
	}


	
	
	
	
}
	




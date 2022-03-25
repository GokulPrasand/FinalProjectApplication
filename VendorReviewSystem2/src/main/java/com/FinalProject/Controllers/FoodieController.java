package com.FinalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.RepoImpl.FoodieRepoImpl;

@Controller
public class FoodieController {
	
	@Autowired
	FoodieRepoImpl fr;
	
	@GetMapping("fhome")
	public String foodieHome(Model m)
	{
		String fid=fr.getFoodieId();
		foodie f=fr.getFoodieById(fid);
		m.addAttribute("f",f);
		return "Foodie/foodiehome";

	}
	
	@GetMapping("freview")
	public String foodieReview(Model m)
	{
		List<vendor> venderacAll=fr.showActivatedVendor();
		m.addAttribute("venderacAll",venderacAll);
		foodie f=fr.getFoodieById(fr.getFoodieId());
		m.addAttribute("f",f);
		return "Foodie/foodiereview";

	}
	
	@GetMapping("vendshow/{vendorname}")
	public String activateVendor(@PathVariable String vendorname,Model m)
	{
		vendor v=fr.getVendorByName(vendorname);
		if(v!=null) {
			/*m.addAttribute("msg",r);
			List<vendor> vlist=ai.showAllApprovedvendor();*/
			m.addAttribute("v", v);
			return "Foodie/showvendor";
		}
		else {
			m.addAttribute("msg", "null vendor");
			return "Foodie/foodiereview";
		}
	}
	
	@PostMapping("/addreview/{vendorid}/{vendorname}/{location}")
	public String addNewReview(@PathVariable String vendorid,@PathVariable String vendorname,
			@PathVariable String location,
			
			@RequestParam String review,
			@RequestParam String visitdate,
			@RequestParam String ratings,
			@RequestParam String reviewdate,Model m)
	{
		Reviews r=new Reviews();
		r.setVendorid(vendorid);
		r.setVendorname(vendorname);
		r.setLocation(location);
		r.setFoodieid(fr.getFoodieId());
		r.setDateofvisit(visitdate);
		r.setDateofreview(reviewdate);
		r.setReview(review);
		r.setRatings(ratings);
		//r.setComplaint(complaints);
		String st=fr.addReview(r);
		m.addAttribute("msg",st);
		return "Foodie/foodiereview";
		
	}
	
	@GetMapping("viewfreview")
	public String viewFoodieReview(Model m)
	{
		String fid=fr.getFoodieId();
		List<Reviews> reviewfAll=fr.viewReview(fid);
		m.addAttribute("reviewfAll",reviewfAll);
		return "Foodie/viewfreview";

	}
	
	@GetMapping("deletereview/{vendorid}")
	public String deleteReview(@PathVariable String vendorid,Model m)
	{
		String foodieid=fr.getFoodieId();
		String msg=fr.deleteReview(foodieid, vendorid);
		m.addAttribute("msg",msg);
		return "Foodie/viewfreview";
	}
	
	@GetMapping("editreview/{review}")
	public String editReview(@PathVariable String review,Model m)
	{
		String foodieid=fr.getFoodieId();
		//System.out.println("vendor id is "+vendorid);
		//Reviews r=fr.getReviewByIds(foodieid ,vendorid);
		Reviews r=fr.getReviewByReview(review);
		System.out.println("review is "+r.getReview());
		//System.out.println("review is "+r.getReview());
		m.addAttribute("r",r);
		return "Foodie/edit";
	}
	
	/*@GetMapping("updatereview")
	public String updategetReview(@RequestParam String vendorid,@RequestParam String review,Model m)
	{
		String foodieid=fr.getFoodieId();
		System.out.println("review in up ids "+review);
		String msg=fr.updateReview( foodieid,vendorid, review);
		m.addAttribute("msg",msg);
		return "Foodie/editfreview";
	}*/
	
	@PostMapping("updatereview/{vendorid}")
	public String updateReview(@PathVariable String vendorid,@RequestParam String submitreview,Model m)
	{
		String foodieid=fr.getFoodieId();
		System.out.println("vendor ids "+vendorid);
		System.out.println("review in up ids "+submitreview);
		String msg=fr.updateReview( foodieid,vendorid, submitreview);
		m.addAttribute("msg",msg);
		return "Foodie/edit";
	}

	
	/*@PostMapping("updatereview/{vendorid}")
	public String updateReview(@PathVariable String vendorid,@RequestParam String review,Model m)
	{
		String foodieid=fr.getFoodieId();
		System.out.println("review in up ids "+review);
		String msg=fr.updateReview( foodieid,vendorid, review);
		m.addAttribute("msg",msg);
		return "Foodie/editfreview";
	}*/
	
	@GetMapping("vsearch")
	public String searchDeatils(Model m)
	{
		
		return "Foodie/searchDetails";

	}
	
	@PostMapping("searchd")
	public String viewsearchDetails(@RequestParam String search,@RequestParam String parameter,Model m)
	{
		if(search.equals("name")) {
			List<vendor> vlist=fr.getVendorsByName(parameter);
			m.addAttribute("vlist",vlist);
			return "Foodie/seeDetails";
		}
		else if(search.equals("location")) {
			List<vendor> vlist=fr.getVendorByLocation(parameter);
			m.addAttribute("vlist",vlist);
			return "Foodie/seeDetails";
		}
		else if(search.equals("rating")) {
			List<vendor> vlist=fr.getVendorByRating(parameter);
			m.addAttribute("vlist",vlist);
			return "Foodie/seeDetails";
		}
		else
			m.addAttribute("msg","details not available");
			return "Foodie/searchDetails";
	}
	
	@GetMapping("viewfprofile")
	public String viewProfile(Model m)
	{
		String fid=fr.getFoodieId();
		foodie f=fr.getFoodieById(fid);
		m.addAttribute("f",f);
		return "Foodie/viewFoodieProf";

	}
	
	@GetMapping("editprofile")
	public String editProfile(Model m)
	{
		String fid=fr.getFoodieId();
		foodie f=fr.getFoodieById(fid);
		m.addAttribute("f",f);
		return "Foodie/editFoodieProf";

	}
	
	@PostMapping("updatefprofile")
	public String updateProfile(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String pass,@RequestParam String email,@RequestParam String dob,
			@RequestParam String gender,@RequestParam String address,@RequestParam String mobile,Model m)
	{
		String fid=fr.getFoodieId();
		foodie f=fr.getFoodieById(fid);
		f.setFirstname(firstname);
		f.setLastname(lastname);
		f.setPassword(pass);
		f.setConfirmpassword(pass);
		f.setEmailid(email);
		f.setDob(dob);
		f.setGender(gender);
		f.setAddress(address);
		f.setMobile(mobile);
		String msg=fr.updateProfile(f);
		m.addAttribute("msg", msg);
		
		return "Foodie/editFoodieProf";
		
	}

}

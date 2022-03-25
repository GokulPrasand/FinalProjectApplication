package com.FinalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FinalProject.Entity.FoodieReviews;
import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.RepoImpl.FoodieRepoImpl;
import com.FinalProject.RepoImpl.VendorRepoImpl;

@Controller
public class VendorController {

@Autowired
VendorRepoImpl vr;
@Autowired
FoodieRepoImpl fr;



@GetMapping("vhome")
public String vendorHome(Model m)
{
String vid=vr.getVendorid();
vendor v=vr.getVendorById(vid);
m.addAttribute("v",v);
return "vendor/vendorhome";



}

@GetMapping("vreview")
public String vendorReview(Model m)
{
	String vid=vr.getVendorid();
	//List<Reviews> reviewVAll=vr.viewReview(vid);
	List<FoodieReviews> reviewVAll=vr.getFoodieDetails(vid);
	m.addAttribute("reviewVAll",reviewVAll);
	vendor v=vr.getVendorById(vid);
	m.addAttribute("v",v);
	return "vendor/viewvreview";

}

@PostMapping("raisecomp")
public String raiseComplaint(@RequestParam String fid,
Model m)
{
String vid=vr.getVendorid();
//m.addAttribute("review",review);
m.addAttribute("fid",fid);
m.addAttribute("vid",vid);
return "vendor/raisecompl";
}

@PostMapping("submitcompl/{foodieid}")
public String submitComplaint(@RequestParam String submitcomp,
@PathVariable String foodieid,Model m)
{
String vid=vr.getVendorid();
String fid=foodieid;

Reviews rw=fr.getReviewByIds(fid, vid);
String review=rw.getReview();
System.out.println("review is"+rw.getReview());
System.out.println("complaint is "+submitcomp);
String msg=vr.updateComplaint(submitcomp,review);
System.out.println("compl is"+msg);
m.addAttribute("msg",msg);
return "vendor/raisecompl";
}

@GetMapping("viewvprofile")
public String viewProfile(Model m)
{
	String vid=vr.getVendorid();
	vendor v=vr.getVendorById(vid);
	m.addAttribute("v",v);
	return "vendor/viewVendorProf";

}

@GetMapping("editvprofile")
public String editProfile(Model m)
{
	String vid=vr.getVendorid();
	vendor v=vr.getVendorById(vid);
	m.addAttribute("v",v);
	return "vendor/editVendorProf";

}

@PostMapping("updatevprofile")
public String updateProfile(@RequestParam String vendorname,@RequestParam String email,@RequestParam String location,@RequestParam String websiteid,@RequestParam String pass,
		@RequestParam String vendortype,@RequestParam String cusinetype,@RequestParam String uploadmenucard,@RequestParam String uploadphoto,Model m)
{
	String vid=vr.getVendorid();
	vendor v=vr.getVendorById(vid);
	v.setVendorname(vendorname);
	v.setEmail(email);
	v.setLocation(location);
	v.setWebsiteid(websiteid);
	v.setPassword(pass);
	v.setVendortype(vendortype);
	v.setCusinetype(cusinetype);
	/*v.setUploadmenucard(uploadmenucard);
	v.setUploadphoto(uploadphoto);*/
	
	String msg=vr.updateVendorProfile(v);
	m.addAttribute("msg", msg);
	
	return "vendor/editVendorProf";
	
}
}


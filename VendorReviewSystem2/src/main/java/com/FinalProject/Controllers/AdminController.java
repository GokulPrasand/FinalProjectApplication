package com.FinalProject.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FinalProject.Entity.Reviews;
import com.FinalProject.Entity.VendorRatings;
import com.FinalProject.Entity.accounts;
import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.RepoImpl.AdminRepoImpl;
import com.FinalProject.RepoImpl.VendorReviewRepoImpl;
import com.FinalProject.excel.UserExcelExporter;

@Controller
public class AdminController {
	
	@Autowired
	AdminRepoImpl ai;
	
	@Autowired
	VendorReviewRepoImpl vrr;
	
	@GetMapping("adminhome")
	public String showHome(Model m)
	{
		return "Admin/HomePage";
	}
	
	
	
	@GetMapping("vendrs")
	public String logIn(Model m) 
	{
		List<vendor> vendrqAll=ai.showAllvendorreq();
		m.addAttribute("vendrqAll", vendrqAll);
		
		return "Admin/vendorreq";
		
	}
	@GetMapping("acceptvendor/{vendorid}")
	public String acceptVendor(@PathVariable String vendorid,Model m) 
	{
	
		String r=ai.approveVendorById(vendorid);
		if(r!=null) {
			m.addAttribute("msg",r);
			List<vendor> vendrqAll=ai.showAllvendorreq();
			m.addAttribute("vendrqAll", vendrqAll);
			return "Admin/vendorreq";
		}
		else {
			m.addAttribute("msg", "failed");
			return "Admin/vendorreq";
		}
	
		
	}
	
	@GetMapping("rejectvendor/{vendorid}")
	public String rejectVendor(@PathVariable String vendorid,Model m) 
	{
	
		String r=ai.rejectVendorById(vendorid);
		if(r!=null) {
			accounts acc=ai.getAccountsObjectById(vendorid);
			acc.setPaidamount(0);
			String subsc=acc.getSubscription();
			if(subsc.equals("one")) {
				ai.transcatDebitAdmin(vendorid, 1000);
				ai.transcatCreditVendor(vendorid, 1000);
			}
			else if(subsc.equals("three")) {
				ai.transcatDebitAdmin(vendorid, 2000);
				ai.transcatCreditVendor(vendorid, 2000);
			}
			else if(subsc.equals("six")) {
				ai.transcatDebitAdmin(vendorid, 5000);
				ai.transcatCreditVendor(vendorid, 1000);
			}
			else if(subsc.equals("twelve")) {
				ai.transcatDebitAdmin(vendorid, 9000);
				ai.transcatCreditVendor(vendorid, 1000);
			}
			m.addAttribute("msg",r);
			List<vendor> vendrqAll=ai.showAllvendorreq();
			m.addAttribute("vendrqAll", vendrqAll);
			return "Admin/vendorreq";
		}
		else {
			m.addAttribute("msg", "failed");
			return "Admin/vendorreq";
		}
	
		
	}
	
	@GetMapping("showv")
	public String viewVendor(Model m)
	{
		List<vendor>vlist=ai.showAllApprovedvendor();
		m.addAttribute("vlist", vlist);
		return "Admin/viewvendor";
	}


	@GetMapping("activate/{vendorid}")
	public String activateVendor(@PathVariable String vendorid,Model m)
	{

	vendor v=ai.searchVendorById(vendorid);
	if(v.getActivestatus().equals("activated")) {
	m.addAttribute("msg", "Alraedy activated");
	return "Admin/viewvendor";
	}
	else {
	String r=ai.ActivateVendorById(vendorid);
	if(r!=null) {
	m.addAttribute("msg",r);
	List<vendor> vlist=ai.showAllApprovedvendor();
	m.addAttribute("vlist", vlist);
	return "Admin/viewvendor";
	}
	else {
	m.addAttribute("msg", "failed activation");
	return "Admin/viewvendor";
	}
	}

	}



	@GetMapping("deactivate/{vendorid}")
	public String deactivateVendor(@PathVariable String vendorid,Model m)
	{
	vendor v=ai.searchVendorById(vendorid);
	if(v.getActivestatus().equals("deactivated")) {
	m.addAttribute("msg", "Already deactivated");
	return "Admin/viewvendor";
	}
	else {
	String r=ai.DeactivateVendorById(vendorid);
	if(r!=null) {
	m.addAttribute("msg",r);
	List<vendor> vlist=ai.showAllApprovedvendor();
	m.addAttribute("vlist", vlist);
	return "Admin/viewvendor";
	}
	else {
	m.addAttribute("msg", "failed deactivation");
	return "Admin/viewvendor";
	}
	}
	}
	@GetMapping("delete/{vendorid}")
	public String deletevendor(@PathVariable String vendorid,Model m)
	{
		String st=ai.searchVendorById(vendorid).getActivestatus();
		if(st.equals("activated")) {
			m.addAttribute("msg", "Cannot delete active vendor");
			return "Admin/viewvendor";
		}
		else if(st.equals("deactivated")) {
			String r = ai.DeleteVendorById(vendorid);
			if(r!=null) {
				m.addAttribute("msg",r);
				List<vendor> vlist=ai.showAllApprovedvendor();
				m.addAttribute("vlist", vlist);
				return "Admin/viewvendor";
			}
			else {
				m.addAttribute("msg", "failed");
				return "Admin/viewvendor";
			}
		}
		return null;
		
	}
	
	@GetMapping("showf")
	public String getFoodieList(Model m)
	{
		List<foodie> flist = ai.showAllfoodie();
		m.addAttribute("flist", flist);
		return "Admin/viewFoodies";

	}
	
	@GetMapping("showreviews")
	public String showReviews(Model m)
	{
		List<Reviews> rlist = ai.showAllReview();
		m.addAttribute("rlist", rlist);
		return "Admin/viewReviews";

	}
	
	@GetMapping("showcomplaints")
	public String showComplaintReviews(Model m)
	{
		List<Reviews> rclist = ai.showReviewComplaints();
		m.addAttribute("rclist", rclist);
		return "Admin/viewComplaint";

	}
	
	@GetMapping("/deletereview/{vid}/{fid}/{complaint}")
	public String deleteReview(@PathVariable String vid,@PathVariable String fid,
			@PathVariable String complaint,Model m)
	{
		System.out.println("vid is"+vid);
		System.out.println("fid is"+fid);
		System.out.println("compl is"+complaint);
		String r=ai.deleteReview(vid, fid, complaint);
		if(r!=null) {
			m.addAttribute("msg",r);
			List<Reviews> rcAll=ai.showReviewComplaints();
			m.addAttribute("rcAll", rcAll);
			return "Admin/viewComplaint";
		}
		else {
			List<Reviews> rcAll=ai.showReviewComplaints();
			m.addAttribute("rcAll", rcAll);
			m.addAttribute("msg", "failed deactivation");
			return "Admin/viewComplaint";
		}
	}
	
	@GetMapping("greport")
	public String generateReport(Model m)
	{
		
		return "Admin/GenReport";

	}
	
	@GetMapping("downloadxl")
	public String exportToExcel(HttpServletResponse response) throws IOException
	{
		response.setContentType("application/octet-stream");
		String headerkey="Content-Disposition";
		
		
		String headerValue="attachement; filename=ratings.xlsx";
		
		response.setHeader(headerkey, headerValue);
		
		List<VendorRatings> vrlist=vrr.getRatingList();
		
		UserExcelExporter ob=new UserExcelExporter(vrlist);
		ob.export(response);
		
		
		return "Admin/GenReport";

	}
	
	
	
	
}

package com.whatsupdoc.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.activation.DataSource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.SpringVersion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Statement;
import com.whatsupdoc.pojo.Address;
import com.whatsupdoc.pojo.Doctor;

import antlr.collections.List;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/* search doctors using given latitude, longitude and radius of search*/
	@RequestMapping(value = "/searchDoctors", method = RequestMethod.GET)
	public @ResponseBody Collection<Doctor> searchDoctors(Model model, HttpServletRequest request) throws ClassNotFoundException{
		
			String lat = request.getParameter("latitude");	
			String lon = request.getParameter("longitude");
			String distanceLimit = request.getParameter("limitDistanceInKm");
			String start = request.getParameter("start");
			String limit = request.getParameter("limit");
			
			return getDoctorList(lat, lon, distanceLimit, start, limit);
	}
	
	public Collection<Doctor> getDoctorList(String lat, String lon, String distanceLimit, String start, String limit) throws ClassNotFoundException{
		/*SELECT * FROM doctor AS d JOIN (select addressID from address where st_distance(location, POINT(18.9246459, 72.8196200))*1000 > 0.08) AS a
		WHERE d.addressID =a.addressID;*/
		String point = "POINT("+lat+","+lon+"))*1000";
		int distInM = Integer.parseInt(distanceLimit)*1000;
		String dist = Integer.toString(distInM);
		String query = "SELECT * FROM doctor AS d JOIN (select addressID from address where st_distance_sphere(location,"+ point + " < "+dist+") AS a ON d.addressID = a.addressID LIMIT "+start+","+limit+";" ;
		System.out.println(query);
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/DocSearch";
        Collection<Doctor> docList =  new ArrayList<Doctor>();
		try { 
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			conn = DriverManager.getConnection(url,"root","aexce123");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(query);
			while(rs.next()){
				Doctor d = new Doctor();
				d.setDoctorID(Integer.parseInt(rs.getString(1)));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setGender(rs.getString(4));
				d.setQualification(rs.getString(5));
				d.setPhoneNumber( rs.getString(6));
				d.setMobileNumber(rs.getString(7));
				d.setImageLocationURL(rs.getString(8));
				docList.add(d);
			}
			conn.close();
			return docList;
//			model.addAttribute("docList", docList);
//			return "success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
	}
}

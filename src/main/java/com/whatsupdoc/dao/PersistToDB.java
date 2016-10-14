package com.whatsupdoc.dao;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.whatsupdoc.pojo.Address;

public class PersistToDB {

	public static void main(String[] args){	
		try{
		
		String url = "jdbc:mysql://localhost:3306/DocSearch";
        Connection conn = DriverManager.getConnection(url,"root","aexce123");
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs;
        int key=0;
        String docQuery = "INSERT INTO doctor (name, email, gender, qualification, phoneNumber, mobileNumber, imageLocationURL, addressID) VALUES (?, ?, ?,?, ?, ?, ?, (SELECT addressID FROM Address WHERE addressID=?))";
        String query = "INSERT INTO address (addressLine1, addressLine2, city, state, zipCode, latitude, longitude, location) VALUES(?,?,?,?,?,?,?,ST_GeomFromText(?))";
        PreparedStatement preparedStmtAddr = (PreparedStatement) conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement preparedStmtDoc = (PreparedStatement) conn.prepareStatement(docQuery);
        
        preparedStmtAddr.setString(1, "555 Daffodils");
        preparedStmtAddr.setString(2, "3rd Road");
        preparedStmtAddr.setString(3, "Mumbai");
        preparedStmtAddr.setString(4, "MH");
        preparedStmtAddr.setString(5, "400123");
        double lat = 18.924626;
        preparedStmtAddr.setDouble(6,lat);
        double lon = 72.819671;
        preparedStmtAddr.setDouble(7, lon);
        String point = "Point("+lat+" "+lon+")";
        preparedStmtAddr.setString(8, point);
        preparedStmtAddr.executeUpdate();
         rs = preparedStmtAddr.getGeneratedKeys();
        if(rs != null && rs.next()){
        	 key = rs.getInt(1);
        }
        System.out.println(key+"*****");
      
        preparedStmtDoc.setString(1, "Dr.Kapadia");
        preparedStmtDoc.setString(2, "drkapadia@gmail.com");
        preparedStmtDoc.setString(3, "male");
        preparedStmtDoc.setString(4, "M.B.B.S");
        preparedStmtDoc.setString(5, "022 28734595");
        preparedStmtDoc.setString(6, "+919818234902");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/0876453.img");
        preparedStmtDoc.setInt(8, key);
        preparedStmtDoc.executeUpdate();
        
        
        preparedStmtAddr.setString(1, "121 Bajaj Bhavan");
        preparedStmtAddr.setString(2, "Nariman Point");
        preparedStmtAddr.setString(3, "Mumbai");
        preparedStmtAddr.setString(4, "MH");
        preparedStmtAddr.setString(5, "400021");
        lat = 18.9246454;
        preparedStmtAddr.setDouble(6,lat);
        lon = 72.8196925;
        preparedStmtAddr.setDouble(7, lon);
        point = "Point("+lat+" "+lon+")";
        preparedStmtAddr.setString(8, point);
        preparedStmtAddr.executeUpdate();
        rs = preparedStmtAddr.getGeneratedKeys();
       if(rs != null && rs.next()){
       	 key = rs.getInt(1);
       }
       System.out.println(key+"*****");
        
        preparedStmtDoc.setString(1, "Dr.Madison Lockhart");
        preparedStmtDoc.setString(2, "ml@myhealth.com");
        preparedStmtDoc.setString(3, "female");
        preparedStmtDoc.setString(4, "M.D. Orthopedic");
        preparedStmtDoc.setString(5, "022 87445951");
        preparedStmtDoc.setString(6, "+917827364091");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/095384.img");
        preparedStmtDoc.setInt(8,key);
        preparedStmtDoc.executeUpdate();
        
        preparedStmtDoc.setString(1, "Dr.Steven Lockhart");
        preparedStmtDoc.setString(2, "sl@myhealth.com");
        preparedStmtDoc.setString(3, "male");
        preparedStmtDoc.setString(4, "M.D. Orthopedic");
        preparedStmtDoc.setString(5, "022 87445952");
        preparedStmtDoc.setString(6, "+917827378923");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/095385.img");
        preparedStmtDoc.setInt(8, key);
        preparedStmtDoc.executeUpdate();
        
        preparedStmtAddr.setString(1, "49 Crystal");
        preparedStmtAddr.setString(2, "Dr. Annie Besant Rd");
        preparedStmtAddr.setString(3, "Mumbai");
        preparedStmtAddr.setString(4, "MH");
        preparedStmtAddr.setString(5, "400009");
        lat = 18.9246033;
        preparedStmtAddr.setDouble(6,lat);
        lon = 72.8196982;
        preparedStmtAddr.setDouble(7, lon);
        point = "Point("+lat+" "+lon+")";
        preparedStmtAddr.setString(8, point);
        preparedStmtAddr.executeUpdate();
        rs = preparedStmtAddr.getGeneratedKeys();
       if(rs != null && rs.next()){
       	 key = rs.getInt(1);
       }
       System.out.println(key+"*****");
        
        preparedStmtDoc.setString(1, "Dr.Kunal Bansal");
        preparedStmtDoc.setString(2, "kbansal@lilavati.com");
        preparedStmtDoc.setString(3, "female");
        preparedStmtDoc.setString(4, "M.D. Neurologist");
        preparedStmtDoc.setString(5, "022 67555951");
        preparedStmtDoc.setString(6, "+919833456929");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/087380.img");
        preparedStmtDoc.setInt(8, key);
        preparedStmtDoc.executeUpdate();
        
        preparedStmtDoc.setString(1, "Dr.Kirti Rao");
        preparedStmtDoc.setString(2, "kbansal@lilavati.com");
        preparedStmtDoc.setString(3, "female");
        preparedStmtDoc.setString(4, "M.D. Radiologist");
        preparedStmtDoc.setString(5, "022 67555760");
        preparedStmtDoc.setString(6, "+916987125331");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/088765.img");
        preparedStmtDoc.setInt(8, key);
        preparedStmtDoc.executeUpdate();
        
        preparedStmtDoc.setString(1, "Dr. Vatsal Kothari");
        preparedStmtDoc.setString(2, "kbansal@lilavati.com");
        preparedStmtDoc.setString(3, "male");
        preparedStmtDoc.setString(4, "M.D");
        preparedStmtDoc.setString(5, "022 67805760");
        preparedStmtDoc.setString(6, "+919722500187");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/083475.img");
        preparedStmtDoc.setInt(8, key);
        preparedStmtDoc.executeUpdate();
        
        preparedStmtAddr.setString(1, "10 Maribelle");
        preparedStmtAddr.setString(2, "Veer Savarkar Road");
        preparedStmtAddr.setString(3, "Mumbai");
        preparedStmtAddr.setString(4, "MH");
        preparedStmtAddr.setString(5, "400032");
        lat = 18.9246923;
        preparedStmtAddr.setDouble(6,lat);
        lon = 72.8196099;
        preparedStmtAddr.setDouble(7, lon);
        point = "Point("+lat+" "+lon+")";
        preparedStmtAddr.setString(8, point);
        preparedStmtAddr.executeUpdate();
        rs = preparedStmtAddr.getGeneratedKeys();
       if(rs != null && rs.next()){
       	 key = rs.getInt(1);
       }
       System.out.println(key+"*****");
        
        preparedStmtDoc.setString(1, "Dr.Vedant Shetty");
        preparedStmtDoc.setString(2, "drshettyvedant@yahoo.com");
        preparedStmtDoc.setString(3, "male");
        preparedStmtDoc.setString(4, "M.D. Urologist");
        preparedStmtDoc.setString(5, "022 67226760");
        preparedStmtDoc.setString(6, "+919876009223");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/049365.img");
        preparedStmtDoc.setInt(8, key);
        
        preparedStmtDoc.executeUpdate();
        preparedStmtDoc.setString(1, "Dr.Deepak Sharma");
        preparedStmtDoc.setString(2, "sharma.d@yahoo.com");
        preparedStmtDoc.setString(3, "female");
        preparedStmtDoc.setString(4, "M.D. Radiologist");
        preparedStmtDoc.setString(5, "022 67555760");
        preparedStmtDoc.setString(6, "+916987125331");
        preparedStmtDoc.setString(7, "/resources/images/doctorimg/076760.img");
        preparedStmtDoc.setInt(8, 4);
        preparedStmtDoc.executeUpdate();
        
        
        
        conn.close();
    } catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
    }
	}
}

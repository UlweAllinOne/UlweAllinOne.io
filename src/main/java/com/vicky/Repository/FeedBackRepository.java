package com.vicky.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vicky.entity.FeedBackEntity;
import com.vicky.util.ConnectionUtil;

@Repository
public class FeedBackRepository {
	
	

	public String save(String name, String mobileNo, String message) throws Exception {
		String result = "-1";
		 StringBuilder sql = new StringBuilder();
	      sql.append("INSERT INTO jalajfeedback (name,mobileNo,message) VALUES ('").append(name).append("','")
	      .append(mobileNo).append("','")
	      .append(message).append("')");
	      Connection conn = null;
	      Statement stmt = null;
		try{			
	      conn = ConnectionUtil.getConnection();
	      stmt = conn.createStatement();
	      int res = stmt.executeUpdate(sql.toString());
	      result = res+"";
	     
		}
		catch(Exception e){
			result=sql.toString() + e.toString();			
		}
		finally{
			stmt.close();
			conn.close();
		}
		return result;
	}
	
	public List<FeedBackEntity> fetchAllDetails() throws Exception {
		
		 String sql = "select id,name,mobileNo,message from jalajfeedback order by id desc";
		 List<FeedBackEntity> list = new ArrayList<>();
		 Connection conn= null;
		 Statement stmt = null;
		 ResultSet rs = null;
		try{			
	      conn = ConnectionUtil.getConnection();
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery(sql);
	      
	      FeedBackEntity fbe;
	      while(rs.next()){
	    	  fbe = new FeedBackEntity(rs.getInt("id"),rs.getString("name"),rs.getString("mobileNo"),rs.getString("message"));
	    	  list.add(fbe);
	      }
		}
		catch(Exception e){
			//list.add(sql.toString() + e.toString());			
		}
		finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return list;
	}

}

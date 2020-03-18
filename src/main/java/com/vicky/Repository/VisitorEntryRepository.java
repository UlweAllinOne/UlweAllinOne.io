package com.vicky.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vicky.entity.VisitorEntity;
import com.vicky.util.ConnectionUtil;

@Repository
public class VisitorEntryRepository {

	public int save(String flatno, String phoneno, String comment) throws SQLException {
		
		String currentDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date());
		int maxid = getMaxID();
		String result = "-1";
		 StringBuilder sql = new StringBuilder();
	      sql.append("INSERT INTO jalajvisitor (id,flatno,phoneno,comment,datetime) VALUES ('")
	      .append(maxid).append("','")
	      .append(flatno).append("','")
	      .append(phoneno).append("','").
	      append(comment).append("','")
	      .append(currentDate).append("')");
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
		return maxid;
	}
	
	
	private int getMaxID() throws SQLException{
		
		 String sql = "select max(id) as id from jalajvisitor";
		 Connection conn= null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 int id = 0;
		try{			
	      conn = ConnectionUtil.getConnection();
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery(sql);
	      
	     
	      while(rs.next()){
	    	  id = rs.getInt("id");
	      }
	      id = id + 1;
		}
		catch(Exception e){
			//list.add(sql.toString() + e.toString());			
		}
		finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return id;
	}
	
	public List<VisitorEntity> fetchVisitorDetails() throws Exception {
		
		 String sql = "select id,flatno,phoneno,comment,datetime from jalajvisitor";
		 List<VisitorEntity> list = new ArrayList<>();
		 Connection conn= null;
		 Statement stmt = null;
		 ResultSet rs = null;
		try{			
	      conn = ConnectionUtil.getConnection();
	      stmt = conn.createStatement();
	      rs = stmt.executeQuery(sql);
	      
	      VisitorEntity fbe;
	      while(rs.next()){
	    	  fbe = new VisitorEntity(rs.getInt("id"),rs.getString("flatno"),rs.getString("phoneno"),rs.getString("comment"),rs.getString("datetime"));
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

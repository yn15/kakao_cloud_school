package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.vo.Member;

public class MemberDAO {
	private DataSource ds;
	
	public MemberDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public Member select(Member member) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결 성공");
		
		String sql = "SELECT * FROM members WHERE id = ? AND pw = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member.setName(rs.getString("name"));
			return member;
		}
		
		return null;
	}
}

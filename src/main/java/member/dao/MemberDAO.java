package member.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static common.JDBCTemplate.*;
import member.vo.Member;

public class MemberDAO {
	
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties prop;
	
	public MemberDAO() {
			try {
				prop = new Properties();
				
				String filePath = MemberDAO.class.getResource("/member/sql/member-sql.xml").getPath();  
				
				prop.loadFromXML(new FileInputStream(filePath));
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	// 로그인
	public Member login(Connection conn, Member mem) throws Exception {
		
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setMemberNickname(rs.getString("MEMBER_NICK"));
				loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
				loginMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
				loginMember.setProfileImage(rs.getString("PROFILE_IMG"));
				loginMember.setEnrollDate(rs.getString("ENROLL_DT"));
				
			}
				
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}
	
	
	
	}
 
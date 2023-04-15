package member.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	// 로그인
	public Member login(Member mem) throws Exception {
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, mem);
		
		close(conn);
		
		return loginMember;
	}
}

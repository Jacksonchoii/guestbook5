package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	

	// 전체리스트
	public List<GuestVo> getGuestList() {
		
		System.out.println("dao : getGuestList()");
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		System.out.println(guestList.toString());
		
		return guestList;
	}
	
	// 방명록 등록
	public int guestInsert(GuestVo guestVo) {
		
		System.out.println("dao : guesInsert()");
		
		int count = sqlSession.insert("guestbook.insert", guestVo);
		
		return count;
	}
	
	// 방명록 삭제
	public int guestDelete(GuestVo guestVo) {
		
		System.out.println("dao : guesDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestVo);
		
		return count;
	}

	
	
	
	
	

}

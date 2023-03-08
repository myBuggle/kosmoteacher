package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
//Dao단은 @Repository 사용 => Dao를 빈으로 등록 시켜준다.
//싱글톤이다. 기본이
@Repository("memberList")
public class MemberDao implements MemberDaoInter{
	// kosmo-web.xml에서 정의한 bean byName
	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public void addMember(MemberDTO dto) {
		// SqlSession ss = FactoryService.getFactory().openSession(true); 대신 
		// 해주는 설정이 <bean id="ss" class="org.mybatis.spring.SqlSessionTemplate">
		ss.insert("member.add", dto);
	
	}
	@Override
	public int idcheck(String id) {
		return ss.selectOne("member.idchk", id);
	}
	
	
	@Override
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("member.logger_in",vo);
	}
	@Override
	public MemberDTO loginCheck(MemberDTO vo) {
		// TODO Auto-generated method stub
		return ss.selectOne("member.login", vo);
	}

}

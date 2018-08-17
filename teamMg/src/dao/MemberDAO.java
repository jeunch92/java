package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> getMembers(Integer id) throws DataAccessException; //여기서 받는 id는 팀아이디
	//특정팀 모든선수보기니까
	MemberDTO		getMember(Integer id) throws DataAccessException;//선수의 정보 보기 :id는 선수아이디
	void			insertMember(MemberDTO dto) throws DataAccessException;//선수등록
	void			deleteMember(MemberDTO dto) throws DataAccessException;//선수삭제
	void			updateMember(MemberDTO dto) throws DataAccessException;//선수 팀 변경, 이름 변경
	

}

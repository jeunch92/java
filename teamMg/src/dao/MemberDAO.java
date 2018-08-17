package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> getMembers(Integer id) throws DataAccessException; //���⼭ �޴� id�� �����̵�
	//Ư���� ��缱������ϱ�
	MemberDTO		getMember(Integer id) throws DataAccessException;//������ ���� ���� :id�� �������̵�
	void			insertMember(MemberDTO dto) throws DataAccessException;//�������
	void			deleteMember(MemberDTO dto) throws DataAccessException;//��������
	void			updateMember(MemberDTO dto) throws DataAccessException;//���� �� ����, �̸� ����
	

}

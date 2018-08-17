package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberDAOImpl extends SimpleJdbcTemplate implements MemberDAO {

	private InsertMember insertMember;
	private DeleteMember deleteMember;
	private UpdateMember updateMember;
	private MembersQuery membersQuery;
	private MemberQuery memberQuery;
	
	public MemberDAOImpl(DataSource dataSource) {
		super(dataSource);
		insertMember = new InsertMember(dataSource);
		membersQuery = new MembersQuery(dataSource);
		memberQuery = new MemberQuery(dataSource);
		deleteMember = new DeleteMember(dataSource);
		updateMember = new UpdateMember(dataSource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MemberDTO> getMembers(Integer id) throws DataAccessException {
		return membersQuery.execute(id); //id값넣어주면 알아서 컴파일됨
	}

	@Override
	public MemberDTO getMember(Integer id) throws DataAccessException {
		return memberQuery.findObject(id);
	}

	@Override
	public void insertMember(MemberDTO dto) throws DataAccessException {
		Object[] obj = new Object[] {dto.getName(), dto.getTeam().getId()};
		insertMember.update(obj);

	}

	@Override
	public void deleteMember(MemberDTO dto) throws DataAccessException {
		deleteMember.update(dto.getId());
	}

	@Override
	public void updateMember(MemberDTO dto) throws DataAccessException {
		Object[] obj = new Object[] {dto.getName(), dto.getTeam().getId(), dto.getId()};
		updateMember.update(obj);
	}

}

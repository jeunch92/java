package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import dto.MemberDTO;
import dto.TeamDTO;

public class MemberQuery extends MappingSqlQuery<MemberDTO>{

	private static String sql = "select member_id, team_member.name as memberName, "
			+"team.team_id, team.name as teamName from team_member, team where "
			+"team_member.team_id = team.team_id and member_id = ?"; 
	//static을 써야지  미리 먼저 실행됨
	public MemberQuery(DataSource dataSource) {
		super(dataSource, sql);
		super.declareParameter(new SqlParameter("member_id", Types.INTEGER));
		compile();
	}
	
	@Override
	protected MemberDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
		//콜백 메소드 arg0=결과, arg1=몇번실행될지 카운트하는거
		MemberDTO member = new MemberDTO();
		member.setId(arg0.getInt("member_id"));
		member.setName(arg0.getString("memberName"));
		TeamDTO team = new TeamDTO();
		team.setId(arg0.getInt("team_id"));
		team.setName(arg0.getString("teamName"));
		member.setTeam(team);
		return member;
	}

}

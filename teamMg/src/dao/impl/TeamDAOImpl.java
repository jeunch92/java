package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.TeamDAO;
import dto.TeamDTO;

public class TeamDAOImpl extends SimpleJdbcTemplate implements TeamDAO {
	
	public TeamDAOImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	//rowMapper는 쿼리결과를 객체로 만든거
	private class MyRowMapper implements RowMapper<TeamDTO>{
		@Override
		public TeamDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
			TeamDTO dto = new TeamDTO();
			dto.setId(arg0.getInt("team_id"));
			dto.setName(arg0.getString("name"));
			return dto;
		}
	}
	MyRowMapper rowMapper = new MyRowMapper();

	@Override
	public List<TeamDTO> getTeamList() throws DataAccessException {
		String sql = "select team_id, name from team";
		List<TeamDTO> teamList = this.query(sql, rowMapper);
		return teamList;
	}

	@Override
	public TeamDTO getTeam(Integer id) throws DataAccessException {
		String sql = "select team_id, name from team where team_id = ?";
		//Object[] value = new Object[] {id};
		TeamDTO dto = this.queryForObject(sql, rowMapper, id);
		return dto;
	}

}

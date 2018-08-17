package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.TeamDTO;

public interface TeamDAO {
	List<TeamDTO>	getTeamList() throws DataAccessException; // 전체 팀 리스트 보기
	TeamDTO			getTeam(Integer id) throws DataAccessException; //id에 해당하는 한개의 팀 보기

}

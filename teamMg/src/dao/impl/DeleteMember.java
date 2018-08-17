package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class DeleteMember extends SqlUpdate{
	public DeleteMember(DataSource dataSource) {
		super(dataSource,"delete from team_member where member_id = ?");
		super.declareParameter(new SqlParameter("member_id",Types.INTEGER));
		compile(); //컴ㅍㅏ일없으면 실행안됨
	}
	

}

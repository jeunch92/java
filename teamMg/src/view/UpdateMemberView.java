package view;

import org.apache.commons.lang.StringUtils;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class UpdateMemberView extends AbsView{
	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void showMenu(){
		String str = ">>>팀원 정보 수정\n";
		str += "팀원 ID를 입력하여 주세요(Enter)\n";
		str += "아무것도 입력하지 않고 Enter를 누르면 메뉴로 복귀합니다.";
		msg(str);		
	}
	@Override
	public void show() {
		showMenu();
		String id = getKeyInputString("팀원 ID ");
		if (StringUtils.isEmpty(id)){
			return;
		}
		
		MemberDTO member = getMember(id);
		if (member != null) {
			member.setName(getName());
			TeamDTO team = getTeam();
			if (team == null) return;
			member.setTeam(team);
			memberDAO.updateMember(member);
		}else {
			show();
		}
	}
	public String getName(){
		String name = getKeyInputString("팀원 이름 ");
		return name;
	}
	public TeamDTO getTeam(){
		String id = getKeyInputString("팀 ID ");
		TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
		return team;
	}
	
	public MemberDTO getMember(String id){
		if (Utils.isNumeric(id, "팀원 ID ")){
			MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			return member;
		}
		return null;
	}

}

package view;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class InsertMemberView extends AbsView {
	private TeamDAO teamDAO;
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		//�����Ƽ���� ����
		final String memberName = "�����̸�";
		String name = getKeyInputString(memberName);
		
		if(Utils.isEmpty(name, memberName)) {
			//show(); ���ȣ����ϰ�
			return; //���൵ �� ������ ����������Ǵϱ�
		}else if(Utils.isSmallLength(name, memberName, 128)) {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}
	
	protected void showTeamField(MemberDTO member) {
		final String teamId = "�� ID";
		String id = getKeyInputString(teamId);
		if(Utils.isEmpty(id, teamId)) {
			showTeamField(member); //���ȣ���� ���ѵ��ǰ�~
		}else if(Utils.isNumeric(id, teamId)) {
			TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
			if(team == null) {
				msg("::::[" + id + "]�� ���� �������� �ʽ��ϴ�. �ٽ� Ȯ���� �ּ���.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.insertMember(member);
				msg("::::�� [ " + team.getName() + "]�� ���� [" + member.getName()+"]�� ���");
			}
		}
	}

}

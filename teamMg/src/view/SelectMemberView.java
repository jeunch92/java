package view;

import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;
import dao.impl.*;
import view.*;

public class SelectMemberView extends AbsViewTemplate {
	
	private MemberDAO memberDAO;
	private DeleteMemberView deleteMemberView;
	private UpdateMemberView updateMemberView;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}
	public void setUpdateMemberView(UpdateMemberView updateMemberView) {
		this.updateMemberView = updateMemberView;
	}


	public void showHeader() {
		System.out.println("********************");
		System.out.println(">>>팀원 관리");
		System.out.println("================");
	}
	
	protected Integer getTeamId() {
		String teamId = getKeyInputString("팀 ID");
		if (Utils.isNumeric(teamId, "팀 ID")) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	
	public void showMemberList(List<MemberDTO> memberList) {
		if (!memberList.isEmpty()) {
			msg("팀명 : " + memberList.get(0).getTeam().getName());
		}
		System.out.println("ID\t\t이름");
		System.out.println("********************");
		for(MemberDTO member : memberList) {
			System.out.println(member.getId() +"\t\t" + member.getName());
		}
	}
	
	public void show() {
		showHeader();
		Integer teamId = getTeamId();
		List<MemberDTO> memberList = memberDAO.getMembers(teamId);
		showMemberList(memberList);
		msg("Enter키를 누르세요");
		getEnter();
		super.show();
	}
	
	@Override
	protected void showMenu() {
		showHeader();
		
		System.out.println("1. 팀원 수정");
		System.out.println("2. 팀원 삭제");
		System.out.println("3. 메뉴 복귀");
		System.out.println("********************");
		System.out.println("번호 입력(엔터키)");
	}
	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1 :
			updateMemberView.show();
			break;
		case 2 :
			deleteMemberView.show();
			break;
		case 3 :
			return;
		}

	}
		
}
	


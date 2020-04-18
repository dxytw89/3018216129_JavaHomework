package cn.tju.lab3;

import java.util.List;

public interface SqlUtil {
	/**
     * ���ݴ���Ĳ������ز�ѯ���
     * @param user
     * @return ���ز�ѯ���
     */
    String query(User user);

    /**
     * ���ݴ���Ĳ������ز������
     * @param user
     * @return ���ز������
     */
    String insert(User user);

    /**
     * ���ݴ���Ĳ������ز������
     * @param users
     * @return ���ز������
     */
    String insert(List<User> users);

    /**
     * ���ݴ���Ĳ�������ɾ����䣨ɾ��idΪuser.id�ļ�¼��
     * @param user
     * @return ����ɾ�����
     */
    String delete(User user);
/**
     * ���ݴ���Ĳ������ظ�����䣨��idΪuser.id�ļ�¼�������ֶθ��³�user�еĶ�Ӧֵ��
     * @param user
     * @return ���ظ������
     */
    String update(User user);

}


class TjuSqlUtil implements SqlUtil{

	@Override
	public String query(User user) {
		// TODO Auto-generated method stub\
		String ans = null;
		if(user.getId() > 0) {
			ans = "SELECT * FROM user WHERE id = " + user.getId();
		}else {
			ans = "SELECT * FROM `user` WHERE `username` LIKE "+user.getUsername();
		}
		return ans; 
	}

	@Override
	public String insert(User user) {
		// TODO Auto-generated method stub
		String ans = null;
		ans = "INSERT INTO `user` (`username`, `telephone`, `email`, `age`) VALUES "+"("+
		user.getUsername()+","+user.getTelephone()+","+user.getEmail()+","+user.getAge()+")";
		return ans;
	}

	@Override
	public String insert(List<User> users) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO `user` (`username`, `telephone`, `email`, `age`) VALUES");
		for(int i = 0; i < users.size(); i++) {
			sb.append(" ("+ users.get(i).getUsername()+","+users.get(i).getTelephone()+
					","+users.get(i).getEmail()+","+users.get(i).getAge()+")");
		}
		return sb.toString();
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		String ans = null;
		ans = "DELETE FROM `user` WHERE `id` = " + user.getId();
		return ans;
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		String ans = null;
		ans = "UPDATE `user` SET `email` = "+user.getEmail()+" WHERE `id` = "+user.getId();
		return ans;
	}
	
	
}

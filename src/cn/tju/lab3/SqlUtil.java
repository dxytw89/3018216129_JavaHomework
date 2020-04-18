package cn.tju.lab3;

import java.util.List;

public interface SqlUtil {
	/**
     * 根据传入的参数返回查询语句
     * @param user
     * @return 返回查询语句
     */
    String query(User user);

    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     */
    String insert(User user);

    /**
     * 根据传入的参数返回插入语句
     * @param users
     * @return 返回插入语句
     */
    String insert(List<User> users);

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     * @param user
     * @return 返回删除语句
     */
    String delete(User user);
/**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     * @param user
     * @return 返回更新语句
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

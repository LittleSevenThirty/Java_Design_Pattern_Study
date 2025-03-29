package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.agent.Select;

public interface IUserDao {
    @Select(value="select userName from user where id=#{uId}")
    String queryUserInfo(String uId);
}

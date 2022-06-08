package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.entity.Group;

public interface GroupService {

   //mapper里自带的一系列功能
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    void join(String userId, String groupname);

    boolean createGroup(String userid, String groupName);
}



package com.whh.service;

import com.whh.domain.PageBean;
import com.whh.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @param selectImfor
     * @return
     */
    public PageBean<User> selectByPageAndCondition(int current, int pageSize, String selectImfor);

    /**
     * 根据账号密码查询用户（登陆用）
     * @param username
     * @param password
     * @return
     */
    public User selectUser(String username, String password);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User selectById(int id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public User selectByUserName(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean add(User user);

    /**
     * 管理员增加
     * @param user
     * @return
     */
    public boolean manageadd(User user);

    /**
     * 根据选择的用户id进行删除
     * @param id
     * @return
     */
    public boolean deleteByChoose(int id);

    /**
     * 根据选择的用户数组进行批量删除
     * @param ids
     * @return
     */
    public boolean deleteByIds(int[] ids);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public boolean update(User user);
}

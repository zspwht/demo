package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.bean.UserOnline;
import com.example.demo.service.SessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author zsp
 * @Date 2021/7/9 11:31
 * @Version 1.0
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDAO sessionDAO;
    @Override
    public List<UserOnline> list() {
        List<UserOnline> list = new ArrayList<>();
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();
        for (Session activeSession : activeSessions) {
            UserOnline userOnline = new UserOnline();
            User user = new User();
            SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection();
            if(activeSession.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)==null){
                continue;
            }else{
                simplePrincipalCollection = (SimplePrincipalCollection) activeSession.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                user =(User) simplePrincipalCollection.getPrimaryPrincipal();
                userOnline.setUserName(user.getUserName());
                userOnline.setUserId(user.getId().toString());
            }

            userOnline.setId(activeSession.getId().toString());
            userOnline.setSystemHost(activeSession.getHost());
            userOnline.setStartTimestamp(activeSession.getStartTimestamp());
            userOnline.setLastAcessTime(activeSession.getLastAccessTime());
            long timeout = activeSession.getTimeout();
            if(timeout==01){
                userOnline.setStatus("离线");
            }else{
                userOnline.setStatus("在线");
            }
            userOnline.setTimeout(timeout);
            list.add(userOnline);
        }
        return list;
    }

    @Override
    public boolean forceLogout(String id) {
        Session session = sessionDAO.readSession(id);
        session.setTimeout(0);
        return true;
    }
}

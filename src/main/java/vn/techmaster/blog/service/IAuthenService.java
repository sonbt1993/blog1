package vn.techmaster.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.controller.request.LoginRequest;
import vn.techmaster.blog.model.User;

import java.util.List;

public interface IAuthenService {
  List<User> getAllUser();

  public UserInfo login(LoginRequest loginRequest) throws AuthenException;

  public boolean isLogined(HttpServletRequest request);

  public UserInfo getLoginedUser(HttpServletRequest request);

  public User getUser(HttpServletRequest request);

  public void setLoginedCookie(HttpServletResponse response, UserInfo user);

  public void clearLoginedCookie(HttpServletResponse response);
} 

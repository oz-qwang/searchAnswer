package com.wxy.web.rest.service.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wxy.web.common.domain.BaseUserInfo;
import com.wxy.web.common.domain.User;
import com.wxy.web.common.repository.BaseUserInfoRespository;
import com.wxy.web.common.repository.GenderRespository;
import com.wxy.web.rest.service.BaseUserInfoService;


/**
 * Created by xinyu wei on 5/20/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/20/2016 01:10
 */
@Service public class BaseUserInfoServiceImpl implements BaseUserInfoService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired BaseUserInfoRespository baseUserInfoRespository;

  /** TODO: DOCUMENT ME! */
  @Autowired GenderRespository genderRespository;


  //~ Methods ----------------------------------------------------------------------------------------------------------

  @Override
  public void save(BaseUserInfo baseUserInfo) {
    baseUserInfoRespository.save(baseUserInfo);
  }

  /**
   * v.
   *
   * @param  user          User
   * @param  baseUserInfo  BaseUserInfo
   * @param  genderId      Long
   */
  @Override public void saveOrUpdateBaseUserInfo(User user, BaseUserInfo baseUserInfo, Long genderId) {
    baseUserInfo.setGender(genderRespository.getOne(genderId));

    if (Objects.isNull(baseUserInfo.getId())) {
      baseUserInfo.setUser(user);
      baseUserInfo.setCreater(user);
      baseUserInfo.setCreateDate(new Date());
      baseUserInfo.setLastUpdater(user);
      baseUserInfo.setLastUpdateDate(new Date());
      baseUserInfoRespository.save(baseUserInfo);
    } else {
      baseUserInfoRespository.save(copyFromBaseUserInfo(user, baseUserInfo));
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private BaseUserInfo copyFromBaseUserInfo(User user, BaseUserInfo baseUserInfo) {
    BaseUserInfo savedBaseUserInfo = baseUserInfoRespository.getOne(baseUserInfo.getId());
    savedBaseUserInfo.setGender(baseUserInfo.getGender());
    savedBaseUserInfo.setNickname(baseUserInfo.getNickname());
    savedBaseUserInfo.setDescription(baseUserInfo.getDescription());
    savedBaseUserInfo.setEmail(baseUserInfo.getEmail());
    savedBaseUserInfo.setLastUpdater(user);
    savedBaseUserInfo.setLastUpdateDate(new Date());

    return savedBaseUserInfo;
  }
} // end class BaseUserInfoServiceImpl

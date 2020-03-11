package com.txsh.utils;

import com.txsh.base.MLAppDiskCache;
import com.txsh.model.UserCityData;
import com.txsh.model.UserCityData.UserCity;

/**
 * Created by 汉玉 on 2017/3/9.
 */
public class MLUserCityUtils {

  public static void saveCityData(String userId, String userName, String cityId, String cityName) {
    UserCityData userCityData;
    UserCity userCity;
    if (MLAppDiskCache.getCity() != null) {
      userCityData = MLAppDiskCache.getCity();
    } else {
      userCityData = new UserCityData();
    }
    if (getCityData(userId, userName) != null) {
      userCity = getCityData(userId, userName);
    } else {
      userCity = userCityData.new UserCity();
    }
    userCity.userId = userId;
    userCity.username = userName;
    userCity.cityId = cityId;
    userCity.cityName = cityName;
    userCityData.datas.add(userCity);
    MLAppDiskCache.setCity(userCityData);
  }

  public static UserCity getCityData(String userId, String userName) {
    if (MLAppDiskCache.getCity() == null) {
      return null;
    } else {
      UserCityData userCityData = MLAppDiskCache.getCity();
      UserCity userCity = null;
      for (UserCity u : userCityData.datas) {
        if (u.username.equals(userName) && u.userId.equals(userId)) {
          userCity = u;
        }
      }
      return userCity;
    }
  }
}

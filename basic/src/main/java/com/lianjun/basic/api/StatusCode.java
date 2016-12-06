package com.lianjun.basic.api;

/**
 * Created by Administrator on 2016/4/27.
 */
public interface StatusCode {

    String SUCCESS = "success";
    String MESSAGE_ERROR_SEX = "error_sex";//error_sex： 性别不能为空
    String MESSAGE_ERROR_SOFA = "error_sofa";//error_sofa: 房间沙发数不足
    String USER_NOT_EXIST = "notExist";//用户不存在
    String USER_PASSWORD_ERROR = "password_validate";//密码错误
    String SOFA_NO_IS_NULL = "sofaNo_is_null";//沙发为空
    String ERROR_PROJECT = "error_project";//未选择项目
    String ERROR_SERVE = "error_serve";//加钟时，未上钟的明细不允许加钟
    String ERROR_WORKING = "error_working";//技师当前正在上钟，不允许在起钟其他项目
    String ERROR_TURN = "error_turnNnull";//暂时没有空闲技师可以轮钟
    String ERROR_CLOSE = "error_close";//技师选择功能已经关闭，不允许用任何方式选择任何技师
    String ERROR_ON_CLOCK = "error_onClock";//技师正在上钟，不允许更换技师
    String ERROR_DOWN_TIME = "error_downTime";//当前用户有落钟的项目,不能修改性别
    String ERROR_NO_AUTORITY = "error_Noauthority";//没有权限

    String ERROR_PROJECT_TIME = "error_projectTime";//所选项目时长大于已选项目时长
    String ERROR_ARTICER2_CD = "error_artificer2Cd";//技师2为空
    String ERROR_WATING = "error_waiting";//双技师项目必须选择空闲技师   多技师项目时，不允许包含等待技师
    String ERROR_SHANGPIN = "error_shangpin";//表示为商品，不能上钟
    String ERROR_DELETED = "error_deleted";//
}

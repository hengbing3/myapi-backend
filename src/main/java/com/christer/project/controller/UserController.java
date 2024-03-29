package com.christer.project.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.christer.project.WebURLConstant;
import com.christer.project.common.CommonResult;
import com.christer.project.common.ResultBody;
import com.christer.project.common.ResultCode;
import com.christer.project.config.SessionServiceConfig;
import com.christer.project.model.dto.user.*;
import com.christer.project.model.vo.UserInfoVO;
import com.christer.project.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.christer.project.constant.CommonConstant.ADMIN_ROLE;
import static io.lettuce.core.AclCategory.ADMIN;

/**
 * @author Christer
 * @version 1.0
 * @date 2023-10-08 17:36
 * Description:
 */
@RestController
@RequiredArgsConstructor
public class UserController extends AbstractSessionController {

    private final UserService userService;

    private final SessionServiceConfig sessionService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping(WebURLConstant.URI_USER_REGISTER)
    @ApiOperation("用户注册")
    public CommonResult<Long> registerUser(@RequestBody @Validated UserRegisterParam userParam) {
        log.info("register user param: {}", userParam);
        final Long id = userService.registerUser(userParam);
        return ResultBody.success(id);
    }

    @PutMapping(WebURLConstant.URI_USER)
    @ApiOperation("用户编辑")
    public CommonResult<Void> editUserInfo(@RequestBody @Validated UserUpdateParam userUpdateParam) {
        log.info("user update,param:{}", userUpdateParam);
        return userService.updateUserInfo(userUpdateParam) ? ResultBody.success()
                : ResultBody.failed(ResultCode.FAILED);
    }

    @PostMapping(WebURLConstant.URI_USER_LOGIN)
    @ApiOperation("用户登录")
    public CommonResult<String> loginUser(@RequestBody @Validated UserLoginParam userParam) {
        log.info("login user param: {}", userParam);
        final UserInfoVO userInfoVO = userService.loginUser(userParam);
        sessionService.login(userInfoVO);
        return ResultBody.success(sessionService.getCurrentUserInfo().getToken());
    }

    @PutMapping(WebURLConstant.URI_USER + "/changePassword")
    @ApiOperation("修改密码")
    public CommonResult<Void> changePassWord(@RequestBody @Validated ChangePasswordParam changePasswordParam) {
        log.info("user change password:{}", changePasswordParam);
        final Boolean flag = userService.changePassword(changePasswordParam);
        return Boolean.TRUE.equals(flag) ? ResultBody.success() : ResultBody.failed(ResultCode.FAILED);
    }

    // TODO 重置密码接口

    // TODO 新增用户

    @PostMapping(WebURLConstant.URI_USER_LOGOUT)
    @ApiOperation("用户登出")
    public CommonResult<Void> userLogout() {
        return sessionService.logout() ? ResultBody.success()
                : ResultBody.failed(ResultCode.FAILED);
    }

    @GetMapping(WebURLConstant.URI_USER_INFO)
    @ApiOperation("当前登录用户信息")
    public CommonResult<UserInfoVO> getUserInfo() {
        return ResultBody.success(getCurrentUserInfo());
    }

    @PostMapping(WebURLConstant.URI_USER_PAGE)
    @ApiOperation("用户分页查询")
    @SaCheckRole(ADMIN_ROLE)
    public CommonResult<Page<UserInfoVO>> queryUserByCondition(@RequestBody @Validated UserQueryParam userParam) {
        log.info("user page condition:{}", userParam);
        final Page<UserInfoVO> userInfoVOPage = userService.queryUserByCondition(userParam);
        return ResultBody.success(userInfoVOPage);
    }

    @GetMapping(WebURLConstant.URI_USER)
    @ApiOperation("用户详情查询")
    public CommonResult<UserInfoVO> queryUserInfoById(@RequestParam Long id) {
        log.info("user info by id:{}", id);
        final UserInfoVO userInfoVO = userService.selectById(id);
        return ResultBody.success(userInfoVO);
    }




}

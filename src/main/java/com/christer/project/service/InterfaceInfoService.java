package com.christer.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.christer.project.model.dto.interfaceinfo.InterfaceInfoInvokeParam;
import com.christer.project.model.dto.interfaceinfo.InterfaceInfoParam;
import com.christer.project.model.dto.interfaceinfo.QueryInterfaceInfoParam;
import com.christer.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
* @author DEKU
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-01-21 22:28:55
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    boolean addInterFaceInfo(InterfaceInfoParam interfaceInfo);

    Page<InterfaceInfo> queryByPage(QueryInterfaceInfoParam interfaceInfoParam);

    InterfaceInfo queryById(Long id);

    boolean editInterfaceInto(InterfaceInfoParam interfaceInfo);

    boolean deleteById(Long id, Long currentUserId);

    /**
     * 上线接口
     * @param id
     * @param currentUserId
     * @return
     */
    boolean onlineInterfaceInfo(Long id, Long currentUserId);

    /**
     * 接口下线
     * @param id
     * @param currentUserId
     * @return
     */
    boolean outlineInterfaceInfo(Long id, Long currentUserId);

    /**
     * 接口调试
     * @param param
     * @return
     */
    Object invokeInterfaceInfo(InterfaceInfoInvokeParam param, Long currentUserId);
}

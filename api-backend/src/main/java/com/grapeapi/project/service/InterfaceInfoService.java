package com.grapeapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.grapeapi.apicommon.model.entity.InterfaceInfo;

/**
 * 接口信息服务
 *
 * @author grape
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}

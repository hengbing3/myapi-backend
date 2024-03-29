package com.christer.myapicommon.common;

/**
 * @author Christer
 * @version 1.0
 * @date 2023-12-02 16:15
 * Description:
 * 常量存储
 */
public final class CommonConstant {

    private CommonConstant() {

    }

    /**
     * 盐值，混淆密码
     */
    public static final String SALT = "My*Christer";

    public static final String DEPARTMENT_SALT = "My*Christer_Department";

    public static final String DEPARTMENT_SALT_ID = "My*Christer_Department_Check_ID";

    public static final String FLOWABLE_SALT = "My*Christer_Flowable";
    /**
     * 角色常量：admin
     */
    public static final String ADMIN_ROLE = "admin";


    public static final String SORT_ORDER_ASC = "asc";

    public static final String SORT_ORDER_DESC = "desc";
    /**
     * api开放工作流审核key
     */
    public static final String API_OPEN_AUDIT_KEY = "openApiAuditProcessKey";
}

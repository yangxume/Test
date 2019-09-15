package com.xy.t_net.retro_okhttp;

import com.google.gson.JsonObject;
import com.xy.t_net.bean.Login;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServiceConcrete {

    @GET("10/1")
    Observable<JsonObject> getData();

    /**
     *  登录
     */
    @POST("rbac/api/user/login")
    Observable<JsonObject> getLogin(@Body RequestBody body);

    /**
     * 登出
     */
    @GET("rbac/api/user/logout")
    Observable<JsonObject> getLogout();

    /**
     * 站点选择
     */
    @POST("rbac/api/depart/siteList")
    Observable<JsonObject> siteList();

    /**************************  预警    **************************/


    /**
     * 主页预警信息统计及通知
     */
    @POST("")
    Observable<JsonObject> warnLeaderList();

    /**
     * 预警列表-领导
     */
    @POST("cp/api/warning/list/leader/gradationDepartment")
    Observable<JsonObject> warnLeaderListSecond(@Body RequestBody body);

    /**
     * 预警处理列表（处理人员）
     */
    @POST("cp/api/warning/list/handle/{gradationDepartment}")
    Observable<JsonObject> warnDisposeList(@Body RequestBody body);

    /**
     * 预警处理列表（审核人员）
     */
    @POST("cp/api/warning/list/audit/{gradationDepartment}")
    Observable<JsonObject> warnAuditList(@Body RequestBody body);

    /**
     * 预警处理详情
     */
    @POST("cp/api/warning/info/handle")
    Observable<JsonObject> warnDisposeDetail(@Body RequestBody body);

    /**
     * 预警审核详情
     */
    @POST("cp/api/warning/info/audit/{id}")
    Observable<JsonObject> warnAuditDetail(@Body RequestBody body);

    /**
     * 预警处理--罐车处理
     */
    @POST("cp/api/warning/info/audit/{id}")
    Observable<JsonObject> warnDisposeGuanche(@Body RequestBody body);

    /**
     * 预警处理—库存/材料/运输过磅处理
     */
    @POST("cp/api/warning/info/audit/{id}")
    Observable<JsonObject> warnDisposeOthers(@Body RequestBody body);

    /**
     * 预警处理—资料补录处理
     */
    @POST("cp/api/warning/info/audit/{id}")
    Observable<JsonObject> warnDisposeRecordData(@Body RequestBody body);

    /**
     * 预警审核
     */
    @POST("cp/api/warning/info/audit/{id}")
    Observable<JsonObject> warnAudit(@Body RequestBody body);


    /**************************   我的    **************************/


    @POST("/cp/api/my/information")
    Observable<JsonObject>  getMyInfo();

    @POST("/cp/api/my/changePassword")
    Observable<JsonObject>  changePassword(@Body RequestBody body);

    @POST("/cp/api/my/proposal/1")
    Observable<JsonObject>  feedBack(@Body RequestBody body);

    @POST("/cp/api/my/initialization/1")
    Observable<JsonObject>  issueReportInit(@Body RequestBody body);

    @POST("/cp/api/my/initialization/gradationDepartment")
    Observable<JsonObject>  issueReport(@Body RequestBody body);

    @POST("me/issuelist")
    Observable<JsonObject>  getIssueList(@Body RequestBody body);

    @POST("me/issuedispose")
    Observable<JsonObject>  issueDispose(@Body RequestBody body);



    /**************************   统计    **************************/
    @POST("statistics/home")
    Observable<JsonObject>  statisticsLeader(@Body RequestBody body);

    @POST("statistics/home")
    Observable<JsonObject>  statisticsHome(@Body RequestBody body);

    @POST("statistics/quality")
    Observable<JsonObject>  statisticsQuality(@Body RequestBody body);

    @POST("statistics/production")
    Observable<JsonObject>  statisticsProduction(@Body RequestBody body);

    @POST("statistics/materials")
    Observable<JsonObject>  statisticsMaterials(@Body RequestBody body);

    @POST("statistics/transport")
    Observable<JsonObject>  statisticsTransport(@Body RequestBody body);

    @POST("statistics/dispose")
    Observable<JsonObject>  statisticsDispose(@Body RequestBody body);
    
    
}

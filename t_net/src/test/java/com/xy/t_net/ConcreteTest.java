package com.xy.t_net;

import com.google.gson.JsonObject;
import com.xy.t_net.retro_okhttp.ApiServiceConcrete;
import com.xy.t_net.retro_okhttp.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.http.POST;

//https://blog.csdn.net/qq_28190653/article/details/81035835

//https://blog.csdn.net/u010316858/article/details/70312795

//https://www.jianshu.com/p/3aa0e4efcfd3

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
public class ConcreteTest {

    @Before
    public void setUp() {

        ShadowLog.stream = System.out;
        initRxJava2();

    }

    private void initRxJava2() {

        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });

        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });

    }

    @Test //ok
    public void login() {

        JSONObject params = new JSONObject();

        try {
            params.put("login", "17301025530");
            params.put("pwd", "111111");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getLogin(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //D/t_net: 上行--> requestid=031858719793 POST http://39.97.253.40/rbac/api/user/login http/1.1
        //D/t_net:
        //D/t_net: {"login":"17301025530","pwd":"111111"}
        //D/t_net: --> END POST (38-byte body)
        //D/t_net: 下行<-- requestid=031858719793, 200  http://39.97.253.40/rbac/api/user/login (127ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=031858719793, {"code":0,"body":{"moduleResource":[],"roleIds":[1],"identityIds":[6],"apiResource":[],"departmentIds":[],"user":{"notes":"","phone":"17301025530","nickName":"李四","loginName":"17301025530","name":"李四","userPosition":"","id":1,"gmtCreate":"2019-01-12 14:55:49","headPic":"","jobNumber":"","email":""},"token":"customerae6317dadbe34f6b8071cfe153417eca"},"message":"success"}


    }

    @Test
    public void logout() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getLogout()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void noticeList() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .noticelist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void noticeReadReport() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .noticeReadReport()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test //ok 缺少项目集次编码
    public void siteList() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .siteList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //D/t_net: 上行--> requestid=032014690902 POST http://39.97.253.40/rbac/api/depart/siteList http/1.1
        //D/t_net:
        //D/t_net:
        //D/t_net: --> END POST (0-byte body)
        //D/t_net: 下行<-- requestid=032014690902, 200  http://39.97.253.40/rbac/api/depart/siteList (103ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=032014690902, {"code":0,"body":[{"id":"null","text":"保津高速公路","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}},{"id":"null","text":"阿斯顿高速公路","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}},{"id":"null","text":"工程1","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}},{"id":"null","text":"工程2","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}},{"id":"null","text":"工程3","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}},{"id":"null","text":"测试12","checked":null,"children":[],"isParent":false,"chkDisabled":null,"open":true,"iconSkin":null,"attr":{"depType":1}}],"message":"success"}

    }

    @Test
    public void warnLeaderList() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnLeaderList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnLeaderListSecond() {

        JSONObject params = new JSONObject();

        try {
            params.put("earlyWarningType", "10");//10 人为作弊,20 生产违规,30 质量风险,40 材料异常,50 人工监督
            params.put("gradationDepartment", "");
            params.put("size", "10");
            params.put("current", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnLeaderListSecond(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnDisposeList() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("size", "10");
            params.put("current", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnDisposeList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnAuditList() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("size", "10");
            params.put("current", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnAuditList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnDisposeDetail() {

        JSONObject params = new JSONObject();

        try {
            params.put("id", "");
            params.put("earlyWarningUnit", "");
            params.put("idCpWeighingMaterial", "");
            params.put("processingUnit", "");
            params.put("treatmentSuggestion", "");
            params.put("earlyWarningIds", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnDisposeDetail(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnAuditDetail() {

        JSONObject params = new JSONObject();

        try {
            params.put("id", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnAuditDetail(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnDisposeGuanche() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("id", "");
            params.put("idCpSendVolume", "");
            params.put("callOutOnSendVolume", "");
            params.put("callOutOnPour", "");
            params.put(" callOutStrengthGrade", "");
            params.put("callOutQuantity", "");
            params.put("scrapQuantity", "");
            params.put("handleDetails", "");
            params.put("fileList", "");
            params.put("enclosureList", "");
            params.put("enclosure", "");

            params.put("id", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnDisposeGuanche(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnDisposeOthers() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("id", "");
            params.put("handleDetails", "");
            params.put("fileList", "");
            params.put("enclosureList", "");
            params.put("enclosure", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnDisposeOthers(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnDisposeRecordData() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("id", "");
            params.put("processingNo", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnDisposeRecordData(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void warnAudit() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("type", "");
            params.put("id", "");
            params.put("notes", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .warnAudit(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test //ok
    public void getMyInfo() {

       RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getMyInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
       //D/t_net: 上行--> requestid=030142441132 POST http://39.97.253.40/cp/api/my/information http/1.1
        //D/t_net:
        //D/t_net:
        //D/t_net: --> END POST (0-byte body)
        //D/t_net: 下行<-- requestid=030142441132, 200  http://39.97.253.40/cp/api/my/information (136ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=030142441132, {"code":0,"body":{"phone":"17301025530","name":"李四","company":"保津高速公路","position":null},"message":"success"}
        //D/t_net: <-- END HTTP (124-byte body)

    }

    @Test //ok
    public void changePassword() {

        JSONObject params = new JSONObject();

        try {
            params.put("oldPwd", "111111");
            params.put("newPwd1", "111111");
            params.put("newPwd2", "111111");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .changePassword(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //D/t_net: 上行--> requestid=031078442643 POST http://39.97.253.40/cp/api/my/changePassword http/1.1
        //D/t_net:
        //D/t_net: {"oldPwd":"111111","newPwd1":"111111","newPwd2":"111111"}
        //D/t_net: --> END POST (57-byte body)
        //D/t_net: 下行<-- requestid=031078442643, 200  http://39.97.253.40/cp/api/my/changePassword (149ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=031078442643, {"code":0,"body":null,"message":"success"}

    }

    @Test //ok 此处url后需要拼接id
    public void feedBack() {

        JSONObject params = new JSONObject();

        try {
            params.put("content", "软件很不错");
            params.put("anonymous", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .feedBack("1",body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        D/t_net: 上行--> requestid=030823742637 POST http://39.97.253.40/cp/api/my/proposal/1 http/1.1
//        D/t_net:
//        D/t_net: {"gradationDepartment":"2","content":"软件很不错","anonymous":"1"}
//        D/t_net: --> END POST (71-byte body)
//        D/t_net: 下行<-- requestid=030823742637, 200  http://39.97.253.40/cp/api/my/proposal/1 (125ms)
//        D/t_net:
//        D/t_net: 下行<-- requestid=030823742637, {"code":0,"body":null,"message":"success"}

    }

    @Test //?
    public void issueReportInit() {

//        JSONObject params = new JSONObject();
//
//        try {
//            params.put("gradationDepartment", "1");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .issueReportInit("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test //?
    public void issueReport() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "1");
            params.put("bidSectionId", "1");
            params.put("bidSectionName", "1");
            params.put("contentOfTheReport", "1");
            params.put("fileList", "1");
            params.put("fileList", "1");
            params.put("anonymous", "1");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .issueReport(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //D/tag_concrete: request headers :Api-Gzip: 0
        //requestid: 031792425405
        //X-AUTH-TOKEN: customerf8cbdee936544c60ba4f044381c26057
        //
        //D/t_net: 上行--> requestid=031792425405 POST http://39.97.253.40/cp/api/my/initialization/gradationDepartment http/1.1
        //D/t_net:
        //D/t_net: {"gradationDepartment":"1","bidSectionId":"1","bidSectionName":"1","contentOfTheReport":"1","fileList":"1","anonymous":"1"}
        //D/t_net: --> END POST (123-byte body)
        //D/t_net: 下行<-- requestid=031792425405, 200  http://39.97.253.40/cp/api/my/initialization/gradationDepartment (250ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=031792425405, {"body":null,"message":"系统正忙,请稍后在试......","code":-9999}
        //D/t_net: <-- END HTTP (73-byte body)

    }

    @Test //? 缺失接口
    public void getIssueList() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getIssueList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void issueDispose() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .issueDispose(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test //ok
    public void statisticsHomeLeader() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsHomeLeader(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //D/t_net: 上行--> requestid=031812544201 POST http://39.97.253.40/cp/api/statistics/homePageLeader http/1.1
        //D/t_net:
        //D/t_net: {"gradationDepartment":"1"}
        //D/t_net: --> END POST (27-byte body)
        //D/t_net: 下行<-- requestid=031812544201, 200  http://39.97.253.40/cp/api/statistics/homePageLeader (104ms)
        //D/t_net:
        //D/t_net: 下行<-- requestid=031812544201, {"code":0,"body":{"proectList":[{"bidSectionList":[{"bidSectionName":"1标段","siteRanking":4,"siteName":"#33站"},{"bidSectionName":"1标段","siteRanking":3,"siteName":"#33站"}],"projectName":"保津高速公路"}]},"message":"success"}

    }



    @Test //?
    public void statisticsHomeOthers() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsHome(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void statisticsQuality() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("rankingBasis", "");
            params.put("startTime", "");
            params.put("endTime", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsQuality(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void statisticsProduction() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("rankingBasis", "");
            params.put("startTime", "");
            params.put("endTime", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsFangliang(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void statisticsMaterials() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("rankingBasis", "");
            params.put("startTime", "");
            params.put("endTime", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsMaterials(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void statisticsTransport() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("rankingBasis", "");
            params.put("startTime", "");
            params.put("endTime", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsTransport(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Test
    public void statisticsDispose() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("rankingBasis", "");
            params.put("startTime", "");
            params.put("endTime", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsDispose(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
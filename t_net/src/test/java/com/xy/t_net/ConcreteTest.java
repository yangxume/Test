package com.xy.t_net;

import com.google.gson.JsonObject;
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

    @Test
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

//        {"code":0,"body":{"moduleResource":[],"roleIds":[1],"identityIds":[6],"apiResource":[],"departmentIds":[],"user":{"notes":"","phone":"17301025530","nickName":"李四","loginName":"17301025530","name":"李四","userPosition":"","id":1,"gmtCreate":"2019-01-12 14:55:49","headPic":"","jobNumber":"","email":""},"token":"customer37b7339c44bf404dbfb2cd2fa0012081"},"message":"success"}

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

    @Test
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

    }

    @Test
    public void changePassword() {

        JSONObject params = new JSONObject();

        try {
            params.put("oldPwd", "");
            params.put("newPwd1", "");
            params.put("newPwd2", "");
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

    }

    @Test
    public void getSoftwareFunction() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getSoftwareFunction()
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
    public void getCompanyIntro() {

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .getCompanyIntro()
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
    public void feedBack() {

        JSONObject params = new JSONObject();

        try {
            params.put("anonymous", "");
            params.put("content", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .feedBack(body)
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
    public void issueReportInit() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .issueReportInit(body)
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
    public void issueReport() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
            params.put("contentOfTheReport", "");
            params.put("fileList", "");
            params.put("enclosure", "");
            params.put("anonymous", "");
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

    }

    @Test
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

    @Test
    public void statisticsLeader() {

        JSONObject params = new JSONObject();

        try {
            params.put("gradationDepartment", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());

        RetrofitClient.getInstance().create(ApiServiceConcrete.class)
                .statisticsLeader(body)
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
    public void statisticsHome() {

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
                .statisticsProduction(body)
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
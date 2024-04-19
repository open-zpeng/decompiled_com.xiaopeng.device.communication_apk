package com.xiaopeng.lib.framework.netchannelmodule.http.tracing;

import android.text.TextUtils;
import b.d.b.e.c;
import b.d.b.e.e;
import b.d.b.e.g;
import b.d.b.e.m.b;
import brave.Span;
import brave.Tracer;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class TracingInterceptor implements Interceptor {
    private static final String B3_HEADER_PARENT_ID = "X-B3-ParentSpanId";
    private static final String B3_HEADER_SAMPLED = "X-B3-Sampled";
    private static final String B3_HEADER_SPAN_ID = "X-B3-SpanId";
    private static final String B3_HEADER_TRACE_ID = "X-B3-TraceId";
    private static final String HOST_XIAOPENG_LAN = "10.0.13.28";
    private static final String HOST_XIAOPENG_WAN = "xiaopeng.com";
    private static final String RESPONSE_HEADER_SAMPLE_RATE = "logan-sample-rates";
    private static final String TAG = "Tracer";
    private static final String TAG_KEY_CDUID = "car.cdu_id";
    private static final String TAG_KEY_HOST = "http.host";
    private static final String TAG_KEY_METHOD = "http.method";
    private static final String TAG_KEY_NET = "car.net";
    private static final String TAG_KEY_PATH = "http.path";
    private static final String TAG_KEY_SID = "car.sid";
    private static final String TAG_KEY_STATUS = "http.status_code";
    private static final String TAG_KEY_URL = "http.url";
    private static final String TAG_KEY_VID = "car.vid";
    private static final String TAG_KEY_VIN = "car.vin";

    private void decorateAndFinishSpan(Span span, String str, String str2, HttpUrl httpUrl, int i, Exception exc) {
        span.name(str).kind(Span.Kind.CLIENT).tag(TAG_KEY_HOST, httpUrl.host()).tag(TAG_KEY_METHOD, str2).tag(TAG_KEY_PATH, httpUrl.encodedPath()).tag(TAG_KEY_URL, httpUrl.toString()).tag(TAG_KEY_STATUS, String.valueOf(i)).tag(TAG_KEY_VID, String.valueOf(g.g())).tag(TAG_KEY_VIN, g.f()).tag(TAG_KEY_CDUID, g.c()).tag(TAG_KEY_SID, g.e()).tag(TAG_KEY_NET, String.valueOf(e.a(GlobalConfig.getApplicationContext()))).error(exc).finish();
    }

    private boolean isXiaopengHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (b.h()) {
            return str.contains(HOST_XIAOPENG_LAN);
        }
        return str.contains(HOST_XIAOPENG_WAN);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        if (!isXiaopengHost(url.host())) {
            c.a(TAG, "isXiaopengHost(url.host()) == false, host:" + url.host());
            return chain.proceed(request);
        }
        String httpUrl = url.toString();
        String substring = httpUrl.substring(httpUrl.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
        Tracer tracer = TracingHolder.getInstance().getTracer();
        Span start = tracer.newTrace().start();
        tracer.withSpanInScope(start);
        Span nextSpan = tracer.nextSpan();
        String hexString = Long.toHexString(start.context().traceId());
        String hexString2 = Long.toHexString(start.context().spanId());
        String hexString3 = Long.toHexString(nextSpan.context().spanId());
        Boolean sampled = start.context().sampled();
        c.a(TAG, "Tracing intercept operationName:" + substring + " traceId:" + hexString + " spanId:" + hexString3 + " sampled:" + sampled);
        try {
            Response proceed = chain.proceed(request.newBuilder().addHeader(B3_HEADER_TRACE_ID, String.valueOf(hexString)).addHeader(B3_HEADER_SPAN_ID, String.valueOf(hexString3)).addHeader(B3_HEADER_SAMPLED, String.valueOf(sampled)).addHeader(B3_HEADER_PARENT_ID, String.valueOf(hexString2)).build());
            TracingHolder.getInstance().updateSampleRate(proceed.header(RESPONSE_HEADER_SAMPLE_RATE));
            int code = proceed.code();
            decorateAndFinishSpan(nextSpan, substring, request.method(), url, code, null);
            decorateAndFinishSpan(start, substring, request.method(), url, code, null);
            c.a(TAG, "Tracing intercept finish, code:" + code);
            return proceed;
        } catch (Exception e) {
            decorateAndFinishSpan(nextSpan, substring, request.method(), url, -1, e);
            decorateAndFinishSpan(start, substring, request.method(), url, -1, e);
            c.a(TAG, "Tracing intercept finish, code:-1");
            throw e;
        }
    }
}

package com.ta.utdid2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.utdid2.b.a.d;
import com.ta.utdid2.b.a.f;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AidRequester.java */
/* loaded from: classes.dex */
public class b {
    private static final String TAG = "com.ta.utdid2.a.b";

    /* renamed from: a  reason: collision with root package name */
    private static b f2108a;

    /* renamed from: a  reason: collision with other field name */
    private Object f104a = new Object();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    private static String b(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, XmartV1Constants.UTF8_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append("http://hydra.alibaba.com/");
        sb.append(str);
        sb.append("/get_aid/");
        sb.append("?");
        sb.append("auth[token]=");
        sb.append(str2);
        sb.append("&type=");
        sb.append("utdid");
        sb.append("&id=");
        sb.append(str3);
        sb.append("&aid=");
        sb.append(str4);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AidRequester.java */
    /* loaded from: classes.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        com.ut.device.a f2109a;

        /* renamed from: a  reason: collision with other field name */
        String f105a;

        /* renamed from: a  reason: collision with other field name */
        HttpPost f106a;

        /* renamed from: b  reason: collision with other field name */
        String f107b;

        /* renamed from: c  reason: collision with root package name */
        String f2111c;

        /* renamed from: d  reason: collision with root package name */
        String f2112d;

        public a(HttpPost httpPost) {
            this.f105a = "";
            this.f2112d = "";
            this.f106a = httpPost;
        }

        public String b() {
            return this.f105a;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0060 -> B:56:0x006b). Please submit an issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            HttpResponse httpResponse;
            com.ut.device.a aVar = this.f2109a;
            if (aVar != null) {
                aVar.a(1000, this.f107b);
            }
            BufferedReader bufferedReader = null;
            try {
                httpResponse = new DefaultHttpClient().execute(this.f106a);
            } catch (Exception e) {
                com.ut.device.a aVar2 = this.f2109a;
                if (aVar2 != null) {
                    aVar2.a(1002, this.f107b);
                }
                Log.e(b.TAG, e.toString());
                httpResponse = null;
            }
            try {
                if (httpResponse == null) {
                    Log.e(b.TAG, "response is null!");
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName(XmartV1Constants.UTF8_ENCODING)));
                }
            } catch (Exception e2) {
                com.ut.device.a aVar3 = this.f2109a;
                if (aVar3 != null) {
                    aVar3.a(1002, this.f107b);
                }
                Log.e(b.TAG, e2.toString());
            }
            try {
                if (bufferedReader != null) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (d.e) {
                            Log.d(b.TAG, readLine);
                        }
                        this.f105a = readLine;
                    }
                } else {
                    Log.e(b.TAG, "BufferredReader is null!");
                }
            } catch (Exception e3) {
                com.ut.device.a aVar4 = this.f2109a;
                if (aVar4 != null) {
                    aVar4.a(1002, this.f107b);
                }
                Log.e(b.TAG, e3.toString());
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (d.e) {
                        Log.d(b.TAG, "close the bufferreader");
                    }
                } catch (IOException e4) {
                    Log.e(b.TAG, e4.toString());
                }
            }
            if (this.f2109a != null) {
                String a2 = b.a(this.f105a, this.f107b);
                this.f2109a.a(1001, a2);
                c.a(b.this.mContext, this.f2111c, a2, this.f2112d);
                return;
            }
            synchronized (b.this.f104a) {
                b.this.f104a.notifyAll();
            }
        }

        public a(HttpPost httpPost, com.ut.device.a aVar, String str, String str2, String str3) {
            this.f105a = "";
            this.f2112d = "";
            this.f106a = httpPost;
            this.f2109a = aVar;
            this.f107b = str;
            this.f2111c = str2;
            this.f2112d = str3;
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f2108a == null) {
                f2108a = new b(context);
            }
            bVar = f2108a;
        }
        return bVar;
    }

    public void a(String str, String str2, String str3, String str4, com.ut.device.a aVar) {
        String b2 = b(str, str2, str3, str4);
        if (d.e) {
            String str5 = TAG;
            Log.d(str5, "url:" + b2 + "; len:" + b2.length());
        }
        new a(new HttpPost(b2), aVar, str4, str, str2).start();
    }

    public String a(String str, String str2, String str3, String str4) {
        String b2 = b(str, str2, str3, str4);
        int i = f.b(this.mContext) ? 3000 : 1000;
        if (d.e) {
            String str5 = TAG;
            Log.d(str5, "url:" + b2 + "; timeout:" + i);
        }
        a aVar = new a(new HttpPost(b2));
        aVar.start();
        try {
            synchronized (this.f104a) {
                this.f104a.wait(i);
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        String b3 = aVar.b();
        if (d.e) {
            String str6 = TAG;
            Log.d(str6, "mLine:" + b3);
        }
        return a(b3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("action") && jSONObject2.has("aid")) {
                    String string = jSONObject2.getString("action");
                    return (string.equalsIgnoreCase("new") || string.equalsIgnoreCase("changed")) ? jSONObject2.getString("aid") : str2;
                }
                return str2;
            } else if (jSONObject.has("isError") && jSONObject.has("status")) {
                String string2 = jSONObject.getString("isError");
                String string3 = jSONObject.getString("status");
                if (string2.equalsIgnoreCase("true")) {
                    if (string3.equalsIgnoreCase("404") || string3.equalsIgnoreCase("401")) {
                        if (d.e) {
                            String str3 = TAG;
                            Log.d(str3, "remove the AID, status:" + string3);
                        }
                        return "";
                    }
                    return str2;
                }
                return str2;
            } else {
                return str2;
            }
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
            return str2;
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
            return str2;
        }
    }
}

package b.b.a.a.f;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiResponseParse.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: ApiResponseParse.java */
    /* renamed from: b.b.a.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0038a {

        /* renamed from: a  reason: collision with root package name */
        public static C0038a f1094a = new C0038a();

        /* renamed from: b  reason: collision with root package name */
        public boolean f1095b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f1096c = null;

        public boolean a() {
            return "E0102".equalsIgnoreCase(this.f1096c);
        }

        public boolean b() {
            return "E0111".equalsIgnoreCase(this.f1096c) || "E0112".equalsIgnoreCase(this.f1096c);
        }
    }

    public static C0038a a(String str) {
        C0038a c0038a = new C0038a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    c0038a.f1095b = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0038a.f1096c = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c0038a;
    }
}

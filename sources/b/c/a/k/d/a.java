package b.c.a.k.d;

import android.text.TextUtils;
import b.c.a.k.d.a;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: BodyRequest.java */
/* loaded from: classes.dex */
public abstract class a<T, R extends a> extends d<T, R> {
    private static final long serialVersionUID = -6459175248476927501L;
    protected transient MediaType q;
    protected String r;
    protected byte[] s;
    protected transient File t;
    protected boolean u;
    protected boolean v;
    protected RequestBody w;

    public a(String str) {
        super(str);
        this.u = false;
        this.v = false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.q = MediaType.parse(str);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MediaType mediaType = this.q;
        objectOutputStream.writeObject(mediaType == null ? "" : mediaType.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder G(RequestBody requestBody) {
        try {
            u(HttpHeaders.CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            b.c.a.l.d.a(e);
        }
        return b.c.a.l.b.a(new Request.Builder(), this.j);
    }

    public R H(boolean z) {
        this.u = z;
        return this;
    }

    public R I(String str, File file) {
        this.i.f(str, file);
        return this;
    }

    public R J(File file) {
        this.t = file;
        this.q = b.c.a.l.b.e(file.getName());
        return this;
    }

    public R K(String str) {
        this.r = str;
        this.q = b.c.a.j.b.f1240b;
        return this;
    }

    @Override // b.c.a.k.d.d
    public RequestBody g() {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        if (this.v) {
            this.f1263a = b.c.a.l.b.c(this.f1264b, this.i.f1242d);
        }
        RequestBody requestBody = this.w;
        if (requestBody != null) {
            return requestBody;
        }
        String str = this.r;
        if (str == null || (mediaType3 = this.q) == null) {
            byte[] bArr = this.s;
            if (bArr == null || (mediaType2 = this.q) == null) {
                File file = this.t;
                return (file == null || (mediaType = this.q) == null) ? b.c.a.l.b.d(this.i, this.u) : RequestBody.create(mediaType, file);
            }
            return RequestBody.create(mediaType2, bArr);
        }
        return RequestBody.create(mediaType3, str);
    }
}

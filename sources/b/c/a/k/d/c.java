package b.c.a.k.d;

import b.c.a.j.c;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* compiled from: ProgressRequestBody.java */
/* loaded from: classes.dex */
public class c<T> extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private RequestBody f1255a;

    /* renamed from: b  reason: collision with root package name */
    private b.c.a.d.b<T> f1256b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0048c f1257c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.c f1258a;

        a(b.c.a.j.c cVar) {
            this.f1258a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f1256b != null) {
                c.this.f1256b.uploadProgress(this.f1258a);
            }
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    private final class b extends ForwardingSink {

        /* renamed from: a  reason: collision with root package name */
        private b.c.a.j.c f1260a;

        /* compiled from: ProgressRequestBody.java */
        /* loaded from: classes.dex */
        class a implements c.a {
            a() {
            }

            @Override // b.c.a.j.c.a
            public void a(b.c.a.j.c cVar) {
                if (c.this.f1257c != null) {
                    c.this.f1257c.uploadProgress(cVar);
                } else {
                    c.this.d(cVar);
                }
            }
        }

        b(Sink sink) {
            super(sink);
            b.c.a.j.c cVar = new b.c.a.j.c();
            this.f1260a = cVar;
            cVar.g = c.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            b.c.a.j.c.c(this.f1260a, j, new a());
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: b.c.a.k.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048c {
        void uploadProgress(b.c.a.j.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RequestBody requestBody, b.c.a.d.b<T> bVar) {
        this.f1255a = requestBody;
        this.f1256b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b.c.a.j.c cVar) {
        b.c.a.l.b.f(new a(cVar));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.f1255a.contentLength();
        } catch (IOException e) {
            b.c.a.l.d.a(e);
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f1255a.contentType();
    }

    public void e(InterfaceC0048c interfaceC0048c) {
        this.f1257c = interfaceC0048c;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new b(bufferedSink));
        this.f1255a.writeTo(buffer);
        buffer.flush();
    }
}

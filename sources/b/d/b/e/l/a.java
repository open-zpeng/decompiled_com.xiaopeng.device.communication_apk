package b.d.b.e.l;

import android.util.Base64;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AESUtils.java */
/* loaded from: classes.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName(XmartV1Constants.UTF8_ENCODING)), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(f(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName(XmartV1Constants.UTF8_ENCODING)), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static boolean c(File e, File file, String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    Cipher e2 = e(str, 1);
                    FileInputStream fileInputStream2 = new FileInputStream((File) e);
                    try {
                        e = new FileOutputStream(file);
                        try {
                            CipherOutputStream cipherOutputStream = new CipherOutputStream(e, e2);
                            byte[] bArr = new byte[1048576];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                cipherOutputStream.write(bArr, 0, read);
                            }
                            cipherOutputStream.close();
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                e.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            return true;
                        } catch (Exception e5) {
                            e = e5;
                            fileInputStream = fileInputStream2;
                            e = e;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (e != 0) {
                                e.close();
                                e = e;
                            }
                            return false;
                        } catch (OutOfMemoryError e7) {
                            e = e7;
                            fileInputStream = fileInputStream2;
                            e = e;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (e != 0) {
                                e.close();
                                e = e;
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (e != 0) {
                                try {
                                    e.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        e = 0;
                    } catch (OutOfMemoryError e12) {
                        e = e12;
                        e = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        e = 0;
                    }
                } catch (IOException e13) {
                    e = e13;
                    e.printStackTrace();
                    return false;
                }
            } catch (Exception e14) {
                e = e14;
                e = 0;
            } catch (OutOfMemoryError e15) {
                e = e15;
                e = 0;
            } catch (Throwable th3) {
                th = th3;
                e = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String d(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] bytes = str.getBytes("utf-8");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Cipher e(String str, int i) {
        Cipher cipher = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(i, secretKeySpec);
            return cipher;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return cipher;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return cipher;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return cipher;
        }
    }

    public static byte[] f(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }
}

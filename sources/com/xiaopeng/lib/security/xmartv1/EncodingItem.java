package com.xiaopeng.lib.security.xmartv1;

import android.util.Base64;
import b.d.b.e.c;
import b.d.b.e.m.b;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.UUID;
/* loaded from: classes.dex */
public final class EncodingItem {
    private static final int FIXED_DATA_LENGTH = 15;
    private static final String TAG = "EncodingItem";
    private static byte[] sDeviceId;
    private static final EncodingItem sEmptyItem;
    private byte[] mAesIv;
    private String mEncodedContent;
    private byte mKeyIndex;
    private byte[] mNonce;
    private byte[] mRawContent;
    private long mTimestamp;
    private static final byte[] sMagicNumber = "XP".getBytes();
    private static final SecureRandom sSecureRandom = new SecureRandom();
    private static final ArrayList<String> sKeyAlias = new ArrayList<>();
    private static byte sVersion = XmartV1Constants.ALGORITHM_DEFAULT_REVISION;

    static {
        for (int i = 0; i < XmartV1Constants.LOCAL_KEYS_NUM; i++) {
            sKeyAlias.add(XmartV1Constants.LOCAL_KEYS_PREFIX + i);
        }
        sDeviceId = b.c().getBytes();
        sEmptyItem = empty();
    }

    private EncodingItem() {
    }

    public static EncodingItem decode(byte[] bArr) {
        byte[] decode = Base64.decode(bArr, 2);
        ByteBuffer wrap = ByteBuffer.wrap(decode);
        byte b2 = wrap.get();
        byte[] bArr2 = sMagicNumber;
        if (b2 == bArr2[0] && wrap.get() == bArr2[1]) {
            if (wrap.get() != sVersion) {
                c.a(TAG, "Wrong version number!");
                return sEmptyItem;
            }
            EncodingItem encodingItem = new EncodingItem();
            encodingItem.mKeyIndex = wrap.get();
            int i = wrap.get();
            if (i > 0) {
                wrap.get(new byte[i]);
            }
            encodingItem.mNonce = new byte[wrap.get()];
            encodingItem.mTimestamp = wrap.getLong();
            byte[] bArr3 = new byte[wrap.get()];
            encodingItem.mAesIv = bArr3;
            wrap.get(bArr3);
            byte[] decryptWithByteBuffer = KeyStoreHelper.decryptWithByteBuffer(ByteBuffer.wrap(decode, encodingItem.getBasicLength(), decode.length - encodingItem.getBasicLength()), sKeyAlias.get(encodingItem.mKeyIndex), encodingItem.mAesIv);
            if (decryptWithByteBuffer != null && decryptWithByteBuffer.length > 0) {
                ByteBuffer wrap2 = ByteBuffer.wrap(decryptWithByteBuffer);
                wrap2.get(encodingItem.mNonce);
                byte[] bArr4 = new byte[decryptWithByteBuffer.length - encodingItem.mNonce.length];
                encodingItem.mRawContent = bArr4;
                wrap2.get(bArr4);
                return encodingItem;
            }
            return sEmptyItem;
        }
        c.a(TAG, "Wrong magic number!");
        return sEmptyItem;
    }

    public static EncodingItem empty() {
        EncodingItem encodingItem = new EncodingItem();
        encodingItem.mRawContent = new byte[0];
        encodingItem.mEncodedContent = "";
        encodingItem.mKeyIndex = (byte) -1;
        return encodingItem;
    }

    public static EncodingItem encode(byte[] bArr) {
        return encode(bArr, pickOneRandomKey());
    }

    private boolean encodeInternal() {
        byte[] encryptString = KeyStoreHelper.encryptString(ByteBuffer.allocate(this.mRawContent.length + this.mNonce.length).put(this.mNonce).put(this.mRawContent).array(), sKeyAlias.get(this.mKeyIndex), this.mAesIv);
        if (encryptString != null && encryptString.length != 0) {
            this.mEncodedContent = Base64.encodeToString(ByteBuffer.allocate(getBasicLength() + encryptString.length).put(sMagicNumber).put(sVersion).put(this.mKeyIndex).put((byte) sDeviceId.length).put(sDeviceId).put((byte) this.mNonce.length).putLong(this.mTimestamp).put((byte) this.mAesIv.length).put(this.mAesIv).put(encryptString).array(), 2);
            return true;
        }
        c.a(TAG, "Failed to encrypt the string.");
        return false;
    }

    private int getBasicLength() {
        return sDeviceId.length + 15 + this.mAesIv.length;
    }

    public static String getGeneralKeyAlias() {
        return sKeyAlias.get(0);
    }

    private static byte pickOneRandomKey() {
        return (byte) ((sSecureRandom.nextInt() & 127) % XmartV1Constants.LOCAL_KEYS_NUM);
    }

    public static void resetRandomSeed() {
        sSecureRandom.setSeed(System.currentTimeMillis());
    }

    public String encodedString() {
        return this.mEncodedContent;
    }

    public boolean isEmpty() {
        byte[] bArr = this.mRawContent;
        return bArr == null || bArr.length == 0;
    }

    public byte[] nonce() {
        return this.mNonce;
    }

    public byte[] rawContent() {
        return this.mRawContent;
    }

    public String rawContentString() {
        if (isEmpty()) {
            return "";
        }
        try {
            return new String(this.mRawContent, XmartV1Constants.UTF8_ENCODING);
        } catch (UnsupportedEncodingException unused) {
            c.a(TAG, "Failed to convert raw content to string!");
            return "";
        }
    }

    public long timestamp() {
        return this.mTimestamp;
    }

    public static EncodingItem encode(byte[] bArr, int i) {
        if (bArr == null && bArr.length == 0) {
            return sEmptyItem;
        }
        if (i >= 0 && i <= XmartV1Constants.LOCAL_KEYS_NUM) {
            byte[] bytes = UUID.randomUUID().toString().getBytes();
            byte[] bArr2 = new byte[XmartV1Constants.ALGORITHM_IV_LENGTH];
            sSecureRandom.nextBytes(bArr2);
            EncodingItem encodingItem = new EncodingItem();
            encodingItem.mNonce = bytes;
            encodingItem.mAesIv = bArr2;
            encodingItem.mKeyIndex = (byte) i;
            encodingItem.mRawContent = bArr;
            encodingItem.mTimestamp = System.currentTimeMillis();
            return !encodingItem.encodeInternal() ? sEmptyItem : encodingItem;
        }
        throw new RuntimeException("Wrong security key index!");
    }
}

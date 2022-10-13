package com.wy.rpc.constant;

public enum ReqType {

    REQUEST((byte) 1),
    RESPONSE((byte) 2),
    HEARTBEAT((byte) 3);


    private byte code;

    ReqType(byte code) {
        this.code = code;
    }

    public byte code() {
        return this.code;
    }

    public static ReqType findByCode(int code) {
        for (ReqType value : ReqType.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}

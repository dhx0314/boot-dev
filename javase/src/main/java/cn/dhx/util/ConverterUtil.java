package cn.dhx.util;

public class ConverterUtil {

    public static short twoBytesToShort(byte high, byte low) {
        return (short) (((high & 0xFF) << 8) | (low & 0xFF));
    }

    public static int twoBytesToInt(byte high, byte low) {
        return ((high & 0xFF) << 8) | (low & 0xFF);
    }

    public static byte[] shortToBytes(short num) {
        byte[] bytes = new byte[2];
        bytes[1] = (byte) (0xFF & num);
        bytes[0] = (byte) (0xFF & (num >> 8));
        return bytes;
    }

    public static byte[] intTo2Bytes(int num) {
        byte[] bytes = new byte[2];
        bytes[1] = (byte) (0xFF & num);
        bytes[0] = (byte) (0xFF & (num >> 8));
        return bytes;
    }

    public static byte[] intToBytes(int num) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) (0xFF & num);
        bytes[2] = (byte) (0xFF & (num >> 8));
        bytes[1] = (byte) (0xFF & (num >> 16));
        bytes[0] = (byte) (0xFF & (num >> 24));
        return bytes;
    }

    public static byte[] longTo4Bytes(long num) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) (0xFF & num);
        bytes[2] = (byte) (0xFF & (num >> 8));
        bytes[1] = (byte) (0xFF & (num >> 16));
        bytes[0] = (byte) (0xFF & (num >> 24));
        return bytes;
    }
}

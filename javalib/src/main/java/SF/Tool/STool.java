package SF.Tool;

/**
 * 项目名称：JavaText
 * 类描述：
 * 创建人：xuguoxi
 * 创建时间：2017/5/25 20:41
 * 修改人：xuguoxi
 * 修改时间：2017/5/25 20:41
 * 修改备注：
 */
public class STool {
    /**
    * created at 2017/5/25 21:15
     * int转byte
    */
    public static byte intToByte(int x) {
        return (byte) x;
    }
    /**
    * created at 2017/5/25 21:15
     * byte转int
    */
    public static int byteToInt(byte b) {
        return b & 0xFF;
    }
    /**
    * created at 2017/5/25 21:14
     * 判断一个数是否为整数，是返回true，
    */
    public static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
    /**
    * created at 2017/5/25 21:16
     * byte数组转String16进制输出
    */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
    * created at 2017/5/25 21:18
     *byte转String16进制输出
    */
    public static String byteToHexString(byte src){
        StringBuilder stringBuilder = new StringBuilder("");
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString();
    }
}

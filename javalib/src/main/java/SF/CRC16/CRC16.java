package SF.CRC16;

/**
 * 项目名称：JavaText
 * 类描述：CRC16校验
 * 创建人：xuguoxi
 * 创建时间：2017/5/25 20:30
 * 修改人：xuguoxi
 * 修改时间：2017/5/25 20:30
 * 修改备注：
 */
public class CRC16 {
    /**
    *
    *@author xuguoxi
    * created at 2017/5/25 20:36
     * crc16类说明:
     * 1.得到字符串信息第一步截取字符串--String.subsring
     * 2.得到具体每一位信息后使用Integer.parseInt(String.substring(2), 16)，
     *   得到16进制数去掉前面两位的在十进制下的数，如16进制0x0a将会转化为十进制10;
     * 3.通过getCrc16函数的计算得到int结果
     * 4.在int转byte后直接下发数据
    */
    // 传入四个个十六进制的十进制数,传出六个十六进制的十进制数,后两个就是crc16校验的低八位和高八位
    public static int[] getCrc16(int[] data) {
        int[] temdata = new int[data.length + 2];
        // unsigned char alen = *aStr – 2; //CRC16只计算前两部分
        int xda, xdapoly;
        int i, j, xdabit;
        xda = 0xFFFF;
        xdapoly = 0xA001; // (X**16 + X**15 + X**2 + 1)
        for (i = 0; i < data.length; i++) {
            xda ^= data[i];
            for (j = 0; j < 8; j++) {
                xdabit = (int) (xda & 0x01);
                xda >>= 1;
                if (xdabit == 1)
                    xda ^= xdapoly;
            }
        }
        System.arraycopy(data, 0, temdata, 0, data.length);
        temdata[temdata.length - 2] = (int) (xda & 0xFF);
        temdata[temdata.length - 1] = (int) (xda >> 8);
        return temdata;
    }
}

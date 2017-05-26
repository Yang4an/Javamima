package SF.CRC16;

import org.junit.Test;

import SF.Tool.STool;

/**
 * 项目名称：JavaText
 * 类描述：
 * 创建人：xuguoxi
 * 创建时间：2017/5/25 20:54
 * 修改人：xuguoxi
 * 修改时间：2017/5/25 20:54
 * 修改备注：
 */
public class CRC16Test {
    @Test
    public void getCrc16() throws Exception {
        byte[] b = {(byte) 0x03,(byte) 0x05,(byte) 0x14, (byte) 0x45};
        int[] ints = new int[4];
        for(int i=0;i<b.length;i++){
            ints[i] = STool.byteToInt(b[i]);//16进制byte转10进制
        }
        int[] intsCRC = CRC16.getCrc16(ints);
        for(int i:intsCRC){
            System.out.print(i+"-");
        }
        for(int i=0;i<intsCRC.length;i++){
             Integer.toHexString(intsCRC[i]);
        }
    }

}
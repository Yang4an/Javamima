package SF.DES;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import org.junit.Test;

/**
 * 项目名称：JavaText
 * 类描述：
 * 创建人：xuguoxi
 * 创建时间：2017/5/26 14:13
 * 修改人：xuguoxi
 * 修改时间：2017/5/26 14:13
 * 修改备注：
 */
public class DesTest {

    //待加密内容
    String str = "D1";
    //密码，长度要是8的倍数
    String password = "9588028820109132570743325311898426347" +
            "85729877354946875887501857953775777216308447887" +
            "36994473060344662006164119605741224340594691002" +
            "35892702736860872901247123456";

    @Test
    public void encrypt() throws Exception {
        byte[] result = Des.encrypt(str.getBytes(),password);
        String JiaMiData = Base64.encode(result);
        System.out.println("加密后:"+JiaMiData);
    }
    @Test
    public void decrypt() throws Exception {
        //加密的数据从上面运算得到
        String JieMiData = "wCzF9eGjQsU=";
        try {
            byte[] decryResult = Des.decrypt(Base64.decode(JieMiData), password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
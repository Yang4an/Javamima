package SF.AFFINE;

import org.junit.Test;

/**
 * 项目名称：JavaText
 * 类描述：
 * 创建人：xuguoxi
 * 创建时间：2017/5/26 15:55
 * 修改人：xuguoxi
 * 修改时间：2017/5/26 15:55
 * 修改备注：
 */
public class AffineJSTest {
    String data = "D2sadae3SDa45";
    int[] K = {7,3};//密钥
    @Test
    public void encrypt() throws Exception {
        String jiamiData = AffineJS.encrypt(data,K[0],K[1]);
        System.out.println(jiamiData);
    }

    @Test
    public void deciphering() throws Exception {
        //解密数据由上面的加密得到结果
        String s = "Y)zdydf0ZYd7>";
        //求密钥K[0]的逆的实现
        int a = AffineJS.Euclid(K[0], AffineJS.number);
        String jiemiData = AffineJS.deciphering(s,a,K[1]);
        System.out.println(jiemiData);
    }

}
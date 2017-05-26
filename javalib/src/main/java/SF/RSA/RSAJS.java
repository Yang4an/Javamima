package SF.RSA;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
/**
 * 项目名称：JavaText
 * 类描述：RSA公钥加密，私钥解密，私钥加密，公钥解密
 *         1.需要加密或者解密的String数据
 *         2.需要模，String类型
 *         3.需要公钥指数或者私钥指数，两者都为String类型
 * 创建人：xuguoxi
 * 创建时间：2017/5/26 11:03
 * 修改人：xuguoxi
 * 修改时间：2017/5/26 11:03
 * 修改备注：
 */
public class RSAJS {
    
    /**
    * created at 2017/5/26 11:42
     * 公钥加密, 使用N、e值还原公钥,在使用公钥加密数据
     * MingData:明文数据
     * mod:模N
     * pubkey:公钥e
    */
    public static String PubKeyJiaMi(String MingData,String mod,String pubkey) throws Exception {
        String mi="";
        RSAPublicKey publicKey = RSAUtils.getPublicKey(mod,pubkey);
        mi = RSAUtils.getMi(MingData,publicKey);
        return mi;
    }

    /**
    * created at 2017/5/26 11:43
     * 私钥解密, 使用N、d值还原公钥,在使用公钥加密数据
     * MiData:解密数据
     * mod:模N
     * prikey:私钥d
    */
    public static String PriKeyJieMi(String MiData,String mod,String prikey) throws Exception {
        String ming = "";
        RSAPrivateKey privateKey = RSAUtils.getPrivateKey(mod,prikey);
        ming = RSAUtils.getMing(MiData,privateKey);
        return ming;
    }
    /**
    * created at 2017/5/26 12:29
     * 私钥加密
     * MingData:加密数据
     * mod:模
     * prikey:私钥
    */
    public static String PriKeyJiaMi(String MingData,String mod,String prikey) throws Exception {
        String mi = "";
        RSAPrivateKey privateKey = RSAUtils.getPrivateKey(mod,prikey);
        byte[] cipherData=RSAUtilsReversal.encrypt(privateKey,MingData.getBytes());
        mi= Base64.encode(cipherData);
        return mi;
    }
    /**
    * created at 2017/5/26 12:32
     * 公钥解密
     * MiData:解密数据
     * mod:模
     * pubkey:公钥
    */
    public static String PubKeyJieMi(String MiData,String mod,String pubkey) throws Exception {
        String ming = "";
        RSAPublicKey publicKey = RSAUtils.getPublicKey(mod,pubkey);
        byte[] str = Base64.decode(MiData);
        byte[] res=RSAUtilsReversal.decrypt(publicKey,str);
        ming=new String(res);
        return ming;
    }
}

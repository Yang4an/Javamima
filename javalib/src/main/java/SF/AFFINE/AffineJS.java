package SF.AFFINE;
/**
 * 项目名称：JavaText
 * 类描述：仿射加密
 * 创建人：xuguoxi
 * 创建时间：2017/5/26 14:33
 * 修改人：xuguoxi
 * 修改时间：2017/5/26 14:33
 * 修改备注：
 */

public class AffineJS {

    public static final int number = 26;
    /*
     * 本代码是仿射密码的加密与解密的实现，内含用欧几里得扩展算法求一个数对于26的逆，
     * encrypt函数实现加密，deciphering函数实现解密， Euclid函数实现用欧几里得算法求一个数对于26 的逆
     */
    public static String encrypt(String s, int a, int b) {// 加密函数的实现
        char[] ch = s.toCharArray();
        int length = ch.length;// 明文长度
        int[] in = new int[length];
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]>=65 && ch[i]<=90){
                in[i] = ch[i] - 65;// 利用ascii变成0-25数字,对大写字母
            }else if(ch[i]>=97 && ch[i]<=122){
                in[i] = ch[i] - 97;// 利用ascii变成0-25数字,对小写字母
            }else if(ch[i]>=39 && ch[i]<=64){
                in[i] = ch[i] - 39;
            }
        }
        for (int i = 0; i < length; i++) {
            in[i] = (in[i] * a + b) % 26;// 加密算法
        }
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]>=65 && ch[i]<=90){
                ch[i] = (char) (in[i] + 65);// 将数字变成字母
            }else if(ch[i]>=97 && ch[i]<=122){
                ch[i] = (char) (in[i] + 97);// 将数字变成字母
            }else if(ch[i]>=39 && ch[i]<=64){
                ch[i] = (char) (in[i] + 39);
            }
        }
        return String.valueOf(ch);// 将字符串数字变成String类型的字符串，返回
    }

    public static int Euclid(int a, int number) {// 求a 的逆的实现
        int a1 = 1, a2 = 0, a3 = number;
        int b1 = 0, b2 = 1, b3 = a;
        int t1, t2, t3;
        int q;
        q = a3 / b3;
        //System.out.println("q=" + q);
        t1 = a1 - q * b1;
        t2 = a2 - q * b2;
        t3 = a3 - q * b3;
        while (t3 != 1) {
            a1 = b1;
            a2 = b2;
            a3 = b3;
            b1 = t1;
            b2 = t2;
            b3 = t3;
            q = a3 / b3;
            t1 = a1 - q * b1;
            t2 = a2 - q * b2;
            t3 = a3 - q * b3;
        }
        int a4 = t2 % number;
        if (a4 < 0)
            a4 += number;// 如果a4小于0，要加上26变正
        return a4;// 返回a的逆
    }
    public static String deciphering(String s, int a, int b) {// 解密的实现
        char[] ch = s.toCharArray();
        int length = ch.length;// 密文长度
        int[] in = new int[length];
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]>=65 && ch[i]<=90){
                in[i] = ch[i] - 65;// 利用ascii变成0-25数字,对大写字母
            }else if(ch[i]>=97 && ch[i]<=122){
                in[i] = ch[i] - 97;// 利用ascii变成0-25数字,对小写字母
            }else if(ch[i]>=39 && ch[i]<=64){
                in[i] = ch[i] - 39;
            }
        }
        for (int i = 0; i < length; i++) {
            in[i] = ((in[i] - b) * a) % 26;// 解密算法
            if (in[i] < 0)
                in[i] += 26;
        }
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]>=65 && ch[i]<=90){
                ch[i] = (char) (in[i] + 65);// 将数字变成字母
            }else if(ch[i]>=97 && ch[i]<=122){
                ch[i] = (char) (in[i] + 97);// 将数字变成字母
            }else if(ch[i]>=39 && ch[i]<=64){
                ch[i] = (char) (in[i] + 39);
            }
        }
        return String.valueOf(ch);// 将字符串数字变成String类型的字符串，返回
    }
}

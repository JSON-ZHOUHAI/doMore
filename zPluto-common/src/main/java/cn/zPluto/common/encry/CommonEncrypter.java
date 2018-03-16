package cn.zPluto.common.encry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/4/14.
 * 对手机号，证件号，银行卡号进行加解密
 */
public class CommonEncrypter {

    private static final Logger logger = Logger.getLogger(CommonEncrypter.class);

    private static final String SALT_MOBILE = "N0thing_gReat_wAs_eveR_achieved_with0ut_enthusiasm,hah,How_you_uY, N0_do_n0_die.";

    private static final String SALT_IDENTITY_CODE = "DO_not_miSs_youR_chAncE_To_BLow_I_am_real_&yt";

    private static final String SALT_BANK_CODE = "_thIs_OPpoRtUNitY_coMeS_onCe_in_a_lIFeTIme_yO_^*)_TRR";

    private static final String SALT_MAIL_CODE = "_Yre_ifIGone_HdeFo_TreeOn_elsEReaDy_qUckYun_Hq1SaM_St";

    private static BlowfishForStr mobileBlowfish;

    private static BlowfishForStr identityBlowfish;

    private static BlowfishForStr bankCardCodeBlowfish;

    private static BlowfishForStr mailBlowfish;


    static {
        mobileBlowfish = new BlowfishForStr(SALT_MOBILE.substring(32), SALT_MOBILE.substring(48, 56));
        identityBlowfish = new BlowfishForStr(SALT_IDENTITY_CODE.substring(5), SALT_IDENTITY_CODE.substring(7, 19));
        bankCardCodeBlowfish = new BlowfishForStr(SALT_BANK_CODE.substring(3), SALT_BANK_CODE.substring(9, 21));
        mailBlowfish = new BlowfishForStr(SALT_MAIL_CODE.substring(7), SALT_BANK_CODE.substring(21, 34));
    }

    /**
     * 手机号加密
     * @param content
     * @return
     */
    public static String encodeMobile(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return getString( mobileBlowfish.encrypt(content));
        } catch (Exception e) {
            logger.error("Mobile encode error, content=" + content, e);
        }
        return null;
    }



    /**
     * 手机号解密
     * @param content
     * @return
     */
    public static String decodeMobile(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return mobileBlowfish.decrypt(getBytes(content));
        } catch (Exception e) {
            logger.error("Mobile decode error, content=" + content, e);
        }
        return null;
    }



    /**
     * 身份证号加密
     * @param content
     * @return
     */
    public static String encodeIdentityCode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return getString( identityBlowfish.encrypt(content));
        } catch (Exception e) {
            logger.error("IdentityCode encode error, content=" + content, e);
        }
        return null;
    }

    /**
     * 身份证号解密
     * @param content
     * @return
     */
    public static String decodeIdentityCode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return identityBlowfish.decrypt(getBytes(content));
        } catch (Exception e) {
            logger.error("IdentityCode decode error, content=" + content, e);
        }
        return null;
    }

    /**
     * 银行卡加密
     * @param content
     * @return
     */
    public static String encodeBankCardCode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
           return getString(bankCardCodeBlowfish.encrypt(content));
        } catch (Exception e) {
            logger.error("BankCardCode encode error, content=" + content, e);
        }
        return null;
    }

    /**
     * 银行卡解密
     * @param content
     * @return
     */
    public static String decodeBankCardCode(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return bankCardCodeBlowfish.decrypt(getBytes(content));
        } catch (Exception e) {
            logger.error("BankCardCode decode error, content=" + content, e);
        }
        return null;
    }

    /**
     * Email加密
     * @param content
     * @return
     */
    public static String encodeMail(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return getString(mailBlowfish.encrypt(content));
        } catch (Exception e) {
            logger.error("encodeMail encode error, content=" + content, e);
        }
        return null;
    }

    /**
     * Email解密
     * @param content
     * @return
     */
    public static String decodeMail(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return mailBlowfish.decrypt(getBytes(content));
        } catch (Exception e) {
            logger.error("decodeMail decode error, content=" + content, e);
        }
        return null;
    }

    private static byte[] getBytes(String content) {
        StringBuilder sb = new StringBuilder(content);
        int i = content.length();
        while (i % 4 != 0) {
            sb.append('=');
            i++;
        }
        for (i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '-') {
                sb.setCharAt(i, '+');
            } else if (sb.charAt(i) == '_') {
                sb.setCharAt(i, '/');
            }
        }
        return Base64.decode(sb.toString());
    }

    private static String getString(byte[] encryptedBytes) {
        char[] base64Chars = Base64.encode(encryptedBytes);
        int i;
        for (i = 0; i < base64Chars.length; i++) {
            if (base64Chars[i] == '=') {
                break; // = only appear at end, so i is the ending
            } else if (base64Chars[i] == '+') {
                base64Chars[i] = '-';
            } else if (base64Chars[i] == '/') {
                base64Chars[i] = '_';
            }
        }
        return new String(base64Chars, 0, i);
    }

    public static void main(String[] args) {
        String mobileStr = encodeMobile("13916145186");
        System.out.println(mobileStr+" "+mobileStr.length());
        System.out.println(decodeMobile(mobileStr));

        String bankcodeStr = encodeBankCardCode("6228480402564890018");
        System.out.println(bankcodeStr+" "+bankcodeStr.length());
        System.out.println(decodeBankCardCode(bankcodeStr));

        String encodeIdentityCode = encodeIdentityCode("371523198705066994");
        System.out.println(encodeIdentityCode+" "+encodeIdentityCode.length());
        System.out.println(decodeIdentityCode(encodeIdentityCode));

        String encodeMailStr = encodeMail("460043237@qq.com");
        System.out.println(encodeMailStr+" "+encodeMailStr.length());
        System.out.println(decodeMail(encodeMailStr));
    }
}

package com.codersdesks.samples;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class PublicKeyFromModulesAndExponent {
   static String exp = "AQAB";
    static String mod = "hCMW-I-jp3_k7dIpEasiU4W_XpByZR8siOVGLLJsVMbQyNYADRJ66lFqB4ZaPSnduaK1Tf9gv3EA7vFeb-yFa5JJGYtDkwakApxnHPHZiBqUDetw83WYmiregbuDE4p9FLml9NXLGCZCNPaNhe0Jrt_OENnBm4_dpgIn0s7EXzmKzwIBWa5ICdz6egzvJFYCbeiAbxmI32DkI4P0OzB6PGLULg8Zl_pqreKpj3MR3OZVhyQzqFdZ1V0nGsso3qdnmJs8VDlpfEJT3QK1d-Qk8M4Rd3rWlGwtAlPDNe4Mmbf4lStYvCRjWwLjLoVWFIgKB3HONXataWGqEXxPxULN433lZddZZ8UgK3dZDwUsZoTeEHwmke550JZucr-yQOewI22ahtySaWOyDGJhmqucO5alZtqdZbPudeB3iJlLZVkstuKUgth9s4LgTKagXAJ7HxKqftN17eOdBLvzMO1f7OKZaH51VTAQsUs4CNmiP3Jh2OgQ2tFeZnz6LbuiJ0DMihI5LhQDMsfrgEuLr-594CftBSKs_xKHn-NHAOm0J9iOxazS30Uz76Yx2_5oVi6MlWZLwutRJh-06N1KZiMwuZhZjGivEn3CQPCpYTmFnxVfsuFfeBSi-BG1dhY4bPPZ_cbUz7GRmKlXkSEGIfVqfoFto_RsU-Cr8C55hq9V8jU";


    public static void main(String[] args) throws Exception {
        BigInteger b1 = new BigInteger(mod.getBytes());
        BigInteger b2 = new BigInteger(exp.getBytes());
        PublicKey key = getPublicKey(b1, b2);
        System.out.println(key);
        System.out.println(new String(Base64.getEncoder().encode(key.getEncoded())));
    }

    public static PublicKey getPublicKey(final BigInteger modulus, final BigInteger exponent) throws Exception {

        final KeyFactory factory = KeyFactory.getInstance("RSA");
        final PublicKey publicKey = factory.generatePublic(new RSAPublicKeySpec(modulus, exponent));
        return publicKey;
    }
}

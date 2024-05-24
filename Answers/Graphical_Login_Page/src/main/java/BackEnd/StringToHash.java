package BackEnd;

import org.apache.commons.codec.digest.DigestUtils;

public class StringToHash {
    // this method convert password to hash(SHA-256) :
    public String StringToHash(String string) {
        return DigestUtils.sha256Hex(string);
    }
}

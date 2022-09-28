package b101.percast.service;

public interface AdminService {
    void update(String password, String encryptedPassword);
    boolean checkByEncryptedP(String encryptedPassword);
    boolean checkByPass(String password);
}

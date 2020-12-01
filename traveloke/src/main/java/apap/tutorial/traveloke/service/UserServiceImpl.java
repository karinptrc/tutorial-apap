package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public void updatePass(String username, String[] pass) {
        UserModel user = userDb.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(pass[0], user.getPassword()) && pass[1].equals(pass[2]) && (!pass[0].equals(pass[1]))){
            user.setPassword(encrypt(pass[1]));
        }
        userDb.save(user);
    }

    @Override
    public boolean validate(String password) {
        boolean huruf = false;
        boolean angka = false;
        if (password.length() > 7){
            for (char c:password.toCharArray()) {
                if (Character.isAlphabetic(c)){
                    huruf = true;
                }
                else if (Character.isDigit(c)){
                    angka = true;
                }
            }
        }
        return (huruf && angka);
    }
}

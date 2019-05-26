package edu.nju.vivofinal.service;

public interface RegisterLoginService {

    String login(String identity, String account, String password);

    /**
     * check the uniqueness of this userMail,
     * then send verification code to this mail address!
     * @param userMail the user's mail address
     * @return verification code or wrong message
     */
    String sendMail(String userMail);

    /**
     * save this new user's info!
     * @param parentMail user mail
     * @param parentPassword user password
     * @return success or not
     */
    boolean parentRegister(String parentMail, String parentPassword);

    boolean teacherRegister(String teacherMail, String teacherPassword);
}

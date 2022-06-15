package com.kaishun.study.info;

import com.kaishun.study.validator.Password;
import com.kaishun.study.validator.Phone;

/**
 * ClassName:    ForgetInfo
 * Package:    com.kaishun.study.info
 * Description:
 * Datetime:    2020/4/16   9:13
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class ForgetInfo {

    @Phone
    private String forgetPhone;

    private String forgetVerificationCode;

    @Password
    private String newPassword;

    public String getForgetPhone() {
        return forgetPhone;
    }

    public void setForgetPhone(String forgetPhone) {
        this.forgetPhone = forgetPhone;
    }

    public String getForgetVerificationCode() {
        return forgetVerificationCode;
    }

    public void setForgetVerificationCode(String forgetVerificationCode) {
        this.forgetVerificationCode = forgetVerificationCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

package com.padc.yaepyaypar.events;

import com.padc.yaepyaypar.data.vos.UserVO;

/**
 * Created by mkt on 9/17/2016.
 */
public class UserEvent {

    public static class SuccessRegistrationEvent {
        private UserVO loginUser;

        public SuccessRegistrationEvent(UserVO loginUser) {
            this.loginUser = loginUser;
        }

        public UserVO getLoginUser() {
            return loginUser;
        }
    }

    public static class FailedRegistrationEvent {
        private String message;

        public FailedRegistrationEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class SuccessLoginEvent {
        private UserVO loginUser;

        public SuccessLoginEvent(UserVO loginUser) {
            this.loginUser = loginUser;
        }

        public UserVO getLoginUser() {
            return loginUser;
        }
    }

    public static class FailedLoginEvent {
        private String message;

        public FailedLoginEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class RefreshUserLoginStatusEvent {

    }
}

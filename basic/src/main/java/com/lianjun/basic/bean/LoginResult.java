package com.lianjun.basic.bean;

/**
 * Created by Administrator on 2016/10/12.
 */

public class LoginResult extends BaseBean {

    private ContentEntity content;

    public ContentEntity getContent() {
        return content;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public static class ContentEntity {
        private String userId;
        private EmpMpaEntity empMpa;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public EmpMpaEntity getEmpMpa() {
            return empMpa;
        }

        public void setEmpMpa(EmpMpaEntity empMpa) {
            this.empMpa = empMpa;
        }

        public static class EmpMpaEntity {
            private String position;
            private String e_STORE_CD;
            private String e_NAME;
            private String e_EMPLOYEE_ID;

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getE_STORE_CD() {
                return e_STORE_CD;
            }

            public void setE_STORE_CD(String e_STORE_CD) {
                this.e_STORE_CD = e_STORE_CD;
            }

            public String getE_NAME() {
                return e_NAME;
            }

            public void setE_NAME(String e_NAME) {
                this.e_NAME = e_NAME;
            }

            public String getE_EMPLOYEE_ID() {
                return e_EMPLOYEE_ID;
            }

            public void setE_EMPLOYEE_ID(String e_EMPLOYEE_ID) {
                this.e_EMPLOYEE_ID = e_EMPLOYEE_ID;
            }
        }
    }
}

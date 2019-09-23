package com.xy.t_net.bean;

import java.util.List;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-06 17:45
 * @Desc:
 */
public class Login {


    /**
     * code : 0
     * body : {"moduleResource":[],"roleIds":[1],"identityIds":[6],"apiResource":[],"departmentIds":[],"user":{"notes":"","phone":"17301025530","nickName":"李四","loginName":"17301025530","name":"李四","userPosition":"","id":1,"gmtCreate":"2019-01-12 14:55:49","headPic":"","jobNumber":"","email":""},"token":"customerae6317dadbe34f6b8071cfe153417eca"}
     * message : success
     */

    private int code;
    private BodyBean body;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        /**
         * moduleResource : []
         * roleIds : [1]
         * identityIds : [6]
         * apiResource : []
         * departmentIds : []
         * user : {"notes":"","phone":"17301025530","nickName":"李四","loginName":"17301025530","name":"李四","userPosition":"","id":1,"gmtCreate":"2019-01-12 14:55:49","headPic":"","jobNumber":"","email":""}
         * token : customerae6317dadbe34f6b8071cfe153417eca
         */

        private UserBean user;
        private String token;
        private List<?> moduleResource;
        private List<Integer> roleIds;
        private List<Integer> identityIds;
        private List<?> apiResource;
        private List<?> departmentIds;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<?> getModuleResource() {
            return moduleResource;
        }

        public void setModuleResource(List<?> moduleResource) {
            this.moduleResource = moduleResource;
        }

        public List<Integer> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Integer> roleIds) {
            this.roleIds = roleIds;
        }

        public List<Integer> getIdentityIds() {
            return identityIds;
        }

        public void setIdentityIds(List<Integer> identityIds) {
            this.identityIds = identityIds;
        }

        public List<?> getApiResource() {
            return apiResource;
        }

        public void setApiResource(List<?> apiResource) {
            this.apiResource = apiResource;
        }

        public List<?> getDepartmentIds() {
            return departmentIds;
        }

        public void setDepartmentIds(List<?> departmentIds) {
            this.departmentIds = departmentIds;
        }

        public static class UserBean {
            /**
             * notes :
             * phone : 17301025530
             * nickName : 李四
             * loginName : 17301025530
             * name : 李四
             * userPosition :
             * id : 1
             * gmtCreate : 2019-01-12 14:55:49
             * headPic :
             * jobNumber :
             * email :
             */

            private String notes;
            private String phone;
            private String nickName;
            private String loginName;
            private String name;
            private String userPosition;
            private int id;
            private String gmtCreate;
            private String headPic;
            private String jobNumber;
            private String email;

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUserPosition() {
                return userPosition;
            }

            public void setUserPosition(String userPosition) {
                this.userPosition = userPosition;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGmtCreate() {
                return gmtCreate;
            }

            public void setGmtCreate(String gmtCreate) {
                this.gmtCreate = gmtCreate;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getJobNumber() {
                return jobNumber;
            }

            public void setJobNumber(String jobNumber) {
                this.jobNumber = jobNumber;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}

package com.xy.t_net.bean;

public class MeMyInfo {


    /**
     * code : 0
     * body : {"phone":"17301025530","name":"李四","company":"保津高速公路","position":null}
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
         * phone : 17301025530
         * name : 李四
         * company : 保津高速公路
         * position : null
         */

        private String phone;
        private String name;
        private String company;
        private Object position;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }
    }
}

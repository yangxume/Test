package com.xy.t_net.bean;

import java.util.List;

public class SiteList {


    /**
     * code : 0
     * body : [{"depType":"1","children":[{"depType":"2","children":[{"depType":"4","id":".1.1.1","text":"1#1队"},{"depType":"3","id":".1.1.2","text":"#363站"},{"depType":"3","id":".1.1.3","text":"#33站"}],"id":".1.1","text":"1标段"},{"depType":"2","children":[{"depType":"3","id":".1.2.3","text":"3#1站"},{"depType":"3","id":".1.2.4","text":"sgd"}],"id":".1.2","text":"#3"}],"id":".1","text":"保津高速公路"},{"depType":"1","children":[{"depType":"2","children":[{"depType":"4","id":".7.2.1","text":"2#1队"},{"depType":"3","id":".7.2.2","text":"2#1站"}],"id":".7.2","text":"#2"},{"depType":"2","children":[{"depType":"3","id":".7.3.1","text":"1112"},{"depType":"3","id":".7.3.2","text":"221"}],"id":".7.3","text":"112"}],"id":".7","text":"阿斯顿高速公路"},{"depType":"1","children":[{"depType":"2","children":[{"depType":"4","id":".7.1.1","text":"施工队1"},{"depType":"4","id":".7.1.2","text":"施工队2"},{"depType":"4","id":".7.1.3","text":"施工队3"}],"id":".7.1","text":"标段1"}],"id":".7","text":"工程1"},{"depType":"1","children":[{"depType":"2","children":[],"id":".8.1","text":"标段2"}],"id":".8","text":"工程2"},{"depType":"1","children":[{"depType":"2","children":[],"id":".9.1","text":"标段3"}],"id":".9","text":"工程3"},{"depType":"1","children":[{"depType":"2","children":[],"id":".11.1","text":"#122"}],"id":".11","text":"测试12"},{"depType":"1","children":[],"id":".8.2","text":"怀仍项目"},{"depType":"1","children":[],"id":".1.5","text":"111"}]
     * message : success
     */

    private int code;
    private String message;
    private List<BodyBean> body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * depType : 1
         * children : [{"depType":"2","children":[{"depType":"4","id":".1.1.1","text":"1#1队"},{"depType":"3","id":".1.1.2","text":"#363站"},{"depType":"3","id":".1.1.3","text":"#33站"}],"id":".1.1","text":"1标段"},{"depType":"2","children":[{"depType":"3","id":".1.2.3","text":"3#1站"},{"depType":"3","id":".1.2.4","text":"sgd"}],"id":".1.2","text":"#3"}]
         * id : .1
         * text : 保津高速公路
         */

        private String depType;
        private String id;
        private String text;
        private List<ChildrenBeanX> children;

        public String getDepType() {
            return depType;
        }

        public void setDepType(String depType) {
            this.depType = depType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * depType : 2
             * children : [{"depType":"4","id":".1.1.1","text":"1#1队"},{"depType":"3","id":".1.1.2","text":"#363站"},{"depType":"3","id":".1.1.3","text":"#33站"}]
             * id : .1.1
             * text : 1标段
             */

            private String depType;
            private String id;
            private String text;
            private List<ChildrenBean> children;

            public String getDepType() {
                return depType;
            }

            public void setDepType(String depType) {
                this.depType = depType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * depType : 4
                 * id : .1.1.1
                 * text : 1#1队
                 */

                private String depType;
                private String id;
                private String text;

                public String getDepType() {
                    return depType;
                }

                public void setDepType(String depType) {
                    this.depType = depType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}

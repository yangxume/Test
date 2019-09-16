package com.xy.t_net.bean;

import java.util.List;

public class StatisticsHomeLeader {


    /**
     * code : 0
     * body : {"proectList":[{"bidSectionList":[{"bidSectionName":"1标段","siteRanking":4,"siteName":"#33站"},{"bidSectionName":"1标段","siteRanking":3,"siteName":"#33站"}],"projectName":"保津高速公路"}]}
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
        private List<ProectListBean> proectList;

        public List<ProectListBean> getProectList() {
            return proectList;
        }

        public void setProectList(List<ProectListBean> proectList) {
            this.proectList = proectList;
        }

        public static class ProectListBean {
            /**
             * bidSectionList : [{"bidSectionName":"1标段","siteRanking":4,"siteName":"#33站"},{"bidSectionName":"1标段","siteRanking":3,"siteName":"#33站"}]
             * projectName : 保津高速公路
             */

            private String projectName;
            private List<BidSectionListBean> bidSectionList;

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public List<BidSectionListBean> getBidSectionList() {
                return bidSectionList;
            }

            public void setBidSectionList(List<BidSectionListBean> bidSectionList) {
                this.bidSectionList = bidSectionList;
            }

            public static class BidSectionListBean {
                /**
                 * bidSectionName : 1标段
                 * siteRanking : 4
                 * siteName : #33站
                 */

                private String bidSectionName;
                private int siteRanking;
                private String siteName;

                public String getBidSectionName() {
                    return bidSectionName;
                }

                public void setBidSectionName(String bidSectionName) {
                    this.bidSectionName = bidSectionName;
                }

                public int getSiteRanking() {
                    return siteRanking;
                }

                public void setSiteRanking(int siteRanking) {
                    this.siteRanking = siteRanking;
                }

                public String getSiteName() {
                    return siteName;
                }

                public void setSiteName(String siteName) {
                    this.siteName = siteName;
                }
            }
        }
    }
}

package com.cdkj.loan.domain;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BodyGuardWZHYResponse implements Serializable {
    private static final long serialVersionUID = 4152462611121573434L;

    private Boolean success = false;

    private String id;

    private ResultDesc result_desc;

    private String reason_desc;

    private String nextService;

    private String reason_code;

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public String getReason_desc() {
        return reason_desc;
    }

    public void setReason_desc(String reason_desc) {
        this.reason_desc = reason_desc;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public ResultDesc getResult_desc() {
        return result_desc;
    }

    public void setResult_desc(ResultDesc result_desc) {
        this.result_desc = result_desc;
    }

    @Override
    public String toString() {
        if (success && StringUtils.isBlank(reason_code)) {
            return "BodyGuardApiResponse [success=" + success + ", id=" + id
                    + ", result_desc=" + result_desc + "]";
        } else {
            return "BodyGuardApiResponse [success=" + success
                    + ", reason_code=" + reason_code + ", reason_desc="
                    + reason_desc + "]";
        }
    }

    public class ResultDesc {
        private AnalysisInfo INFOANALYSIS;

        private Antifraud ANTIFRAUD;

        public AnalysisInfo getINFOANALYSIS() {
            return INFOANALYSIS;
        }

        public void setINFOANALYSIS(AnalysisInfo iNFOANALYSIS) {
            INFOANALYSIS = iNFOANALYSIS;
        }

        public Antifraud getANTIFRAUD() {
            return ANTIFRAUD;
        }

        public void setANTIFRAUD(Antifraud aNTIFRAUD) {
            ANTIFRAUD = aNTIFRAUD;
        }

        public class AnalysisInfo {
            private String id_age;

            private AddressDetect address_detect;

            private GeoipInfo geoip_info;

            private DeviceInfo device_info;

            private GeotrueipInfo geotrueip_info;

            private String id_gender;

            public String getId_age() {
                return id_age;
            }

            public void setId_age(String id_age) {
                this.id_age = id_age;
            }

            public AddressDetect getAddress_detect() {
                return address_detect;
            }

            public void setAddress_detect(AddressDetect address_detect) {
                this.address_detect = address_detect;
            }

            public GeoipInfo getGeoip_info() {
                return geoip_info;
            }

            public void setGeoip_info(GeoipInfo geoip_info) {
                this.geoip_info = geoip_info;
            }

            public DeviceInfo getDevice_info() {
                return device_info;
            }

            public void setDevice_info(DeviceInfo device_info) {
                this.device_info = device_info;
            }

            public GeotrueipInfo getGeotrueip_info() {
                return geotrueip_info;
            }

            public void setGeotrueip_info(GeotrueipInfo geotrueip_info) {
                this.geotrueip_info = geotrueip_info;
            }

            public String getId_gender() {
                return id_gender;
            }

            public void setId_gender(String id_gender) {
                this.id_gender = id_gender;
            }

            public class AddressDetect {
                private String bank_card_address;

                private String true_ip_address;

                private String mobile_address_city;

                private String id_card_city;

                private String mobile_address;

                private String wifi_address;

                private String id_card_province;

                private String cell_address;

                private String mobile_address_province;

                private String id_card_address;

                public String getBank_card_address() {
                    return bank_card_address;
                }

                public void setBank_card_address(String bank_card_address) {
                    this.bank_card_address = bank_card_address;
                }

                public String getTrue_ip_address() {
                    return true_ip_address;
                }

                public void setTrue_ip_address(String true_ip_address) {
                    this.true_ip_address = true_ip_address;
                }

                public String getMobile_address_city() {
                    return mobile_address_city;
                }

                public void setMobile_address_city(String mobile_address_city) {
                    this.mobile_address_city = mobile_address_city;
                }

                public String getId_card_city() {
                    return id_card_city;
                }

                public void setId_card_city(String id_card_city) {
                    this.id_card_city = id_card_city;
                }

                public String getMobile_address() {
                    return mobile_address;
                }

                public void setMobile_address(String mobile_address) {
                    this.mobile_address = mobile_address;
                }

                public String getWifi_address() {
                    return wifi_address;
                }

                public void setWifi_address(String wifi_address) {
                    this.wifi_address = wifi_address;
                }

                public String getId_card_province() {
                    return id_card_province;
                }

                public void setId_card_province(String id_card_province) {
                    this.id_card_province = id_card_province;
                }

                public String getCell_address() {
                    return cell_address;
                }

                public void setCell_address(String cell_address) {
                    this.cell_address = cell_address;
                }

                public String getMobile_address_province() {
                    return mobile_address_province;
                }

                public void setMobile_address_province(
                        String mobile_address_province) {
                    this.mobile_address_province = mobile_address_province;
                }

                public String getId_card_address() {
                    return id_card_address;
                }

                public void setId_card_address(String id_card_address) {
                    this.id_card_address = id_card_address;
                }
            }

            public class GeoipInfo {
                private String proxy_info;

                private String isp;

                private String latitude;

                private String position;

                private String longitude;

                public String getProxy_info() {
                    return proxy_info;
                }

                public void setProxy_info(String proxy_info) {
                    this.proxy_info = proxy_info;
                }

                public String getIsp() {
                    return isp;
                }

                public void setIsp(String isp) {
                    this.isp = isp;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }

            public class DeviceInfo {
                private String error;

                public String getError() {
                    return error;
                }

                public void setError(String error) {
                    this.error = error;
                }
            }

            public class GeotrueipInfo {
                private String isp;

                private String latitude;

                private String position;

                private String longitude;

                public String getIsp() {
                    return isp;
                }

                public void setIsp(String isp) {
                    this.isp = isp;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }
        }

        public class Antifraud {
            private String final_score;

            private List<RiskItems> risk_items;

            private String final_decision;

            public String getFinal_score() {
                return final_score;
            }

            public void setFinal_score(String final_score) {
                this.final_score = final_score;
            }

            public List<RiskItems> getRisk_items() {
                return risk_items;
            }

            public void setRisk_items(List<RiskItems> risk_items) {
                this.risk_items = risk_items;
            }

            public String getFinal_decision() {
                return final_decision;
            }

            public void setFinal_decision(String final_decision) {
                this.final_decision = final_decision;
            }

            public class RiskItems {
                private String rule_id;

                private String policy_score;

                private String score;

                private String policy_mode;

                private String decision;

                private String policy_decision;

                private String policy_name;

                private String risk_name;

                private List<String> risk_detail;

                public String getRule_id() {
                    return rule_id;
                }

                public void setRule_id(String rule_id) {
                    this.rule_id = rule_id;
                }

                public String getPolicy_score() {
                    return policy_score;
                }

                public void setPolicy_score(String policy_score) {
                    this.policy_score = policy_score;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getPolicy_mode() {
                    return policy_mode;
                }

                public void setPolicy_mode(String policy_mode) {
                    this.policy_mode = policy_mode;
                }

                public String getDecision() {
                    return decision;
                }

                public void setDecision(String decision) {
                    this.decision = decision;
                }

                public String getPolicy_decision() {
                    return policy_decision;
                }

                public void setPolicy_decision(String policy_decision) {
                    this.policy_decision = policy_decision;
                }

                public String getPolicy_name() {
                    return policy_name;
                }

                public void setPolicy_name(String policy_name) {
                    this.policy_name = policy_name;
                }

                public String getRisk_name() {
                    return risk_name;
                }

                public void setRisk_name(String risk_name) {
                    this.risk_name = risk_name;
                }

                public List<String> getRisk_detail() {
                    return risk_detail;
                }

                public void setRisk_detail(List<String> risk_detail) {
                    this.risk_detail = risk_detail;
                }

                public class RiskDetail {
                    private List<FrequencyDetailList> frequency_detail_list;

                    private String type;

                    public List<FrequencyDetailList> getFrequency_detail_list() {
                        return frequency_detail_list;
                    }

                    public void setFrequency_detail_list(
                            List<FrequencyDetailList> frequency_detail_list) {
                        this.frequency_detail_list = frequency_detail_list;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public class FrequencyDetailList {
                        private String detail;

                        public String getDetail() {
                            return detail;
                        }

                        public void setDetail(String detail) {
                            this.detail = detail;
                        }
                    }
                }
            }
        }
    }

}

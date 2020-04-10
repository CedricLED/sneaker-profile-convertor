package com.example.profileconverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.regex.Pattern;

class profileSterilizer {

    public enum CardType {

        UNKNOWN,
        Visa("^4[0-9]{12}(?:[0-9]{3}){0,2}$"),
        MasterCard("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$"),
        AmericanExpress("^3[47][0-9]{13}$"),
        DINERS_CLUB("^3(?:0[0-5]\\d|095|6\\d{0,2}|[89]\\d{2})\\d{12,15}$"),
        Discover("^6(?:011|[45][0-9]{2})[0-9]{12}$"),
        JCB("^(?:2131|1800|35\\d{3})\\d{11}$"),
        CHINA_UNION_PAY("^62[0-9]{14,17}$");

        private Pattern pattern;

        CardType() {
            this.pattern = null;
        }

        CardType(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        public static CardType detect(String cardNumber) {

            for (CardType cardType : CardType.values()) {
                if (null == cardType.pattern) continue;
                if (cardType.pattern.matcher(cardNumber).matches()) return cardType;
            }

            return UNKNOWN;
        }

    }

    @SuppressWarnings("unchecked")
    static JSONArray universalProfileSterilizer(JSONArray array) {

        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.get("profile_name"));
            universalProfile.put("email", profile.get("email"));
            universalProfile.put("phone", profile.get("phone").toString().replaceAll("[^0-9]", ""));
            universalProfile.put("cc_number", profile.get("cc_number").toString().replaceAll("[^0-9]", ""));
            universalProfile.put("cc_name", profile.get("cc_name"));
            if (profile.get("cc_exp_month").toString().length() == 1) {
                universalProfile.put("cc_exp_month", "0" + profile.get("cc_exp_month"));
            } else {
                universalProfile.put("cc_exp_month", profile.get("cc_exp_month"));
            }
            if (profile.get("cc_exp_year").toString().length() == 4) {
                universalProfile.put("cc_exp_year", profile.get("cc_exp_year").toString().substring(2));
            } else {
                universalProfile.put("cc_exp_year", profile.get("cc_exp_year"));
            }
            universalProfile.put("cc_cvv", profile.get("cc_cvv"));
            universalProfile.put("cc_type", CardType.detect(profile.get("cc_number").toString().replaceAll("[^0-9]", "")));
            if (profile.get("billing_last_name").toString().isEmpty()) {
                String fullName = profile.get("billing_first_name").toString();
                int idx = fullName.lastIndexOf(' ');
                if (idx == -1) {
                    return new JSONArray();
                } else {
                    universalProfile.put("billing_first_name", fullName.substring(0, idx));
                    universalProfile.put("billing_last_name", fullName.substring(idx + 1));
                }
            } else {
                universalProfile.put("billing_first_name", profile.get("billing_first_name"));
                universalProfile.put("billing_last_name", profile.get("billing_last_name"));
            }
            universalProfile.put("billing_addr1", profile.get("billing_addr1"));
            universalProfile.put("billing_addr2", profile.get("billing_addr2"));
            universalProfile.put("billing_zip", profile.get("billing_zip"));
            universalProfile.put("billing_city", profile.get("billing_city"));
            universalProfile.put("billing_state", locationAbbrevConverter.stateToAbbrev(profile.get("billing_state").toString()));
            universalProfile.put("billing_country", locationAbbrevConverter.countryToAbbrev(profile.get("billing_country").toString()));
            universalProfile.put("billing_phone", profile.get("billing_phone").toString().replaceAll("[^0-9]", ""));
            universalProfile.put("billing_apt", profile.get("billing_apt"));
            universalProfile.put("one_checkout", Boolean.parseBoolean(profile.getOrDefault("one_checkout", false).toString()));
            if (profile.get("shipping_first_name").toString().isEmpty()) {
                universalProfile.put("shipping_first_name", universalProfile.get("billing_first_name"));
                universalProfile.put("shipping_last_name", universalProfile.get("billing_last_name"));
                universalProfile.put("shipping_addr1", universalProfile.get("billing_addr1"));
                universalProfile.put("shipping_addr2", universalProfile.get("billing_addr2"));
                universalProfile.put("shipping_zip", universalProfile.get("billing_zip"));
                universalProfile.put("shipping_city", universalProfile.get("billing_city"));
                universalProfile.put("shipping_state", locationAbbrevConverter.stateToAbbrev(universalProfile.get("billing_state").toString()));
                universalProfile.put("shipping_country", locationAbbrevConverter.countryToAbbrev(universalProfile.get("billing_country").toString()));
                universalProfile.put("shipping_phone", universalProfile.get("billing_phone").toString().replaceAll("[^0-9]", ""));
                universalProfile.put("shipping_apt", universalProfile.get("billing_apt"));
            } else {
                universalProfile.put("shipping_first_name", profile.get("shipping_first_name"));
                universalProfile.put("shipping_last_name", profile.get("shipping_last_name"));
                universalProfile.put("shipping_addr1", profile.get("shipping_addr1"));
                universalProfile.put("shipping_addr2", profile.get("shipping_addr2"));
                universalProfile.put("shipping_zip", profile.get("shipping_zip"));
                universalProfile.put("shipping_city", profile.get("shipping_city"));
                universalProfile.put("shipping_state", locationAbbrevConverter.stateToAbbrev(profile.get("shipping_state").toString()));
                universalProfile.put("shipping_country", locationAbbrevConverter.countryToAbbrev(profile.get("shipping_country").toString()));
                universalProfile.put("shipping_phone", profile.get("shipping_phone").toString().replaceAll("[^0-9]", ""));
                universalProfile.put("shipping_apt", profile.get("shipping_apt"));
            }
            universalArray.add(universalProfile);
        }
        return universalArray;
    }
}

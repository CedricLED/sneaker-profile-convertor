package com.example.profileconverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;


class profileImports {
    private static final String DEFAULTPROFILENAME = "toolstify profile";
    private static final String DEFAULTEMAIL = "default@email.com";
    private static final String DEFAULTPHONE = "5551234567";
    private static final String DEFAULTCCNUMBER = "1234123412341234";
    private static final String DEFAULTCCTYPE = "visa";
    private static final String DEFAULTCCNAME = "John Smith";
    private static final String DEFAULTEXPMONTH = "01";
    private static final String DEFAULTEXPYEAR = "2000";
    private static final String DEFAULTCVV = "111";
    private static final String DEFAULTBILLINGADDR1 = "420 Default Street";
    private static final String DEFAULTBILLINGZIP = "55555";
    private static final String DEFAULTBILLINGCITY = "New York";
    private static final String DEFAULTBILLINGSTATE = "NY";
    private static final String DEFAULTBILLINGCOUNTRY = "US";


    @SuppressWarnings("unchecked")
    static JSONArray hasteyImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.getOrDefault("profilename", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("tel", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("cc_number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", profile.getOrDefault("cc_month", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("cc_year", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("cc_cvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("cardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", "");
            universalProfile.put("billing_addr1", profile.getOrDefault("address", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("address_2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("tel", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", "");
            universalProfile.put("shipping_last_name", "");
            universalProfile.put("shipping_addr1", "");
            universalProfile.put("shipping_addr2", "");
            universalProfile.put("shipping_zip", "");
            universalProfile.put("shipping_city", "");
            universalProfile.put("shipping_state", "");
            universalProfile.put("shipping_country", "");
            universalProfile.put("shipping_phone", "");
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray tripImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.getOrDefault("profile", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("creditcardnumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", profile.getOrDefault("expirymonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("expiryyear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("cvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("cardtype", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", "");
            universalProfile.put("billing_addr1", profile.getOrDefault("address", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", "");
            universalProfile.put("billing_zip", profile.getOrDefault("zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", profile.getOrDefault("apt", ""));
            universalProfile.put("shipping_first_name", "");
            universalProfile.put("shipping_last_name", "");
            universalProfile.put("shipping_addr1", "");
            universalProfile.put("shipping_addr2", "");
            universalProfile.put("shipping_zip", "");
            universalProfile.put("shipping_city", "");
            universalProfile.put("shipping_state", "");
            universalProfile.put("shipping_country", "");
            universalProfile.put("shipping_phone", "");
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray phantomImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            JSONObject billing = (JSONObject) profile.get("Billing");
            JSONObject shipping = (JSONObject) profile.get("Shipping");
            universalProfile.put("profile_name", profile.getOrDefault("Name", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("Email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CCNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", billing.get("FirstName") + " " + billing.get("LastName"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("ExpMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("ExpYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("CVV", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("FirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("LastName", ""));
            universalProfile.put("billing_addr1", billing.getOrDefault("Address", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", "");
            universalProfile.put("billing_zip", billing.getOrDefault("Zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("City", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("State", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("Country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("Apt", ""));
            universalProfile.put("shipping_first_name", shipping.getOrDefault("FirstName", ""));
            universalProfile.put("shipping_last_name", shipping.getOrDefault("LastName", ""));
            universalProfile.put("shipping_addr1", shipping.getOrDefault("Address", ""));
            universalProfile.put("shipping_addr2", "");
            universalProfile.put("shipping_zip", shipping.getOrDefault("Zip", ""));
            universalProfile.put("shipping_city", shipping.getOrDefault("City", ""));
            universalProfile.put("shipping_state", shipping.getOrDefault("State", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("Country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("shipping_phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("shipping_apt", shipping.getOrDefault("Apt", ""));
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray ghostImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            JSONObject shipping = (JSONObject) profile.get("Shipping");
            JSONObject billing = (JSONObject) profile.get("Billing");
            universalProfile.put("profile_name", profile.getOrDefault("Name", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("Email", ""));
            universalProfile.put("phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CCNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", billing.get("FirstName") + " " + billing.get("LastName"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("ExpMonth", DEFAULTCCNAME));
            universalProfile.put("cc_exp_year", profile.getOrDefault("ExpYear", DEFAULTCCNAME));
            universalProfile.put("cc_cvv", profile.getOrDefault("CVV", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("FirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("LastName", DEFAULTCCNAME));
            universalProfile.put("billing_addr1", billing.getOrDefault("Address", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", billing.getOrDefault("Address2", ""));
            universalProfile.put("billing_zip", billing.getOrDefault("Zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("City", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("State", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("Country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("Apt", ""));
            universalProfile.put("shipping_first_name", shipping.getOrDefault("FirstName", ""));
            universalProfile.put("shipping_last_name", shipping.getOrDefault("LastName", ""));
            universalProfile.put("shipping_addr1", shipping.getOrDefault("Address", ""));
            universalProfile.put("shipping_addr2", shipping.getOrDefault("Address2", ""));
            universalProfile.put("shipping_zip", shipping.getOrDefault("Zip", ""));
            universalProfile.put("shipping_city", shipping.getOrDefault("City", ""));
            universalProfile.put("shipping_state", shipping.getOrDefault("State", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("Country", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("Phone", ""));
            universalProfile.put("shipping_apt", shipping.getOrDefault("Apt", ""));
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray pdImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            JSONObject shipping = (JSONObject) profile.get("shipping");
            JSONObject billing = (JSONObject) profile.get("billing");
            JSONObject card = (JSONObject) profile.get("card");
            String exp = card.getOrDefault("expire", DEFAULTEXPMONTH).toString().replaceAll("[^0-9]", "");
            String expMonth = exp.substring(0, 2);
            String expYear = exp.substring(2);
            universalProfile.put("profile_name", profile.getOrDefault("title", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", shipping.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("cc_number", card.getOrDefault("number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", card.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", expMonth);
            universalProfile.put("cc_exp_year", expYear);
            universalProfile.put("cc_cvv", card.getOrDefault("code", DEFAULTCVV));
            universalProfile.put("cc_type", card.getOrDefault("type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("firstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("lastName", DEFAULTCCNAME));
            universalProfile.put("billing_addr1", billing.getOrDefault("address1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", billing.getOrDefault("address2", ""));
            universalProfile.put("billing_zip", billing.getOrDefault("zipcode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", billing.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", billing.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("apt", ""));
            universalProfile.put("shipping_first_name", shipping.getOrDefault("firstName", ""));
            universalProfile.put("shipping_last_name", shipping.getOrDefault("lastName", ""));
            universalProfile.put("shipping_addr1", shipping.getOrDefault("address1", ""));
            universalProfile.put("shipping_addr2", shipping.getOrDefault("address2", ""));
            universalProfile.put("shipping_zip", shipping.getOrDefault("zipcode", ""));
            universalProfile.put("shipping_city", shipping.getOrDefault("city", ""));
            universalProfile.put("shipping_state", shipping.getOrDefault("state", ""));
            universalProfile.put("shipping_country", shipping.getOrDefault("country", ""));
            universalProfile.put("shipping_phone", shipping.getOrDefault("phone", ""));
            universalProfile.put("shipping_apt", shipping.getOrDefault("apt", ""));
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray nikeShoeBotImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            JSONObject shipping = (JSONObject) profile.get("shipping");
            JSONObject billing = (JSONObject) profile.get("billing");
            JSONObject card = (JSONObject) profile.get("cc");
            String exp = (String) card.getOrDefault("expiry", DEFAULTEXPMONTH);
            String expMonth = exp.substring(0, 2);
            String expYear = exp.substring(5);
            universalProfile.put("profile_name", profile.getOrDefault("name", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", shipping.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("cc_number", card.getOrDefault("number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", card.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", expMonth);
            universalProfile.put("cc_exp_year", expYear);
            universalProfile.put("cc_cvv", card.getOrDefault("cvc", DEFAULTCVV));
            universalProfile.put("cc_type", card.getOrDefault("type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("firstname", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("lastname", DEFAULTCCNAME));
            universalProfile.put("billing_addr1", billing.getOrDefault("address", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", billing.getOrDefault("address2", ""));
            universalProfile.put("billing_zip", billing.getOrDefault("zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", billing.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", billing.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("apt", ""));
            universalProfile.put("shipping_first_name", shipping.getOrDefault("firstname", ""));
            universalProfile.put("shipping_last_name", shipping.getOrDefault("lastname", ""));
            universalProfile.put("shipping_addr1", shipping.getOrDefault("address", ""));
            universalProfile.put("shipping_addr2", shipping.getOrDefault("address2", ""));
            universalProfile.put("shipping_zip", shipping.getOrDefault("zip", ""));
            universalProfile.put("shipping_city", shipping.getOrDefault("city", ""));
            universalProfile.put("shipping_state", shipping.getOrDefault("state", ""));
            universalProfile.put("shipping_country", shipping.getOrDefault("country", ""));
            universalProfile.put("shipping_phone", shipping.getOrDefault("phone", ""));
            universalProfile.put("shipping_apt", shipping.getOrDefault("apt", ""));
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray supremeSlayerImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            JSONObject billing = (JSONObject) profile.get("billing");
            JSONObject card = (JSONObject) profile.get("card");
            universalProfile.put("profile_name", profile.getOrDefault("name", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", billing.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("cc_number", card.getOrDefault("number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", billing.get("first") + " " + billing.get("last"));
            universalProfile.put("cc_exp_month", card.getOrDefault("month", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", card.getOrDefault("year", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", card.getOrDefault("code", DEFAULTCVV));
            universalProfile.put("cc_type", card.getOrDefault("type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("first", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("last", ""));
            universalProfile.put("billing_addr1", billing.getOrDefault("address1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", billing.getOrDefault("address2", ""));
            universalProfile.put("billing_zip", billing.getOrDefault("postcode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("region", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", billing.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", billing.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("apt", ""));
            universalProfile.put("shipping_first_name", "");
            universalProfile.put("shipping_last_name", "");
            universalProfile.put("shipping_addr1", "");
            universalProfile.put("shipping_addr2", "");
            universalProfile.put("shipping_zip", "");
            universalProfile.put("shipping_city", "");
            universalProfile.put("shipping_state", "");
            universalProfile.put("shipping_country", "");
            universalProfile.put("shipping_phone", "");
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray cyberImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();

        JSONObject profiles = (JSONObject) array.get(0);
        profiles = (JSONObject) profiles.getOrDefault("profiles", profiles);
        profiles.forEach((k, v) -> {
            JSONObject universalProfile = new JSONObject();
            JSONObject profile = (JSONObject) v;
            universalProfile.put("profile_name", profile.get("name"));
            JSONObject billing = (JSONObject) profile.get("billing");
            JSONObject payment = (JSONObject) profile.get("payment");
            JSONObject card = (JSONObject) payment.get("card");
            JSONObject shipping = (JSONObject) profile.get("delivery");
            universalProfile.put("email", payment.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", payment.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("cc_number", card.getOrDefault("number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", card.getOrDefault("name", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", card.getOrDefault("exp_month", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", card.getOrDefault("exp_year", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", card.getOrDefault("cvv", DEFAULTCVV));
            universalProfile.put("cc_type", card.getOrDefault("type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", billing.getOrDefault("first_name", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", billing.getOrDefault("last_name", ""));
            universalProfile.put("billing_addr1", billing.getOrDefault("addr1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", billing.getOrDefault("addr2", ""));
            universalProfile.put("billing_zip", billing.getOrDefault("zip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", billing.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", billing.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", billing.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", payment.getOrDefault("phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", billing.getOrDefault("apt", ""));
            universalProfile.put("shipping_first_name", shipping.getOrDefault("first_name", ""));
            universalProfile.put("shipping_last_name", shipping.getOrDefault("last_name", ""));
            universalProfile.put("shipping_addr1", shipping.getOrDefault("addr1", ""));
            universalProfile.put("shipping_addr2", shipping.getOrDefault("addr2", ""));
            universalProfile.put("shipping_zip", shipping.getOrDefault("zip", ""));
            universalProfile.put("shipping_city", shipping.getOrDefault("city", ""));
            universalProfile.put("shipping_state", shipping.getOrDefault("state", ""));
            universalProfile.put("shipping_country", shipping.getOrDefault("country", ""));
            universalProfile.put("shipping_phone", payment.getOrDefault("phone", ""));
            universalProfile.put("shipping_apt", shipping.getOrDefault("apt", ""));
            universalArray.add(universalProfile);
        });
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray candyPremeImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();

        JSONObject profiles = (JSONObject) array.get(0);
        for (Iterator iterator = profiles.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            JSONObject profile = (JSONObject) profiles.get(key);
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", key);
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("phoneNumber", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("billingCardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.getOrDefault("billingName", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", profile.getOrDefault("billingExpMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("billingExpYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("billingCVV", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("billingCardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("fullName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("last", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("addressLine1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("addressLine2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("zipCode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("city", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("state", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("phoneNumber", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", "");
            universalProfile.put("shipping_last_name", "");
            universalProfile.put("shipping_addr1", "");
            universalProfile.put("shipping_addr2", "");
            universalProfile.put("shipping_zip", "");
            universalProfile.put("shipping_city", "");
            universalProfile.put("shipping_state", "");
            universalProfile.put("shipping_country", "");
            universalProfile.put("shipping_phone", "");
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray dasheImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();

        JSONObject profiles = (JSONObject) array.get(0);
        for (Iterator iterator = profiles.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            JSONObject profile = (JSONObject) profiles.get(key);
            JSONObject universalProfile = new JSONObject();
            String exp = profile.getOrDefault("cardExpiry", DEFAULTEXPMONTH).toString().replaceAll("[^0-9]", "");
            String expMonth = exp.substring(0, 2);
            String expYear = exp.substring(2);
            universalProfile.put("profile_name", key);
            universalProfile.put("email", profile.getOrDefault("email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("billingPhone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("cardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.getOrDefault("cardName", DEFAULTCCNAME));
            universalProfile.put("cc_exp_month", profile.getOrDefault(expMonth, DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault(expYear, DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("cardCvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("billingFirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("billingLastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("billingAddress", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("address_2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("billingZipCode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("billingCity", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("billingState", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("billingCountry", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("billingPhone", DEFAULTPHONE));
            universalProfile.put("billing_apt", profile.getOrDefault("billingApt", ""));
            universalProfile.put("shipping_first_name", profile.getOrDefault("firstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("lastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("address", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("address_2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("zipCode", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("city", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("state", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("country", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("phone", ""));
            universalProfile.put("shipping_apt", profile.getOrDefault("apt", ""));
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray masterCSVImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.getOrDefault("Profile_Name", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("Email", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("Phone", DEFAULTPHONE));
            universalProfile.put("one_checkout", profile.getOrDefault("One_Checkout", false));
            universalProfile.put("cc_number", profile.getOrDefault("Card_Number", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.getOrDefault("Billing_FirstName", "").toString() + " " + profile.getOrDefault("Billing_LastName", "").toString());
            universalProfile.put("cc_exp_month", profile.getOrDefault("Expire_Month", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("Expire_Year", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("Card_CVV", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("Card_Type", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("Billing_FirstName", ""));
            universalProfile.put("billing_last_name", profile.getOrDefault("Billing_LastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("Billing_Address1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("Billing_Address2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("Billing_Zipcode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("Billing_City", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("Billing_State", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("Billing_Country", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("Billing_Phone", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", profile.getOrDefault("Shipping_FirstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("Shipping_LastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("Shipping_Address1", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("Shipping_Address2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("Shipping_Zipcode", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("Shipping_City", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("Shipping_State", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("Shipping_Country", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("Shipping_Phone", ""));
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray bnbNikeImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.getOrDefault("Name", DEFAULTPROFILENAME));
            universalProfile.put("email", "");
            universalProfile.put("phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CreditCardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.get("BillingFirstName") + " " + profile.get("BillingLastName"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("CreditCardExpiryMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("CreditCardExpiryYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("CreditCardCvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CreditCardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("BillingFirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("BillingLastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("BillingAddress1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("BillingAddress2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("BillingZipCode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("BillingCity", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("BillingState", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", "US");
            universalProfile.put("billing_phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", profile.getOrDefault("ShippingFirstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("ShippingLastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("ShippingAddress1", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("ShippingAddress2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("ShippingZipCode", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("ShippingCity", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("ShippingState", ""));
            universalProfile.put("shipping_country", "US");
            universalProfile.put("shipping_phone", profile.getOrDefault("ShippingPhone", ""));
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray bnbAIOImport(JSONArray array) {
        JSONArray universalArray = new JSONArray();
        for (Object o : array) {
            JSONObject profile = (JSONObject) o;
            JSONObject universalProfile = new JSONObject();
            universalProfile.put("profile_name", profile.getOrDefault("Name", DEFAULTPROFILENAME));
            universalProfile.put("email", "");
            universalProfile.put("phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CreditCardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.get("BillingFirstName") + " " + profile.get("BillingLastName"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("CreditCardExpiryMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("CreditCardExpiryYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("CreditCardCvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CreditCardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("BillingFirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("BillingLastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("BillingAddress1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("BillingAddress2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("BillingZipCode", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("BillingCity", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("BillingState", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("BillingCountry", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", profile.getOrDefault("ShippingFirstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("ShippingLastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("ShippingAddress1", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("ShippingAddress2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("ShippingZipCode", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("ShippingCity", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("ShippingState", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("ShippingCountry", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("ShippingPhone", ""));
            universalProfile.put("shipping_apt", "");
            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    //TODO anb with shipping/billing
    static JSONArray anbImport(JSONObject anbProfile) {
        JSONArray universalArray = new JSONArray();
        JSONArray a = new JSONArray();
        anbProfile = (JSONObject) anbProfile.get(anbProfile.keySet().stream().findFirst().orElse(null));
        if (anbProfile.get("Profile") instanceof JSONObject) {
            anbProfile = (JSONObject) anbProfile.get("Profile");
            a.add(anbProfile);
        } else {
            a = (JSONArray) anbProfile.get("Profile");
        }
        for (Object u : a) {
            JSONObject universalProfile = new JSONObject();
            JSONObject profile = (JSONObject) u;
            universalProfile.put("profile_name", profile.getOrDefault("ProfileName", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("BillingEmail", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CreditCardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.get("NameOnCard"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("ExpirationMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("ExpirationYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("Cvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("BillingFirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("BillingLastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("BillingAddressLine1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("BillingAddressLine2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("BillingZip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("BillingCity", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("BillingState", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("BillingCountryCode", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", profile.getOrDefault("ShippingFirstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("ShippingLastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("ShippingAddress1", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("ShippingAddress2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("ShippingZip", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("ShippingCity", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("ShippingState", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("ShippingCountryCode", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("ShippingPhone", ""));
            universalProfile.put("shipping_apt", "");

            universalArray.add(universalProfile);
        }
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray eveImport(JSONObject eveProfile) {
        JSONArray universalArray = new JSONArray();
        JSONArray a = new JSONArray();
        eveProfile = (JSONObject) eveProfile.get(eveProfile.keySet().stream().findFirst().orElse(null));
        if (eveProfile.get("Profile") instanceof JSONObject) {
            eveProfile = (JSONObject) eveProfile.get("Profile");
            a.add(eveProfile);
        } else {
            a = (JSONArray) eveProfile.get("Profile");
        }
        for (Object u : a) {
            JSONObject universalProfile = new JSONObject();
            JSONObject profile = (JSONObject) u;
            universalProfile.put("profile_name", profile.getOrDefault("ProfileName", DEFAULTPROFILENAME));
            universalProfile.put("email", profile.getOrDefault("BillingEmail", DEFAULTEMAIL));
            universalProfile.put("phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("cc_number", profile.getOrDefault("CreditCardNumber", DEFAULTCCNUMBER));
            universalProfile.put("cc_name", profile.get("NameOnCard"));
            universalProfile.put("cc_exp_month", profile.getOrDefault("ExpirationMonth", DEFAULTEXPMONTH));
            universalProfile.put("cc_exp_year", profile.getOrDefault("ExpirationYear", DEFAULTEXPYEAR));
            universalProfile.put("cc_cvv", profile.getOrDefault("Cvv", DEFAULTCVV));
            universalProfile.put("cc_type", profile.getOrDefault("CardType", DEFAULTCCTYPE));
            universalProfile.put("billing_first_name", profile.getOrDefault("BillingFirstName", DEFAULTCCNAME));
            universalProfile.put("billing_last_name", profile.getOrDefault("BillingLastName", ""));
            universalProfile.put("billing_addr1", profile.getOrDefault("BillingAddressLine1", DEFAULTBILLINGADDR1));
            universalProfile.put("billing_addr2", profile.getOrDefault("BillingAddressLine2", ""));
            universalProfile.put("billing_zip", profile.getOrDefault("BillingZip", DEFAULTBILLINGZIP));
            universalProfile.put("billing_city", profile.getOrDefault("BillingCity", DEFAULTBILLINGCITY));
            universalProfile.put("billing_state", profile.getOrDefault("BillingState", DEFAULTBILLINGSTATE));
            universalProfile.put("billing_country", profile.getOrDefault("BillingCountryCode", DEFAULTBILLINGCOUNTRY));
            universalProfile.put("billing_phone", profile.getOrDefault("BillingPhone", DEFAULTPHONE));
            universalProfile.put("billing_apt", "");
            universalProfile.put("shipping_first_name", profile.getOrDefault("ShippingFirstName", ""));
            universalProfile.put("shipping_last_name", profile.getOrDefault("ShippingLastName", ""));
            universalProfile.put("shipping_addr1", profile.getOrDefault("ShippingAddress1", ""));
            universalProfile.put("shipping_addr2", profile.getOrDefault("ShippingAddress2", ""));
            universalProfile.put("shipping_zip", profile.getOrDefault("ShippingZip", ""));
            universalProfile.put("shipping_city", profile.getOrDefault("ShippingCity", ""));
            universalProfile.put("shipping_state", profile.getOrDefault("ShippingState", ""));
            universalProfile.put("shipping_country", profile.getOrDefault("ShippingCountryCode", ""));
            universalProfile.put("shipping_phone", profile.getOrDefault("ShippingPhone", ""));
            universalProfile.put("shipping_apt", "");

            universalArray.add(universalProfile);
        }
        return (universalArray);
    }
}

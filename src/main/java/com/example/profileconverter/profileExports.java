package com.example.profileconverter;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

class profileExports {
    @SuppressWarnings("unchecked")
    static JSONArray hasteyExport(JSONArray universalArray) {
        JSONArray hasteyArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject hasteyProfile = new JSONObject();
            String phone = (String) universalProfile.get("phone");
            String ccNumber = (String) universalProfile.get("cc_number");
            ccNumber = ccNumber.substring(0, 4) + " " + ccNumber.substring(4, 8) + " " + ccNumber.substring(8, 12) + " " + ccNumber.substring(12, 16);
            phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6, 10);
            hasteyProfile.put("profilename", universalProfile.get("profile_name"));
            hasteyProfile.put("email", universalProfile.get("email"));
            hasteyProfile.put("tel", phone);
            hasteyProfile.put("cc_number", ccNumber);
            hasteyProfile.put("cc_exp_month", universalProfile.get("cc_exp_month"));
            hasteyProfile.put("cc_exp_year", universalProfile.get("cc_exp_year"));
            hasteyProfile.put("cc_cvv", universalProfile.get("cc_cvv"));
            hasteyProfile.put("cardType", universalProfile.get("cc_type").toString().toLowerCase());
            hasteyProfile.put("address", universalProfile.get("billing_addr1"));
            hasteyProfile.put("address_2", universalProfile.get("billing_addr2"));
            hasteyProfile.put("city", universalProfile.get("billing_city"));
            hasteyProfile.put("state", universalProfile.get("billing_state"));
            hasteyProfile.put("country", universalProfile.get("billing_country"));
            hasteyProfile.put("name", universalProfile.get("cc_name"));
            hasteyProfile.put("zip", universalProfile.get("billing_zip"));
            hasteyProfile.put("id", "");
            hasteyArray.add(hasteyProfile);
        }
        return (hasteyArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray tripExport(JSONArray universalArray) {
        JSONArray tripArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject tripProfile = new JSONObject();
            String ccNumber = (String) universalProfile.get("cc_number");
            String phone = (String) universalProfile.get("phone");
            ccNumber = ccNumber.substring(0, 4) + " " + ccNumber.substring(4, 8) + " " + ccNumber.substring(8, 12) + " " + ccNumber.substring(12, 16);
            phone = phone.substring(0, 3) + " " + phone.substring(3, 6) + " " + phone.substring(6, 10);
            tripProfile.put("profile", universalProfile.get("profile_name"));
            tripProfile.put("name", universalProfile.get("cc_name"));
            tripProfile.put("address", universalProfile.get("billing_addr1"));
            tripProfile.put("apt", universalProfile.get("billing_apt"));
            tripProfile.put("email", universalProfile.get("email"));
            tripProfile.put("city", universalProfile.get("billing_city"));
            tripProfile.put("zip", universalProfile.get("billing_zip"));
            tripProfile.put("phone", phone);
            tripProfile.put("country", universalProfile.get("billing_country"));
            tripProfile.put("state", universalProfile.get("billing_state"));
            tripProfile.put("creditcardnumber", ccNumber);
            tripProfile.put("cardtype", universalProfile.get("cc_type").toString().toLowerCase());
            tripProfile.put("expirymonth", universalProfile.get("cc_exp_month"));
            tripProfile.put("expiryyear", universalProfile.get("cc_exp_year"));
            tripProfile.put("cvv", universalProfile.get("cc_cvv"));
            tripArray.add(tripProfile);
        }
        return (tripArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray phantomExport(JSONArray universalArray) {
        JSONArray phantomArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject phantomProfile = new JSONObject();
            JSONObject billing = new JSONObject();
            billing.put("FirstName", universalProfile.get("billing_first_name"));
            billing.put("LastName", universalProfile.get("billing_last_name"));
            billing.put("Address", universalProfile.get("billing_addr1"));
            billing.put("Apt", universalProfile.get("billing_apt"));
            billing.put("City", universalProfile.get("billing_city"));
            billing.put("State", universalProfile.get("billing_state"));
            billing.put("Zip", universalProfile.get("billing_zip"));
            JSONObject shipping = new JSONObject();
            shipping.put("FirstName", universalProfile.get("shipping_first_name"));
            shipping.put("LastName", universalProfile.get("shipping_last_name"));
            shipping.put("Address", universalProfile.get("shipping_addr1"));
            shipping.put("Apt", universalProfile.get("shipping_apt"));
            shipping.put("City", universalProfile.get("shipping_city"));
            shipping.put("State", universalProfile.get("shipping_state"));
            shipping.put("Zip", universalProfile.get("shipping_zip"));
            phantomProfile.put("CCNumber", universalProfile.get("cc_number"));
            phantomProfile.put("CVV", universalProfile.get("cc_cvv"));
            phantomProfile.put("ExpMonth", universalProfile.get("cc_exp_month"));
            phantomProfile.put("ExpYear", "20" + universalProfile.get("cc_exp_year"));
            phantomProfile.put("Email", universalProfile.get("email"));
            phantomProfile.put("CardType", universalProfile.get("cc_type").toString().toLowerCase());
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                phantomProfile.put("Same", true);
                phantomProfile.put("Billing", billing);
                phantomProfile.put("Shipping", shipping);
            } else {
                phantomProfile.put("Same", false);
                phantomProfile.put("Billing", billing);
                phantomProfile.put("Shipping", shipping);
            }
            phantomProfile.put("Phone", universalProfile.get("phone"));
            phantomProfile.put("Name", universalProfile.get("profile_name"));
            phantomProfile.put("Country", universalProfile.get("billing_country"));

            phantomArray.add(phantomProfile);
        }
        return (phantomArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray ghostExport(JSONArray universalArray) {
        JSONArray ghostArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject ghostProfile = new JSONObject();
            JSONObject billing = new JSONObject();
            billing.put("Address", universalProfile.get("billing_addr1"));
            billing.put("Apt", universalProfile.get("billing_apt"));
            billing.put("City", universalProfile.get("billing_city"));
            billing.put("FirstName", universalProfile.get("billing_first_name"));
            billing.put("LastName", universalProfile.get("billing_last_name"));
            billing.put("State", universalProfile.get("billing_state"));
            billing.put("Zip", universalProfile.get("billing_zip"));
            JSONObject shipping = new JSONObject();
            shipping.put("Address", universalProfile.get("shipping_addr1"));
            shipping.put("Apt", universalProfile.get("shipping_apt"));
            shipping.put("City", universalProfile.get("shipping_city"));
            shipping.put("FirstName", universalProfile.get("shipping_first_name"));
            shipping.put("LastName", universalProfile.get("shipping_last_name"));
            shipping.put("State", universalProfile.get("shipping_state"));
            shipping.put("Zip", universalProfile.get("shipping_zip"));
            ghostProfile.put("CCNumber", universalProfile.get("cc_number"));
            ghostProfile.put("CVV", universalProfile.get("cc_cvv"));
            ghostProfile.put("ExpMonth", universalProfile.get("cc_exp_month"));
            ghostProfile.put("ExpYear", "20" + universalProfile.get("cc_exp_year"));
            ghostProfile.put("CardType", universalProfile.get("cc_type").toString());
            ghostProfile.put("Phone", universalProfile.get("phone"));
            ghostProfile.put("Name", universalProfile.get("profile_name"));
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                ghostProfile.put("Same", true);
            } else {
                ghostProfile.put("Same", false);
            }
            ghostProfile.put("Country", universalProfile.get("billing_country"));
            ghostProfile.put("Billing", billing);
            ghostProfile.put("Shipping", shipping);
            ghostArray.add(ghostProfile);
        }
        return (ghostArray);
    }

    static String getID()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 5; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        String numbers = "123456789";

        for (int i = 0; i < 3; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(numbers.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(numbers
                    .charAt(index));
        }

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    static JSONArray pdExport(JSONArray universalArray) {
        JSONArray pdArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject pdProfile = new JSONObject();
            JSONObject shipping = new JSONObject();
            JSONObject billing = new JSONObject();
            JSONObject card = new JSONObject();
            String ccNumber = (String) universalProfile.get("cc_number");
            ccNumber = ccNumber.substring(0, 4) + " " + ccNumber.substring(4, 8) + " " + ccNumber.substring(8, 12) + " " + ccNumber.substring(12, 16);
            billing.put("address1", universalProfile.get("billing_addr1"));
            billing.put("address2", universalProfile.get("billing_addr2"));
            billing.put("city", universalProfile.get("billing_city"));
            billing.put("country", locationAbbrevConverter.abbrevToCountry((String) universalProfile.get("billing_country")));
            billing.put("firstName", universalProfile.get("billing_first_name"));
            billing.put("lastName", universalProfile.get("billing_last_name"));
            billing.put("phone", universalProfile.get("billing_phone"));
            billing.put("state", locationAbbrevConverter.abbrevToState((String) universalProfile.get("billing_state")));
            billing.put("zipcode", universalProfile.get("billing_zip"));
            shipping.put("address1", universalProfile.get("shipping_addr1"));
            shipping.put("address2", universalProfile.get("shipping_addr2"));
            shipping.put("city", universalProfile.get("shipping_city"));
            shipping.put("country", locationAbbrevConverter.abbrevToCountry((String) universalProfile.get("shipping_country")));
            shipping.put("firstName", universalProfile.get("shipping_first_name"));
            shipping.put("lastName", universalProfile.get("shipping_last_name"));
            shipping.put("phone", universalProfile.get("shipping_phone"));
            shipping.put("state", locationAbbrevConverter.abbrevToState((String) universalProfile.get("shipping_state")));
            shipping.put("zipcode", universalProfile.get("shipping_zip"));
            card.put("number", ccNumber);
            card.put("code", universalProfile.get("cc_cvv"));
            card.put("expire", universalProfile.get("cc_exp_month").toString() + "/" + universalProfile.get("cc_exp_year").toString());
            card.put("name", universalProfile.get("cc_name"));
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                pdProfile.put("match", true);
            } else {
                pdProfile.put("match", false);
            }
            pdProfile.put("limit", false);
            pdProfile.put("id", getID());
            pdProfile.put("email", universalProfile.get("email"));
            pdProfile.put("title", universalProfile.get("profile_name"));
            pdProfile.put("dotTrick", false);
            pdProfile.put("jigAddress", false);
            pdProfile.put("jigPhone", false);
            pdProfile.put("billing", billing);
            pdProfile.put("shipping", shipping);
            pdProfile.put("card", card);
            pdArray.add(pdProfile);
        }
        return (pdArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray nikeShoeBotExport(JSONArray universalArray) {
        JSONArray nsbArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject nsbProfile = new JSONObject();
            JSONObject billing = new JSONObject();
            billing.put("firstname", universalProfile.get("billing_first_name"));
            billing.put("lastname", universalProfile.get("billing_last_name"));
            billing.put("country", universalProfile.get("billing_country"));
            billing.put("city", universalProfile.get("billing_city"));
            billing.put("address", universalProfile.get("billing_addr1"));
            billing.put("address2", universalProfile.get("billing_addr2"));
            billing.put("state", universalProfile.get("billing_state"));
            billing.put("zip", universalProfile.get("billing_zip"));
            billing.put("phone", universalProfile.get("billing_phone"));
            JSONObject shipping = new JSONObject();
            shipping.put("firstname", universalProfile.get("shipping_first_name"));
            shipping.put("lastname", universalProfile.get("shipping_last_name"));
            shipping.put("country", universalProfile.get("shipping_country"));
            shipping.put("city", universalProfile.get("shipping_city"));
            shipping.put("address", universalProfile.get("shipping_addr1"));
            shipping.put("address2", universalProfile.get("shipping_addr2"));
            shipping.put("state", universalProfile.get("shipping_state"));
            shipping.put("zip", universalProfile.get("shipping_zip"));
            shipping.put("phone", universalProfile.get("shipping_phone"));
            JSONObject card = new JSONObject();
            card.put("number", universalProfile.get("cc_number"));
            card.put("expiry", universalProfile.get("cc_exp_month") + " / " + universalProfile.get("cc_exp_year"));
            card.put("cvc", universalProfile.get("cc_cvv"));
            card.put("name", universalProfile.get("cc_name"));
            nsbProfile.put("email", universalProfile.get("email"));
            nsbProfile.put("name", universalProfile.get("profile_name"));
            nsbProfile.put("checkoutLimit", 0);
            nsbProfile.put("date", System.currentTimeMillis() / 1000L);
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                nsbProfile.put("billingSame", true);
                nsbProfile.put("shipping", shipping);
                nsbProfile.put("cc", card);
            } else {
                nsbProfile.put("billingSame", false);
                nsbProfile.put("billing", billing);
                nsbProfile.put("shipping", shipping);
                nsbProfile.put("cc", card);
            }
            nsbArray.add(nsbProfile);
        }
        return (nsbArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray supremeSlayerExport(JSONArray universalArray) {
        JSONArray ssArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject ssProfile = new JSONObject();
            JSONObject billing = new JSONObject();
            JSONObject card = new JSONObject();
            billing.put("address1", universalProfile.get("billing_addr1"));
            billing.put("address2", universalProfile.get("billing_addr2"));
            billing.put("country", universalProfile.get("billing_country"));
            billing.put("city", universalProfile.get("billing_city"));
            billing.put("first", universalProfile.get("billing_first_name"));
            billing.put("last", universalProfile.get("billing_last_name"));
            billing.put("region", universalProfile.get("billing_state"));
            billing.put("postcode", universalProfile.get("billing_zip"));
            billing.put("phone", universalProfile.get("billing_phone"));
            card.put("number", universalProfile.get("cc_number"));
            card.put("code", universalProfile.get("cc_cvv"));
            if (universalProfile.get("cc_exp_month").toString().startsWith("0")) {
                card.put("month", universalProfile.get("cc_exp_month").toString().substring(1));
            } else {
                card.put("month", universalProfile.get("cc_exp_month"));
            }
            card.put("year", "20" + universalProfile.get("cc_exp_year"));
            card.put("type", universalProfile.get("cc_type").toString().toLowerCase());
            ssProfile.put("email", universalProfile.get("email"));
            ssProfile.put("name", universalProfile.get("profile_name"));
            ssProfile.put("index", "");
            ssProfile.put("locale", universalProfile.get("billing_country").toString().toLowerCase());
            ssProfile.put("billing", billing);
            ssProfile.put("card", card);
            ssArray.add(ssProfile);
        }
        return (ssArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray cyberExport(JSONArray universalArray) {
        return (universalArray);
    }

    @SuppressWarnings("unchecked")
    static JSONObject candyPremeExport(JSONArray universalArray) {
        JSONObject candyPremeArray = new JSONObject();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject candyPremeProfile = new JSONObject();
            candyPremeProfile.put("fullName", universalProfile.get("billing_first_name").toString() + " " + universalProfile.get("billing_last_name").toString());
            candyPremeProfile.put("addressLine1", universalProfile.get("billing_addr1"));
            candyPremeProfile.put("addressLine2", universalProfile.get("billing_addr2"));
            candyPremeProfile.put("city", universalProfile.get("billing_city"));
            candyPremeProfile.put("state", universalProfile.get("billing_state"));
            candyPremeProfile.put("zipCode", universalProfile.get("billing_zip"));
            candyPremeProfile.put("billingCardNumber", universalProfile.get("cc_number"));
            candyPremeProfile.put("billingCardType", universalProfile.get("cc_type").toString().toLowerCase());
            candyPremeProfile.put("billingCVV", universalProfile.get("cc_cvv"));
            candyPremeProfile.put("billingExpMonth", universalProfile.get("cc_exp_month"));
            candyPremeProfile.put("billingExpYear", "20" + universalProfile.get("cc_exp_year"));
            candyPremeProfile.put("billingName", universalProfile.get("cc_name"));
            candyPremeProfile.put("email", universalProfile.get("email"));
            candyPremeProfile.put("phoneNumber", universalProfile.get("phone"));
            if (universalProfile.get("billing_country").equals("US")) {
                candyPremeProfile.put("country", "USA");
            } else {
                candyPremeProfile.put("country", universalProfile.get("billing_country"));
            }

            candyPremeArray.put(universalProfile.get("profile_name"), candyPremeProfile);
        }
        return (candyPremeArray);
    }

    @SuppressWarnings("unchecked")
    static JSONObject dasheExport(JSONArray universalArray) {
        JSONObject dasheArray = new JSONObject();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject dasheProfile = new JSONObject();
            dasheProfile.put("address", universalProfile.get("shipping_addr1"));
            dasheProfile.put("apt", universalProfile.get("shipping_apt"));
            dasheProfile.put("billingAddress", universalProfile.get("billing_addr1"));
            dasheProfile.put("billingApt", universalProfile.get("billing_apt"));
            dasheProfile.put("billingCity", universalProfile.get("billing_city"));
            dasheProfile.put("billingState", universalProfile.get("billing_state"));
            dasheProfile.put("billingZipCode", universalProfile.get("billing_zip"));
            dasheProfile.put("billingCountry", locationAbbrevConverter.abbrevToCountry(universalProfile.get("billing_country").toString()));
            dasheProfile.put("billingFirstName", universalProfile.get("billing_first_name"));
            dasheProfile.put("billingLastName", universalProfile.get("billing_last_name"));
            dasheProfile.put("billingPhone", universalProfile.get("billing_phone"));
            dasheProfile.put("cardCvv", universalProfile.get("cc_cvv"));
            dasheProfile.put("cardExpiry", universalProfile.get("cc_exp_month") + " / " + universalProfile.get("cc_exp_year"));
            dasheProfile.put("cardNumber", universalProfile.get("cc_number"));
            dasheProfile.put("cardName", universalProfile.get("cc_name"));
            dasheProfile.put("firstName", universalProfile.get("shipping_first_name"));
            dasheProfile.put("lastName", universalProfile.get("shipping_last_name"));
            dasheProfile.put("zipCode", universalProfile.get("shipping_zip"));
            dasheProfile.put("phone", universalProfile.get("billing_phone"));
            dasheProfile.put("city", universalProfile.get("shipping_city"));
            dasheProfile.put("state", universalProfile.get("shipping_state"));
            dasheProfile.put("country", locationAbbrevConverter.abbrevToCountry(universalProfile.get("shipping_country").toString()));
            dasheProfile.put("email", universalProfile.get("email"));
            dasheProfile.put("oneUseOnly", "");
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                dasheProfile.put("billingMatch", true);
            } else {
                dasheProfile.put("billingMatch", false);
            }

            dasheArray.put(universalProfile.get("profile_name"), dasheProfile);
        }
        return (dasheArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray bnbAIOExport(JSONArray universalArray) {
        JSONArray bnbAIOArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject bnbAIOProfile = new JSONObject();
            bnbAIOProfile.put("Name", universalProfile.get("profile_name"));
            bnbAIOProfile.put("BillingFirstName", universalProfile.get("billing_first_name"));
            bnbAIOProfile.put("BillingLastName", universalProfile.get("billing_last_name"));
            bnbAIOProfile.put("BillingAddress1", universalProfile.get("billing_addr1"));
            bnbAIOProfile.put("BillingAddress2", universalProfile.get("billing_addr2"));
            bnbAIOProfile.put("BillingZipCode", universalProfile.get("billing_zip"));
            bnbAIOProfile.put("BillingPhone", universalProfile.get("billing_phone"));
            bnbAIOProfile.put("BillingCity", universalProfile.get("billing_city"));
            bnbAIOProfile.put("BillingState", universalProfile.get("billing_state"));
            bnbAIOProfile.put("BillingProvince", universalProfile.get("billing_state"));
            bnbAIOProfile.put("BillingCountry", universalProfile.get("billing_country"));
            bnbAIOProfile.put("BillingEURegion", "");
            bnbAIOProfile.put("BillingDSMRegion", "");
            bnbAIOProfile.put("ShippingFirstName", universalProfile.get("shipping_first_name"));
            bnbAIOProfile.put("ShippingLastName", universalProfile.get("shipping_last_name"));
            bnbAIOProfile.put("ShippingAddress1", universalProfile.get("shipping_addr1"));
            bnbAIOProfile.put("ShippingAddress2", universalProfile.get("shipping_addr2"));
            bnbAIOProfile.put("ShippingZipCode", universalProfile.get("shipping_zip"));
            bnbAIOProfile.put("ShippingPhone", universalProfile.get("shipping_phone"));
            bnbAIOProfile.put("ShippingCity", universalProfile.get("shipping_city"));
            bnbAIOProfile.put("ShippingState", universalProfile.get("shipping_state"));
            bnbAIOProfile.put("ShippingProvince", universalProfile.get("shipping_state"));
            bnbAIOProfile.put("ShippingCountry", universalProfile.get("shipping_country"));
            bnbAIOProfile.put("ShippingEURegion", "");
            bnbAIOProfile.put("ShippingDSMRegion", "");
            bnbAIOProfile.put("CreditCardType", universalProfile.get("cc_type").toString());
            bnbAIOProfile.put("CreditCardNumber", universalProfile.get("cc_number"));
            if (universalProfile.get("cc_exp_month").toString().startsWith("0")) {
                bnbAIOProfile.put("CreditCardExpiryMonth", universalProfile.get("cc_exp_month").toString().substring(1));
            } else {
                bnbAIOProfile.put("CreditCardExpiryMonth", universalProfile.get("cc_exp_month"));
            }
            bnbAIOProfile.put("CreditCardExpiryYear", universalProfile.get("cc_exp_year"));
            bnbAIOProfile.put("CreditCardCvv", universalProfile.get("cc_cvv"));
            bnbAIOProfile.put("MaxCheckouts", 0);
            bnbAIOArray.add(bnbAIOProfile);
        }
        return (bnbAIOArray);
    }

    @SuppressWarnings("unchecked")
    static JSONArray bnbNikeExport(JSONArray universalArray) {
        JSONArray bnbNikeArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject bnbNikeProfile = new JSONObject();
            bnbNikeProfile.put("Name", universalProfile.get("profile_name"));
            bnbNikeProfile.put("BillingFirstName", universalProfile.get("billing_first_name"));
            bnbNikeProfile.put("BillingLastName", universalProfile.get("billing_last_name"));
            bnbNikeProfile.put("BillingAddress1", universalProfile.get("billing_addr1"));
            bnbNikeProfile.put("BillingAddress2", universalProfile.get("billing_addr2"));
            bnbNikeProfile.put("BillingAddress3", "");
            bnbNikeProfile.put("BillingZipCode", universalProfile.get("billing_zip"));
            bnbNikeProfile.put("BillingPhone", universalProfile.get("billing_phone"));
            bnbNikeProfile.put("BillingCity", universalProfile.get("billing_city"));
            bnbNikeProfile.put("BillingState", universalProfile.get("billing_state"));
            bnbNikeProfile.put("BillingStateJP", "");
            bnbNikeProfile.put("ShippingFirstName", universalProfile.get("shipping_first_name"));
            bnbNikeProfile.put("ShippingLastName", universalProfile.get("shipping_last_name"));
            bnbNikeProfile.put("ShippingAddress1", universalProfile.get("shipping_addr1"));
            bnbNikeProfile.put("ShippingAddress2", universalProfile.get("shipping_addr2"));
            bnbNikeProfile.put("ShippingAddress3", "");
            bnbNikeProfile.put("ShippingZipCode", universalProfile.get("shipping_zip"));
            bnbNikeProfile.put("ShippingPhone", universalProfile.get("shipping_phone"));
            bnbNikeProfile.put("ShippingCity", universalProfile.get("shipping_city"));
            bnbNikeProfile.put("ShippingState", universalProfile.get("shipping_state"));
            bnbNikeProfile.put("ShippingStateJP", "");
            bnbNikeProfile.put("CreditCardType", universalProfile.get("cc_type").toString());
            bnbNikeProfile.put("CreditCardNumber", universalProfile.get("cc_number"));
            if (universalProfile.get("cc_exp_month").toString().startsWith("0")) {
                bnbNikeProfile.put("CreditCardExpiryMonth", universalProfile.get("cc_exp_month").toString().substring(1));
            } else {
                bnbNikeProfile.put("CreditCardExpiryMonth", universalProfile.get("cc_exp_month"));
            }
            bnbNikeProfile.put("CreditCardExpiryYear", "20" + universalProfile.get("cc_exp_year"));
            bnbNikeProfile.put("CreditCardCvv", universalProfile.get("cc_cvv"));
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                bnbNikeProfile.put("ShippingAddressSame", true);
            } else {
                bnbNikeProfile.put("ShippingAddressSame", false);
            }
            bnbNikeProfile.put("MaxCheckouts", 0);
            bnbNikeArray.add(bnbNikeProfile);
        }
        return (bnbNikeArray);
    }

    @SuppressWarnings("unchecked")
    static String eveExport(JSONArray universalArray) {
        String xml;
        JSONArray eveArray = new JSONArray();
        for (Object o : universalArray) {
            JSONObject universalProfile = (JSONObject) o;
            JSONObject profile = new JSONObject();
            profile.put("ProfileName", universalProfile.get("profile_name"));
            profile.put("BillingFirstName", universalProfile.get("billing_first_name"));
            profile.put("BillingLastName", universalProfile.get("billing_last_name"));
            profile.put("BillingAddressLine1", universalProfile.get("billing_addr1"));
            profile.put("BillingAddressLine2", universalProfile.get("billing_addr2"));
            profile.put("BillingCity", universalProfile.get("billing_city"));
            profile.put("BillingState", universalProfile.get("billing_state"));
            profile.put("BillingCountryCode", universalProfile.get("billing_country"));
            profile.put("BillingZip", universalProfile.get("billing_zip"));
            profile.put("BillingPhone", universalProfile.get("billing_phone"));
            profile.put("BillingEmail", universalProfile.get("email"));
            profile.put("ShippingFirstName", universalProfile.get("shipping_first_name"));
            profile.put("ShippingLastName", universalProfile.get("shipping_last_name"));
            profile.put("ShippingAddressLine1", universalProfile.get("shipping_addr1"));
            profile.put("ShippingAddressLine2", universalProfile.get("shipping_addr2"));
            profile.put("ShippingCity", universalProfile.get("shipping_city"));
            profile.put("ShippingState", universalProfile.get("shipping_state"));
            profile.put("ShippingCountryCode", universalProfile.get("shipping_country"));
            profile.put("ShippingZip", universalProfile.get("shipping_zip"));
            profile.put("ShippingPhone", universalProfile.get("shipping_phone"));
            profile.put("ShippingEmail", universalProfile.get("email"));
            profile.put("NameOnCard", universalProfile.get("cc_name"));
            profile.put("CreditCardNumber", universalProfile.get("cc_number"));
            profile.put("ExpirationMonth", universalProfile.get("cc_exp_month"));
            profile.put("ExpirationYear", "20" + universalProfile.get("cc_exp_year"));
            profile.put("Cvv", universalProfile.get("cc_cvv"));
            profile.put("CardType", universalProfile.get("cc_type").toString().toLowerCase());
            profile.put("OneCheckoutPerWebsite", false);
            if (universalProfile.get("billing_addr1").toString().equals(universalProfile.get("shipping_addr1").toString())) {
                profile.put("SameBillingShipping", true);
            } else {
                profile.put("SameBillingShipping", false);
            }
            profile.put("BirthDay", 1);
            profile.put("BirthMonth", 1);
            profile.put("BirthYear", 1985);
            eveArray.add(profile);
        }
        JSONObject result = new JSONObject();
        JSONObject eveProfile = new JSONObject();
        eveProfile.put("Profile", eveArray);
        result.put("ArrayOfProfile", eveProfile);
        org.json.JSONObject finalProfile = new org.json.JSONObject(result);
        xml = XML.toString(finalProfile);
        return (toPrettyString(xml));
    }

    private static String toPrettyString(String xml) {
        try {
            // Turn xml string into a document
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

            // Remove whitespaces outside tags
            document.normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.evaluate("//text()[normalize-space()='']",
                    document,
                    XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                node.getParentNode().removeChild(node);
            }

            // Setup pretty print options
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Element element = (Element) document.getFirstChild();
            element.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            element.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

            // Return pretty print xml string
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

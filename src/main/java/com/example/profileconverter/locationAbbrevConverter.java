package com.example.profileconverter;

import java.util.HashMap;
import java.util.Map;

class locationAbbrevConverter {
    static String stateToAbbrev(String state) {
        Map<String, String> states = new HashMap<>();
        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("Alberta", "AB");
        states.put("American Samoa", "AS");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("Armed Forces (AE)", "AE");
        states.put("Armed Forces Americas", "AA");
        states.put("Armed Forces Pacific", "AP");
        states.put("British Columbia", "BC");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CT");
        states.put("Delaware", "DE");
        states.put("District Of Columbia", "DC");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Guam", "GU");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Manitoba", "MB");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Brunswick", "NB");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("Newfoundland", "NF");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Northwest Territories", "NT");
        states.put("Nova Scotia", "NS");
        states.put("Nunavut", "NU");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Ontario", "ON");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Prince Edward Island", "PE");
        states.put("Puerto Rico", "PR");
        states.put("Quebec", "QC");
        states.put("Rhode Island", "RI");
        states.put("Saskatchewan", "SK");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virgin Islands", "VI");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");
        states.put("Yukon Territory", "YT");
        return states.getOrDefault(state, state);
    }

    static String abbrevToCountry(String country) {
        Map<String, String> countries = new HashMap<>();
        countries.put("WF", "Wallis And Futuna Islands");
        countries.put("PG", "Papua New Guinea");
        countries.put("MQ", "Martinique (French)");
        countries.put("KZ", "Kazakhstan");
        countries.put("NT", "Neutral Zone");
        countries.put("PY", "Paraguay");
        countries.put("SY", "Syria");
        countries.put("BS", "Bahamas");
        countries.put("SB", "Solomon Islands");
        countries.put("MS", "Montserrat");
        countries.put("MH", "Marshall Islands");
        countries.put("ML", "Mali");
        countries.put("PA", "Panama");
        countries.put("LA", "Laos");
        countries.put("AR", "Argentina");
        countries.put("FK", "Falkland Islands");
        countries.put("FX", "France (European Territory)");
        countries.put("SC", "Seychelles");
        countries.put("BA", "Bosnia-Herzegovina");
        countries.put("BZ", "Belize");
        countries.put("ZM", "Zambia");
        countries.put("BH", "Bahrain");
        countries.put("CG", "Congo");
        countries.put("NA", "Namibia");
        countries.put("FI", "Finland");
        countries.put("FO", "Faroe Islands");
        countries.put("KM", "Comoros");
        countries.put("AN", "Netherlands Antilles");
        countries.put("GE", "Georgia");
        countries.put("YE", "Yemen");
        countries.put("KG", "Kyrgyz Republic (Kyrgyzstan)");
        countries.put("ER", "Eritrea");
        countries.put("PR", "Puerto Rico");
        countries.put("AW", "Aruba");
        countries.put("MG", "Madagascar");
        countries.put("LY", "Libya");
        countries.put("SE", "Sweden");
        countries.put("CC", "Cocos (Keeling) Islands");
        countries.put("MW", "Malawi");
        countries.put("LI", "Liechtenstein");
        countries.put("PL", "Poland");
        countries.put("BG", "Bulgaria");
        countries.put("JO", "Jordan");
        countries.put("TN", "Tunisia");
        countries.put("AE", "United Arab Emirates");
        countries.put("TV", "Tuvalu");
        countries.put("CD", "Congo, The Democratic Republic Of The");
        countries.put("KE", "Kenya");
        countries.put("DJ", "Djibouti");
        countries.put("LB", "Lebanon");
        countries.put("CU", "Cuba");
        countries.put("CZ", "Czech Republic");
        countries.put("LC", "Saint Lucia");
        countries.put("MR", "Mauritania");
        countries.put("YT", "Mayotte");
        countries.put("IL", "Israel");
        countries.put("SM", "San Marino");
        countries.put("AU", "Australia");
        countries.put("SJ", "Svalbard And Jan Mayen Islands");
        countries.put("MM", "Myanmar");
        countries.put("CM", "Cameroon");
        countries.put("GI", "Gibraltar");
        countries.put("CY", "Cyprus");
        countries.put("MP", "Northern Mariana Islands");
        countries.put("MY", "Malaysia");
        countries.put("IS", "Iceland");
        countries.put("OM", "Oman");
        countries.put("AM", "Armenia");
        countries.put("GA", "Gabon");
        countries.put("YU", "Yugoslavia");
        countries.put("SK", "Slovak Republic");
        countries.put("ZR", "Zaire");
        countries.put("LU", "Luxembourg");
        countries.put("BR", "Brazil");
        countries.put("DZ", "Algeria");
        countries.put("SI", "Slovenia");
        countries.put("CO", "Colombia");
        countries.put("EC", "Ecuador");
        countries.put("GF", "French Guyana");
        countries.put("SU", "Former USSR");
        countries.put("VU", "Vanuatu");
        countries.put("GW", "Guinea Bissau");
        countries.put("HN", "Honduras");
        countries.put("IT", "Italy");
        countries.put("AQ", "Antarctica");
        countries.put("NR", "Nauru");
        countries.put("HT", "Haiti");
        countries.put("BI", "Burundi");
        countries.put("RU", "Russian Federation");
        countries.put("SG", "Singapore");
        countries.put("AS", "American Samoa");
        countries.put("CX", "Christmas Island");
        countries.put("VC", "Saint Vincent & Grenadines");
        countries.put("NL", "Netherlands");
        countries.put("CN", "China");
        countries.put("PM", "Saint Pierre And Miquelon");
        countries.put("BT", "Bhutan");
        countries.put("RO", "Romania");
        countries.put("TG", "Togo");
        countries.put("PH", "Philippines");
        countries.put("UZ", "Uzbekistan");
        countries.put("VA", "Holy See (Vatican City State)");
        countries.put("NC", "New Caledonia (French)");
        countries.put("ZW", "Zimbabwe");
        countries.put("IO", "British Indian Ocean Territory");
        countries.put("TJ", "Tadjikistan");
        countries.put("DM", "Dominica");
        countries.put("ID", "Indonesia");
        countries.put("BJ", "Benin");
        countries.put("AO", "Angola");
        countries.put("VG", "Virgin Islands (British)");
        countries.put("SD", "Sudan");
        countries.put("TP", "East Timor");
        countries.put("BN", "Brunei Darussalam");
        countries.put("PT", "Portugal");
        countries.put("GD", "Grenada");
        countries.put("KP", "North Korea");
        countries.put("GR", "Greece");
        countries.put("KY", "Cayman Islands");
        countries.put("LV", "Latvia");
        countries.put("MN", "Mongolia");
        countries.put("IR", "Iran");
        countries.put("MA", "Morocco");
        countries.put("GT", "Guatemala");
        countries.put("GY", "Guyana");
        countries.put("IQ", "Iraq");
        countries.put("CL", "Chile");
        countries.put("NP", "Nepal");
        countries.put("UM", "USA Minor Outlying Islands");
        countries.put("TZ", "Tanzania");
        countries.put("UA", "Ukraine");
        countries.put("CS", "Former Czechoslovakia");
        countries.put("GH", "Ghana");
        countries.put("AI", "Anguilla");
        countries.put("IN", "India");
        countries.put("CA", "Canada");
        countries.put("MV", "Maldives");
        countries.put("TR", "Turkey");
        countries.put("BE", "Belgium");
        countries.put("TW", "Taiwan");
        countries.put("ZA", "South Africa");
        countries.put("BM", "Bermuda");
        countries.put("CF", "Central African Republic");
        countries.put("JM", "Jamaica");
        countries.put("PE", "Peru");
        countries.put("TM", "Turkmenistan");
        countries.put("DE", "Germany");
        countries.put("AZ", "Azerbaidjan");
        countries.put("FJ", "Fiji");
        countries.put("TK", "Tokelau");
        countries.put("HK", "Hong Kong");
        countries.put("AF", "Afghanistan, Islamic State Of");
        countries.put("GN", "Guinea");
        countries.put("US", "United States");
        countries.put("SO", "Somalia");
        countries.put("TD", "Chad");
        countries.put("ST", "Saint Tome (Sao Tome) And Principe");
        countries.put("TH", "Thailand");
        countries.put("GQ", "Equatorial Guinea");
        countries.put("KI", "Kiribati");
        countries.put("RE", "Reunion (French)");
        countries.put("CR", "Costa Rica");
        countries.put("MD", "Moldavia");
        countries.put("GS", "S. Georgia & S. Sandwich Isls.");
        countries.put("VN", "Vietnam");
        countries.put("PN", "Pitcairn Island");
        countries.put("KW", "Kuwait");
        countries.put("NG", "Nigeria");
        countries.put("HR", "Croatia");
        countries.put("CK", "Cook Islands");
        countries.put("LK", "Sri Lanka");
        countries.put("UY", "Uruguay");
        countries.put("UK", "United Kingdom");
        countries.put("CH", "Switzerland");
        countries.put("WS", "Samoa");
        countries.put("ES", "Spain");
        countries.put("LR", "Liberia");
        countries.put("VE", "Venezuela");
        countries.put("BF", "Burkina Faso");
        countries.put("SZ", "Swaziland");
        countries.put("PW", "Palau");
        countries.put("CI", "Ivory Coast (Cote D'Ivoire)");
        countries.put("TC", "Turks And Caicos Islands");
        countries.put("EE", "Estonia");
        countries.put("VI", "Virgin Islands (USA)");
        countries.put("NU", "Niue");
        countries.put("HM", "Heard And McDonald Islands");
        countries.put("AT", "Austria");
        countries.put("KR", "South Korea");
        countries.put("MZ", "Mozambique");
        countries.put("SV", "El Salvador");
        countries.put("MC", "Monaco");
        countries.put("GU", "Guam (USA)");
        countries.put("LS", "Lesotho");
        countries.put("TO", "Tonga");
        countries.put("EH", "Western Sahara");
        countries.put("HU", "Hungary");
        countries.put("JP", "Japan");
        countries.put("BY", "Belarus");
        countries.put("MU", "Mauritius");
        countries.put("BV", "Bouvet Island");
        countries.put("AL", "Albania");
        countries.put("NF", "Norfolk Island");
        countries.put("TT", "Trinidad And Tobago");
        countries.put("NZ", "New Zealand");
        countries.put("SN", "Senegal");
        countries.put("KN", "Saint Kitts & Nevis Anguilla");
        countries.put("MK", "Macedonia");
        countries.put("PF", "Polynesia (French)");
        countries.put("ET", "Ethiopia");
        countries.put("EG", "Egypt");
        countries.put("MO", "Macau");
        countries.put("SL", "Sierra Leone");
        countries.put("BO", "Bolivia");
        countries.put("MT", "Malta");
        countries.put("SA", "Saudi Arabia");
        countries.put("CV", "Cape Verde");
        countries.put("PK", "Pakistan");
        countries.put("GM", "Gambia");
        countries.put("AD", "Andorra, Principality Of");
        countries.put("IE", "Ireland");
        countries.put("QA", "Qatar");
        countries.put("FR", "France");
        countries.put("LT", "Lithuania");
        countries.put("NE", "Niger");
        countries.put("RW", "Rwanda");
        countries.put("KH", "Cambodia, Kingdom Of");
        countries.put("TF", "French Southern Territories");
        countries.put("BD", "Bangladesh");
        countries.put("BB", "Barbados");
        countries.put("NI", "Nicaragua");
        countries.put("NO", "Norway");
        countries.put("BW", "Botswana");
        countries.put("DK", "Denmark");
        countries.put("DO", "Dominican Republic");
        countries.put("MX", "Mexico");
        countries.put("UG", "Uganda");
        countries.put("FM", "Micronesia");
        countries.put("SR", "Suriname");
        countries.put("GL", "Greenland");
        countries.put("SH", "Saint Helena");
        countries.put("AG", "Antigua And Barbuda");
        countries.put("GP", "Guadeloupe (French)");
        return countries.getOrDefault(country, country);
    }

    static String countryToAbbrev(String country) {
        Map<String, String> countries = new HashMap<>();
        countries.put("Andorra, Principality Of", "AD");
        countries.put("United Arab Emirates", "AE");
        countries.put("Afghanistan, Islamic State Of", "AF");
        countries.put("Antigua And Barbuda", "AG");
        countries.put("Anguilla", "AI");
        countries.put("Albania", "AL");
        countries.put("Armenia", "AM");
        countries.put("Netherlands Antilles", "AN");
        countries.put("Angola", "AO");
        countries.put("Antarctica", "AQ");
        countries.put("Argentina", "AR");
        countries.put("American Samoa", "AS");
        countries.put("Austria", "AT");
        countries.put("Australia", "AU");
        countries.put("Aruba", "AW");
        countries.put("Azerbaidjan", "AZ");
        countries.put("Bosnia-Herzegovina", "BA");
        countries.put("Barbados", "BB");
        countries.put("Bangladesh", "BD");
        countries.put("Belgium", "BE");
        countries.put("Burkina Faso", "BF");
        countries.put("Bulgaria", "BG");
        countries.put("Bahrain", "BH");
        countries.put("Burundi", "BI");
        countries.put("Benin", "BJ");
        countries.put("Bermuda", "BM");
        countries.put("Brunei Darussalam", "BN");
        countries.put("Bolivia", "BO");
        countries.put("Brazil", "BR");
        countries.put("Bahamas", "BS");
        countries.put("Bhutan", "BT");
        countries.put("Bouvet Island", "BV");
        countries.put("Botswana", "BW");
        countries.put("Belarus", "BY");
        countries.put("Belize", "BZ");
        countries.put("Canada", "CA");
        countries.put("Cocos (Keeling) Islands", "CC");
        countries.put("Central African Republic", "CF");
        countries.put("Congo, The Democratic Republic Of The", "CD");
        countries.put("Congo", "CG");
        countries.put("Switzerland", "CH");
        countries.put("Ivory Coast (Cote D'Ivoire)", "CI");
        countries.put("Cook Islands", "CK");
        countries.put("Chile", "CL");
        countries.put("Cameroon", "CM");
        countries.put("China", "CN");
        countries.put("Colombia", "CO");
        countries.put("Costa Rica", "CR");
        countries.put("Former Czechoslovakia", "CS");
        countries.put("Cuba", "CU");
        countries.put("Cape Verde", "CV");
        countries.put("Christmas Island", "CX");
        countries.put("Cyprus", "CY");
        countries.put("Czech Republic", "CZ");
        countries.put("Germany", "DE");
        countries.put("Djibouti", "DJ");
        countries.put("Denmark", "DK");
        countries.put("Dominica", "DM");
        countries.put("Dominican Republic", "DO");
        countries.put("Algeria", "DZ");
        countries.put("Ecuador", "EC");
        countries.put("Estonia", "EE");
        countries.put("Egypt", "EG");
        countries.put("Western Sahara", "EH");
        countries.put("Eritrea", "ER");
        countries.put("Spain", "ES");
        countries.put("Ethiopia", "ET");
        countries.put("Finland", "FI");
        countries.put("Fiji", "FJ");
        countries.put("Falkland Islands", "FK");
        countries.put("Micronesia", "FM");
        countries.put("Faroe Islands", "FO");
        countries.put("France", "FR");
        countries.put("France (European Territory)", "FX");
        countries.put("Gabon", "GA");
        countries.put("Great Britain", "UK");
        countries.put("Grenada", "GD");
        countries.put("Georgia", "GE");
        countries.put("French Guyana", "GF");
        countries.put("Ghana", "GH");
        countries.put("Gibraltar", "GI");
        countries.put("Greenland", "GL");
        countries.put("Gambia", "GM");
        countries.put("Guinea", "GN");
        countries.put("Guadeloupe (French)", "GP");
        countries.put("Equatorial Guinea", "GQ");
        countries.put("Greece", "GR");
        countries.put("S. Georgia & S. Sandwich Isls.", "GS");
        countries.put("Guatemala", "GT");
        countries.put("Guam (USA)", "GU");
        countries.put("Guinea Bissau", "GW");
        countries.put("Guyana", "GY");
        countries.put("Hong Kong", "HK");
        countries.put("Heard And McDonald Islands", "HM");
        countries.put("Honduras", "HN");
        countries.put("Croatia", "HR");
        countries.put("Haiti", "HT");
        countries.put("Hungary", "HU");
        countries.put("Indonesia", "ID");
        countries.put("Ireland", "IE");
        countries.put("Israel", "IL");
        countries.put("India", "IN");
        countries.put("British Indian Ocean Territory", "IO");
        countries.put("Iraq", "IQ");
        countries.put("Iran", "IR");
        countries.put("Iceland", "IS");
        countries.put("Italy", "IT");
        countries.put("Jamaica", "JM");
        countries.put("Jordan", "JO");
        countries.put("Japan", "JP");
        countries.put("Kenya", "KE");
        countries.put("Kyrgyz Republic (Kyrgyzstan)", "KG");
        countries.put("Cambodia, Kingdom Of", "KH");
        countries.put("Kiribati", "KI");
        countries.put("Comoros", "KM");
        countries.put("Saint Kitts & Nevis Anguilla", "KN");
        countries.put("North Korea", "KP");
        countries.put("South Korea", "KR");
        countries.put("Kuwait", "KW");
        countries.put("Cayman Islands", "KY");
        countries.put("Kazakhstan", "KZ");
        countries.put("Laos", "LA");
        countries.put("Lebanon", "LB");
        countries.put("Saint Lucia", "LC");
        countries.put("Liechtenstein", "LI");
        countries.put("Sri Lanka", "LK");
        countries.put("Liberia", "LR");
        countries.put("Lesotho", "LS");
        countries.put("Lithuania", "LT");
        countries.put("Luxembourg", "LU");
        countries.put("Latvia", "LV");
        countries.put("Libya", "LY");
        countries.put("Morocco", "MA");
        countries.put("Monaco", "MC");
        countries.put("Moldavia", "MD");
        countries.put("Madagascar", "MG");
        countries.put("Marshall Islands", "MH");
        countries.put("Macedonia", "MK");
        countries.put("Mali", "ML");
        countries.put("Myanmar", "MM");
        countries.put("Mongolia", "MN");
        countries.put("Macau", "MO");
        countries.put("Northern Mariana Islands", "MP");
        countries.put("Martinique (French)", "MQ");
        countries.put("Mauritania", "MR");
        countries.put("Montserrat", "MS");
        countries.put("Malta", "MT");
        countries.put("Mauritius", "MU");
        countries.put("Maldives", "MV");
        countries.put("Malawi", "MW");
        countries.put("Mexico", "MX");
        countries.put("Malaysia", "MY");
        countries.put("Mozambique", "MZ");
        countries.put("Namibia", "NA");
        countries.put("New Caledonia (French)", "NC");
        countries.put("Niger", "NE");
        countries.put("Norfolk Island", "NF");
        countries.put("Nigeria", "NG");
        countries.put("Nicaragua", "NI");
        countries.put("Netherlands", "NL");
        countries.put("Norway", "NO");
        countries.put("Nepal", "NP");
        countries.put("Nauru", "NR");
        countries.put("Neutral Zone", "NT");
        countries.put("Niue", "NU");
        countries.put("New Zealand", "NZ");
        countries.put("Oman", "OM");
        countries.put("Panama", "PA");
        countries.put("Peru", "PE");
        countries.put("Polynesia (French)", "PF");
        countries.put("Papua New Guinea", "PG");
        countries.put("Philippines", "PH");
        countries.put("Pakistan", "PK");
        countries.put("Poland", "PL");
        countries.put("Saint Pierre And Miquelon", "PM");
        countries.put("Pitcairn Island", "PN");
        countries.put("Puerto Rico", "PR");
        countries.put("Portugal", "PT");
        countries.put("Palau", "PW");
        countries.put("Paraguay", "PY");
        countries.put("Qatar", "QA");
        countries.put("Reunion (French)", "RE");
        countries.put("Romania", "RO");
        countries.put("Russian Federation", "RU");
        countries.put("Rwanda", "RW");
        countries.put("Saudi Arabia", "SA");
        countries.put("Solomon Islands", "SB");
        countries.put("Seychelles", "SC");
        countries.put("Sudan", "SD");
        countries.put("Sweden", "SE");
        countries.put("Singapore", "SG");
        countries.put("Saint Helena", "SH");
        countries.put("Slovenia", "SI");
        countries.put("Svalbard And Jan Mayen Islands", "SJ");
        countries.put("Slovak Republic", "SK");
        countries.put("Sierra Leone", "SL");
        countries.put("San Marino", "SM");
        countries.put("Senegal", "SN");
        countries.put("Somalia", "SO");
        countries.put("Suriname", "SR");
        countries.put("Saint Tome (Sao Tome) And Principe", "ST");
        countries.put("Former USSR", "SU");
        countries.put("El Salvador", "SV");
        countries.put("Syria", "SY");
        countries.put("Swaziland", "SZ");
        countries.put("Turks And Caicos Islands", "TC");
        countries.put("Chad", "TD");
        countries.put("French Southern Territories", "TF");
        countries.put("Togo", "TG");
        countries.put("Thailand", "TH");
        countries.put("Tadjikistan", "TJ");
        countries.put("Tokelau", "TK");
        countries.put("Turkmenistan", "TM");
        countries.put("Tunisia", "TN");
        countries.put("Tonga", "TO");
        countries.put("East Timor", "TP");
        countries.put("Turkey", "TR");
        countries.put("Trinidad And Tobago", "TT");
        countries.put("Tuvalu", "TV");
        countries.put("Taiwan", "TW");
        countries.put("Tanzania", "TZ");
        countries.put("Ukraine", "UA");
        countries.put("Uganda", "UG");
        countries.put("United Kingdom", "UK");
        countries.put("USA Minor Outlying Islands", "UM");
        countries.put("United States", "US");
        countries.put("Uruguay", "UY");
        countries.put("Uzbekistan", "UZ");
        countries.put("Holy See (Vatican City State)", "VA");
        countries.put("Saint Vincent & Grenadines", "VC");
        countries.put("Venezuela", "VE");
        countries.put("Virgin Islands (British)", "VG");
        countries.put("Virgin Islands (USA)", "VI");
        countries.put("Vietnam", "VN");
        countries.put("Vanuatu", "VU");
        countries.put("Wallis And Futuna Islands", "WF");
        countries.put("Samoa", "WS");
        countries.put("Yemen", "YE");
        countries.put("Mayotte", "YT");
        countries.put("Yugoslavia", "YU");
        countries.put("South Africa", "ZA");
        countries.put("Zambia", "ZM");
        countries.put("Zaire", "ZR");
        countries.put("Zimbabwe", "ZW");
        countries.put("USA", "US");
        return countries.getOrDefault(country, country);
    }

    static String abbrevToState(String state) {
        Map<String, String> states = new HashMap<>();
        states.put("AL", "Alabama");
        states.put("AK", "Alaska");
        states.put("AB", "Alberta");
        states.put("AZ", "Arizona");
        states.put("AR", "Arkansas");
        states.put("BC", "British Columbia");
        states.put("CA", "California");
        states.put("CO", "Colorado");
        states.put("CT", "Connecticut");
        states.put("DE", "Delaware");
        states.put("DC", "District Of Columbia");
        states.put("FL", "Florida");
        states.put("GA", "Georgia");
        states.put("GU", "Guam");
        states.put("HI", "Hawaii");
        states.put("ID", "Idaho");
        states.put("IL", "Illinois");
        states.put("IN", "Indiana");
        states.put("IA", "Iowa");
        states.put("KS", "Kansas");
        states.put("KY", "Kentucky");
        states.put("LA", "Louisiana");
        states.put("ME", "Maine");
        states.put("MB", "Manitoba");
        states.put("MD", "Maryland");
        states.put("MA", "Massachusetts");
        states.put("MI", "Michigan");
        states.put("MN", "Minnesota");
        states.put("MS", "Mississippi");
        states.put("MO", "Missouri");
        states.put("MT", "Montana");
        states.put("NE", "Nebraska");
        states.put("NV", "Nevada");
        states.put("NB", "New Brunswick");
        states.put("NH", "New Hampshire");
        states.put("NJ", "New Jersey");
        states.put("NM", "New Mexico");
        states.put("NY", "New York");
        states.put("NF", "Newfoundland");
        states.put("NC", "North Carolina");
        states.put("ND", "North Dakota");
        states.put("NT", "Northwest Territories");
        states.put("NS", "Nova Scotia");
        states.put("NU", "Nunavut");
        states.put("OH", "Ohio");
        states.put("OK", "Oklahoma");
        states.put("ON", "Ontario");
        states.put("OR", "Oregon");
        states.put("PA", "Pennsylvania");
        states.put("PE", "Prince Edward Island");
        states.put("PR", "Puerto Rico");
        states.put("QC", "Quebec");
        states.put("RI", "Rhode Island");
        states.put("SK", "Saskatchewan");
        states.put("SC", "South Carolina");
        states.put("SD", "South Dakota");
        states.put("TN", "Tennessee");
        states.put("TX", "Texas");
        states.put("UT", "Utah");
        states.put("VT", "Vermont");
        states.put("VI", "Virgin Islands");
        states.put("VA", "Virginia");
        states.put("WA", "Washington");
        states.put("WV", "West Virginia");
        states.put("WI", "Wisconsin");
        states.put("WY", "Wyoming");
        states.put("YT", "Yukon Territory");
        return states.getOrDefault(state, state);
    }
}

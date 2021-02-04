package com.example.snap.Helpers;

import com.example.snap.DataModel.HTMLModel;

import java.util.ArrayList;

public class HTMLIDHelper {


    public static final String NAME  = "name";
    public static final String TEMP  = "temperature";
    public static final String RESIDENCE  = "residence";
    public static final String NATURE_OF_VISIT_OFFICIAL  = "official";
    public static final String NATURE_OF_VISIT_PERSONAL  = "personal";
    public static final String COMPANY_NAME  = "companyName";
    public static final String COMPANY_ADDRESS  = "companyAddress";
    public static final String HAS_SORE_THROAT_YES  = "soreThroatYes";
    public static final String HAS_SORE_THROAT_NO  = "soreThroatNo";
    public static final String HAS_BODY_PAINS_YES  = "bodyPainYes";
    public static final String HAS_BODY_PAINS_NO  = "bodyPainNo";
    public static final String HAS_HEADACHE_YES  = "headAcheYes";
    public static final String HAS_HEADACHE_NO  = "headAcheNo";
    public static final String HAS_FEVER_YES  = "feverYes";
    public static final String HAS_FEVER_NO  = "feverNo";
    public static final String CLOSE_CASE_CONTACT_YES  = "closeCaseContactYes";
    public static final String CLOSE_CASE_CONTACT_NO  = "closeCaseContactNo";
    public static final String CLOSE_SYMPTOM_CONTACT_YES   = "closeSymptomContactYes";
    public static final String CLOSE_SYMPTOM_CONTACT_NO  = "closeSymptomContactNo";
    public static final String INTERNATIONAL_TRAVEL_YES  = "internationalTravelYes";
    public static final String INTERNATIONAL_TRAVEL_NO  = "internationalTravelNo";
    public static final String DOMESTIC_TRAVEL_YES  = "domesticTravelYes";
    public static final String DOMESTIC_TRAVEL_NO  = "domesticTravelNo";
    public static final String DELIVERY_YES  = "deliveryYes";
    public static final String DELIVERY_NO  = "deliveryNo";
    public static final String GROCERY_YES  = "groceryYes";
    public static final String GROCERY_NO  = "groceryNo";
    public static final String COMPANY_ADDRESS_DIV  = "officialAdditionalForm";
    public static final String GROCERY_DIV  = "groceryWhen";
    public static final String GROCERY_DATE  = "groceryDate";




    public static String NATURE_OF_VISIT ="";
    public static  String HAS_SORE_THROAT = "";
    public static  String HAS_BODY_PAINS = "";
    public static  String HAS_HEADACHE = "";
    public static  String HAS_FEVER = "";
    public static  String HAS_CLOSE_CASE_CONTACT = "";
    public static  String HAS_CLOSE_SYMPTOM_CONTACT = "";
    public static  String HAD_INTERNATIONAL_TRAVEL = "";
    public static  String HAD_DOMESTIC_TRAVEL = "";
    public static  String HAS_DELIVERY = "";
    public static  String HAD_GROCERY = "";

    public static final String html_string ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "    <head>\n" +
            "        <!-- meta tags -->\n" +
            "        <meta name=\"description\" content=\"Sample form for android autofill\">\n" +
            "        <!-- site info -->\n" +
            "        <title> GTI Contact Tracing Form </title>\n" +
            "        <script src=\"/index.js\" defer></script>\n" +
            "    </head>\n" +
            "    <body onload=\"defaultConfig()\">\n" +
            "        <h1>GTI COVID-19 Contact Tracing Form</h1>\n" +
            "        <form id=\"tracingForm\">\n" +
            "            <div>\n" +
            "                <label for=\"temperature\">Temperature:</label>\n" +
            "                <input type=\"text\" id=\"temperature\" name=\"temperature\" value=\"\">\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <div>\n" +
            "                <label for=\"name\">Name:</label>\n" +
            "                <input type=\"text\" name=\"name\" id=\"name\" value=\"\">\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <div>\n" +
            "                <label for=\"residence\">Residence:</label>\n" +
            "                <input type=\"text\" name=\"residence\" id=\"residence\" value=\"\">\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <div>\n" +
            "                <label for=\"natureOfVisit\">Nature of visit:</label>\n" +
            "                <input type=\"radio\" name=\"natureOfVisit\" id=\"official\" value=\"official\" onchange=\"showOfficialForm(true)\"> Official\n" +
            "                <input type=\"radio\" name=\"natureOfVisit\" id=\"personal\" value=\"personal\" onchange=\"showOfficialForm(false)\"> Personal\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <div id=\"officialAdditionalForm\">\n" +
            "                <div>\n" +
            "                    <label for=\"companyName\">Company Name:</label>\n" +
            "                    <input type=\"text\" name=\"companyName\" id=\"companyName\">\n" +
            "                </div>\n" +
            "                <br>\n" +
            "                <div>\n" +
            "                    <label for=\"companyAddress\">Company Address:</label>\n" +
            "                    <input type=\"text\" name=\"companyAddress\" id=\"companyAddress\">\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <h1>Health Checklist</h1>\n" +
            "            <div>\n" +
            "                <ol type=\"1\">\n" +
            "                    <li>\n" +
            "                        <b>Nakararanas ka ba ng: (Are you experiencing:)</b><br>\n" +
            "                        <ol type=\"a\">\n" +
            "                            <li>\n" +
            "                                Sore throat (pananakit ng lalamunan/masakit lumunok)\n" +
            "                                <input type=\"radio\" name=\"soreThroat\" id=\"soreThroatYes\" value=\"yes\"> Yes\n" +
            "                                <input type=\"radio\" name=\"soreThroat\" id=\"soreThroatNo\" value=\"no\"> No\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                Body pain (pananakit ng katawan)\n" +
            "                                <input type=\"radio\" name=\"bodyPain\" id=\"bodyPainYes\" value=\"yes\"> Yes\n" +
            "                                <input type=\"radio\" name=\"bodyPain\" id=\"bodyPainNo\" value=\"no\"> No\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                Headache (pananakit ng olo)\n" +
            "                                <input type=\"radio\" name=\"headAche\" id=\"headAcheYes\" value=\"yes\"> Yes\n" +
            "                                <input type=\"radio\" name=\"headAche\" id=\"headAcheNo\" value=\"no\"> No\n" +
            "                            </li>\n" +
            "                            <li>\n" +
            "                                Fever for the past few days (Lagnat sa nakalipas na mga araw)\n" +
            "                                <input type=\"radio\" name=\"fever\" id=\"feverYes\" value=\"yes\"> Yes\n" +
            "                                <input type=\"radio\" name=\"fever\" id=\"feverNo\" value=\"no\"> No\n" +
            "                            </li>\n" +
            "                        </ol>\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Have you worked together or stayed in the same close environment of a confirment covid-19 case? (May nakasama ka ba o nakatrabahong tao na kumpirmadong may COVID-19/may impeksyon ng coronavirus?)</b>\n" +
            "                        <input type=\"radio\" name=\"closeCaseContact\" id=\"closeCaseContactYes\" value=\"yes\"> Yes\n" +
            "                        <input type=\"radio\" name=\"closeCaseContact\" id=\"closeCaseContactNo\" value=\"no\"> No\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Have you had any contact with anyone with fever, cough, colds, and sore throat in the past 2 weeks? (Mayroon ka bang nakasama na mat lagnat, ubo, sipon, o sakit ng lalamunan sa nakalipas na dalawang linggo?</b>\n" +
            "                        <input type=\"radio\" name=\"closeSymptomContact\" id=\"closeSymptomContactYes\" value=\"yes\"> Yes\n" +
            "                        <input type=\"radio\" name=\"closeSymptomContact\" id=\"closeSymptomContactNo\" value=\"no\"> No\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Have you travelled outside of the Philippines in the last 12 days? (Ikaw ba ay nagbyahe sa labas ng Pilipinas sa nakalipas na 12 na araw?)</b>\n" +
            "                        <input type=\"radio\" name=\"internationalTravel\" id=\"internationalTravelYes\" value=\"yes\"> Yes\n" +
            "                        <input type=\"radio\" name=\"internationalTravel\" id=\"internationalTravelNo\" value=\"no\"> No\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Have you travelled to any area in NCR ased from your home? (Ikaw ba ay nagpunta sa iba pang parte ng NCR o Metro Manila bukod sa iyong bahay?)</b>\n" +
            "                        <input type=\"radio\" name=\"domesticTravel\" value=\"yes\" id=\"domesticTravelYes\"> Yes\n" +
            "                        <input type=\"radio\" name=\"domesticTravel\" value=\"no\" id=\"domesticTravelNo\"> No\n" +
            "                        <br>\n" +
            "                        <b>Specify (Sabihin kung saan:)</b>\n" +
            "                        <input type=\"text\" name=\"domesticTravelWhere\" id=\"domesticTravelWhere\">\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Sino sa inyo and nagsideline ng grab/lalamove (kotse, bisikleta, motorsiklo) o iba pang pagdedeliver noong nakaraang dalawang (2) buwan simula noong lockdown</b>\n" +
            "                        <input type=\"radio\" name=\"delivery\" id=\"deliveryYes\" value=\"yes\"> Yes\n" +
            "                        <input type=\"radio\" name=\"delivery\" id=\"deliveryNo\" value=\"no\"> No\n" +
            "                    </li>\n" +
            "                    <br>\n" +
            "                    <li>\n" +
            "                        <b>Sino sa inyo ang mga namamalengke?</b>\n" +
            "                        <input type=\"radio\" name=\"grocery\" id=\"groceryYes\" value=\"yes\" onchange=\"showgroceryWhenForm(true)\"> Yes\n" +
            "                        <input type=\"radio\" name=\"grocery\" id=\"groceryNo\" value=\"no\" onchange=\"showgroceryWhenForm(false)\"> No\n" +
            "                        <br>\n" +
            "                        <div id=\"groceryWhen\">\n" +
            "                            <b>Kailan ang huling petsa na kayo ay namalengke?</b>\n" +
            "                            <input type=\"date\" name=\"groceryDate\" id=\"groceryDate\">\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                </ol>\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <div>\n" +
            "                <label for=\"dateToday\">Date Filled Up:</label>\n" +
            "                <input type=\"date\" name=\"dateToday\" id=\"dateToday\">\n" +
            "            </div>\n" +
            "            <br>\n" +
            "            <br>\n" +
            "            <br>\n" +
            "            <button type=\"submit\">Save Data</button>\n" +
            "        </form>\n" +
            "        <div id=\"results\"></div>\n" +
            "    </body>\n" +
            "</html>";

    public static ArrayList<HTMLModel> getHtmlIds(){
        String[] data = html_string.split("<");
        ArrayList<HTMLModel> ids = new ArrayList<>();
        for(String string:data){
            if(getStringBetweenTwoChars(string,""," ").equals("input")){
                String id = getStringBetweenTwoChars(string,"id="," ");
                String type = getStringBetweenTwoChars(string,"type="," ");
                String name = getStringBetweenTwoChars(string,"name="," ");
                id = getRawHTMLString(id).trim();
                type = getRawHTMLString(type).trim();
                name = getRawHTMLString(name).trim();
                HTMLModel htmlModel = new HTMLModel();
                htmlModel.setId(id);
                htmlModel.setInputType(type);
                htmlModel.setName(name);

                ids.add(htmlModel);
            }

        }

        return ids;
    }
    private static String getRawHTMLString(String string){
        if(string.equals(""))
            return "";

        if(string.contains(">")){
            string = string.replace(">","");
        }
        string = string.replace("\"","");
        return string;

    }
    public static String getStringBetweenTwoChars(String input, String startChar, String endChar) {
        try {
            if(input == null || input.equals(""))
                return "";

            int start = input.indexOf(startChar);
            if (start != -1) {
                int end = input.indexOf(endChar, start + startChar.length());
                if (end != -1) {
                    return input.substring(start + startChar.length(), end);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input; // return null; || return "" ;
    }

    private static ArrayList<String> getHtmlInputTypes(){
        ArrayList<String> inputTypes = new ArrayList<>();
            inputTypes.add("button");
            inputTypes.add("checkbox");
            inputTypes.add("color");
            inputTypes.add("date");
            inputTypes.add("datetime-local");
            inputTypes.add("email");
            inputTypes.add("file");
            inputTypes.add("hidden");
            inputTypes.add("image");
            inputTypes.add("month");
            inputTypes.add("number");
            inputTypes.add("password");
            inputTypes.add("radio");
            inputTypes.add("range");
            inputTypes.add("reset");
            inputTypes.add("search");
            inputTypes.add("submit");
            inputTypes.add("tel");
            inputTypes.add("text");
            inputTypes.add("time");
            inputTypes.add("url");
            inputTypes.add("week");
            return inputTypes;

    }
}

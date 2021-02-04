package com.example.snap.Helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.snap.DataModel.CheckListAnswerModel;

import static com.example.snap.Helpers.HTMLIDHelper.*;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewHelper {
    public static final String WEB_URL = "192.168.1.251:5500";
    public static final String WEB_URL_DUMMY = "https://www.google.com/";
    private Context context;
    private CheckListAnswerModel checkList;


    public WebViewHelper(Context context) {
        this.context = context;
    }

    public WebView initWebViewSettings(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                //Load Dummy Data if no data is passed
                if (checkList == null)
                    checkList = getCheckListDataDummy();

                injectDataToHtml(webView, checkList);
            }
        });


        return webView;


    }

    public void loadUrl(WebView webView, String url) {
        webView.loadUrl(url);


    }

    private void injectDataToHtml(WebView webView, CheckListAnswerModel model) {


        //Nature of visit
        if (model.getNatureOfVisit().equals(CheckListAnswerModel.OFFICIAL_VISIT))
            NATURE_OF_VISIT = NATURE_OF_VISIT_OFFICIAL;
        else if (model.getNatureOfVisit().equals(CheckListAnswerModel.PERSONAL_VISIT)) {
            NATURE_OF_VISIT = NATURE_OF_VISIT_PERSONAL;
            model.setCompanyName("");
            model.setCompanyAddress("");
        }

        //Sore Throat
        if (model.isHasSoreThroat())
            HAS_SORE_THROAT = HAS_SORE_THROAT_YES;
        else if (!model.isHasSoreThroat())
            HAS_SORE_THROAT = HAS_SORE_THROAT_NO;
        //Body Pains
        if (model.isHasBodyPains())
            HAS_BODY_PAINS = HAS_BODY_PAINS_YES;
        else if (!model.isHasBodyPains())
            HAS_BODY_PAINS = HAS_BODY_PAINS_NO;
        //Headache
        if (model.isHasHeadache())
            HAS_HEADACHE = HAS_HEADACHE_YES;
        else if (!model.isHasHeadache())
            HAS_HEADACHE = HAS_HEADACHE_NO;
        //Fever
        if (model.isHasFeverPastFewDays())
            HAS_FEVER = HAS_FEVER_YES;
        else if (!model.isHasFeverPastFewDays())
            HAS_FEVER = HAS_FEVER_NO;

        //Close Case Contact
        if (model.isHaveWorkedInSameEnvtOfConfmCase())
            HAS_CLOSE_CASE_CONTACT = CLOSE_CASE_CONTACT_YES;
        else if (!model.isHaveWorkedInSameEnvtOfConfmCase())
            HAS_CLOSE_CASE_CONTACT = CLOSE_CASE_CONTACT_NO;
        //Close Symptom Contact
        if (model.isHaveHadContactWithSymptoms())
            HAS_CLOSE_SYMPTOM_CONTACT = CLOSE_SYMPTOM_CONTACT_YES;
        else if (!model.isHaveHadContactWithSymptoms())
            HAS_CLOSE_SYMPTOM_CONTACT = CLOSE_SYMPTOM_CONTACT_NO;
        //Travelled Outside of country
        if (model.isHasTraveledOutsideOfPh())
            HAD_INTERNATIONAL_TRAVEL = INTERNATIONAL_TRAVEL_YES;
        else if (!model.isHasTraveledOutsideOfPh())
            HAD_INTERNATIONAL_TRAVEL = INTERNATIONAL_TRAVEL_NO;
        //Travelled any part of NCR
        if (model.isHaveTravelledAroundNcr())
            HAD_DOMESTIC_TRAVEL = DOMESTIC_TRAVEL_YES;
        else if (!model.isHaveTravelledAroundNcr())
            HAD_DOMESTIC_TRAVEL = DOMESTIC_TRAVEL_NO;
        //Travelled any part of NCR
        if (model.isHaveASLineOfDlvry())
            HAS_DELIVERY = DELIVERY_YES;
        else if (!model.isHaveASLineOfDlvry())
            HAS_DELIVERY = DELIVERY_NO;
        //Travelled any part of NCR
        if (model.isHaveGoneToWetMarket())
            HAD_GROCERY = GROCERY_YES;
        else if (!model.isHaveGoneToWetMarket())
            HAD_GROCERY = GROCERY_NO;


        webView.loadUrl("javascript:(function()" +
                "{" +
                "document.getElementsByName('" + NAME + "')[0].value='" + model.getName() + "';" +
                "document.getElementsByName('" + TEMP + "')[0].value='" + model.getTemperature() + "';" +
                "document.getElementsByName('" + RESIDENCE + "')[0].value='" + model.getResidence() + "';" +
                "document.getElementById('" + NATURE_OF_VISIT + "').checked = true;" +
                "document.getElementsByName('" + COMPANY_NAME + "')[0].value='" + model.getCompanyName() + "';" +
                "document.getElementsByName('" + COMPANY_ADDRESS + "')[0].value='" + model.getCompanyAddress() + "';" +
                "document.getElementById('" + HAS_SORE_THROAT + "').checked = true;" +
                "document.getElementById('" + HAS_BODY_PAINS + "').checked = true;" +
                "document.getElementById('" + HAS_HEADACHE + "').checked = true;" +
                "document.getElementById('" + HAS_FEVER + "').checked = true;" +
                "document.getElementById('" + HAS_CLOSE_CASE_CONTACT + "').checked = true;" +
                "document.getElementById('" + HAS_CLOSE_SYMPTOM_CONTACT + "').checked = true;" +
                "document.getElementById('" + HAD_INTERNATIONAL_TRAVEL + "').checked = true;" +
                "document.getElementById('" + HAD_DOMESTIC_TRAVEL + "').checked = true;" +
                "document.getElementById('" + HAS_DELIVERY + "').checked = true;" +
                "document.getElementById('" + HAD_GROCERY + "').checked = true;" +

                "if(" + model.getNatureOfVisit().equals(CheckListAnswerModel.PERSONAL_VISIT) + ")" +
                "{" +
                " document.getElementById('" + COMPANY_ADDRESS_DIV + "').style.display = 'none';" +
                "} " +
                "   else{" +
                " document.getElementById('" + COMPANY_ADDRESS_DIV + "').style.display = 'block';" +

                "}" +
        "if(" + model.isHaveGoneToWetMarket() + ")" +
                "{" +
                " document.getElementById('" + GROCERY_DIV + "').style.display = 'block'; " +
                "document.getElementsByName('" + GROCERY_DATE + "')[0].value= '" + model.getHaveGoneToWetMarketAnswer() +"' ;"+
                "} " +
                "   else{" +
                " document.getElementById('" + GROCERY_DIV + "').style.display = 'none';" +
                "}" +



                "})()"
        );
//

    }

    private CheckListAnswerModel getCheckListDataDummy() {
        CheckListAnswerModel model = new CheckListAnswerModel();
        model.setName("Matt");
        model.setTemperature(35);
        model.setResidence("Manila City");
        model.setNatureOfVisit(CheckListAnswerModel.OFFICIAL_VISIT);
        model.setCompanyName("AIX");
        model.setCompanyAddress("Manila City");
        model.setHasSoreThroat(false);
        model.setHasBodyPains(true);
        model.setHasHeadache(false);
        model.setHasFeverPastFewDays(true);
        model.setHaveWorkedInSameEnvtOfConfmCase(false);
        model.setHaveHadContactWithSymptoms(true);
        model.setHasTraveledOutsideOfPh(false);
        model.setHaveTravelledAroundNcr(true);
        model.setHaveASLineOfDlvry(false);
        model.setHaveGoneToWetMarket(true);
        model.setHaveGoneToWetMarketAnswer("2021-01-23");


        return model;

    }

    public void setCheckList(CheckListAnswerModel checkList) {
        this.checkList = checkList;
    }


}

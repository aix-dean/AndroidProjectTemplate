package com.example.snap.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.snap.Helpers.WebViewHelper;
import com.example.snap.databinding.FragmentWebviewBinding;

public class WebViewFragment extends Fragment {
    private FragmentWebviewBinding binder;
    private WebView webView;
    private WebViewHelper webViewHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binder = FragmentWebviewBinding.inflate(inflater,container,false);
            return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = binder.webView;
        webViewHelper = new WebViewHelper(requireContext());

        Bundle bundle = getArguments();
        if(bundle != null) {
            String scannedUrl = bundle.getString(MainDashboardFragment.SCANNED_QR,"");
            System.out.println("URL TO LOAD: " + scannedUrl);
            webViewHelper.loadUrl(webViewHelper.initWebViewSettings(webView),scannedUrl);

        }






    }
}

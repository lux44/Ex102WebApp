package com.lux.ex102webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val wv:WebView by lazy { findViewById(R.id.wv) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 기본적으로 WebView 는 JavaScript 실행을 허용하지 않음.
        // 웹뷰 설정객체를 통해 JS 사용을 허용하도록 변경
        wv.settings.javaScriptEnabled=true

        // 웹뷰 사용할 때 필수 설정값 2가지
        // 1. 예전에는 새로운 웹 문서를 열때 무조건 이 웹뷰를 사용하지 않고
        //    디바이스의 웹브라우저앱(크롬 등)이 실행되면서 열림.
        //    그래서 이 웹뷰 안에서 열리도록 설정
        wv.webViewClient = WebViewClient()

        // 2. alert()이나 새로운 다이얼로그같은 팝업이 보이도록
        wv.webChromeClient= WebChromeClient()

        // 웹뷰가 보여줄 웹 문서(.html) 로드하기
        // 오프라인 상태일때도 화면이 보이고 싶다면 html 문서가 이 프로젝트 폴더 안에 위치해야 함
        // res 폴더는 html 을 저장하는 용도의 창고가 아님. 그래서 다른 창고(assets)를 사용.
        wv.loadUrl("file:///android_asset/index.html")
        // 당연히 별도 서버 호스트의 html 문서도 볼 수 있음.
        wv.loadUrl("http://wearegroot.dothome.co.kr")
    }

    override fun onBackPressed() {
        if(wv.canGoBack()) wv.goBack()
        else super.onBackPressed()
    }
}
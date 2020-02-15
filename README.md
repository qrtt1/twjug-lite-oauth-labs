# OAuth Labs

這是 twjug-lite 的 OAuth Authorization Code Flow 的 workshop 練習專案。

## 準備工作

* 背景知識 [OAuth 2.0 and OpenID Connect (in plain English)](https://www.youtube.com/watch?v=996OiexHze0&feature=youtu.be)
  * [投影片](https://speakerdeck.com/nbarbettini/oauth-and-openid-connect-in-plain-english)
  * [TWJUG-LITE: 電影欣賞 timecode 筆記](https://medium.com/@qrtt1/%E9%9B%BB%E5%BD%B1%E6%AC%A3%E8%B3%9E-oauth-2-0-and-openid-connect-in-plain-english-787d0937e442)

* 實作準備
  * OAuth 2.0 Provider。請準備一個已認證的 [GitHub](https://github.com/) Account，我們將使用它作為練習的對象。
  * 請註冊並下載 [ngrok](https://ngrok.com/)，我們將用它來發佈開發中的 Spring Web。

* 專案架構，我們使用 [start.spring.io](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.2.4.RELEASE&packaging=jar&jvmVersion=1.8&groupId=twjug.lite&artifactId=oauth&name=oauth&description=Demo%20project%20for%20Spring%20Boot&packageName=twjug.lite.oauth&dependencies=devtools,web,thymeleaf) 建立專案基礎架構：
    * Spring Boot DevTools
    * Spring Web
    * Thymeleaf
* [gitignore 設定](https://www.gitignore.io/api/java,gradle,java-web,intellij)


package com.example;

/**
 * config.json の内容をそのまま Java オブジェクトとして表すクラス。
 *
 * Gson は「フィールド名」と「JSON のキー名」を自動で対応付ける。
 * たとえば JSON の "appName" はこのクラスの appName フィールドに入る。
 * このような変換を「デシリアライズ（Deserialization）」と呼ぶ。
 */
public class AppConfig {

    // config.json の "appName" キーと対応する
    private String appName;

    // config.json の "version" キーと対応する
    private String version;

    // config.json の "maxRecords" キーと対応する
    private int maxRecords;

    // --- Getter メソッド ---
    // Gson はデシリアライズ時に直接フィールドに書き込むため、
    // Setter は不要。読み取り用の Getter だけ定義する。

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public int getMaxRecords() {
        return maxRecords;
    }
}

package com.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
  public static void main(String[] args) throws IOException {
    Path configPath = Paths.get("config.json");

    if (!Files.exists(configPath)) {
      System.err.println("エラー: config.json が見つかりません。");
      System.err.println("実行ディレクトリ: " + Paths.get(".").toAbsolutePath());
      System.err.println("ヒント: ZIP を展開したフォルダ内で java -jar コマンドを実行してください。");
      System.exit(1);
    }

    String json = Files.readString(configPath);
    Gson gson = new Gson();
    AppConfig config = gson.fromJson(json, AppConfig.class);

    new SalesReporter(config).run();
  }
}

package com.example;

public class SalesReporter {
  private final AppConfig config;

  public SalesReporter(AppConfig config) {
    this.config = config;
  }

  public void run() {
    System.out.println("=== " + config.getAppName() + " v" + config.getVersion() + " 起動 ===");
    System.out.println("処理上限: " + config.getMaxRecords() + " 件");
    for (int i = 1; i <= config.getMaxRecords(); i++) {
      System.out.printf("  [%03d] 売上レコード処理完了%n", i);
    }
    System.out.println("=== 処理完了 ===");
  }
}

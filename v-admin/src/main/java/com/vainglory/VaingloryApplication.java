package com.vainglory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaingloryApplication {
  public static void main(String[] args) {
    // System.setProperty("spring.devtools.restart.enabled", "false");
    SpringApplication.run(VaingloryApplication.class, args);
    System.out.println("虚荣启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    String logo = """
      .-. .-.  .--.  .-..-. .-. .---. .-.    .----. .----..-.  .-.
      | | | | / {} \\ | ||  `| |/   __}| |   /  {}  \\| {}  }\\ \\/ /\s
      \\ \\_/ //  /\\  \\| || |\\  |\\  {_ }| `--.\\      /| .-. \\ }  { \s
       `---' `-'  `-'`-'`-' `-' `---' `----' `----' `-' `-' `--' \s
      """;
    System.out.println("logo\n");
  }
}

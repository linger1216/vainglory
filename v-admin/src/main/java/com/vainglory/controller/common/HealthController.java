package com.vainglory.controller.common;

import com.vainglory.common.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
  /**
     * 通用健康检查接口
     */
    @GetMapping("/healthcheck")
    public AjaxResult healthcheck() {
      AjaxResult ret = AjaxResult.success();
      ret.put("status", "UP");
      return ret;
    }
}

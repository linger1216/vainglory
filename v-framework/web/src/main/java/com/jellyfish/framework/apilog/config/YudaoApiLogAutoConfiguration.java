package com.jellyfish.framework.apilog.config;

import com.jellyfish.common.enums.WebFilterOrderEnum;
import com.jellyfish.framework.apilog.core.filter.ApiAccessLogFilter;
import com.jellyfish.framework.apilog.core.interceptor.ApiAccessLogInterceptor;
import com.jellyfish.framework.apilog.core.service.ApiAccessLogApi;
import com.jellyfish.framework.web.config.YudaoWebAutoConfiguration;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration(after = YudaoWebAutoConfiguration.class)
public class YudaoApiLogAutoConfiguration implements WebMvcConfigurer {

  /**
   * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
   */
  @Bean
  @ConditionalOnProperty(prefix = "yudao.access-log", value = "enable", matchIfMissing = true)
  // 允许使用 yudao.access-log.enable=false 禁用访问日志
  public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                       @Value("${spring.application.name}") String applicationName,
                                                                       ApiAccessLogApi apiAccessLogApi) {
    ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogApi);
    return createFilterBean(filter, WebFilterOrderEnum.API_ACCESS_LOG_FILTER);
  }

  private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
    FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
    bean.setOrder(order);
    return bean;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ApiAccessLogInterceptor());
  }

}

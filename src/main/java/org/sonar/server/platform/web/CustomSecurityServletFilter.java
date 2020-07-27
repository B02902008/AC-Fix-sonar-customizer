package org.sonar.server.platform.web;

import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomSecurityServletFilter implements Filter {
  private static final Set<String> ALLOWED_HTTP_METHODS = ImmutableSet.of("DELETE", "GET", "HEAD", "POST", "PUT");
  @Override
  public void init(FilterConfig filterConfig) { }
  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    doHttpFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain);
  }
  @Override
  public void destroy() { }
  private static void doHttpFilter(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain) throws IOException, ServletException {
    if (!ALLOWED_HTTP_METHODS.contains(httpRequest.getMethod())) {
      httpResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return;
    }
    String origin = String.format("http://%s:%s", Config.CLIENT_HOST, Config.CLIENT_PORT);
    httpResponse.addHeader("Content-Security-Policy", "frame-ancestors " + origin);
    httpResponse.addHeader("X-Frame-Options", "ALLOW-FROM " + origin);
    httpResponse.addHeader("X-XSS-Protection", "1; mode=block");
    httpResponse.addHeader("X-Content-Type-Options", "nosniff");
    chain.doFilter(httpRequest, httpResponse);
  }
}
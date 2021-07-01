####spring boot 整合 spring security oauth2 权限
本项目是授权服务器(oauth2-server)

## 根目录下 test.sql 为该项目 mysql 表数据

## 疑问解答
* 有同学问该项目是否需要redis？本项目使用了redis来缓存token信息，当然token信息也可以缓存到内存中（这种是不建议的做法），最好使用第三方组件来保存token信息

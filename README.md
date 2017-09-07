# spring-data-redis-demo
spring-data-redis操作数据的demo,包括相关配置，以及String,list,set,hash,zset这5种数据结构的基本操作
* 配置文件:/config/
* 代码实现:/repository/impl
* 测试:/test
## repository中根据redis的5种数据类型进行划分：
### ValueRepository 
String-字符串
### ListRepository
List-列表
### SetRepository
Set-集合
### HashRepository
Hash-哈希
### ZsetRepository
Zset-有序集合

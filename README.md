##毕业设计
毕业设计课题为:基于安卓的疾病药品自查app。
关于App最终实现的功能主要有两大模块：1.查找药品。2.查找疾病（有疾病详情，如症状，治疗方法，适用药品等，适用药品这一模块就是查找药品功能的子功能），意味着两大功能需要互相渗透。
tips:可以增加一个新闻模块，显示医疗类型的新闻,下拉刷新。
其余一些小的功能可以视时间而定，如头像上传，疾病收藏等，甚至可以有网页版的后台管理系统。
毕业设计项目需求

此文件为本次毕业设计的项目需求，所有关于毕业设计的需求分析和设计思路，在此文件记录。
本App将实现：与后台的数据交互，后台数据逻辑处理，前端（App）显示。
 后台：数据库用mysql 或者 oracle 初步打算用mysql，
	   服务器使用tomcat，
	   后台返回数据一律用json格式
	   
需求1：实现登录功能,后台需要有张用户表,字段为_userid,password,长度15----->因为目前想法是用户可以收藏药品信息和疾病信息,方便下次查看,不用再次查找
...
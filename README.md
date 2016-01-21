
#毕业设计
##毕业设计课题为:基于安卓的疾病药品自查app。
关于App最终实现的功能主要有两大模块：1.查找药品。2.查找疾病（有疾病详情，如症状，治疗方法，适用药品等，适用药品这一模块就是查找药品功能的子功能），意味着两大功能需要互相渗透。
tips:可以增加一个新闻模块，显示医疗类型的新闻,下拉刷新。
其余一些小的功能可以视时间而定，如头像上传，疾病收藏等，甚至可以有网页版的后台管理系统。
毕业设计项目需求

此文件为本次毕业设计的项目需求，所有关于毕业设计的需求分析和设计思路，在此文件记录。
本App将实现：与后台的数据交互，后台数据逻辑处理，前端（App）显示。
 后台：*数据库用mysql 或者 oracle 初步打算用mysql，
	   *服务器使用tomcat，
	   *后台返回数据一律用json格式
	   
需求1：实现登录功能,后台需要有张用户表,字段为_userid,password,长度15----->因为目前想法是用户可以收藏药品信息和疾病信息,方便下次查看,不用再次查找
...

2016/1/11
上网找了一些接口，药品分类，药品信息，药品价格等的一个接口，并且写了一些json数据获取的代码，主要用的开源项目retrofit，
在IMedicalService类里面的header的用法是 @Headers({Key：Value})的方式，下一步计划继续完成药品查询这块的代码,先用第三方的api
把ui先做出来，以后如果还有时间可以尝试用自己写的api。  
  
  
2016/1/19
这一个礼拜都在学习后台相关技术，现在在学mysql数据库，一年多前其实已经学过，但是因为用的不多所有有些生疏现在就当复习，
后续还会学习spring ,mybatis,hibernate，MVC等。这样看来,毕业设计的后台应该是用自己搭的服务器了。今天使用了一个比较陌生的控件ExpanableListView;
效果还不错，类似于ListView，区别在ExpanableListView是一个二维列表，利用其一级目录作为分类，二级目录显示分类下的具体部位，例如，头部->分为头，鼻，耳朵...等，并且找到了一个pulltorefreshlistview的bug，调用pulltorefreshlistview.onrefreshcomplete()无效，做的处理是在调用之前延时一点时间。
  
2016/1/20
今天为了提高使用体验，先使用了一个弹性ScrollView，这个空间是模仿的ios系统上的原声控件，安卓没有，所以需要对安卓原生控件ScrollView进行一些改写
。另外，添加了两个搜索功能，通过药品关键字、疾病关键字搜索相关的药品、疾病。并且显示其具体的信息，使用了第三方API时发现了第三方给的JSON数据格式非常非常不同意，而且同一请求不同情况下返回的字段也不同，使得在实体类和接口定义的时候不得不多加一些字段，所以决定寒假一定要把后台学号，下学期开始自己搭建后台，返回格式同一的JSON数据。
  
2016/1/21
今天都在看《github入门与实践》这本书....收益颇丰 
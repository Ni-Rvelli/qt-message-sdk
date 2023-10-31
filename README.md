将qt包引入当前maven

    mvn install:install-file -Dfile=E:\quickaplus-log-collector-java-sdk-1.0.1-SNAPSHOT.jar -DgroupId=com.nr -DartifactId=quickaplus-log-collector-java-sdk -Dversion=1.0.1-SNAPSHOT -Dpackaging=jar

当前项目打包后引入新项目

    mvn install:install-file -Dfile=E:\x-third-message-sdk-1.0.1-SNAPSHOT.jar -DgroupId=com.nd -DartifactId=third-message-sdk -Dversion=1.0.1-SNAPSHOT -Dpackaging=jar

-----------------------------------------------------------------------------------------------
使用示例

    手动引入jar包「x-third-message-sdk-1.0.1-SNAPSHOT.jar」
    
    引入示例：
    mvn install:install-file
    -Dfile=E:\x-third-message-sdk-1.0.1-SNAPSHOT.jar
    -DgroupId=com.nr
    -DartifactId=third-message-sdk
    -Dversion=1.0.1-SNAPSHOT
    -Dpackaging=jar
    
    添加对应的依赖
    <!-- 下面为导入的jar包依赖，根据导入参数可调整!-->
    <dependency>
        <groupId>com.nr</groupId>
        <artifactId>third-message-sdk</artifactId>
        <version>1.0.1-SNAPSHOT</version>
    </dependency>
    <!-- 下面为相关依赖，视项目情况添加!-->
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.9.1</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.83</version>
    </dependency>
    <dependency>
    <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.12.0</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.30</version>
    </dependency>

运用示例

    1、初始化配置（项目启动的时候初始化一次即可）
    String clientId = "350322"; 			//通用参数 client_id，该参数由外部(区域平台)传入
    NrMessageConfig config = new NrMessageConfig();
    config.setAppKey("xxxxxxxxxx");  						//您的appKey
    config.setServiceId("xxxxxxxxxx");						//您的ServiceId
    config.setServiceSecret("xxxxxxxxxx");					//您的ServiceSecret
    config.setQlcEndpoint("https://xxxxxxxxxx");			//您的收数域名
    config.setOpenLod(true); 								//是否开启日志
    NrThirdMessageService.initConfig(clientId, config);
    
    2、事件上报示例
    public static void main(String[] args) {
    // 设置事件属性
    Map<String, Object> customProperty = new HashMap<>();
    customProperty.put("carrierId","123");
    customProperty.put("clientVersion", "13333");
    customProperty.put("contentId", "V123456789");
    customProperty.put("contentName", "1.三年级上册学习导引");
    customProperty.put("deviceType", "ABC-AAA2");
    customProperty.put("grade", "三年级");
    customProperty.put("productType", "OTY");
    customProperty.put("programeName", "语文");
    customProperty.put("startTime", "2023-09-18 15:01:38.038");
    customProperty.put("endTime", "2023-09-18 15:01:42.042");
    customProperty.put("playTime", "3");
    // 设置系统属性
    Map<String, Object> systemProperty = new HashMap<>();
    //systemProperty.put("date",new Date());
    // 设置系统属性的设备标识
    Map<String, String> idTracking = new HashMap();
    idTracking.put("ios", "12341513245613");
    // 构造日志对象
    NrMessageLog log = new NrMessageLog.Builder()
    .eventId("order_success_new")           //事件编码（必填）
    .deviceId("dev-001")                //设置设备ID（设备ID和账号ID必填一个）
    .userId("666640020100277")          //设置账号ID（设备ID和账号ID必填一个）
    .pageName("pageName")               //设置页面编码（选填）
    .customProperty(customProperty)		//设置事件属性（选填）
    .systemProperty(systemProperty)		//设置系统属性（选填）
    .idTracking(idTracking)             //设置系统属性的设备标识
    .debugKey("dk-0001")                //设置埋点验证标志位（选填）
    .eventTimestamp(System.currentTimeMillis())   //设置客户端时间戳（必填）
    .serverTimestamp(System.currentTimeMillis())  //设置服务端时间戳（可选）
    .uuid(UUID.randomUUID().toString()) //设置事件日志唯一标识，用于生成log_id
    .build();
    NrThirdMessageService.syncSendLog(log);
    }
    
    3、全局参数设置（按需）
    public void testGlobalProperties() {
        // 添加全局参数
        Map<String, Object> addProperties = new HashMap<>(8);
        addProperties.put("date", new Date());
        addProperties.put("name", "大白公司");
        NrThirdMessageService.addGlobalProperties(addProperties);
        // 删除全局参数
        NrThirdMessageService.removeGlobalProperties(Arrays.asList("date"));
        // 获取全局参数
        Map<String,Object> allProperties = NrThirdMessageService.getAllGlobalProperties();
        // 清空全局参数
        NrThirdMessageService.clearGlobalProperties();
    } 
"# qt-message-sdk" 

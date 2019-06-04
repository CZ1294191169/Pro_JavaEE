package com.cs.meet.controller;

import com.alibaba.fastjson.JSONObject;
import com.cs.meet.dto.*;
import com.cs.meet.entity.Affairs_table;
import com.cs.meet.entity.Message_log;
import com.cs.meet.entity.User_info;
import com.cs.meet.services.*;
import com.cs.meet.services.servicesImpl.UserserImpl;
import com.cs.meet.util.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.catalina.User;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.aspectj.asm.AsmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserserImpl userser;

    @Autowired
    UserinfoServices userinfoServices;

    @Autowired
    DepartmentServices departmentServices;

    @Autowired
    com.cs.meet.services.affairsServices affairsServices;

    @Autowired
    MessageServices messageServices;

    @Autowired
    affpeoService affpeopleServices;


    Random random = new Random();



    @GetMapping("/init")
    public Map<String, Object> initInfo(HttpSession session) {
        System.out.println("init into!");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User_info user_info = (User_info) session.getAttribute("user");
        try {
            if (user_info != null) {
                System.out.println("user_info session is not null");
                User_info info = userser.findByUserCode(user_info.getUserCode());

                if (info != null) {
                    System.out.println("info  is not null");
                    modelMap.put("success", true);
                    modelMap.put("user", info);
                    modelMap.put("date", DateUtil.Convertdatetoymd(info.getJobJointime()));
                } else {
                    System.out.println("info not null");
                }
            } else {
                System.out.println("user_info session is null");
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "userinfo为空");
        }

        return modelMap;

    }

    @GetMapping("/getUserListPage")
    public List<UserMeetCondition> GetDatawithinuser(HttpServletRequest request,
                                           HttpSession session) throws Exception {

        System.out.println("hey im in getUserListPage!");

        User_info user_info = (User_info) session.getAttribute("user");
        User_info info = userser.findByUserCode(user_info.getUserCode());
        List<Object[]> list = userinfoServices.selectByempCode();

        if(list.size()!=0) {
            List<UserMeetCondition> userMeetConditionList = convertUtil.castEntity(list, UserMeetCondition.class);
            return userMeetConditionList;
        }
        else
        {
            List<UserMeetCondition> userMeetConditions=null;
            return userMeetConditions;
        }

        //PageHelper.startPage(pageNumber,pageSize);



    }
    @GetMapping("/getDepartmentListPage")
    public List<DepartmentMeetCondition> GetDatawithindepartment(HttpServletRequest request,
                                                 HttpSession session) throws Exception {

        System.out.println("hey im in getDepartmentListPage!");

        User_info user_info = (User_info) session.getAttribute("user");
        User_info info = userser.findByUserCode(user_info.getUserCode());
        List<Object[]> list = userinfoServices.selectByCode(info.getDepartmentId());
        if(list.size()!=0) {
            List<DepartmentMeetCondition> departmentMeetConditionList = convertUtil.castEntity(list, DepartmentMeetCondition.class);
            return departmentMeetConditionList;
        }
        else
        {
            List<DepartmentMeetCondition> departmentMeetConditionList=null;
            return departmentMeetConditionList;
        }

        //PageHelper.startPage(pageNumber,pageSize);



    }

    @GetMapping("/event")
    public JSONObject getcal(HttpServletRequest request,HttpSession session) throws Exception {

        User_info user_info = (User_info) session.getAttribute("user");
        User_info info = userser.findByUserCode(user_info.getUserCode());
        JSONObject result = new JSONObject();
//        result.put("title", "生物信息");
//        String date =
//                String.valueOf(new Date(2019,8,9,12,00,30));
//        String enddate =
//                String.valueOf(new Date(2019,8,9,15,00,30));
//
//        Map<String,Object> hashMap = new HashMap<>();
//        result.put("start", date);
//        result.put("end", enddate);

        List<Object[]> list = userinfoServices.selectByuserId(info.getUserId());
        List<Calendercondition> calenderconditions = convertUtil.castEntity(list, Calendercondition.class);

        System.out.println("calenderconditions"+calenderconditions.size());

        List<Calfinalcondition> calendars = new ArrayList<>();

        for(int i=0;i<calenderconditions.size();i++){

            calendars.add(new Calfinalcondition(calenderconditions.get(i).title,DateUtil.ConvertTimeStamptodate(calenderconditions.get(i).start),DateUtil.ConvertTimeStamptodate(calenderconditions.get(i).end)));

        }

        result.put("data",calendars);
        return result;

    }

    @PostMapping("/update")
    public Map<String,Object> UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws FileNotFoundException {
        Map<String,Object> modelmap= new HashMap<>();
        User_info user_info = new User_info();
       User_info userInfo = new User_info();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());

        String changeinfo = HttpServletUtil.getString(request,"changeinfo");

        ObjectMapper mapper = new ObjectMapper();

        Userinfocondition userinfocondition=null;
        try {
            userinfocondition = mapper.readValue(changeinfo,Userinfocondition.class);
            userInfo.setUserId(user_info.getUserId());
            user_info.setUserName(userinfocondition.getUserName());
            user_info.setLoginPassword(userinfocondition.getLoginPassword());
            user_info.setPersonEmail(userinfocondition.getPersonEmail());
            user_info.setPersonPhone(userinfocondition.getPersonPhone());

            userinfoServices.save(user_info);

            modelmap.put("success",true);

        }catch (Exception e){
            modelmap.put("success",false);
            modelmap.put("errMsg",e.getMessage());
        }

        return modelmap;
    }

    @PostMapping("/updateIcon")
    public Map<String,Object> UpdateIcon(HttpServletRequest request, @RequestParam("file1") MultipartFile file, HttpSession session) throws IOException {

        Map<String ,Object> modelmap = new HashMap<>();
        User_info user_info = new User_info();
        User_info userInfo = new User_info();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        String filename = HttpServletUtil.getString(request,"filename");

       if(file.isEmpty()){
           System.out.println("nothing?");
       }
       else{
           String[] fileNameSpliteArray=null;
           String fileName = file.getOriginalFilename();
           System.out.println("文件大小为"+file.getSize());
           if(fileName.indexOf(".")>0){
               fileNameSpliteArray = fileName.split("\\.");
           }
           fileName=user_info.getEmpCode()+"icon"+".jpg";
            File path = new File(ResourceUtils.getURL("").getPath());//获取Spring boot项目的根路径，在开发时获取到的是/target/classes/
            System.out.println(path.getPath());//如果你的图片存储路径在static下，可以参考下面的写法
            File uploadFile = new File(path.getAbsolutePath(), "src/main/resources/static/UserIcon/"+fileName);//开发测试模式中 获取到的是/target/classes/static/images/upload/
            if (!uploadFile.getParentFile().exists()){
                uploadFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(uploadFile);


                modelmap.put("success",true);
            }catch (IOException e){
                e.printStackTrace();
                modelmap.put("success",false);
            }


       }

//        if(file!=null) {
//            FileUtil.deleteFileAndPath(user_info.getLoginIcon());
//            String originalFilename = file.getOriginalFilename();
//            String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
//
//            File path = new File(ResourceUtils.getURL("").getPath());//获取Spring boot项目的根路径，在开发时获取到的是/target/classes/
//            System.out.println(path.getPath());//如果你的图片存储路径在static下，可以参考下面的写法
//            File uploadFile = new File(path.getAbsolutePath(), "src/main/resources//static/UserIcon/"+user_info.getEmpCode()+"icon"+"/");//开发测试模式中 获取到的是/target/classes/static/images/upload/
//            if (!uploadFile.exists()){
//                uploadFile.mkdirs();
//            }
//        }


        return modelmap;
    }



    /*用户上传文件*/
    @PostMapping("/updateFile")
    public JSONObject update(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        JSONObject result = new JSONObject();
        request.setCharacterEncoding("UTF-8");

        InputStream inputStream;
        String returnPath = "";

        User_info user_info = new User_info();

        user_info = (User_info)session.getAttribute("user");

        Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map = multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            Object obj = i.next();
            multipartFile = (MultipartFile) map.get(obj);
        }
        System.out.println(multipartFile.getOriginalFilename());

        inputStream = multipartFile.getInputStream();

        String filename = multipartFile.getOriginalFilename();
        File path = new File(ResourceUtils.getURL("").getPath());//获取Spring boot项目的根路径，在开发时获取到的是/target/classes/
        System.out.println(path.getPath());//如果你的图片存储路径在static下，可以参考下面的写法
        File uploadFile = new File(path.getAbsolutePath(), "src/main/resources/static/FILE/meetfile/upload"+user_info.getUserCode()+"/");//开发测试模式中 获取到的是/target/classes/static/images/upload/
        if (!uploadFile.exists()){
            uploadFile.mkdirs();
        }
        //获取文件后缀名
        String end = FileUtil.getextension(filename) ;
        String diskFileName = FileUtil.getrealname()  +end; //目标文件的文件名
        String pathname = uploadFile.getPath() + "/" + diskFileName;
        System.out.println(pathname);
        multipartFile.transferTo(new File(pathname));//文件转存
        String returnpath="meetfile/upload"+user_info.getUserCode()+"/"+diskFileName;
        JSONObject object = new JSONObject();
        object.put("success",true);
        object.put("data",new com.cs.meet.entity.File(returnpath,new Date()));
        return object;
    }

    @RequestMapping(value = "/Download", method = RequestMethod.GET)
    public void testDownload(HttpServletResponse res,HttpServletRequest request) {
        String filename = request.getParameter("file");
        String userName = request.getParameter("userName");

        try {
            File file=new File("src/main/resources/static/"
                    + filename);

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream("src/main/resources/static/"
                    + filename));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            res.reset();

            res.setContentType("application/octet-stream;charset=UTF-8");
            String fileName = new String(filename.getBytes("gb2312"), "iso8859-1");
            res.setHeader("Content-disposition", "attachment;filename=" + fileName);
            OutputStream ouputStream = res.getOutputStream();
            ouputStream.write(buffer);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    @GetMapping("/usermanagement")
    public List<UserFullmessagecondition>userManagement(HttpSession session,HttpServletRequest request) throws Exception {


        List<Object[]> list = userinfoServices.GetfullUser();

        List<UserFullmessagecondition> userFullmessageconditions = convertUtil.castEntity(list,UserFullmessagecondition.class);

        System.out.println(userFullmessageconditions.get(0).getDepartmentName());
        return userFullmessageconditions;
    }

    @GetMapping("/GetDepartments")
    public List<Userdepartmentcondition> Getdepartments(HttpSession session,HttpServletRequest request) throws Exception {
        List<Object[]> userdepartmentconditionList= departmentServices.findDepartment();
        List<Userdepartmentcondition> list = convertUtil.castEntity(userdepartmentconditionList,Userdepartmentcondition.class);

        return list;
    }

    @GetMapping("/meetappList")
    public List<getUserappList> meetappList(HttpSession session, HttpServletRequest request) throws Exception {
        Map<String,Object> modelmap = new HashMap<>();
        User_info userInfo = (User_info) session.getAttribute("user");
        userInfo = userinfoServices.findByUserCode(userInfo.getUserCode());
        List<getUserappList> getUserappLists=null;
        try {
            List<Object[]> list = affairsServices.GetAppListByUserId(userInfo.getUserId());
             getUserappLists= convertUtil.castEntity(list,getUserappList.class);
           // modelmap.put("success",true);

        }catch (Exception e){
            //modelmap.put("success",false);
            e.printStackTrace();
        }
        return getUserappLists;
    }

    @PostMapping("/affchange")
    public Map<String,Object> affChange(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        Map<String,Object> modelmap = new HashMap<>();
        User_info user_info = new User_info();
        Affairs_table affairs_table = new Affairs_table();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());



        String affchange = HttpServletUtil.getString(request,"affairschange");

        ObjectMapper mapper = new ObjectMapper();

        Affchangecondition affchangecondition;

        try{
            affchangecondition = mapper.readValue(affchange,Affchangecondition.class);
            affairs_table.setAffairsId(affchangecondition.getAffairsId());
            affairs_table = affairsServices.findById(affairs_table.getAffairsId()).get();
            affairs_table.setParticipate(affchangecondition.getParticipate());
            affairs_table.setRoomId(affchangecondition.getRoomId());
            affairs_table.setArrangementPeriodstart(affchangecondition.getArrangementPeriodstart());
            affairs_table.setArrangementPeriodend(affchangecondition.getArrangementPeriodend());

            affairsServices.save(affairs_table);
            modelmap.put("success",true);
        }catch (RuntimeException e){
            modelmap.put("success",false);
            modelmap.put("errMsg",e.getMessage());
        }





        return modelmap;
    }

    @PostMapping("/roleList")
    public Map<String,Object> getUserRoleList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User_info user_info = new User_info();
        Affairs_table affairs_table = new Affairs_table();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        Map<String,Object> modelmap = new HashMap<>();
        List<Affpeocondition> userInfoList = new ArrayList<>();
        List<Object[]> objects = userinfoServices.getAppUserList(user_info.getUserId(),user_info.getDepartmentId());
        userInfoList = convertUtil.castEntity(objects,Affpeocondition.class);
        try {
            modelmap.put("userInfoList",userInfoList);
            modelmap.put("success",true);

        }catch (Exception e){
            modelmap.put("success",false);
        }

        return modelmap;
    }

    @PostMapping("/updatestatus")
    public Map<String,Object>updateStatus(HttpSession session,@RequestBody JSONObject jsonParam)
    {
        User_info user_info = new User_info();
        Affairs_table affairs_table = new Affairs_table();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        Map<String,Object> modelmap = new HashMap<>();





        try{
            affpeopleServices.updateStatus(Integer.parseInt( jsonParam.getString("peopleId")));
            modelmap.put("success",true);
        }catch (Exception e){
            modelmap.put("success",false);
        }

        return modelmap;
    }





//    public List<User> getUserListPage(User user, HttpServletRequest request, HttpSession session) throws Exception {
//        User_info user_info = (User_info) session.getAttribute("user");
//        User_info info = userser.findByUserCode(user_info.getUserCode());
//        List<Object[]> list = userinfoServices.selectByempCode(info.getEmpCode());
//        List<UserMeetCondition> userMeetConditionList = convertUtil.castEntity(list, UserMeetCondition.class);
//        return userMeetConditionList;
//    }


//    @GetMapping
//    @JsonView(User_info.UserSimpleView.class)
//    public List<User_info> QueryUser(UserCondition userCondition/*, @PageableDefault(page = 1,size = 9,sort = "userCode,asc") Pageable pageable*/){//pageable 分页
//        Map<String, User_info> modelmap = new HashMap<String, User_info>();
//        List<User_info> infoList = new ArrayList<>();
//        System.out.println(ReflectionToStringBuilder.toString(userCondition, ToStringStyle.MULTI_LINE_STYLE));
//        infoList.add(new User_info());
//        infoList.add(new User_info());
//        infoList.add(new User_info());
//        return infoList;
//    }

//    @GetMapping("/{id:\\d+}")//使用正则表达式
//    @JsonView(User_info.UserDetailView.class)//设置权限指定视图
//    public User_info GetInfo(@PathVariable String id) {
//        User_info user_info = new User_info();
//        user_info.setUserName("chenz");
//
//        return user_info;
//    }
//
//    @PostMapping
//    public User_info InsertInfo(@Valid @RequestBody User_info user, BindingResult erros)//使用标签将请求映射到user中
//    {
//
//        if (erros.hasErrors()) {
//            erros.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
//        }
//        System.out.println(user.getLoginPassword());
//        System.out.println(user.getUserName());
//        user.setUserId(1);
//
//        return user;
//    }
//
//    @PutMapping("/{id:\\d+}")
//    public User_info UpdateInfo(@Valid @RequestBody User_info user, BindingResult erros) {
//        if (erros.hasErrors()) {
//            erros.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
//        }
//        System.out.println(user.getLoginPassword());
//        System.out.println(user.getUserName());
//        user.setUserId(1);
//
//        return user;
//    }
//
//    @DeleteMapping("/{id:\\d+}")
//    public void DeleteInfo(@PathVariable String id) {
//        System.out.println(id);
//
//
//    }
}

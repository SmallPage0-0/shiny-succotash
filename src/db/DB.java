package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import model.LyTable;
import model.User;
public class DB {
    Connection ct;
    PreparedStatement pstmt,p1;
    static int id;
    static int i,n;//为插入用户和留言统计记录
    // 在构造函数中建立与数据库的连接，这样在建立DB对象时就连接了数据库
    //数据库操作失败,会导致服务器弹出下载servlet的提示框
    public DB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            ct=DriverManager.getConnection
                    ("jdbc:sqlserver://localhost:1433; DatabaseName=jsp","sa","123456");
            pstmt=ct.prepareStatement("select count(*) from lyTable ");

            ResultSet rs=pstmt.executeQuery();

            rs.next();
            i=rs.getInt(1);
            pstmt=ct.prepareStatement("select count(*) from usertable ");

            rs=pstmt.executeQuery();

            rs.next();
            n=rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 根据username和password查询用户，查到就返回该对象，没有就返回null
    public User checkUser(String username,String password){
        try{
            pstmt=ct.prepareStatement("select * from usertable where username=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            User user=new User();
            while(rs.next()){
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                return user;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public String getUserName(int id){
        String username=null;
        try{
            pstmt=ct.prepareStatement("select username from usertable where id=?");
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                username=rs.getString(1);

            }
            return username;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public boolean insertUser(String username,String pwd)
    {
        try{
            n=n+1;
            pstmt=ct.prepareStatement("insert into usertable(username,password) values(?,?,?)");
            pstmt.setInt(1,n);
            pstmt.setString(2,username);
            pstmt.setString(3, pwd);
            pstmt.executeUpdate();
            return true;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean addInfo(LyTable ly)
    {
        try{
            i=i+1;
            pstmt=ct.prepareStatement("insert into lyTable values(?,?,?,?,?)");
            pstmt.setInt(1,i);
            pstmt.setInt(2,ly.getUserId());
            pstmt.setString(3, String.valueOf(ly.getDate()));
            pstmt.setString(4, ly.getTitle());
            pstmt.setString(5, ly.getContent());
            pstmt.executeUpdate();
            return true;



        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // 查询留言信息，返回一个ArrayList
    public ArrayList findLyInfo(){
        try{
            ArrayList al=new ArrayList();
            pstmt=ct.prepareStatement("select * from lyTable");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                LyTable ly=new LyTable();
                ly.setId(rs.getInt(1));
                ly.setUserId(rs.getInt(2));
                ly.setDate(rs.getDate(3));
                ly.setTitle(rs.getString(4));
                ly.setContent(rs.getString(5));
                al.add(ly);
            }
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
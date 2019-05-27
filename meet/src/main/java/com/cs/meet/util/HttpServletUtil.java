package com.cs.meet.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletUtil {

    public static int getInt(HttpServletRequest request, String key)
    {
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key)
    {
        try {
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    public static double getDouble(HttpServletRequest request, String key)
    {
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    public static boolean getBool(HttpServletRequest request, String key)
    {
        try {
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static String getString(HttpServletRequest request, String key)
    {
        String s =  request.getParameter(key);
        try {
            if(s!=null)
            {
                return s.trim();
            }
            if(s.equals(""))
            {
                return null;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return s;
    }
}

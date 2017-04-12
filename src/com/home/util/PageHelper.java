package com.home.util;

import java.util.List;



/** 
 * @ClassName: PageHelper 
 * @Description: TODO 分页工具类
 * @date 2016年12月20日 下午3:59:12  
 */
public class PageHelper{
    // 总共的数据量
    private int total;
 
    // 每页显示多少条
    private int pageSize;
 
    // 共有多少页
    private int totalPage;
 
    // 当前是第几页
    private int index;
 
    // 数据
    private List<?> data;
 
    // 连接路径
    private String path = "";
 
    /**
     * 页码HTML信息
     */
    @SuppressWarnings("unused")
    private String pageHTML;
 
    private int startPage; // 开始页面
 
    private int endPage; // 结束页面
 
    private int displayNum = 5; // 显示的页数
 
    /**
     * @return the startPage
     */
    public int getStartPage()
    {
        return startPage;
    }
 
    /**
     * @return the endPage
     */
    public int getEndPage()
    {
        return endPage;
    }
 
    /**
     * @return the path
     */
    public String getPath()
    {
        return path;
    }
 
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
 
    public void setIndex(int index)
    {
        this.index = index;
    }
 
    /**
     * 设置路径前缀，页面第一页index为1
     * 
     * @param path
     * 此path含有参数形式，如/aa/article?page=,或者/bb/article/list/
     */
    public void setPath(String path)
    {
        this.path = path;
    }
 
    public int getPageSize()
    {
        return pageSize;
    }
 
    public int getTotalPage()
    {
        return (this.total + this.pageSize - 1) / this.pageSize;
    }
 
    public int getIndex()
    {
        return index;
    }
 
    public List<?> getData()
    {
        return data;
    }
 
    public void setData(List<?> data)
    {
        this.data = data;
    }
 
    /**
     * @return the total
     */
    public int getTotal()
    {
        return total;
    }
 
    /**
     * @param total
     *  the total to set
     */
    public void setTotal(int total)
    {
        this.total = total;
    }
 
    public String getPageHTML()
    {
        totalPage = getTotalPage();
        StringBuffer displayInfo = new StringBuffer();
        if (totalPage != 0 && pageSize != 0)
        {
        	displayInfo.append("<div class='pager'>");
            // 判断如果当前是第一页 则“首页”和“第一页”，设置为不显示
            if (index <= 1)
            {
                displayInfo.append("<span class='item nolink' style='display:none'>首页</span>");
                displayInfo.append("<span class='item nolink' style='display:none'>上一页</span>");
            }
            else
            {
                displayInfo.append("<span class='item'><a href='" + path + "1'>首页</a></span>");
                displayInfo.append("<span class='item'><a href='" + path + (index - 1) + "'>上一页</a></span>");
            }
 
            countPages();
            displayInfo.append("<span class='item nums'>");
            for (int i = startPage; i <= endPage; i++)
            {
                if (i == index)
                {
                    displayInfo.append("<span class='nolink'>" + i + "</span>");
                }
                else
                {
                    displayInfo.append("<a href='" + path + i + "'>" + i + "</a>");
                }
            }
            displayInfo.append("</span>");
 
            if (index >= totalPage)
            {
                displayInfo.append("<span class='item nolink' style='display:none'>下一页</span>");
                displayInfo.append("<span class='item nolink' style='display:none'>尾页</span>");
            }
            else
            {
                displayInfo.append("<span class='item'><a href='" + path + (index+1) + "'>下一页</a></span>");
                displayInfo.append("<span class='item'><a href='" + path + totalPage + "'>尾页</a></span>");
            }
            
            displayInfo.append("<span class='item nolink'>      共<span class='num'>" + totalPage + "</span>页/<span class='num'>" + total + "</span>条记录</span>");
            //displayInfo.append("<span class='item nolink'>/<span class='num'>" + total + "</span>条记录</span>");
            displayInfo.append("</div>");
        }
       /* System.out.print(displayInfo.toString());*/
        return displayInfo.toString();
    }
 
    /**
     * 计算起始页和结束页
     */
    public void countPages()
    {
 
        if (index - displayNum / 2 < 1)
        {
            startPage = 1;
            endPage = displayNum > totalPage ? totalPage : displayNum;
        }
        else if (index + displayNum / 2 > totalPage)
        {
            int n = totalPage - displayNum + 1;
            startPage = n > 0 ? n : 1;
            endPage = totalPage;
        }
        else
        {
            startPage = index - displayNum / 2;
            endPage = startPage + displayNum - 1;
        }
    }
 
    /**
     * @param pageHTML the pageHTML to set
     */
    public void setPageHTML(String pageHTML)
    {
        this.pageHTML = pageHTML;
    }
 
  /*  public static void main(String[] args)
    {
        PageHelper p = new PageHelper();
        // p.totalPage = p.getTotalPage();
        p.setTotal(1002);
        p.setPageSize(20);
        p.setPath("./news.do?type='zzz'&p=");
        // for (int i = -80; i < 80; i++)
        // {
        // p.setIndex(i);
        // p.countPages();
        // System.out.println(i+"----"+p.getStartPage() + "-----" +
        // p.getEndPage());
        // }
        p.setIndex(33);
        System.out.println(p.getPageHTML());
    }*/
}
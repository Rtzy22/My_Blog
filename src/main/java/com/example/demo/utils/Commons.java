package com.example.demo.utils;


import com.example.demo.constant.WebConst;
import com.example.demo.entity.T_contents;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 主题公共函数
 * <p>
 * Created by 13 on 2017/2/21.
 */
@Component
public final class Commons {

    public static String THEME = "themes/default";

    /**
     * 获取随机数
     *
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

    public static String fmtdate(Integer unixTime) {
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    /**
     * 格式化unix时间戳为日期
     * @param unixTime
     * @param patten 日期格式
     * @return
     */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && !StringUtils.isEmpty(unixTime)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }



    public static String permalink(T_contents contents) {
        return permalink(contents.getCid(), contents.getSlug());
    }

    /**
     * 返回文章链接地址
     *
     * @param cid
     * @param slug
     * @return
     */
    public static String permalink(Integer cid, String slug) {
        return site_url("/article/" + (!StringUtils.isEmpty(slug) ? slug : cid.toString()));
    }

    /**
     * 网站链接
     *
     * @return
     */
    public static String site_url() {
        return site_url("");
    }

    /**
     * 返回网站链接下的全址
     *
     * @param sub 后面追加的地址
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 网站配置项
     *
     * @param key
     * @param defalutValue 默认值
     * @return
     */
    public static String site_option(String key, String defalutValue) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (!StringUtils.isEmpty(str)) {
            return str;
        } else {
            return defalutValue;
        }
    }


    /**
     * 返回github头像地址
     *
     * @param email
     * @return
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isEmpty(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

}

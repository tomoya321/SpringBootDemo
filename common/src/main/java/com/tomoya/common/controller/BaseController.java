/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseController
 * Author:   Administrator
 * Date:     2019/8/21 16:39
 * Description: 基础controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.controller;

import com.tomoya.common.dto.PageView;
import org.apache.commons.lang.StringUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈基础controller〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class BaseController {
    public PageView pageView = null;

    public PageView getPageView(String pageNo, String pagesize) {
        if (StringUtils.isEmpty(pageNo)) {
            pageView = new PageView(0);
        } else {
            pageView = new PageView(Integer.parseInt(pageNo) - 1);
        }
        if (StringUtils.isEmpty(pagesize)) {
            pagesize = "10";
        }
        pageView.setPageSize(Integer.parseInt(pagesize));
        return pageView;
    }
}
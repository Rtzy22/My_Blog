package com.example.demo.controller.admin;

import com.example.demo.VO.ResultVO;
import com.example.demo.constant.WebConst;
import com.example.demo.controller.BaseController;
import com.example.demo.dto.Types;
import com.example.demo.entity.T_contents;
import com.example.demo.entity.T_metas;
import com.example.demo.service.IContentService;
import com.example.demo.service.MetaService;
import com.example.demo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhong on 2018/6/26.
 */
@Controller
@RequestMapping("/admin/article")
@Slf4j
public class ArticleController extends BaseController {

    @Autowired
    private IContentService iContentService;

    @Autowired
    private MetaService metaService;


    @GetMapping("")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        HttpServletRequest request) {
        Page<T_contents> t_contentsPage = iContentService.getArticlesWithpage(page - 1, size);
        request.setAttribute("articles", t_contentsPage);
        return "admin/article_list";
    }

    @GetMapping("/{cid}")
    public String editArticle(@PathVariable String cid, HttpServletRequest request) {
        T_contents t_contents = iContentService.getContents(cid);
        request.setAttribute("contents", t_contents);

        List<T_metas> categories = metaService.getMetas(Types.CATEGORY.getType());

        request.setAttribute("categories", categories);
        request.setAttribute("active", "article");
        return "admin/article_edit";
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestParam int cid) {

        String result = iContentService.deleteByCid(cid);
        if (result.equals(WebConst.SUCCESS_RESULT)) {
            return ResultVOUtil.success();

        }
        return ResultVOUtil.error(result);

    }
}

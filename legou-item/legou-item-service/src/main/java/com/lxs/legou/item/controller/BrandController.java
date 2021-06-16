package com.lxs.legou.item.controller;

import com.lxs.legou.core.controller.BaseController;
import com.lxs.legou.item.po.Brand;
import com.lxs.legou.item.po.Category;
import com.lxs.legou.item.service.IBrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item/brand")
@CrossOrigin
public class BrandController extends BaseController<IBrandService, Brand> {

    @Override
    public void afterEdit(Brand domain) {
        List<Category> categories = service.selectCategoryByBrand(domain.getId());
        Long[] ids = new Long[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            ids[i] = categories.get(i).getId();
        }
        domain.setCategoryIds(ids);
    }
}

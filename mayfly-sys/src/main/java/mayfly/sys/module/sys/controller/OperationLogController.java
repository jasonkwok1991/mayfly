package mayfly.sys.module.sys.controller;

import mayfly.core.result.Result;
import mayfly.core.util.bean.BeanUtils;
import mayfly.sys.module.sys.controller.query.OperationLogQuery;
import mayfly.sys.module.sys.entity.OperationLogDO;
import mayfly.sys.module.sys.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meilin.huang
 * @date 2020-03-05 4:05 下午
 */
@RestController
@RequestMapping("/sys/logs")
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @GetMapping
    public Result<?> list(OperationLogQuery query) {
        return operationLogService.listByCondition(BeanUtils.copyProperties(query, OperationLogDO.class), query).toResult();
    }
}
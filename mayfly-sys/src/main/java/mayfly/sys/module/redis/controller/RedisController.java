package mayfly.sys.module.redis.controller;

import io.lettuce.core.api.sync.BaseRedisCommands;
import io.lettuce.core.api.sync.RedisKeyCommands;
import jakarta.validation.Valid;
import mayfly.core.log.annotation.Log;
import mayfly.core.model.result.CommonCodeEnum;
import mayfly.core.model.result.Result;
import mayfly.core.permission.Permission;
import mayfly.core.util.StringUtils;
import mayfly.core.util.bean.BeanUtils;
import mayfly.sys.module.redis.commands.KeyInfo;
import mayfly.sys.module.redis.commands.KeyValueCommand;
import mayfly.sys.module.redis.controller.form.KeyValueForm;
import mayfly.sys.module.redis.controller.form.ScanForm;
import mayfly.sys.module.redis.controller.vo.KeyScanVO;
import mayfly.sys.module.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2019-01-21 3:35 PM
 */
@Permission(code = "redis:key")
@RestController
@RequestMapping("/devops/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @Log(level = Log.Level.DEBUG)
    @GetMapping("/{cluster}/{id}/scan")
    public Result<?> scan(@PathVariable Boolean cluster, @PathVariable Long id, @Valid ScanForm scanForm) {
        RedisKeyCommands<String, byte[]> cmds = getKeyCmd(cluster, id);
        KeyScanVO scan = cluster ? KeyValueCommand.clusterScan(cmds, scanForm.getCount(), scanForm.getMatch())
                : KeyValueCommand.scan(cmds, scanForm.getCursor(), scanForm.getCount(), scanForm.getMatch());
        return Result.success(scan);
    }

    @Log(value = "查询redis value", resLevel = Log.Level.DEBUG)
    @GetMapping("/{cluster}/{id}/value")
    public Result<?> value(@PathVariable Boolean cluster, @PathVariable Long id, String key) {
        if (StringUtils.isEmpty(key)) {
            return CommonCodeEnum.PARAM_ERROR.toResult("key不能为空!");
        }
        return Result.success(KeyValueCommand.value(getKeyCmd(cluster, id), key));
    }

    @Log("新增redis key value")
    @PostMapping("/{cluster}/{id}/value")
    public Result<?> addKeyValue(@PathVariable Boolean cluster, @PathVariable Long id, @Valid KeyValueForm keyValue) {
        BaseRedisCommands<String, byte[]> cmds = cluster ? redisService.getClusterCmds(id) : redisService.getCmds(id);
        KeyValueCommand.addKeyValue(cmds, BeanUtils.copy(keyValue, KeyInfo.class));
        return Result.success();
    }

    @Log("删除key")
    @DeleteMapping("/{cluster}/{id}")
    public Result<?> delete(@PathVariable Boolean cluster, @PathVariable Long id, String key) {
        if (StringUtils.isEmpty(key)) {
            return CommonCodeEnum.PARAM_ERROR.toResult("key不能为空！");
        }
        KeyValueCommand.del(getKeyCmd(cluster, id), key);
        return Result.success();
    }

    private RedisKeyCommands<String, byte[]> getKeyCmd(Boolean cluster, Long id) {
        return cluster ? redisService.getClusterCmds(id) : redisService.getCmds(id);
    }
}

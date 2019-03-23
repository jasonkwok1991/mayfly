package mayfly.sys.redis.service.impl;

import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;
import mayfly.common.exception.BusinessRuntimeException;
import mayfly.common.utils.Assert;
import mayfly.common.utils.StringUtils;
import mayfly.dao.RedisMapper;
import mayfly.entity.Redis;
import mayfly.sys.redis.connection.RedisConnectionRegister;
import mayfly.sys.redis.connection.RedisInfo;
import mayfly.sys.redis.service.RedisService;
import mayfly.sys.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2019-01-07 4:08 PM
 */
@Service
public class RedisServiceImpl extends BaseServiceImpl<RedisMapper, Redis> implements RedisService {

    @Autowired
    private RedisMapper redisMapper;

    private RedisConnectionRegister register = RedisConnectionRegister.getInstance();

    @Override
    public void connect(boolean cluster, int id) {
        if (register.contains(cluster, id)) {
            return;
        }
        if (cluster) {
            register.register(toRedisCluster(id));
        } else {
            register.register(toRedisInfo(id));
        }
    }

    @Override
    public RedisCommands<String, byte[]> getCmds(int redisId) {
        return register.getCmds(redisId);
    }

    @Override
    public RedisClusterCommands<String, byte[]> getClusterCmds(int clusterId) {
        return register.getClusterCmds(clusterId);
    }

    private RedisInfo toRedisInfo(int id) {
        Redis redis = getById(id);
        Assert.notNull(redis, "不存在该redis实例！");
        if (redis.getClusterId() != null && redis.getClusterId() != RedisInfo.STANDALONE) {
            throw new BusinessRuntimeException("该redis为集群模式！");
        }
        RedisURI redisURI = RedisURI.create(redis.getIp(), redis.getPort());
        if (!StringUtils.isEmpty(redis.getPwd())) {
            redisURI.setPassword(redis.getPwd());
        }
        return RedisInfo.builder(redis.getId()).uri(redisURI).build();
    }

    private Set<RedisInfo> toRedisCluster(int id) {
        List<Redis> nodes = listByCondition(Redis.builder().clusterId(id).build());
        Assert.notEmpty(nodes, "不存在该redis集群实例！");

        return nodes.stream().map(n -> {
            RedisURI redisURI = RedisURI.create(n.getIp(), n.getPort());
            if (!StringUtils.isEmpty(n.getPwd())) {
                redisURI.setPassword(n.getPwd());
            }
            return RedisInfo.builder(n.getId()).uri(redisURI).clusterId(id).build();
        }).collect(Collectors.toSet());
    }
}

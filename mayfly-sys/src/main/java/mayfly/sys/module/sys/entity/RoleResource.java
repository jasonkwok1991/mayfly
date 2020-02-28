package mayfly.sys.module.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mayfly.sys.common.base.model.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2018-12-07 4:14 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResource extends BaseEntity {

    private Integer id;

    private Integer roleId;

    private Integer resourceId;

    private LocalDateTime createTime;
}

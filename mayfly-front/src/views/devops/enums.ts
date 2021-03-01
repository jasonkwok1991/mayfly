import { Enum } from '@/common/Enum'

/**
 * 枚举类
 */
export default {
  // 文件类型枚举
  FileTypeEnum: new Enum().add('DIRECTORY', '目录', 1).add('FILE', '文件', 2),
  // redis值类型枚举
  ValueTypeEnum: new Enum().add('string', 'string', 1).add('set', 'set', 2),
  DbTypeEnum: new Enum().add('MYSQL', 'mysql', 1).add('ORACLE', 'oracle', 2)
}
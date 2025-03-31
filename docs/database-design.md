
---

## 数据库表设计

### 1. 供应商信息表 (`supplier_info`)

**功能**：存储供应商的基本信息，如企业名称、统一社会信用代码、供应商性质等。

| 字段名             | 类型                | 描述                     | 备注                  |
|--------------------|---------------------|--------------------------|-----------------------|
| id                 | bigint unsigned     | 自增ID                   | 主键                  |
| supplier_id        | bigint unsigned     | 供应商ID                 | 唯一标识供应商        |
| organization_name  | varchar(128)         | 企业名称                 |                       |
| organization_code  | varchar(128)         | 企业统一社会信用代码     |                       |
| supplier_nature    | int                 | 供应商性质               | 如：1 - 国内，2 - 外资 |
| note               | varchar(512)         | 备注                     |                       |
| qualification      | json                | 供应商资质               | 存储供应商资质信息    |
| create_time        | timestamp           | 创建时间                 |                       |
| create_operator    | varchar(64)         | 创建操作人               |                       |
| last_update_time   | timestamp           | 最后更新时间             |                       |
| last_update_operator | varchar(64)       | 更新操作人               |                       |
| is_deleted         | tinyint             | 是否已删除               | 0 - 否，1 - 是         |

#### 创建 SQL 语句：

```sql
CREATE TABLE supplier_info (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '自增Id',
    supplier_id BIGINT UNSIGNED NOT NULL UNIQUE COMMENT '供应商ID',
    organization_name VARCHAR(128) NOT NULL COMMENT '企业名称',
    organization_code VARCHAR(128) NOT NULL COMMENT '统一社会信用代码',
    supplier_nature INT NOT NULL COMMENT '供应商性质',
    note VARCHAR(512) NOT NULL COMMENT '备注',
    qualification JSON COMMENT '供应商资质',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    create_operator VARCHAR(64) NOT NULL COMMENT '创建操作人',
    last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    last_update_operator VARCHAR(64) NOT NULL COMMENT '更新操作人',
    is_deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否已删除',
    UNIQUE KEY uniq_supplier_id (supplier_id, is_deleted)
) COMMENT '供应商主体信息表';
```

---

### 2. 风险标签历史表 (`risk_label_history`)

**功能**：记录每次供应商的风险标签，跟踪历史变动。

| 字段名           | 类型                | 描述                     | 备注                  |
|------------------|---------------------|--------------------------|-----------------------|
| id               | bigint unsigned     | 自增ID                   | 主键                  |
| supplier_id      | bigint unsigned     | 供应商ID                 | 外键                  |
| label_json       | json                | 风险标签详情             | 存储标签的详细信息    |
| scan_time        | datetime            | 扫描时间                 |                       |

#### 创建 SQL 语句：

```sql
CREATE TABLE risk_label_history (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '风险记录ID',
    supplier_id BIGINT UNSIGNED NOT NULL COMMENT '供应商ID',
    label_json JSON NOT NULL COMMENT '风险标签详情',
    scan_time DATETIME NOT NULL COMMENT '扫描时间'
) COMMENT '风险历史记录表';
```

---

### 3. 风险标签表 (`risk_label`)

**功能**：存储各类风险标签及其相关信息。

| 字段名           | 类型      | 描述                        | 备注                  |
|------------------|-----------|-----------------------------|-----------------------|
| risk_label_id    | int       | 风险标签ID                  | 主键                  |
| risk_label_name  | varchar(64) | 风险标签名称（如“经营异常”）  |                       |
| risk_label_level | varchar(64) | 风险标签等级（如P0、P1）      |                       |

#### 创建 SQL 语句：

```sql
CREATE TABLE risk_label (
    risk_label_id INT PRIMARY KEY COMMENT '风险标签ID',
    risk_label_name VARCHAR(64) COMMENT '风险标签名称',
    risk_label_level VARCHAR(64) COMMENT '风险标签等级'
) COMMENT '风险标签表';
```

---

### 4. KV 存储设计

#### 4.1 供应商风险标签 KV 存储

**Key 设计**：
- **Key**: `supplier:{supplier_id}:risk_labels`
- **Value**: 存储该供应商的所有风险标签，采用 JSON 格式。

#### 示例存储：

```json
{
  "labels": [
    { "label": "经营异常", "level": "P0", "detail": "吊销" },
    { "label": "黑名单", "level": "P1", "detail": "法律诉讼" }
  ],
  "last_update": "2025-03-25T10:00:00"
}
```

#### 4.2 风险标签历史 KV 存储

**Key 设计**：
- **Key**: `supplier:{supplier_id}:risk_history:{scan_time}`
- **Value**: 存储该供应商在特定扫描时间的风险标签信息，采用 JSON 格式。

#### 示例存储：

```json
{
  "label": "经营异常",
  "level": "P0",
  "detail": "吊销",
  "scan_time": "2025-03-25T10:00:00"
}
```

---

### 5. 数据库建表步骤

1. 在数据库中执行上述 SQL 脚本，创建 `supplier_info`、`risk_label_history` 和 `risk_label` 三张表。
2. 索引设计：`supplier_id` 已经有唯一索引，考虑到查询时会涉及 `is_deleted`，建议在 `is_deleted` 字段上添加普通索引，以提高筛选已删除与未删除数据的效率。
3. JSON 字段：`qualification` 使用 JSON 存储，方便了存储灵活的数据，但如果你后续需要对这些字段进行复杂的查询（如基于某个资质的筛选），可能会影响查询效率。可以考虑将常用查询条件的数据提取出来，进行拆分。

---

### 6. 后续工作

1. **接口开发**：根据数据库表设计，后端开发人员将实现对应的增删改查 (CRUD) 接口，提供给前端进行数据操作。
2. **数据库优化**：随着数据量增长，可以根据查询性能调整索引或拆分表结构。

---


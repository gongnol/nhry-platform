### 数据Merge规范

#### 目录规范
数据脚本放置在`src/main/resources/db/migration`

#### 命名规范
`主版本_日期_序列号__动作类型_名称.sql`

**样例**

    V1.0_20160617_1__Create_flyway_test_table.sql
    V1.0_20160617_2__Change_flyway_test_table.sql
    V1.0_20160617_3__Add_flyway_test_table.sql
    V1.0_20160617_3__Delete_flyway_test_table.sql
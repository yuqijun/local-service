/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90624
 Source Host           : localhost:5432
 Source Catalog        : ls
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90624
 File Encoding         : 65001

 Date: 02/04/2022 10:32:20
*/


-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_user";
CREATE TABLE "public"."tb_user" (
  "create_user_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "update_user_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "login_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "id_no" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "province" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "city" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "region" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "county" varchar(100) COLLATE "pg_catalog"."default",
  "country" varchar(100) COLLATE "pg_catalog"."default",
  "village" varchar(100) COLLATE "pg_catalog"."default",
  "address" varchar COLLATE "pg_catalog"."default",
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "receiving_address" jsonb
)
;
COMMENT ON COLUMN "public"."tb_user"."create_user_id" IS '用户编号';
COMMENT ON COLUMN "public"."tb_user"."update_user_id" IS '修改人编号';
COMMENT ON COLUMN "public"."tb_user"."login_name" IS '登陆账号';
COMMENT ON COLUMN "public"."tb_user"."password" IS '登陆密码';
COMMENT ON COLUMN "public"."tb_user"."phone" IS '用户联系电话';
COMMENT ON COLUMN "public"."tb_user"."email" IS '用户邮箱';
COMMENT ON COLUMN "public"."tb_user"."id_no" IS '用户身份证号';
COMMENT ON COLUMN "public"."tb_user"."province" IS '省';
COMMENT ON COLUMN "public"."tb_user"."city" IS '市';
COMMENT ON COLUMN "public"."tb_user"."region" IS '区';
COMMENT ON COLUMN "public"."tb_user"."county" IS '县';
COMMENT ON COLUMN "public"."tb_user"."country" IS '乡';
COMMENT ON COLUMN "public"."tb_user"."village" IS '村';
COMMENT ON COLUMN "public"."tb_user"."address" IS '详细地址';
COMMENT ON COLUMN "public"."tb_user"."create_time" IS '记录创建时间';
COMMENT ON COLUMN "public"."tb_user"."update_time" IS '记录最后一次修改时间';
COMMENT ON COLUMN "public"."tb_user"."remark" IS '备注';
COMMENT ON COLUMN "public"."tb_user"."receiving_address" IS '收货地址信息';
COMMENT ON TABLE "public"."tb_user" IS '用户信息表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO "public"."tb_user" VALUES ('10101010', '10101010', 'yuqijun123', '$2a$10$Kt60XKB/OYMkJ2Vhf/dcHOTtPwXg67sOBQNxUmePXtI2wXCXRrp36', '15625487985', '864784156@qq.com', '365125421325212412', '上海', '上海市', '闵行区', NULL, NULL, NULL, '{}', '2021-01-31 14:02:29', '2021-01-31 14:02:36', NULL, '[{"phone": "15078392019", "address": "上海市青浦区明珠家园4区14栋108", "userName": "张三", "createUserId": "10101010"}, {"phone": "15078392029", "address": "上海市青浦区明珠家园4区14栋109", "userName": "李四", "createUserId": "10101010"}, {"phone": "15078392039", "address": "上海市青浦区明珠家园4区14栋110", "userName": "王五", "createUserId": "10101010"}]');

-- ----------------------------
-- Primary Key structure for table tb_user
-- ----------------------------
ALTER TABLE "public"."tb_user" ADD CONSTRAINT "tb_user_pkey" PRIMARY KEY ("create_user_id");
